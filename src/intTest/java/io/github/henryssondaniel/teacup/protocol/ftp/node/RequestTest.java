package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.protocol.ftp.server.Request;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

class RequestTest {
  private static final String ARGUMENT = "argument";
  private static final String COMMAND = "command";
  private static final long TIME = Date.from(Instant.now()).getTime();

  @Test
  void createRequestBuilder() {
    Request request = new TestRequest();

    Factory.createRequestBuilder()
        .setArgument(
            io.github.henryssondaniel.teacup.core.assertion.Factory.createStringAssert()
                .isEqualTo(ARGUMENT))
        .setAssertion(
            io.github.henryssondaniel.teacup.core.assertion.Factory.<Request>createObjectAssert()
                .isSameAs(request))
        .setCommand(
            io.github.henryssondaniel.teacup.core.assertion.Factory.createStringAssert()
                .isEqualTo(COMMAND))
        .setReceivedTime(
            io.github.henryssondaniel.teacup.core.assertion.Factory.createLongAssert()
                .isEqualTo(TIME))
        .build()
        .verify(request);
  }

  private static class TestRequest implements Request {
    private static final Logger LOGGER =
        io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(TestRequest.class);

    @Override
    public String getArgument() {
      LOGGER.log(Level.FINE, "Get argument");
      return ARGUMENT;
    }

    @Override
    public String getCommand() {
      LOGGER.log(Level.FINE, "Get command");
      return COMMAND;
    }

    @Override
    public long getReceivedTime() {
      LOGGER.log(Level.FINE, "Get received time");
      return TIME;
    }
  }
}
