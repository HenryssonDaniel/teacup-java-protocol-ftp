package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.protocol.DefaultBuilder;

class ContextBuilderImpl extends DefaultBuilder<Context, Context> implements ContextBuilder {
  private final Reply reply;

  ContextBuilderImpl(Reply reply) {
    super(new ContextImpl(reply));
    this.reply = reply;
  }

  @Override
  protected Context createImplementation() {
    return new ContextImpl(reply);
  }
}
