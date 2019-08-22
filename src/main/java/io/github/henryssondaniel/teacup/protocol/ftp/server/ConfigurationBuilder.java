package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.Builder;

/**
 * Configuration builder.
 *
 * @since 1.0
 */
public interface ConfigurationBuilder extends Builder<Configuration> {
  /**
   * Sets the client configuration.
   *
   * @param clientConfiguration the client configuration
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setClientConfiguration(ClientConfiguration clientConfiguration);

  /**
   * Sets the idle timeout.
   *
   * @param idleTimeout the idle timeout
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setIdleTimeout(Integer idleTimeout);

  /**
   * Sets the implicit SSL.
   *
   * @param implicitSsl the implicit SSL
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setImplicitSsl(boolean implicitSsl);

  /**
   * Sets the port.
   *
   * @param port the port
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setPort(Integer port);

  /**
   * Sets the server address.
   *
   * @param serverAddress the server address
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setServerAddress(String serverAddress);

  /**
   * Sets the SSL configuration.
   *
   * @param sslConfiguration the SSL configuration
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setSslConfiguration(SslConfiguration sslConfiguration);
}
