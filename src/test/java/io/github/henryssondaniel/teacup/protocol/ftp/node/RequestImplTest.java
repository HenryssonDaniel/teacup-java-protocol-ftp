package io.github.henryssondaniel.teacup.protocol.ftp.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Request;
import org.junit.jupiter.api.Test;

class RequestImplTest {
  private final GenericStringAssert<?> genericStringAssert = mock(GenericStringAssert.class);
  private final Request request = mock(Request.class);
  private final RequestSetter requestSetter = new RequestImpl();

  @Test
  void setArgument() {
    requestSetter.setArgument(genericStringAssert);
    requestSetter.verify(request);

    verify(genericStringAssert).verify(request.getArgument());
    verifyNoMoreInteractions(genericStringAssert);

    verify(request, times(2)).getArgument();
    verifyNoMoreInteractions(request);
  }

  @Test
  void setCommand() {
    requestSetter.setCommand(genericStringAssert);
    requestSetter.verify(request);

    verify(genericStringAssert).verify(request.getCommand());
    verifyNoMoreInteractions(genericStringAssert);

    verify(request, times(2)).getCommand();
    verifyNoMoreInteractions(request);
  }

  @Test
  void setReceivedTime() {
    GenericLongAssert<?> genericLongAssert = mock(GenericLongAssert.class);

    requestSetter.setReceivedTime(genericLongAssert);
    requestSetter.verify(request);

    verify(genericLongAssert).verify(request.getReceivedTime());
    verifyNoMoreInteractions(genericLongAssert);

    verify(request, times(2)).getReceivedTime();
    verifyNoMoreInteractions(request);
  }
}
