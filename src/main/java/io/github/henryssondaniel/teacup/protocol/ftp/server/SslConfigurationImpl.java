package io.github.henryssondaniel.teacup.protocol.ftp.server;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

class SslConfigurationImpl implements SslConfigurationSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(SslConfigurationImpl.class);

  private String clientAuthentication;
  private String[] enabledCipherSuites;
  private String keyAlias;
  private String keyPassword;
  private String keystoreAlgorithm;
  private File keystoreFile;
  private String keystorePassword;
  private String keystoreType;
  private String sslProtocol;
  private String truststoreAlgorithm;
  private File truststoreFile;
  private String truststorePassword;
  private String truststoreType;

  @Override
  public String getClientAuthentication() {
    return clientAuthentication;
  }

  @Override
  public String[] getEnabledCipherSuites() {
    LOGGER.log(Level.FINE, "Get enabled cipher suites");
    return enabledCipherSuites.clone();
  }

  @Override
  public String getKeyAlias() {
    return keyAlias;
  }

  @Override
  public String getKeyPassword() {
    return keyPassword;
  }

  @Override
  public String getKeystoreAlgorithm() {
    return keystoreAlgorithm;
  }

  @Override
  public File getKeystoreFile() {
    return keystoreFile;
  }

  @Override
  public String getKeystorePassword() {
    return keystorePassword;
  }

  @Override
  public String getKeystoreType() {
    return keystoreType;
  }

  @Override
  public String getSslProtocol() {
    return sslProtocol;
  }

  @Override
  public String getTruststoreAlgorithm() {
    return truststoreAlgorithm;
  }

  @Override
  public File getTruststoreFile() {
    return truststoreFile;
  }

  @Override
  public String getTruststorePassword() {
    return truststorePassword;
  }

  @Override
  public String getTruststoreType() {
    return truststoreType;
  }

  @Override
  public void setClientAuthentication(String clientAuthentication) {
    this.clientAuthentication = clientAuthentication;
  }

  @Override
  public void setEnabledCipherSuites(String... enabledCipherSuites) {
    LOGGER.log(Level.FINE, "Set enabled cipher suites");
    this.enabledCipherSuites = enabledCipherSuites.clone();
  }

  @Override
  public void setKeyAlias(String keyAlias) {
    this.keyAlias = keyAlias;
  }

  @Override
  public void setKeyPassword(String keyPassword) {
    this.keyPassword = keyPassword;
  }

  @Override
  public void setKeystoreAlgorithm(String keystoreAlgorithm) {
    this.keystoreAlgorithm = keystoreAlgorithm;
  }

  @Override
  public void setKeystoreFile(File keystoreFile) {
    this.keystoreFile = keystoreFile;
  }

  @Override
  public void setKeystorePassword(String keystorePassword) {
    this.keystorePassword = keystorePassword;
  }

  @Override
  public void setKeystoreType(String keystoreType) {
    this.keystoreType = keystoreType;
  }

  @Override
  public void setSslProtocol(String sslProtocol) {
    this.sslProtocol = sslProtocol;
  }

  @Override
  public void setTruststoreAlgorithm(String truststoreAlgorithm) {
    this.truststoreAlgorithm = truststoreAlgorithm;
  }

  @Override
  public void setTruststoreFile(File truststoreFile) {
    this.truststoreFile = truststoreFile;
  }

  @Override
  public void setTruststorePassword(String truststorePassword) {
    this.truststorePassword = truststorePassword;
  }

  @Override
  public void setTruststoreType(String truststoreType) {
    this.truststoreType = truststoreType;
  }
}
