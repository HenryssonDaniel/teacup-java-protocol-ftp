package io.github.henryssondaniel.teacup.protocol.ftp.server;

import java.io.File;

interface SslConfigurationSetter extends SslConfiguration {
  void setClientAuthentication(String clientAuthentication);

  void setEnabledCipherSuites(String... enabledCipherSuites);

  void setKeyAlias(String keyAlias);

  void setKeyPassword(String keyPassword);

  void setKeystoreAlgorithm(String keystoreAlgorithm);

  void setKeystoreFile(File keystoreFile);

  void setKeystorePassword(String keystorePassword);

  void setKeystoreType(String keystoreType);

  void setSslProtocol(String sslProtocol);

  void setTruststoreAlgorithm(String truststoreAlgorithm);

  void setTruststoreFile(File truststoreFile);

  void setTruststorePassword(String truststorePassword);

  void setTruststoreType(String truststoreType);
}
