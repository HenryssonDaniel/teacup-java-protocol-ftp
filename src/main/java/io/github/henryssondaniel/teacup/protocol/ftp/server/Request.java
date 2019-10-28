package io.github.henryssondaniel.teacup.protocol.ftp.server;

/**
 * An incoming request to the server.
 *
 * @since 1.0
 */
public interface Request {
  /**
   * Returns the argument.
   *
   * @return the argument
   * @since 1.0
   */
  String getArgument();

  /**
   * Returns the command.
   *
   * @return the command
   * @since 1.0
   */
  String getCommand();

  /**
   * Returns the received time.
   *
   * @return the received time
   * @since 1.0
   */
  long getReceivedTime();
}
