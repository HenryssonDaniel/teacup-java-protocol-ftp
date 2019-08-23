package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.Test;

class ListenerFactoryImplTest {
  @Test
  void createListener() {
    var handler = mock(Handler.class);
    assertThat(new ListenerFactoryImpl(handler).createListener())
        .isExactlyInstanceOf(ListenerImpl.class);
    verifyZeroInteractions(handler);
  }
}
