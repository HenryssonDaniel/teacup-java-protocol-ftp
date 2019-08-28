package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResponseBuilderImplTest {
  @Test
  void createImplementation() {
    assertThat(new ReplyBuilderImpl(1, "message").createImplementation())
        .isExactlyInstanceOf(ReplyImpl.class);
  }
}
