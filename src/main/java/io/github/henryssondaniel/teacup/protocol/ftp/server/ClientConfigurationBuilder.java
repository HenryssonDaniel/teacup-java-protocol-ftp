package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.protocol.Builder;

/**
 * Client configuration builder.
 *
 * @since 1.0
 */
public interface ClientConfigurationBuilder extends Builder<ClientConfiguration> {
  /**
   * Sets the active enabled.
   *
   * @param activeEnabled the active enabled
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setActiveEnabled(boolean activeEnabled);

  /**
   * Sets the active IP check.
   *
   * @param activeIpCheck the active IP check
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setActiveIpCheck(boolean activeIpCheck);

  /**
   * Sets the active local address.
   *
   * @param activeLocalAddress the active local address
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setActiveLocalAddress(String activeLocalAddress);

  /**
   * Sets the active local port.
   *
   * @param activeLocalPort the active local port
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setActiveLocalPort(int activeLocalPort);

  /**
   * Sets the idle time.
   *
   * @param idleTime the idle time
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setIdleTime(int idleTime);

  /**
   * Sets the implicit SSL.
   *
   * @param implicitSsl the implicit SSL
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setImplicitSsl(boolean implicitSsl);

  /**
   * Sets the passive address.
   *
   * @param passiveAddress the passive address
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setPassiveAddress(String passiveAddress);

  /**
   * Sets the passive external address.
   *
   * @param passiveExternalAddress the passive external address
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setPassiveExternalAddress(String passiveExternalAddress);

  /**
   * Sets the passive UP check.
   *
   * @param passiveIpCheck the passive UP check
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setPassiveIpCheck(boolean passiveIpCheck);

  /**
   * Sets the passive ports.
   *
   * @param passivePorts the passive ports
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setPassivePorts(String passivePorts);

  /**
   * Sets the SSL configuration.
   *
   * @param sslConfiguration the SSL configuration
   * @return the client configuration builder
   * @since 1.0
   */
  ClientConfigurationBuilder setSslConfiguration(SslConfiguration sslConfiguration);
}
