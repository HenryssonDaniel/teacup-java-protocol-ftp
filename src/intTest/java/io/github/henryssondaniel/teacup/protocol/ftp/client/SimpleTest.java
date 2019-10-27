package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.henryssondaniel.teacup.protocol.Server;
import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Context;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Request;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private static final int CODE = 200;
  private static final String LOCALHOST = "localhost";
  private static final String MESSAGE = "message";
  private static final int PORT = 1234;

  private final Client client = Factory.createClient();

  private Server<Context, Request> simpleServer;

  @AfterEach
  void afterEach() throws IOException {
    client.disconnect();
    simpleServer.tearDown();
  }

  @BeforeEach
  void beforeEach() throws IOException {
    simpleServer =
        io.github.henryssondaniel.teacup.protocol.ftp.server.Factory.createServer(
            io.github.henryssondaniel.teacup.protocol.ftp.server.Factory
                .createConfigurationBuilder()
                .setServerAddress(LOCALHOST)
                .setPort(PORT)
                .build());
    simpleServer.setUp();
    simpleServer.setContext(
        io.github.henryssondaniel.teacup.protocol.ftp.server.Factory.createContextBuilder(
                io.github.henryssondaniel.teacup.protocol.ftp.server.Factory.createReplyBuilder(
                        CODE, MESSAGE)
                    .build())
            .build());

    client.connect(LOCALHOST, PORT);
  }

  @Test
  void send() throws IOException {
    client.configure(Factory.createConfigurationBuilder("systemKey").build());
    var response = client.send(Command.ACCOUNT);

    assertThat(response.getCode()).isEqualTo(CODE);
    assertThat(response.getText()).isEqualTo(CODE + " " + MESSAGE + "\r\n");
  }
}
