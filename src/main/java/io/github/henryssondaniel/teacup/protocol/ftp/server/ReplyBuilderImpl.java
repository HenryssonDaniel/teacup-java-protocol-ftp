package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.protocol.DefaultBuilder;

class ReplyBuilderImpl extends DefaultBuilder<Reply, Reply> implements ReplyBuilder {
  private final int code;
  private final String message;

  ReplyBuilderImpl(int code, String message) {
    super(new ReplyImpl(code, message));

    this.code = code;
    this.message = message;
  }

  @Override
  protected Reply createImplementation() {
    return new ReplyImpl(code, message);
  }
}
