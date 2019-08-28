package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.client.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseImpl extends SetterImpl<Response, GenericObjectAssert<Response, ?>>
    implements ResponseSetter {
  private static final Logger LOGGER = Factory.getLogger(ResponseImpl.class);

  private GenericObjectAssert<Integer, ?> code;
  private GenericObjectAssert<String, ?> text;

  @Override
  public void setCode(GenericIntegerAssert<?> code) {
    LOGGER.log(Level.FINE, "Set code");
    this.code = code;
  }

  @Override
  public void setText(GenericStringAssert<?> text) {
    LOGGER.log(Level.FINE, "Set text");
    this.text = text;
  }

  @Override
  public void verify(Response response) {
    LOGGER.log(Level.FINE, "Verify");

    if (code != null) code.verify(response.getCode());
    if (text != null) text.verify(response.getText());
  }
}
