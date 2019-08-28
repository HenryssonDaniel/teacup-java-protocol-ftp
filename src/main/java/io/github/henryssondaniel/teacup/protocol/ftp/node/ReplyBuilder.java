package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;

/**
 * Reply builder.
 *
 * @since 1.0
 */
public interface ReplyBuilder
    extends NodeBuilder<
        io.github.henryssondaniel.teacup.protocol.ftp.server.Reply, Reply, ReplyBuilder> {
  /**
   * Sets the code.
   *
   * @param code the code
   * @return the response builder
   * @since 1.0
   */
  ReplyBuilder setCode(GenericIntegerAssert<?> code);

  /**
   * Sets the message.
   *
   * @param message the message
   * @return the response builder
   * @since 1.0
   */
  ReplyBuilder setMessage(GenericStringAssert<?> message);
}
