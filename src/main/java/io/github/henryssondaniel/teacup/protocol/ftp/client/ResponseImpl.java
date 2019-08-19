package io.github.henryssondaniel.teacup.protocol.ftp.client;

class ResponseImpl implements Response {
  private final int code;
  private final String text;

  ResponseImpl(int code, String text) {
    this.code = code;
    this.text = text;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getText() {
    return text;
  }
}
