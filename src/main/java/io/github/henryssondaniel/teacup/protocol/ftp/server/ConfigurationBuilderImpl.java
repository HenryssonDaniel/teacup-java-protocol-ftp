package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.protocol.DefaultBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConfigurationBuilderImpl extends DefaultBuilder<Configuration, ConfigurationSetter>
    implements ConfigurationBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ConfigurationBuilderImpl.class);

  ConfigurationBuilderImpl() {
    super(new ConfigurationImpl());
  }

  @Override
  public ConfigurationBuilder setClientConfiguration(ClientConfiguration clientConfiguration) {
    LOGGER.log(Level.FINE, "Set client configuration");
    getImplementation().setClientConfiguration(clientConfiguration);
    return this;
  }

  @Override
  public ConfigurationBuilder setIdleTimeout(Integer idleTimeout) {
    LOGGER.log(Level.FINE, "Set idle timeout");
    getImplementation().setIdleTimeout(idleTimeout);
    return this;
  }

  @Override
  public ConfigurationBuilder setImplicitSsl(boolean implicitSsl) {
    LOGGER.log(Level.FINE, "Set implicit SSL");
    getImplementation().setImplicitSsl(implicitSsl);
    return this;
  }

  @Override
  public ConfigurationBuilder setPort(Integer port) {
    LOGGER.log(Level.FINE, "Set port");
    getImplementation().setPort(port);
    return this;
  }

  @Override
  public ConfigurationBuilder setServerAddress(String serverAddress) {
    LOGGER.log(Level.FINE, "Set server address");
    getImplementation().setServerAddress(serverAddress);
    return this;
  }

  @Override
  public ConfigurationBuilder setSslConfiguration(SslConfiguration sslConfiguration) {
    LOGGER.log(Level.FINE, "Set SSL configuration");
    getImplementation().setSslConfiguration(sslConfiguration);
    return this;
  }

  @Override
  protected ConfigurationSetter createImplementation() {
    return new ConfigurationImpl();
  }
}
