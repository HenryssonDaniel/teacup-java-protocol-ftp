package io.github.henryssondaniel.teacup.protocol.ftp.server;

/**
 * Configuration.
 *
 * @since 1.0
 */
public interface Configuration {
  /**
   * Returns the client configuration.
   *
   * @return the client configuration
   * @since 1.0
   */
  ClientConfiguration getClientConfiguration();

  /**
   * Returns the idle timeout.
   *
   * @return the idle timeout
   * @since 1.0
   */
  Integer getIdleTimeout();

  /**
   * Returns the port.
   *
   * @return the port
   * @since 1.0
   */
  Integer getPort();

  /**
   * Returns the server address.
   *
   * @return the server address
   * @since 1.0
   */
  String getServerAddress();

  /**
   * Returns the SSL configuration.
   *
   * @return the SSL configuration
   * @since 1.0
   */
  SslConfiguration getSslConfiguration();

  /**
   * Returns whether implicit SSL.
   *
   * @return whether implicit SSL
   * @since 1.0
   */
  boolean hasImplicitSsl();
}
