package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import io.github.henryssondaniel.teacup.protocol.ftp.SecureClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPSClient;

/**
 * Factory class for the client package.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Factory.class);
  private static final String LOG_SECURE = "Create secure client";

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
   * @param systemKey the system key
   * @return the configuration builder
   * @since 1.0
   */
  public static ConfigurationBuilder createConfigurationBuilder(String systemKey) {
    LOGGER.log(Level.FINE, "Create configuration builder");
    return new ConfigurationBuilderImpl(systemKey);
  }

  /**
   * Creates a new {@link SecureClient}.
   *
   * @param isImplicit whether the client is implicit
   * @return the secure client
   * @since 1.0
   */
  public static SecureClient createSecureClient(boolean isImplicit) {
    LOGGER.log(Level.FINE, LOG_SECURE);
    return new Secure(new FTPSClient(isImplicit));
  }

  /**
   * Creates a new {@link SecureClient}.
   *
   * @param isImplicit whether the client is implicit
   * @param protocol the protocol
   * @return the secure client
   * @since 1.0
   */
  public static SecureClient createSecureClient(boolean isImplicit, String protocol) {
    LOGGER.log(Level.FINE, LOG_SECURE);
    return new Secure(new FTPSClient(protocol, isImplicit));
  }

  /**
   * Creates a new {@link SecureClient}.
   *
   * @param isImplicit whether the client is implicit
   * @param sslContext the SSL context
   * @return the secure client
   * @since 1.0
   */
  public static SecureClient createSecureClient(boolean isImplicit, SSLContext sslContext) {
    LOGGER.log(Level.FINE, LOG_SECURE);
    return new Secure(new FTPSClient(isImplicit, sslContext));
  }
}
