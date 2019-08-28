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

class ResponseBuilderImplTest {
  @InjectMocks private final ResponseBuilder responseBuilder = new ResponseBuilderImpl();
  @Mock private ResponseSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ResponseBuilderImpl().createImplementation())
        .isExactlyInstanceOf(ResponseImpl.class);
  }

  @Test
  void setCode() {
    var genericIntegerAssert = mock(GenericIntegerAssert.class);

    assertThat(responseBuilder.setCode(genericIntegerAssert)).isSameAs(responseBuilder);
    verify(implementation).setCode(genericIntegerAssert);
  }

  @Test
  void setText() {
    var genericStringAssert = mock(GenericStringAssert.class);

    assertThat(responseBuilder.setText(genericStringAssert)).isSameAs(responseBuilder);
    verify(implementation).setText(genericStringAssert);
  }
}
