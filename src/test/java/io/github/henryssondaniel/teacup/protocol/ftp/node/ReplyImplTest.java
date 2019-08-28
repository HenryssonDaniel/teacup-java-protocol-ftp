package io.github.henryssondaniel.teacup.protocol.ftp.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Reply;
import org.junit.jupiter.api.Test;

class ReplyImplTest {
  private final Reply reply = mock(Reply.class);
  private final ReplySetter replySetter = new ReplyImpl();

  @Test
  void getMessage() {
    GenericStringAssert<?> genericStringAssert = mock(GenericStringAssert.class);

    replySetter.setMessage(genericStringAssert);
    replySetter.verify(reply);

    verify(genericStringAssert).verify(reply.getMessage());
    verifyNoMoreInteractions(genericStringAssert);

    verify(reply, times(2)).getMessage();
    verifyNoMoreInteractions(reply);
  }

  @Test
  void setCode() {
    GenericIntegerAssert<?> genericIntegerAssert = mock(GenericIntegerAssert.class);

    replySetter.setCode(genericIntegerAssert);
    replySetter.verify(reply);

    verify(genericIntegerAssert).verify(reply.getCode());
    verifyNoMoreInteractions(genericIntegerAssert);

    verify(reply, times(2)).getCode();
    verifyNoMoreInteractions(reply);
  }
}
