package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createClient() {
    assertThat(Factory.createClient()).isExactlyInstanceOf(Simple.class);
  }
}
