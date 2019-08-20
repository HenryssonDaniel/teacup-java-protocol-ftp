package io.github.henryssondaniel.teacup.protocol.ftp.server;

/**
 * Client configuration.
 *
 * @since 1.0
 */
public interface ClientConfiguration {
  /**
   * Returns the active local address.
   *
   * @return the active local address
   * @since 1.0
   */
  String getActiveLocalAddress();

  /**
   * Returns the active local port.
   *
   * @return the active local port
   * @since 1.0
   */
  int getActiveLocalPort();

  /**
   * Returns the idle time.
   *
   * @return the idle time
   * @since 1.0
   */
  Integer getIdleTime();

  /**
   * Returns the passive address.
   *
   * @return the passive address
   * @since 1.0
   */
  String getPassiveAddress();

  /**
   * Returns the passive external address.
   *
   * @return the passive external address
   * @since 1.0
   */
  String getPassiveExternalAddress();

  /**
   * Returns the passive ports.
   *
   * @return the passive ports
   * @since 1.0
   */
  String getPassivePorts();

  /**
   * Returns the SSL configuration.
   *
   * @return the SSL configuration
   * @since 1.0
   */
  SslConfiguration getSslConfiguration();

  /**
   * Returns whether active enabled.
   *
   * @return whether active enabled
   * @since 1.0
   */
  Boolean hasActiveEnabled();

  /**
   * Returns whether active IP check.
   *
   * @return whether active IP check
   * @since 1.0
   */
  boolean hasActiveIpCheck();

  /**
   * Returns whether implicit SSL.
   *
   * @return whether implicit SSL
   * @since 1.0
   */
  boolean hasImplicitSsl();

  /**
   * Returns whether passive IP check.
   *
   * @return whether passive IP check
   * @since 1.0
   */
  boolean hasPassiveIpCheck();
}
