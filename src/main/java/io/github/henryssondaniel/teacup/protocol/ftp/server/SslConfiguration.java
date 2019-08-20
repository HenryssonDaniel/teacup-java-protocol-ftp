package io.github.henryssondaniel.teacup.protocol.ftp.server;

import java.io.File;

/**
 * SSL configuration.
 *
 * @since 1.0
 */
public interface SslConfiguration {
  /**
   * Returns the client authentication.
   *
   * @return the client authentication
   * @since 1.0
   */
  String getClientAuthentication();

  /**
   * Returns the enabled cipher suites.
   *
   * @return the enabled cipher suites
   * @since 1.0
   */
  String[] getEnabledCipherSuites();

  /**
   * Returns the key alias.
   *
   * @return the key alias
   * @since 1.0
   */
  String getKeyAlias();

  /**
   * Returns the key password.
   *
   * @return the key password
   * @since 1.0
   */
  String getKeyPassword();

  /**
   * Returns the keystore algorithm.
   *
   * @return the keystore algorithm
   * @since 1.0
   */
  String getKeystoreAlgorithm();

  /**
   * Returns the keystore file.
   *
   * @return the keystore file
   * @since 1.0
   */
  File getKeystoreFile();

  /**
   * Returns the keystore password.
   *
   * @return the keystore password
   * @since 1.0
   */
  String getKeystorePassword();

  /**
   * Returns the keystore type.
   *
   * @return the keystore type
   * @since 1.0
   */
  String getKeystoreType();

  /**
   * Returns the SSL protocol.
   *
   * @return the SSL protocol
   * @since 1.0
   */
  String getSslProtocol();

  /**
   * Returns the truststore algorithm.
   *
   * @return the truststore algorithm
   * @since 1.0
   */
  String getTruststoreAlgorithm();

  /**
   * Returns the truststore file.
   *
   * @return the truststore file
   * @since 1.0
   */
  File getTruststoreFile();

  /**
   * Returns the truststore password.
   *
   * @return the truststore password
   * @since 1.0
   */
  String getTruststorePassword();

  /**
   * Returns the truststore type.
   *
   * @return the truststore type
   * @since 1.0
   */
  String getTruststoreType();
}
