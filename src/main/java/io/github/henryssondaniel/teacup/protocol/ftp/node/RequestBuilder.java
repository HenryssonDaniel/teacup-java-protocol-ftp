package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.protocol.NodeBuilder;

/**
 * Request builder.
 *
 * @since 1.0
 */
public interface RequestBuilder
    extends NodeBuilder<
        io.github.henryssondaniel.teacup.protocol.ftp.server.Request, Request, RequestBuilder> {
  /**
   * Sets the argument.
   *
   * @param argument the argument
   * @return the request builder
   * @since 1.0
   */
  RequestBuilder setArgument(GenericStringAssert<?> argument);

  /**
   * Sets the command.
   *
   * @param command the command
   * @return the request builder
   * @since 1.0
   */
  RequestBuilder setCommand(GenericStringAssert<?> command);

  /**
   * Sets the received time.
   *
   * @param receivedTime the received time
   * @return the response builder
   * @since 1.0
   */
  RequestBuilder setReceivedTime(GenericLongAssert<?> receivedTime);
}
