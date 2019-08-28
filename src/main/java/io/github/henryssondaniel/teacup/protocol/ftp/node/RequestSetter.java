package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;

interface RequestSetter
    extends Request,
        Setter<
            io.github.henryssondaniel.teacup.protocol.ftp.server.Request,
            GenericObjectAssert<io.github.henryssondaniel.teacup.protocol.ftp.server.Request, ?>> {
  void setArgument(GenericStringAssert<?> argument);

  void setCommand(GenericStringAssert<?> command);

  void setReceivedTime(GenericLongAssert<?> receivedTime);
}
