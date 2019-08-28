package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseBuilderImpl
    extends BuilderImpl<
        io.github.henryssondaniel.teacup.protocol.ftp.client.Response,
        Response,
        ResponseSetter,
        ResponseBuilder>
    implements ResponseBuilder {
  private static final Logger LOGGER = Factory.getLogger(ResponseBuilderImpl.class);

  ResponseBuilderImpl() {
    super(new ResponseImpl());
  }

  @Override
  public ResponseBuilder setCode(GenericIntegerAssert<?> code) {
    LOGGER.log(Level.FINE, "Set code");
    getImplementation().setCode(code);
    return this;
  }

  @Override
  public ResponseBuilder setText(GenericStringAssert<?> text) {
    LOGGER.log(Level.FINE, "Set text");
    getImplementation().setText(text);
    return this;
  }

  @Override
  protected ResponseSetter createImplementation() {
    return new ResponseImpl();
  }
}
