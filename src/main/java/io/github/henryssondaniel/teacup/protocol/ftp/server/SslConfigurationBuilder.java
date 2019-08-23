package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.Builder;
import java.io.File;

public interface SslConfigurationBuilder extends Builder<SslConfiguration> {
  SslConfigurationBuilder setClientAuthentication(String clientAuthentication);

  SslConfigurationBuilder setEnabledCipherSuites(String... enabledCipherSuites);

  SslConfigurationBuilder setKeyAlias(String keyAlias);

  SslConfigurationBuilder setKeyPassword(String keyPassword);

  SslConfigurationBuilder setKeystoreAlgorithm(String keystoreAlgorithm);

  SslConfigurationBuilder setKeystoreFile(File keystoreFile);

  SslConfigurationBuilder setKeystorePassword(String keystorePassword);

  SslConfigurationBuilder setKeystoreType(String keystoreType);

  SslConfigurationBuilder setSslProtocol(String sslProtocol);

  SslConfigurationBuilder setTruststoreAlgorithm(String truststoreAlgorithm);

  SslConfigurationBuilder setTruststoreFile(File truststoreFile);

  SslConfigurationBuilder setTruststorePassword(String truststorePassword);

  SslConfigurationBuilder setTruststoreType(String truststoreType);
}
