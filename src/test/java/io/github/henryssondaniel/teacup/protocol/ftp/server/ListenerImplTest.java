package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.lang.reflect.Field;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.junit.jupiter.api.Test;

class ListenerImplTest {
  private final Handler handler = mock(Handler.class);
  private final ListenerFactory listenerFactory = mock(ListenerFactory.class);

  @Test
  void isStopped() throws IllegalAccessException, NoSuchFieldException {
    Listener listener = new ListenerImpl(handler, listenerFactory, "handler");
    assertThat(listener.isStopped()).isTrue();

    verifyParameters();

    var field = getField(listener);
    assertThat(field.get(listener)).isSameAs(handler);

    field.set(listener, null);

    assertThat(listener.isStopped()).isTrue();
    assertThat(field.get(listener)).isNull();
  }

  @Test
  void isStoppedWhenFieldNotExist() throws IllegalAccessException, NoSuchFieldException {
    Listener listener = new ListenerImpl(handler, listenerFactory, "noExisting");
    assertThat(listener.isStopped()).isTrue();

    verifyParameters();
    assertThat(getField(listener).get(listener)).isNotSameAs(handler);
  }

  private static Field getField(Listener listener) throws NoSuchFieldException {
    var field = listener.getClass().getSuperclass().getDeclaredField("handler");
    field.setAccessible(true);

    return field;
  }

  private void verifyParameters() {
    verifyZeroInteractions(handler);

    verify(listenerFactory).getDataConnectionConfiguration();
    verify(listenerFactory).getIdleTimeout();
    verify(listenerFactory).getPort();
    verify(listenerFactory).getServerAddress();
    verify(listenerFactory).getSessionFilter();
    verify(listenerFactory).getSslConfiguration();
    verify(listenerFactory).isImplicitSsl();
    verifyNoMoreInteractions(listenerFactory);
  }
}
