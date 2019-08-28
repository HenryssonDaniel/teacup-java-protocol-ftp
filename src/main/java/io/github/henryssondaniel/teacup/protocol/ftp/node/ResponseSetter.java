package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;

interface ResponseSetter
    extends Response,
        Setter<
            io.github.henryssondaniel.teacup.protocol.ftp.client.Response,
            GenericObjectAssert<io.github.henryssondaniel.teacup.protocol.ftp.client.Response, ?>> {
  void setCode(GenericIntegerAssert<?> code);

  void setText(GenericStringAssert<?> text);
}
