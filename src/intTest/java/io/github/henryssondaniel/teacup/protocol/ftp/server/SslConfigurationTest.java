package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import org.junit.jupiter.api.Test;

class SslConfigurationTest {
  private static final String CLIENT_AUTHENTICATION = "clientAuthentication";
  private static final String ENABLED_CIPHER_SUITE = "enabledCipherSuite";
  private static final String KEYSTORE_ALGORITHM = "keystoreAlgorithm";
  private static final File KEYSTORE_FILE = new File("test");
  private static final String KEYSTORE_PASSWORD = "keystorePassword";
  private static final String KEYSTORE_TYPE = "keystoreType";
  private static final String KEY_ALIAS = "keyAlias";
  private static final String KEY_PASSWORD = "keyPassword";
  private static final String SSL_PROTOCOL = "sslProtocol";
  private static final String TRUSTSTORE_ALGORITHM = "truststoreAlgorithm";
  private static final File TRUSTSTORE_FILE = new File("test");
  private static final String TRUSTSTORE_PASSWORD = "truststorePassword";
  private static final String TRUSTSTORE_TYPE = "truststoreType";

  @Test
  void createSslConfigurationBuilder() {
    var sslConfiguration =
        Factory.createSslConfigurationBuilder()
            .setClientAuthentication(CLIENT_AUTHENTICATION)
            .setEnabledCipherSuites(ENABLED_CIPHER_SUITE)
            .setKeyAlias(KEY_ALIAS)
            .setKeyPassword(KEY_PASSWORD)
            .setKeystoreAlgorithm(KEYSTORE_ALGORITHM)
            .setKeystoreFile(KEYSTORE_FILE)
            .setKeystorePassword(KEYSTORE_PASSWORD)
            .setKeystoreType(KEYSTORE_TYPE)
            .setSslProtocol(SSL_PROTOCOL)
            .setTruststoreAlgorithm(TRUSTSTORE_ALGORITHM)
            .setTruststoreFile(TRUSTSTORE_FILE)
            .setTruststorePassword(TRUSTSTORE_PASSWORD)
            .setTruststoreType(TRUSTSTORE_TYPE)
            .build();

    assertThat(sslConfiguration.getClientAuthentication()).isEqualTo(CLIENT_AUTHENTICATION);
    assertThat(sslConfiguration.getEnabledCipherSuites()).containsExactly(ENABLED_CIPHER_SUITE);
    assertThat(sslConfiguration.getKeyAlias()).isEqualTo(KEY_ALIAS);
    assertThat(sslConfiguration.getKeyPassword()).isEqualTo(KEY_PASSWORD);
    assertThat(sslConfiguration.getKeystoreAlgorithm()).isEqualTo(KEYSTORE_ALGORITHM);
    assertThat(sslConfiguration.getKeystoreFile()).isEqualTo(KEYSTORE_FILE);
    assertThat(sslConfiguration.getKeystorePassword()).isEqualTo(KEYSTORE_PASSWORD);
    assertThat(sslConfiguration.getKeystoreType()).isEqualTo(KEYSTORE_TYPE);
    assertThat(sslConfiguration.getSslProtocol()).isEqualTo(SSL_PROTOCOL);
    assertThat(sslConfiguration.getTruststoreAlgorithm()).isEqualTo(TRUSTSTORE_ALGORITHM);
    assertThat(sslConfiguration.getTruststoreFile()).isEqualTo(TRUSTSTORE_FILE);
    assertThat(sslConfiguration.getTruststorePassword()).isEqualTo(TRUSTSTORE_PASSWORD);
    assertThat(sslConfiguration.getTruststoreType()).isEqualTo(TRUSTSTORE_TYPE);
  }
}
