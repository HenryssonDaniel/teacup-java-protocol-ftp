package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.listener.nio.NioListener;

class ListenerImpl extends NioListener {
  private static final Logger LOGGER = Factory.getLogger(ListenerImpl.class);

  private final String name;
  private final Handler newHandler;

  private boolean defaultHandler = true;

  ListenerImpl(Handler handler, ListenerFactory listenerFactory, String name) {
    super(
        listenerFactory.getServerAddress(),
        listenerFactory.getPort(),
        listenerFactory.isImplicitSsl(),
        listenerFactory.getSslConfiguration(),
        listenerFactory.getDataConnectionConfiguration(),
        listenerFactory.getIdleTimeout(),
        listenerFactory.getSessionFilter());

    this.name = name;
    newHandler = handler;
  }

  @Override
  public boolean isStopped() {
    if (defaultHandler) {
      try {
        var field = getClass().getSuperclass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(this, newHandler);
      } catch (IllegalAccessException | NoSuchFieldException e) {
        LOGGER.log(Level.FINE, "Could not set the handler", e);
      }

      defaultHandler = false;
    }

    return super.isStopped();
  }
}
