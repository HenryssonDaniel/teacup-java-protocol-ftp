package io.github.henryssondaniel.teacup.protocol.ftp.server;

import java.util.logging.Level;
import java.util.logging.Logger;

class ClientConfigurationImpl implements ClientConfigurationSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ClientConfigurationImpl.class);

  private Boolean activeEnabled;
  private boolean activeIpCheck;
  private String activeLocalAddress;
  private int activeLocalPort;
  private Integer idleTime;
  private boolean implicitSsl;
  private String passiveAddress;
  private String passiveExternalAddress;
  private boolean passiveIpCheck;
  private String passivePorts;
  private SslConfiguration sslConfiguration;

  @Override
  public String getActiveLocalAddress() {
    return activeLocalAddress;
  }

  @Override
  public int getActiveLocalPort() {
    return activeLocalPort;
  }

  @Override
  public Integer getIdleTime() {
    return idleTime;
  }

  @Override
  public String getPassiveAddress() {
    return passiveAddress;
  }

  @Override
  public String getPassiveExternalAddress() {
    return passiveExternalAddress;
  }

  @Override
  public String getPassivePorts() {
    return passivePorts;
  }

  @Override
  public SslConfiguration getSslConfiguration() {
    return sslConfiguration;
  }

  @Override
  public Boolean hasActiveEnabled() {
    LOGGER.log(Level.FINE, "Has active enabled");
    return activeEnabled;
  }

  @Override
  public boolean hasActiveIpCheck() {
    LOGGER.log(Level.FINE, "Has active IP check");
    return activeIpCheck;
  }

  @Override
  public boolean hasImplicitSsl() {
    LOGGER.log(Level.FINE, "Has implicit SSL");
    return implicitSsl;
  }

  @Override
  public boolean hasPassiveIpCheck() {
    LOGGER.log(Level.FINE, "Has passive IP check");
    return passiveIpCheck;
  }

  @Override
  public void setActiveEnabled(boolean activeEnabled) {
    LOGGER.log(Level.FINE, "Set active enabled");
    this.activeEnabled = activeEnabled;
  }

  @Override
  public void setActiveIpCheck(boolean activeIpCheck) {
    this.activeIpCheck = activeIpCheck;
  }

  @Override
  public void setActiveLocalAddress(String activeLocalAddress) {
    this.activeLocalAddress = activeLocalAddress;
  }

  @Override
  public void setActiveLocalPort(int activeLocalPort) {
    this.activeLocalPort = activeLocalPort;
  }

  @Override
  public void setIdleTime(int idleTime) {
    LOGGER.log(Level.FINE, "Set idle time");
    this.idleTime = idleTime;
  }

  @Override
  public void setImplicitSsl(boolean implicitSsl) {
    this.implicitSsl = implicitSsl;
  }

  @Override
  public void setPassiveAddress(String passiveAddress) {
    this.passiveAddress = passiveAddress;
  }

  @Override
  public void setPassiveExternalAddress(String passiveExternalAddress) {
    this.passiveExternalAddress = passiveExternalAddress;
  }

  @Override
  public void setPassiveIpCheck(boolean passiveIpCheck) {
    this.passiveIpCheck = passiveIpCheck;
  }

  @Override
  public void setPassivePorts(String passivePorts) {
    this.passivePorts = passivePorts;
  }

  @Override
  public void setSslConfiguration(SslConfiguration sslConfiguration) {
    this.sslConfiguration = sslConfiguration;
  }
}
