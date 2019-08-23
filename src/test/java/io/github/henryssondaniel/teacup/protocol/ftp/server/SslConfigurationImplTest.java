package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.io.File;
import org.junit.jupiter.api.Test;

class SslConfigurationImplTest {
  private final File file = mock(File.class);
  private final SslConfigurationSetter sslConfigurationSetter = new SslConfigurationImpl();

  @Test
  void getClientAuthentication() {
    assertThat(sslConfigurationSetter.getClientAuthentication()).isNull();
  }

  @Test
  void getEnabledCipherSuites() {
    assertThat(sslConfigurationSetter.getEnabledCipherSuites()).isNull();
  }

  @Test
  void getKeyAlias() {
    assertThat(sslConfigurationSetter.getKeyAlias()).isNull();
  }

  @Test
  void getKeyPassword() {
    assertThat(sslConfigurationSetter.getKeyPassword()).isNull();
  }

  @Test
  void getKeystoreAlgorithm() {
    assertThat(sslConfigurationSetter.getKeystoreAlgorithm()).isNull();
  }

  @Test
  void getKeystoreFile() {
    assertThat(sslConfigurationSetter.getKeystoreFile()).isNull();
  }

  @Test
  void getKeystorePassword() {
    assertThat(sslConfigurationSetter.getKeystorePassword()).isNull();
  }

  @Test
  void getKeystoreType() {
    assertThat(sslConfigurationSetter.getKeystoreType()).isNull();
  }

  @Test
  void getSslProtocol() {
    assertThat(sslConfigurationSetter.getSslProtocol()).isNull();
  }

  @Test
  void getTruststoreAlgorithm() {
    assertThat(sslConfigurationSetter.getTruststoreAlgorithm()).isNull();
  }

  @Test
  void getTruststoreFile() {
    assertThat(sslConfigurationSetter.getTruststoreFile()).isNull();
  }

  @Test
  void getTruststorePassword() {
    assertThat(sslConfigurationSetter.getTruststorePassword()).isNull();
  }

  @Test
  void getTruststoreType() {
    assertThat(sslConfigurationSetter.getTruststoreType()).isNull();
  }

  @Test
  void setAndGetClientAuthentication() {
    var clientAuthentication = "clientAuthentication";
    sslConfigurationSetter.setClientAuthentication(clientAuthentication);
    assertThat(sslConfigurationSetter.getClientAuthentication()).isEqualTo(clientAuthentication);
  }

  @Test
  void setAndGetEnabledCipherSuites() {
    var enabledCipherSuites = "enabledCipherSuites";
    sslConfigurationSetter.setEnabledCipherSuites(enabledCipherSuites);
    assertThat(sslConfigurationSetter.getEnabledCipherSuites())
        .containsExactly(enabledCipherSuites);
  }

  @Test
  void setAndGetKeyAlias() {
    var keyAlias = "keyAlias";
    sslConfigurationSetter.setKeyAlias(keyAlias);
    assertThat(sslConfigurationSetter.getKeyAlias()).isEqualTo(keyAlias);
  }

  @Test
  void setAndGetKeyPassword() {
    var keyPassword = "keyPassword";
    sslConfigurationSetter.setKeyPassword(keyPassword);
    assertThat(sslConfigurationSetter.getKeyPassword()).isEqualTo(keyPassword);
  }

  @Test
  void setAndGetKeystoreAlgorithm() {
    var keystoreAlgorithm = "keystoreAlgorithm";
    sslConfigurationSetter.setKeystoreAlgorithm(keystoreAlgorithm);
    assertThat(sslConfigurationSetter.getKeystoreAlgorithm()).isEqualTo(keystoreAlgorithm);
  }

  @Test
  void setAndGetKeystoreFile() {
    sslConfigurationSetter.setKeystoreFile(file);
    assertThat(sslConfigurationSetter.getKeystoreFile()).isSameAs(file);
  }

  @Test
  void setAndGetKeystorePassword() {
    var keystorePassword = "keystorePassword";
    sslConfigurationSetter.setKeystorePassword(keystorePassword);
    assertThat(sslConfigurationSetter.getKeystorePassword()).isEqualTo(keystorePassword);
  }

  @Test
  void setAndGetKeystoreType() {
    var keystoreType = "keystoreType";
    sslConfigurationSetter.setKeystoreType(keystoreType);
    assertThat(sslConfigurationSetter.getKeystoreType()).isEqualTo(keystoreType);
  }

  @Test
  void setAndGetSslProtocol() {
    var sslProtocol = "sslProtocol";
    sslConfigurationSetter.setSslProtocol(sslProtocol);
    assertThat(sslConfigurationSetter.getSslProtocol()).isEqualTo(sslProtocol);
  }

  @Test
  void setAndGetTruststoreAlgorithm() {
    var truststoreAlgorithm = "truststoreAlgorithm";
    sslConfigurationSetter.setTruststoreAlgorithm(truststoreAlgorithm);
    assertThat(sslConfigurationSetter.getTruststoreAlgorithm()).isEqualTo(truststoreAlgorithm);
  }

  @Test
  void setAndGetTruststoreFile() {
    sslConfigurationSetter.setTruststoreFile(file);
    assertThat(sslConfigurationSetter.getTruststoreFile()).isSameAs(file);
  }

  @Test
  void setAndGetTruststorePassword() {
    var truststorePassword = "truststorePassword";
    sslConfigurationSetter.setTruststorePassword(truststorePassword);
    assertThat(sslConfigurationSetter.getTruststorePassword()).isEqualTo(truststorePassword);
  }

  @Test
  void setAndGetTruststoreType() {
    var truststoreType = "truststoreType";
    sslConfigurationSetter.setTruststoreType(truststoreType);
    assertThat(sslConfigurationSetter.getTruststoreType()).isEqualTo(truststoreType);
  }
}
