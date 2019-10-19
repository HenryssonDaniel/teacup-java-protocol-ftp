package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.protocol.NodeBuilder;

/**
 * Response builder.
 *
 * @since 1.0
 */
public interface ResponseBuilder
    extends NodeBuilder<
        io.github.henryssondaniel.teacup.protocol.ftp.client.Response, Response, ResponseBuilder> {
  /**
   * Sets the code.
   *
   * @param code the code
   * @return the response builder
   * @since 1.0
   */
  ResponseBuilder setCode(GenericIntegerAssert<?> code);

  /**
   * Sets the text.
   *
   * @param text the text
   * @return the response builder
   * @since 1.0
   */
  ResponseBuilder setText(GenericStringAssert<?> text);
}
