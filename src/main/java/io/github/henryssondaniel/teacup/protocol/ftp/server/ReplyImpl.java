package io.github.henryssondaniel.teacup.protocol.ftp.server;

class ReplyImpl implements Reply {
  private final int code;
  private final String message;

  ReplyImpl(int code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
