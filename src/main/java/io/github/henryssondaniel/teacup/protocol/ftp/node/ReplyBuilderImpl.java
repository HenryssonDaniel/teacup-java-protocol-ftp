package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Reply;
import java.util.logging.Level;
import java.util.logging.Logger;

class ReplyBuilderImpl
    extends BuilderImpl<
        Reply, io.github.henryssondaniel.teacup.protocol.ftp.node.Reply, ReplySetter, ReplyBuilder>
    implements ReplyBuilder {
  private static final Logger LOGGER = Factory.getLogger(ReplyBuilderImpl.class);

  ReplyBuilderImpl() {
    super(new ReplyImpl());
  }

  @Override
  public ReplyBuilder setCode(GenericIntegerAssert<?> code) {
    LOGGER.log(Level.FINE, "Set code");
    getImplementation().setCode(code);
    return this;
  }

  @Override
  public ReplyBuilder setMessage(GenericStringAssert<?> message) {
    LOGGER.log(Level.FINE, "Set message");
    getImplementation().setMessage(message);
    return this;
  }

  @Override
  protected ReplySetter createImplementation() {
    return new ReplyImpl();
  }
}
