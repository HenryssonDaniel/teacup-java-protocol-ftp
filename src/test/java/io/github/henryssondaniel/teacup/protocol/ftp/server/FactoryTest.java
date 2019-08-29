package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactoryTest {
  private static final String ALGORITHM = KeyManagerFactory.getDefaultAlgorithm();
  private static final String PASSWORD = "password";
  private static final String TYPE = KeyStore.getDefaultType();

  private final ClientConfiguration clientConfiguration = mock(ClientConfiguration.class);
  private final Configuration configuration = mock(Configuration.class);
  private final SslConfiguration sslConfiguration = mock(SslConfiguration.class);

  @BeforeEach
  void beforeEach() {
    when(configuration.getClientConfiguration()).thenReturn(clientConfiguration);
    when(configuration.getIdleTimeout()).thenReturn(1);
    when(configuration.getPort()).thenReturn(1);
    when(configuration.getSslConfiguration()).thenReturn(sslConfiguration);

    when(sslConfiguration.getKeystorePassword()).thenReturn(PASSWORD);
  }

  @Test
  void createClientConfigurationBuilder() {
    assertThat(Factory.createClientConfigurationBuilder())
        .isExactlyInstanceOf(ClientConfigurationBuilderImpl.class);
  }

  @Test
  void createConfigurationBuilder() {
    assertThat(Factory.createConfigurationBuilder())
        .isExactlyInstanceOf(ConfigurationBuilderImpl.class);
  }

  @Test
  void createContextBuilder() {
    var reply = mock(Reply.class);
    assertThat(Factory.createContextBuilder(reply)).isExactlyInstanceOf(ContextBuilderImpl.class);
    verifyZeroInteractions(reply);
  }

  @Test
  void createReplyBuilder() {
    assertThat(Factory.createReplyBuilder(1, "message"))
        .isExactlyInstanceOf(ReplyBuilderImpl.class);
  }

  @Test
  void createServer() {
    when(configuration.getClientConfiguration()).thenReturn(null);
    when(configuration.getIdleTimeout()).thenReturn(null);
    when(configuration.getPort()).thenReturn(null);
    when(configuration.getSslConfiguration()).thenReturn(null);

    assertThat(Factory.createServer(configuration)).isExactlyInstanceOf(Simple.class);

    verifyConfiguration();
    verifyZeroInteractions(clientConfiguration);
    verifyZeroInteractions(sslConfiguration);
  }

  @Test
  void createServerWithConfiguration()
      throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
    var folder = createRes();
    var file = createKeystore(folder);

    when(clientConfiguration.hasActiveEnabled()).thenReturn(null);
    when(clientConfiguration.getIdleTime()).thenReturn(null);

    try {
      assertThat(Factory.createServer(configuration)).isExactlyInstanceOf(Simple.class);

      verifyConfiguration();
      verifyClientConfiguration();
      verifySslConfiguration(1);
    } finally {
      assertThat(file.delete()).isTrue();
      assertThat(folder.delete()).isTrue();
    }
  }

  @Test
  void createServerWithConfigurationAndSsl()
      throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException {
    var folder = createRes();
    var file = createKeystore(folder);

    when(clientConfiguration.hasActiveEnabled()).thenReturn(true);
    when(clientConfiguration.getIdleTime()).thenReturn(1);
    when(clientConfiguration.getPassivePorts()).thenReturn("1");
    when(clientConfiguration.getSslConfiguration()).thenReturn(sslConfiguration);

    when(sslConfiguration.getKeystoreAlgorithm()).thenReturn(ALGORITHM);
    when(sslConfiguration.getKeystoreFile()).thenReturn(file);
    when(sslConfiguration.getKeystoreType()).thenReturn(TYPE);
    when(sslConfiguration.getSslProtocol()).thenReturn("TLS");
    when(sslConfiguration.getTruststoreAlgorithm()).thenReturn(ALGORITHM);
    when(sslConfiguration.getTruststoreType()).thenReturn(TYPE);

    try {
      assertThat(Factory.createServer(configuration)).isExactlyInstanceOf(Simple.class);

      verifyConfiguration();
      verifyClientConfiguration();
      verifySslConfiguration(2);
    } finally {
      assertThat(file.delete()).isTrue();
      assertThat(folder.delete()).isTrue();
    }
  }

  @Test
  void createServerWithoutConfiguration() {
    assertThat(Factory.createServer()).isExactlyInstanceOf(Simple.class);
  }

  @Test
  void createSslConfigurationBuilder() {
    assertThat(Factory.createSslConfigurationBuilder())
        .isExactlyInstanceOf(SslConfigurationBuilderImpl.class);
  }

  private static File createKeystore(File folder)
      throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
    var file = new File(folder, ".keystore");

    assertThat(file.createNewFile()).isTrue();

    var pwdArray = PASSWORD.toCharArray();
    var keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    keyStore.load(null, pwdArray);

    try (OutputStream outputStream = new FileOutputStream(file)) {
      keyStore.store(outputStream, pwdArray);
    }

    return file;
  }

  private static File createRes() {
    var folder = new File("res");
    assertThat(folder.mkdir()).isTrue();
    return folder;
  }

  private void verifyClientConfiguration() {
    verify(clientConfiguration).hasActiveEnabled();
    verify(clientConfiguration).hasActiveIpCheck();
    verify(clientConfiguration).getActiveLocalAddress();
    verify(clientConfiguration).getActiveLocalPort();
    verify(clientConfiguration).getIdleTime();
    verify(clientConfiguration).hasImplicitSsl();
    verify(clientConfiguration).getPassiveAddress();
    verify(clientConfiguration).getPassiveExternalAddress();
    verify(clientConfiguration).hasPassiveIpCheck();
    verify(clientConfiguration).getPassivePorts();
    verify(clientConfiguration).getSslConfiguration();
    verifyNoMoreInteractions(clientConfiguration);
  }

  private void verifyConfiguration() {
    verify(configuration).getClientConfiguration();
    verify(configuration).getIdleTimeout();
    verify(configuration).getPort();
    verify(configuration).getServerAddress();
    verify(configuration).getSslConfiguration();
    verify(configuration).hasImplicitSsl();
    verifyNoMoreInteractions(configuration);
  }

  private void verifySslConfiguration(int i) {
    verify(sslConfiguration, times(i)).getClientAuthentication();
    verify(sslConfiguration, times(i)).getEnabledCipherSuites();
    verify(sslConfiguration, times(i)).getKeyAlias();
    verify(sslConfiguration, times(i)).getKeyPassword();
    verify(sslConfiguration, times(i)).getKeystoreAlgorithm();
    verify(sslConfiguration, times(i)).getKeystoreFile();
    verify(sslConfiguration, times(i)).getKeystorePassword();
    verify(sslConfiguration, times(i)).getKeystoreType();
    verify(sslConfiguration, times(i)).getSslProtocol();
    verify(sslConfiguration, times(i)).getTruststoreAlgorithm();
    verify(sslConfiguration, times(i)).getTruststoreFile();
    verify(sslConfiguration, times(i)).getTruststorePassword();
    verify(sslConfiguration, times(i)).getTruststoreType();
    verifyNoMoreInteractions(sslConfiguration);
  }
}
