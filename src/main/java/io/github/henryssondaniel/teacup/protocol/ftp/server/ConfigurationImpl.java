package io.github.henryssondaniel.teacup.protocol.ftp.server;

import java.util.logging.Level;
import java.util.logging.Logger;

class ConfigurationImpl implements ConfigurationSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(ConfigurationImpl.class);

  private ClientConfiguration clientConfiguration;
  private Integer idleTimeout;
  private boolean implicitSsl;
  private Integer port;
  private String serverAddress;
  private SslConfiguration sslConfiguration;

  @Override
  public ClientConfiguration getClientConfiguration() {
    return clientConfiguration;
  }

  @Override
  public Integer getIdleTimeout() {
    return idleTimeout;
  }

  @Override
  public Integer getPort() {
    return port;
  }

  @Override
  public String getServerAddress() {
    return serverAddress;
  }

  @Override
  public SslConfiguration getSslConfiguration() {
    return sslConfiguration;
  }

  @Override
  public boolean hasImplicitSsl() {
    LOGGER.log(Level.FINE, "Has implicit SSL");
    return implicitSsl;
  }

  @Override
  public void setClientConfiguration(ClientConfiguration clientConfiguration) {
    this.clientConfiguration = clientConfiguration;
  }

  @Override
  public void setIdleTimeout(Integer idleTimeout) {
    this.idleTimeout = idleTimeout;
  }

  @Override
  public void setImplicitSsl(boolean implicitSsl) {
    this.implicitSsl = implicitSsl;
  }

  @Override
  public void setPort(Integer port) {
    this.port = port;
  }

  @Override
  public void setServerAddress(String serverAddress) {
    this.serverAddress = serverAddress;
  }

  @Override
  public void setSslConfiguration(SslConfiguration sslConfiguration) {
    this.sslConfiguration = sslConfiguration;
  }
}
