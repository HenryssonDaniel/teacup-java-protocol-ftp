package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.DefaultBuilder;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

class SslConfigurationBuilderImpl extends DefaultBuilder<SslConfiguration, SslConfigurationSetter>
    implements SslConfigurationBuilder {
  private static final Logger LOGGER = Factory.getLogger(SslConfigurationBuilderImpl.class);

  SslConfigurationBuilderImpl() {
    super(new SslConfigurationImpl());
  }

  @Override
  public SslConfigurationBuilder setClientAuthentication(String clientAuthentication) {
    LOGGER.log(Level.FINE, "Set client authentication");
    getImplementation().setClientAuthentication(clientAuthentication);
    return this;
  }

  @Override
  public SslConfigurationBuilder setEnabledCipherSuites(String... enabledCipherSuites) {
    LOGGER.log(Level.FINE, "Set enabled cipher suites");
    getImplementation().setEnabledCipherSuites(enabledCipherSuites);
    return this;
  }

  @Override
  public SslConfigurationBuilder setKeyAlias(String keyAlias) {
    LOGGER.log(Level.FINE, "Set key alias");
    getImplementation().setKeyAlias(keyAlias);
    return this;
  }

  @Override
  public SslConfigurationBuilder setKeyPassword(String keyPassword) {
    LOGGER.log(Level.FINE, "Set key password");
    getImplementation().setKeyPassword(keyPassword);
    return this;
  }

  @Override
  public SslConfigurationBuilder setKeystoreAlgorithm(String keystoreAlgorithm) {
    LOGGER.log(Level.FINE, "Set keystore algorithm");
    getImplementation().setKeystoreAlgorithm(keystoreAlgorithm);
    return this;
  }

  @Override
  public SslConfigurationBuilder setKeystoreFile(File keystoreFile) {
    LOGGER.log(Level.FINE, "Set keystore file");
    getImplementation().setKeystoreFile(keystoreFile);
    return this;
  }

  @Override
  public SslConfigurationBuilder setKeystorePassword(String keystorePassword) {
    LOGGER.log(Level.FINE, "Set keystore password");
    getImplementation().setKeystorePassword(keystorePassword);
    return this;
  }

  @Override
  public SslConfigurationBuilder setKeystoreType(String keystoreType) {
    LOGGER.log(Level.FINE, "Set keystore type");
    getImplementation().setKeystoreType(keystoreType);
    return this;
  }

  @Override
  public SslConfigurationBuilder setSslProtocol(String sslProtocol) {
    LOGGER.log(Level.FINE, "Set SSL protocol");
    getImplementation().setSslProtocol(sslProtocol);
    return this;
  }

  @Override
  public SslConfigurationBuilder setTruststoreAlgorithm(String truststoreAlgorithm) {
    LOGGER.log(Level.FINE, "Set truststore algorithm");
    getImplementation().setTruststoreAlgorithm(truststoreAlgorithm);
    return this;
  }

  @Override
  public SslConfigurationBuilder setTruststoreFile(File truststoreFile) {
    LOGGER.log(Level.FINE, "Set truststore file");
    getImplementation().setTruststoreFile(truststoreFile);
    return this;
  }

  @Override
  public SslConfigurationBuilder setTruststorePassword(String truststorePassword) {
    LOGGER.log(Level.FINE, "Set truststore password");
    getImplementation().setTruststorePassword(truststorePassword);
    return this;
  }

  @Override
  public SslConfigurationBuilder setTruststoreType(String truststoreType) {
    LOGGER.log(Level.FINE, "Set truststore type");
    getImplementation().setTruststoreType(truststoreType);
    return this;
  }

  @Override
  protected SslConfigurationSetter createImplementation() {
    return new SslConfigurationImpl();
  }
}
