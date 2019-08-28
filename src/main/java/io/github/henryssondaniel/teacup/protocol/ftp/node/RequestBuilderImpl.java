package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

class RequestBuilderImpl
    extends BuilderImpl<
        io.github.henryssondaniel.teacup.protocol.ftp.server.Request,
        Request,
        RequestSetter,
        RequestBuilder>
    implements RequestBuilder {
  private static final Logger LOGGER = Factory.getLogger(RequestBuilderImpl.class);

  RequestBuilderImpl() {
    super(new RequestImpl());
  }

  @Override
  public RequestBuilder setArgument(GenericStringAssert<?> argument) {
    LOGGER.log(Level.FINE, "Set argument");
    getImplementation().setArgument(argument);
    return this;
  }

  @Override
  public RequestBuilder setCommand(GenericStringAssert<?> command) {
    LOGGER.log(Level.FINE, "Set command");
    getImplementation().setCommand(command);
    return this;
  }

  @Override
  public RequestBuilder setReceivedTime(GenericLongAssert<?> receivedTime) {
    LOGGER.log(Level.FINE, "Set received time");
    getImplementation().setReceivedTime(receivedTime);
    return this;
  }

  @Override
  protected RequestSetter createImplementation() {
    return new RequestImpl();
  }
}
