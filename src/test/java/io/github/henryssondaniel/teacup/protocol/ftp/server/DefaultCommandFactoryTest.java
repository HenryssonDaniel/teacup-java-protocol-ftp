package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DefaultCommandFactoryTest {
  @Test
  void getCommand() {
    assertThat(new DefaultCommandFactory().getCommand("command"))
        .isExactlyInstanceOf(DefaultCommand.class);
  }
}
