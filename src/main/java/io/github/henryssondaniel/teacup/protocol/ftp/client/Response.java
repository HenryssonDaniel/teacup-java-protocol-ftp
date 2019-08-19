package io.github.henryssondaniel.teacup.protocol.ftp.client;

/**
 * Response.
 *
 * @since 1.0
 */
public interface Response {
  /**
   * Returns the code.
   *
   * @return the code
   * @since 1.0
   */
  int getCode();

  /**
   * Returns the text.
   *
   * @return the text
   * @since 1.0
   */
  String getText();
}
