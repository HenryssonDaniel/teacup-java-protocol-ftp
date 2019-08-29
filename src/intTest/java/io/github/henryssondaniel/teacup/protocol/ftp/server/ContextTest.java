package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ContextTest {
  private static final Reply REPLY = Factory.createReplyBuilder(1, "message").build();

  @Test
  void createContextBuilder() {
    assertThat(Factory.createContextBuilder(REPLY).build().getReply()).isEqualTo(REPLY);
  }
}
