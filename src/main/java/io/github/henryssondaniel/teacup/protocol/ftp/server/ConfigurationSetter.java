package io.github.henryssondaniel.teacup.protocol.ftp.server;

interface ConfigurationSetter extends Configuration {
  void setClientConfiguration(ClientConfiguration clientConfiguration);

  void setIdleTimeout(Integer idleTimeout);

  void setImplicitSsl(boolean implicitSsl);

  void setPort(Integer port);

  void setServerAddress(String serverAddress);

  void setSslConfiguration(SslConfiguration sslConfiguration);
}
