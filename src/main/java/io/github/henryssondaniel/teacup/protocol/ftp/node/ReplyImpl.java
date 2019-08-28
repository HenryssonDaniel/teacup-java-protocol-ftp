package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Reply;
import java.util.logging.Level;
import java.util.logging.Logger;

class ReplyImpl extends SetterImpl<Reply, GenericObjectAssert<Reply, ?>> implements ReplySetter {
  private static final Logger LOGGER = Factory.getLogger(ReplyImpl.class);

  private GenericObjectAssert<Integer, ?> code;
  private GenericObjectAssert<String, ?> message;

  @Override
  public void setCode(GenericIntegerAssert<?> code) {
    LOGGER.log(Level.FINE, "Set code");
    this.code = code;
  }

  @Override
  public void setMessage(GenericStringAssert<?> message) {
    LOGGER.log(Level.FINE, "Set message");
    this.message = message;
  }

  @Override
  public void verify(Reply reply) {
    LOGGER.log(Level.FINE, "Verify");

    if (code != null) code.verify(reply.getCode());
    if (message != null) message.verify(reply.getMessage());
  }
}
