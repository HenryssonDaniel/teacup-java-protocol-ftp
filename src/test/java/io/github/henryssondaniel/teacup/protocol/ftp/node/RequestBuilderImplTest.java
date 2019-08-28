package io.github.henryssondaniel.teacup.protocol.ftp.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RequestBuilderImplTest {
  private final GenericStringAssert<?> genericStringAssert = mock(GenericStringAssert.class);
  @InjectMocks private final RequestBuilder requestBuilder = new RequestBuilderImpl();

  @Mock private RequestSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new RequestBuilderImpl().createImplementation())
        .isExactlyInstanceOf(RequestImpl.class);
  }

  @Test
  void setArgument() {
    assertThat(requestBuilder.setArgument(genericStringAssert)).isSameAs(requestBuilder);
    verify(implementation).setArgument(genericStringAssert);
  }

  @Test
  void setCommand() {
    assertThat(requestBuilder.setCommand(genericStringAssert)).isSameAs(requestBuilder);
    verify(implementation).setCommand(genericStringAssert);
  }

  @Test
  void setText() {
    var genericLongAssert = mock(GenericLongAssert.class);
    assertThat(requestBuilder.setReceivedTime(genericLongAssert)).isSameAs(requestBuilder);
    verify(implementation).setReceivedTime(genericLongAssert);
  }
}
