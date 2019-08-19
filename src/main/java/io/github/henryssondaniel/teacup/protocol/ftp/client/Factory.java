package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Factory class for {@link Client}.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Factory.class);

  /**
   * Creates a new {@link Client}.
   *
   * @return the client
   * @since 1.0
   */
  public static Client createClient() {
    LOGGER.log(Level.FINE, "Create client");
    return new Simple(new FTPClient());
  }

  /**
   * Creates a new {@link ConfigurationBuilder}.
   *
   * @return the configuration builder
   * @since 1.0
   */
  public static ConfigurationBuilder createConfigurationBuilder(String systemKey) {
    LOGGER.log(Level.FINE, "Create configuration builder");
    return new ConfigurationBuilderImpl(systemKey);
  }
}
