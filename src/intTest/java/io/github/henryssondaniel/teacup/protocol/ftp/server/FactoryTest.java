package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import org.junit.jupiter.api.Test;

class FactoryTest {
  private final ReplyBuilder replyBuilder = Factory.createReplyBuilder(1, "message");

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
    assertThat(Factory.createContextBuilder(replyBuilder.build()))
        .isExactlyInstanceOf(ContextBuilderImpl.class);
  }

  @Test
  void createReplyBuilder() {
    assertThat(replyBuilder).isExactlyInstanceOf(ReplyBuilderImpl.class);
  }

  @Test
  void createServerWithConfiguration()
      throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
    var folder = createRes();
    var file = createKeystore(folder);

    var sslConfiguration =
        Factory.createSslConfigurationBuilder()
            .setKeystorePassword("password")
            .setTruststoreAlgorithm(KeyManagerFactory.getDefaultAlgorithm())
            .build();

    try {
      assertThat(
              Factory.createServer(
                  Factory.createConfigurationBuilder()
                      .setClientConfiguration(
                          Factory.createClientConfigurationBuilder()
                              .setSslConfiguration(sslConfiguration)
                              .build())
                      .setSslConfiguration(sslConfiguration)
                      .build()))
          .isExactlyInstanceOf(Simple.class);
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

    var pwdArray = "password".toCharArray();
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
}
