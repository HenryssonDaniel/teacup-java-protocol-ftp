package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RequestImplTest {
  private static final String ARGUMENT = "argument";
  private static final String COMMAND = "command";
  private static final long RECEIVED_TIME = 1L;

  private final Request request = new RequestImpl(ARGUMENT, COMMAND, RECEIVED_TIME);

  @Test
  void getArgument() {
    assertThat(request.getArgument()).isEqualTo(ARGUMENT);
  }

  @Test
  void getCommand() {
    assertThat(request.getCommand()).isEqualTo(COMMAND);
  }

  @Test
  void getReceivedTime() {
    assertThat(request.getReceivedTime()).isEqualTo(RECEIVED_TIME);
  }
}
