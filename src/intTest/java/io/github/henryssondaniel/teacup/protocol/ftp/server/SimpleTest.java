package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.henryssondaniel.teacup.protocol.ftp.SimpleServer;
import io.github.henryssondaniel.teacup.protocol.ftp.client.Command;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;
import javax.net.ssl.KeyManagerFactory;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private static final int CODE = 200;
  private static final String LOCALHOST = "localhost";
  private static final String PASSWORD = "password";
  private static final int PORT = 1234;

  @Test
  void createServerWithConfiguration()
      throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException {
    var folder = createRes();
    var file = createKeystore(folder);

    var sslConfiguration =
        Factory.createSslConfigurationBuilder()
            .setKeystorePassword(PASSWORD)
            .setTruststoreAlgorithm(KeyManagerFactory.getDefaultAlgorithm())
            .build();

    try {
      verifyServer(
          Factory.createServer(
              Factory.createConfigurationBuilder()
                  .setClientConfiguration(
                      Factory.createClientConfigurationBuilder()
                          .setSslConfiguration(sslConfiguration)
                          .build())
                  .setPort(PORT)
                  .setServerAddress(LOCALHOST)
                  .setSslConfiguration(sslConfiguration)
                  .build()));
    } finally {
      assertThat(file.delete()).isTrue();
      assertThat(folder.delete()).isTrue();
    }
  }

  private static File createKeystore(File folder)
      throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException {
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

  private static void verifyServer(SimpleServer simpleServer) throws IOException {
    simpleServer.setUp();

    var supplier =
        simpleServer.setContext(
            Factory.createContextBuilder(Factory.createReplyBuilder(CODE, "message").build())
                .build());

    var client = io.github.henryssondaniel.teacup.protocol.ftp.client.Factory.createClient();
    client.connect(LOCALHOST, PORT);
    client.send(Command.ACCOUNT);

    var requests = supplier.get();
    assertThat(requests).hasSize(1);

    var request = requests.get(0);

    assertThat(request.getArgument()).isNull();
    assertThat(request.getCommand()).isEqualTo("ACCT");
    assertThat(request.getReceivedTime()).isLessThanOrEqualTo(Date.from(Instant.now()).getTime());

    simpleServer.removeSupplier(supplier);
    simpleServer.tearDown();
  }
}
