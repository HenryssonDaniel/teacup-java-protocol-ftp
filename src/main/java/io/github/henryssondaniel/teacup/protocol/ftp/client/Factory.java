package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Factory class for {@link Client}.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  /**
   * Creates a new {@link Client}.
   *
   * @return the client
   * @since 1.0
   */
  public static Client createClient() {
    return new Simple(new FTPClient());
  }
}
