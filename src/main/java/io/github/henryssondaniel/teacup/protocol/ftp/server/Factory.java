package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.protocol.Server;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.apache.ftpserver.ssl.SslConfigurationFactory;

/**
 * Factory class for the server package.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Factory.class);

  /**
   * Creates a new {@link ClientConfigurationBuilder}.
   *
   * @return the client configuration builder
   * @since 1.0
   */
  public static ClientConfigurationBuilder createClientConfigurationBuilder() {
    LOGGER.log(Level.FINE, "Create client configuration builder");
    return new ClientConfigurationBuilderImpl();
  }

  /**
   * Creates a new {@link ConfigurationBuilder}.
   *
   * @return the configuration builder
   * @since 1.0
   */
  public static ConfigurationBuilder createConfigurationBuilder() {
    LOGGER.log(Level.FINE, "Create configuration builder");
    return new ConfigurationBuilderImpl();
  }

  /**
   * Creates a new {@link ContextBuilder}.
   *
   * @param reply the reply
   * @return the context builder
   * @since 1.0
   */
  public static ContextBuilder createContextBuilder(Reply reply) {
    LOGGER.log(Level.FINE, "Create context builder");
    return new ContextBuilderImpl(reply);
  }

  /**
   * Creates a new {@link ReplyBuilder}.
   *
   * @param code the code
   * @param message the message
   * @return the reply builder
   * @since 1.0
   */
  public static ReplyBuilder createReplyBuilder(int code, String message) {
    LOGGER.log(Level.FINE, "Create reply builder");
    return new ReplyBuilderImpl(code, message);
  }

  /**
   * Creates a new {@link Server}.
   *
   * @return the simple server
   * @since 1.0
   */
  public static Server<Context, Request> createServer() {
    LOGGER.log(Level.FINE, "Create server");
    return createServer(null);
  }

  /**
   * Creates a new {@link Server}.
   *
   * @param configuration the configuration
   * @return the simple server
   * @since 1.0
   */
  public static Server<Context, Request> createServer(Configuration configuration) {
    LOGGER.log(Level.FINE, "Create server");

    Handler handler = new HandlerImpl();

    var ftpServerFactory = new FtpServerFactory();
    ftpServerFactory.addListener(
        "default", createListener(configuration, new ListenerFactoryImpl(handler)));

    return new Simple(ftpServerFactory.createServer(), handler);
  }

  /**
   * Creates a new {@link SslConfigurationBuilder}.
   *
   * @return the SSL configuration builder
   * @since 1.0
   */
  public static SslConfigurationBuilder createSslConfigurationBuilder() {
    LOGGER.log(Level.FINE, "Create SSL configuration builder");
    return new SslConfigurationBuilderImpl();
  }

  private static DataConnectionConfiguration createDataConnectionConfiguration(
      ClientConfiguration clientConfiguration) {
    var dataConnectionConfigurationFactory = new DataConnectionConfigurationFactory();

    var activeEnabled = clientConfiguration.hasActiveEnabled();
    if (activeEnabled != null) dataConnectionConfigurationFactory.setActiveEnabled(activeEnabled);

    dataConnectionConfigurationFactory.setActiveIpCheck(clientConfiguration.hasActiveIpCheck());
    dataConnectionConfigurationFactory.setActiveLocalAddress(
        clientConfiguration.getActiveLocalAddress());

    dataConnectionConfigurationFactory.setActiveLocalPort(clientConfiguration.getActiveLocalPort());

    var idleTime = clientConfiguration.getIdleTime();
    if (idleTime != null) dataConnectionConfigurationFactory.setIdleTime(idleTime);

    dataConnectionConfigurationFactory.setImplicitSsl(clientConfiguration.hasImplicitSsl());
    dataConnectionConfigurationFactory.setPassiveAddress(clientConfiguration.getPassiveAddress());
    dataConnectionConfigurationFactory.setPassiveExternalAddress(
        clientConfiguration.getPassiveExternalAddress());
    dataConnectionConfigurationFactory.setPassiveIpCheck(clientConfiguration.hasPassiveIpCheck());

    var passivePorts = clientConfiguration.getPassivePorts();
    if (passivePorts != null) dataConnectionConfigurationFactory.setPassivePorts(passivePorts);

    setSslConfiguration(clientConfiguration, dataConnectionConfigurationFactory);

    return dataConnectionConfigurationFactory.createDataConnectionConfiguration();
  }

  private static Listener createListener(
      Configuration configuration, ListenerFactory listenerFactory) {
    if (configuration != null) setConfiguration(configuration, listenerFactory);

    return listenerFactory.createListener();
  }

  private static SslConfiguration createSslConfiguration(
      io.github.henryssondaniel.teacup.protocol.ftp.server.SslConfiguration sslConfiguration) {
    var sslConfigurationFactory = new SslConfigurationFactory();
    sslConfigurationFactory.setClientAuthentication(sslConfiguration.getClientAuthentication());
    sslConfigurationFactory.setEnabledCipherSuites(sslConfiguration.getEnabledCipherSuites());
    sslConfigurationFactory.setKeyAlias(sslConfiguration.getKeyAlias());
    sslConfigurationFactory.setKeyPassword(sslConfiguration.getKeyPassword());

    setKeyStore(sslConfiguration, sslConfigurationFactory);

    var sslProtocol = sslConfiguration.getSslProtocol();
    if (sslProtocol != null) sslConfigurationFactory.setSslProtocol(sslProtocol);

    var truststoreAlgorithm = sslConfiguration.getTruststoreAlgorithm();
    if (truststoreAlgorithm != null)
      sslConfigurationFactory.setTruststoreAlgorithm(truststoreAlgorithm);

    sslConfigurationFactory.setTruststoreFile(sslConfiguration.getTruststoreFile());
    sslConfigurationFactory.setTruststorePassword(sslConfiguration.getTruststorePassword());

    var truststoreType = sslConfiguration.getTruststoreType();
    if (truststoreType != null) sslConfigurationFactory.setTruststoreType(truststoreType);

    return sslConfigurationFactory.createSslConfiguration();
  }

  private static void setConfiguration(
      Configuration configuration, ListenerFactory listenerFactory) {
    var clientConfiguration = configuration.getClientConfiguration();
    if (clientConfiguration != null)
      listenerFactory.setDataConnectionConfiguration(
          createDataConnectionConfiguration(clientConfiguration));

    var idleTimeout = configuration.getIdleTimeout();
    if (idleTimeout != null) listenerFactory.setIdleTimeout(idleTimeout);

    listenerFactory.setImplicitSsl(configuration.hasImplicitSsl());

    var port = configuration.getPort();
    if (port != null) listenerFactory.setPort(port);

    listenerFactory.setServerAddress(configuration.getServerAddress());

    setSslConfiguration(configuration, listenerFactory);
  }

  private static void setKeyStore(
      io.github.henryssondaniel.teacup.protocol.ftp.server.SslConfiguration sslConfiguration,
      SslConfigurationFactory sslConfigurationFactory) {
    var keystoreAlgorithm = sslConfiguration.getKeystoreAlgorithm();
    if (keystoreAlgorithm != null) sslConfigurationFactory.setKeystoreAlgorithm(keystoreAlgorithm);

    var keystoreFile = sslConfiguration.getKeystoreFile();
    if (keystoreFile != null) sslConfigurationFactory.setKeystoreFile(keystoreFile);

    sslConfigurationFactory.setKeystorePassword(sslConfiguration.getKeystorePassword());

    var keystoreType = sslConfiguration.getKeystoreType();
    if (keystoreType != null) sslConfigurationFactory.setKeystoreType(keystoreType);
  }

  private static void setSslConfiguration(
      ClientConfiguration clientConfiguration,
      DataConnectionConfigurationFactory dataConnectionConfigurationFactory) {
    var sslConfiguration = clientConfiguration.getSslConfiguration();
    if (sslConfiguration != null)
      dataConnectionConfigurationFactory.setSslConfiguration(
          createSslConfiguration(sslConfiguration));
  }

  private static void setSslConfiguration(
      Configuration configuration, ListenerFactory listenerFactory) {
    var sslConfiguration = configuration.getSslConfiguration();
    if (sslConfiguration != null)
      listenerFactory.setSslConfiguration(createSslConfiguration(sslConfiguration));
  }
}
