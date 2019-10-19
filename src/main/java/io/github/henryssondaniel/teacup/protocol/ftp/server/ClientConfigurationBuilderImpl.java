package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.DefaultBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientConfigurationBuilderImpl
    extends DefaultBuilder<ClientConfiguration, ClientConfigurationSetter>
    implements ClientConfigurationBuilder {
  private static final Logger LOGGER = Factory.getLogger(ClientConfigurationBuilderImpl.class);

  ClientConfigurationBuilderImpl() {
    super(new ClientConfigurationImpl());
  }

  @Override
  public ClientConfigurationBuilder setActiveEnabled(boolean activeEnabled) {
    LOGGER.log(Level.FINE, "Set active enabled");
    getImplementation().setActiveEnabled(activeEnabled);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setActiveIpCheck(boolean activeIpCheck) {
    LOGGER.log(Level.FINE, "Set active IP check");
    getImplementation().setActiveIpCheck(activeIpCheck);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setActiveLocalAddress(String activeLocalAddress) {
    LOGGER.log(Level.FINE, "Set active local address");
    getImplementation().setActiveLocalAddress(activeLocalAddress);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setActiveLocalPort(int activeLocalPort) {
    LOGGER.log(Level.FINE, "Set active local port");
    getImplementation().setActiveLocalPort(activeLocalPort);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setIdleTime(int idleTime) {
    LOGGER.log(Level.FINE, "Set idle time");
    getImplementation().setIdleTime(idleTime);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setImplicitSsl(boolean implicitSsl) {
    LOGGER.log(Level.FINE, "Set implicit SSL");
    getImplementation().setImplicitSsl(implicitSsl);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setPassiveAddress(String passiveAddress) {
    LOGGER.log(Level.FINE, "Set passive address");
    getImplementation().setPassiveAddress(passiveAddress);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setPassiveExternalAddress(String passiveExternalAddress) {
    LOGGER.log(Level.FINE, "Set passive external address");
    getImplementation().setPassiveExternalAddress(passiveExternalAddress);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setPassiveIpCheck(boolean passiveIpCheck) {
    LOGGER.log(Level.FINE, "Set passive IP check");
    getImplementation().setPassiveIpCheck(passiveIpCheck);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setPassivePorts(String passivePorts) {
    LOGGER.log(Level.FINE, "Set passive ports");
    getImplementation().setPassivePorts(passivePorts);
    return this;
  }

  @Override
  public ClientConfigurationBuilder setSslConfiguration(SslConfiguration sslConfiguration) {
    LOGGER.log(Level.FINE, "Set SSL configuration");
    getImplementation().setSslConfiguration(sslConfiguration);
    return this;
  }

  @Override
  protected ClientConfigurationSetter createImplementation() {
    return new ClientConfigurationImpl();
  }
}
