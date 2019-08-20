package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createServer() {
    assertThat(Factory.createServer()).isExactlyInstanceOf(Simple.class);
  }
}
