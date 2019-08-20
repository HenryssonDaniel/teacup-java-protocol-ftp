package io.github.henryssondaniel.teacup.protocol.ftp;

import javax.net.ssl.HostnameVerifier;

/**
 * An FTPS client.
 *
 * @since 1.0
 */
public interface SecureClient extends Client {
  /**
   * Sets whether the endpoint checking is enabled.
   *
   * @param enable whether the endpoint checking is enabled
   * @since 1.0
   */
  void setEndpointCheckingEnabled(boolean enable);

  /**
   * Sets the hostname verifier.
   *
   * @param hostnameVerifier the hostname verifier
   * @since 1.0
   */
  void setHostnameVerifier(HostnameVerifier hostnameVerifier);
}
