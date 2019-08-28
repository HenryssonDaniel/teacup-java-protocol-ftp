package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;

interface ReplySetter
    extends Reply,
        Setter<
            io.github.henryssondaniel.teacup.protocol.ftp.server.Reply,
            GenericObjectAssert<io.github.henryssondaniel.teacup.protocol.ftp.server.Reply, ?>> {
  void setCode(GenericIntegerAssert<?> code);

  void setMessage(GenericStringAssert<?> message);
}
