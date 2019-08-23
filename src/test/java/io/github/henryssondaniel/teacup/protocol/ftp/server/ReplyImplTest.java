package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReplyImplTest {
  private static final int CODE = 1;
  private static final String MESSAGE = "message";

  private final Reply reply = new ReplyImpl(CODE, MESSAGE);

  @Test
  void getCode() {
    assertThat(reply.getCode()).isEqualTo(CODE);
  }

  @Test
  void getMessage() {
    assertThat(reply.getMessage()).isEqualTo(MESSAGE);
  }
}
