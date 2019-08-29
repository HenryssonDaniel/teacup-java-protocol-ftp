package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReplyTest {
  private static final int CODE = 1;
  private static final String MESSAGE = "message";

  @Test
  void createReplyBuilder() {
    var reply = Factory.createReplyBuilder(CODE, MESSAGE).build();

    assertThat(reply.getCode()).isEqualTo(CODE);
    assertThat(reply.getMessage()).isEqualTo(MESSAGE);
  }
}
