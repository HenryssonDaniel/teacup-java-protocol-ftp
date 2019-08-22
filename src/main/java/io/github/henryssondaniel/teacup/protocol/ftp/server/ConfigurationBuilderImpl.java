package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.DefaultBuilder;

class ConfigurationBuilderImpl extends DefaultBuilder<Configuration, ConfigurationSetter>
    implements ConfigurationBuilder {

  ConfigurationBuilderImpl() {
    super(new ConfigurationImpl());
  }

  @Override
  public ConfigurationBuilder setClientConfiguration(ClientConfiguration clientConfiguration) {
    getImplementation().setClientConfiguration(clientConfiguration);
    return this;
  }

  @Override
  public ConfigurationBuilder setIdleTimeout(Integer idleTimeout) {
    getImplementation().setIdleTimeout(idleTimeout);
    return this;
  }

  @Override
  public ConfigurationBuilder setImplicitSsl(boolean implicitSsl) {
    getImplementation().setImplicitSsl(implicitSsl);
    return this;
  }

  @Override
  public ConfigurationBuilder setPort(Integer port) {
    getImplementation().setPort(port);
    return this;
  }

  @Override
  public ConfigurationBuilder setServerAddress(String serverAddress) {
    getImplementation().setServerAddress(serverAddress);
    return this;
  }

  @Override
  public ConfigurationBuilder setSslConfiguration(SslConfiguration sslConfiguration) {
    getImplementation().setSslConfiguration(sslConfiguration);
    return this;
  }

  @Override
  protected ConfigurationSetter createImplementation() {
    return new ConfigurationImpl();
  }
}
