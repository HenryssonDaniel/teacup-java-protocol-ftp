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

  /**
   * Send the command.
   *
   * @param command the command
   * @return the response
   * @throws IOException If an I/O error occurs while either sending the command or receiving the
   *     server reply.
   * @since 1.0
   */
  Response send(String command) throws IOException;

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
  Response send(String command, String argument) throws IOException;
}
