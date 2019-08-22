package io.github.henryssondaniel.teacup.protocol.ftp.server;

interface ClientConfigurationSetter extends ClientConfiguration {
  void setActiveEnabled(boolean activeEnabled);

  void setActiveIpCheck(boolean activeIpCheck);

  void setActiveLocalAddress(String activeLocalAddress);

  void setActiveLocalPort(int activeLocalPort);

  void setIdleTime(int idleTime);

  void setImplicitSsl(boolean implicitSsl);

  void setPassiveAddress(String passiveAddress);

  void setPassiveExternalAddress(String passiveExternalAddress);

  void setPassiveIpCheck(boolean passiveIpCheck);

  void setPassivePorts(String passivePorts);

  void setSslConfiguration(SslConfiguration sslConfiguration);
}
