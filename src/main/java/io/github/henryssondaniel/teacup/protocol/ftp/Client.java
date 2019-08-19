package io.github.henryssondaniel.teacup.protocol.ftp;

import io.github.henryssondaniel.teacup.protocol.ftp.client.Command;
import io.github.henryssondaniel.teacup.protocol.ftp.client.Response;
import java.io.IOException;

/**
 * An FTP client.
 *
 * @since 1.0
 */
public interface Client {
  /**
   * Connect.
   *
   * @param hostname the hostname
   * @throws IOException If the socket could not be opened. In most cases you will only want to
   *     catch IOException since SocketException is derived from it.
   */
  void connect(String hostname) throws IOException;

  /**
   * Connect.
   *
   * @param hostname the hostname
   * @param port the port
   * @throws IOException If the socket could not be opened. In most cases you will only want to
   *     catch IOException since SocketException is derived from it.
   */
  void connect(String hostname, int port) throws IOException;

  /**
   * Disconnect.
   *
   * @throws IOException If an error occurs while disconnecting.
   */
  void disconnect() throws IOException;

  /**
   * Send the command.
   *
   * @param command the command
   * @return the response
   * @throws IOException If an I/O error occurs while either sending the command or receiving the
   *     server reply.
   * @since 1.0
   */
  Response send(Command command) throws IOException;

  /**
   * Send the command with an argument.
   *
   * @param command the command
   * @param argument the argument
   * @return the response
   * @throws IOException If an I/O error occurs while either sending the command or receiving the
   *     server reply.
   * @since 1.0
   */
  Response send(Command command, String argument) throws IOException;
}
