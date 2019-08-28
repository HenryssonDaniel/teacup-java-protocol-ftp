package io.github.henryssondaniel.teacup.protocol.ftp.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ReplyBuilderImplTest {
  @InjectMocks private final ReplyBuilder replyBuilder = new ReplyBuilderImpl();
  @Mock private ReplySetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ReplyBuilderImpl().createImplementation()).isExactlyInstanceOf(ReplyImpl.class);
  }

  @Test
  void setCode() {
    var genericIntegerAssert = mock(GenericIntegerAssert.class);

    assertThat(replyBuilder.setCode(genericIntegerAssert)).isSameAs(replyBuilder);
    verify(implementation).setCode(genericIntegerAssert);
  }

  @Test
  void setMessage() {
    var genericStringAssert = mock(GenericStringAssert.class);

    assertThat(replyBuilder.setMessage(genericStringAssert)).isSameAs(replyBuilder);
    verify(implementation).setMessage(genericStringAssert);
  }
}
