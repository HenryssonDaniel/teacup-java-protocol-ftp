package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResponseImplTest {
  private static final int CODE = 100;
  private static final String TEXT = "text";

  private final Response response = new ResponseImpl(CODE, TEXT);

  @Test
  void getCode() {
    assertThat(response.getCode()).isSameAs(CODE);
  }

  @Test
  void getText() {
    assertThat(response.getText()).isEqualTo(TEXT);
  }
}
