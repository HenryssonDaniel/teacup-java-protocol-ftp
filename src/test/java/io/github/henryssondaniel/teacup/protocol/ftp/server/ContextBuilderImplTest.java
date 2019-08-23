package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.Test;

class ContextBuilderImplTest {
  @Test
  void createImplementation() {
    var reply = mock(Reply.class);
    assertThat(new ContextBuilderImpl(reply).createImplementation())
        .isExactlyInstanceOf(ContextImpl.class);
    verifyZeroInteractions(reply);
  }
}
