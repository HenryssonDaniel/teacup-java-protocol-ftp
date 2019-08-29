package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.protocol.ftp.client.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

class ResponseTest {
  private static final int CODE = 200;
  private static final String TEXT = "command";

  @Test
  void createResponseBuilder() {
    Factory.createResponseBuilder()
        .setCode(
            io.github.henryssondaniel.teacup.core.assertion.Factory.createIntegerAssert()
                .isEqualTo(CODE))
        .setText(
            io.github.henryssondaniel.teacup.core.assertion.Factory.createStringAssert()
                .isEqualTo(TEXT))
        .build()
        .verify(new TestResponse());
  }

  private static class TestResponse implements Response {
    private static final Logger LOGGER =
        io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(TestResponse.class);

    @Override
    public int getCode() {
      LOGGER.log(Level.FINE, "Get code");
      return CODE;
    }

    @Override
    public String getText() {
      LOGGER.log(Level.FINE, "Get text");
      return TEXT;
    }
  }
}
