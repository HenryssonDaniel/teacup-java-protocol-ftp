package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.SecureClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import org.apache.commons.net.ftp.FTPSClient;

class Secure extends Simple implements SecureClient {
  private static final Logger LOGGER = Factory.getLogger(Secure.class);
  private final FTPSClient ftpsClient;

  Secure(FTPSClient ftpsClient) {
    super(ftpsClient);
    this.ftpsClient = ftpsClient;
  }

  @Override
  public void setEndpointCheckingEnabled(boolean enable) {
    LOGGER.log(Level.FINE, "Set endpoint checking enabled");
    ftpsClient.setEndpointCheckingEnabled(enable);
  }

  @Override
  public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
    LOGGER.log(Level.FINE, "Set hostname verified");
    ftpsClient.setHostnameVerifier(hostnameVerifier);
  }
}
