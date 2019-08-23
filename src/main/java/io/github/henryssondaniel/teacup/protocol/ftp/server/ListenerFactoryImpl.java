package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;

class ListenerFactoryImpl extends ListenerFactory {
  private static final Logger LOGGER = Factory.getLogger(ListenerFactoryImpl.class);
  private final Handler handler;

  ListenerFactoryImpl(Handler handler) {
    this.handler = handler;
  }

  @Override
  public Listener createListener() {
    LOGGER.log(Level.FINE, "Create listener");
    return new ListenerImpl(handler, this, "handler");
  }
}
