package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.Builder;
import java.io.File;

/**
 * SSL configuration builder.
 *
 * @since 1.0
 */
public interface SslConfigurationBuilder extends Builder<SslConfiguration> {
  /**
   * Sets the client authentication.
   *
   * @param clientAuthentication the client authentication
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setClientAuthentication(String clientAuthentication);

  /**
   * Sets the enabled cipher suites.
   *
   * @param enabledCipherSuites the enabled cipher suites
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setEnabledCipherSuites(String... enabledCipherSuites);

  /**
   * Sets the key alias.
   *
   * @param keyAlias the key alias
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setKeyAlias(String keyAlias);

  /**
   * Sets the key password.
   *
   * @param keyPassword the key password
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setKeyPassword(String keyPassword);

  /**
   * Sets the keystore algorithm.
   *
   * @param keystoreAlgorithm the keystore algorithm
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setKeystoreAlgorithm(String keystoreAlgorithm);

  /**
   * Sets the keystore file.
   *
   * @param keystoreFile the keystore file
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setKeystoreFile(File keystoreFile);

  /**
   * Sets the keystore password.
   *
   * @param keystorePassword the keystore password
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setKeystorePassword(String keystorePassword);

  /**
   * Sets the keystore type.
   *
   * @param keystoreType the keystore type
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setKeystoreType(String keystoreType);

  /**
   * Sets the SSL protocol.
   *
   * @param sslProtocol the SSL protocol
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setSslProtocol(String sslProtocol);

  /**
   * Sets the truststore algorithm.
   *
   * @param truststoreAlgorithm the truststore algorithm
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setTruststoreAlgorithm(String truststoreAlgorithm);

  /**
   * Sets the truststore file.
   *
   * @param truststoreFile the truststore file
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setTruststoreFile(File truststoreFile);

  /**
   * Sets the truststore password.
   *
   * @param truststorePassword the truststore password
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setTruststorePassword(String truststorePassword);

  /**
   * Sets the truststore type.
   *
   * @param truststoreType the truststore type
   * @return the SSL configuration builder
   * @since 1.0
   */
  SslConfigurationBuilder setTruststoreType(String truststoreType);
}
