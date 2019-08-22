package io.github.henryssondaniel.teacup.protocol.ftp.server;

/**
 * An outgoing reply from the server.
 *
 * @since 1.0
 */
public interface Reply {
  /**
   * Returns the code.
   *
   * @return the code
   * @since 1.0
   */
  int getCode();

  /**
   * Returns the message.
   *
   * @return the message
   * @since 1.0
   */
  String getMessage();
}
