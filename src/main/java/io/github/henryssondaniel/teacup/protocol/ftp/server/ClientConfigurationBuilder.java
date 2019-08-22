package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.Builder;

public interface ClientConfigurationBuilder extends Builder<ClientConfiguration> {
  ClientConfigurationBuilder setActiveEnabled(boolean activeEnabled);

  ClientConfigurationBuilder setActiveIpCheck(boolean activeIpCheck);

  ClientConfigurationBuilder setActiveLocalAddress(String activeLocalAddress);

  ClientConfigurationBuilder setActiveLocalPort(int activeLocalPort);

  ClientConfigurationBuilder setIdleTime(int idleTime);

  ClientConfigurationBuilder setImplicitSsl(boolean implicitSsl);

  ClientConfigurationBuilder setPassiveAddress(String passiveAddress);

  ClientConfigurationBuilder setPassiveExternalAddress(String passiveExternalAddress);

  ClientConfigurationBuilder setPassiveIpCheck(boolean passiveIpCheck);

  ClientConfigurationBuilder setPassivePorts(String passivePorts);

  ClientConfigurationBuilder setSslConfiguration(SslConfiguration sslConfiguration);
}
