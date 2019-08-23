package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.SimpleServer;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;

class Simple implements SimpleServer {
  private static final Logger LOGGER = Factory.getLogger(Simple.class);

  private final FtpServer ftpServer;
  private final Handler handler;
  private final Object lock = new Object();

  private boolean waiting = true;

  Simple(FtpServer ftpServer, Handler handler) {
    this.ftpServer = ftpServer;
    this.handler = handler;
  }

  @Override
  public void removeSupplier(Supplier<List<Request>> supplier) {
    LOGGER.log(Level.FINE, "Remove supplier");
    if (supplier instanceof TimeoutSupplier) ((TimeoutSupplier) supplier).stop();
  }

  @Override
  public Supplier<List<Request>> setContext(Context context) {
    LOGGER.log(Level.FINE, "Set context");

    TimeoutSupplier timeoutSupplier = new TimeoutSupplierImpl(new ReentrantLock());

    try {
      addSupplier(context, timeoutSupplier);
      timeoutSupplier.whenStopped(consumer -> cleanup(timeoutSupplier));
    } catch (InterruptedException e) {
      LOGGER.log(Level.SEVERE, "The server got interrupted", e);
      Thread.currentThread().interrupt();
    }

    return timeoutSupplier;
  }

  @Override
  public void setUp() {
    LOGGER.log(Level.FINE, "Set up");

    try {
      ftpServer.start();
    } catch (FtpException e) {
      LOGGER.log(Level.FINE, "Could not start the server", e);
    }
  }

  @Override
  public void tearDown() {
    LOGGER.log(Level.FINE, "Tear down");
    ftpServer.stop();
  }

  private void addSupplier(Context context, TimeoutSupplier timeoutSupplier)
      throws InterruptedException {
    synchronized (lock) {
      var reply = handler.getReply();

      if (reply == null) createHttpContext(context, timeoutSupplier);
      else tryAddSupplier(context, reply, timeoutSupplier);
    }
  }

  private void cleanup(TimeoutSupplier timeoutSupplier) {
    handler.removeTimeoutSupplier(timeoutSupplier);

    synchronized (lock) {
      if (handler.getTimeoutSuppliers().isEmpty()) {
        handler.setReply(null);
        waiting = false;
        lock.notifyAll();
      }
    }
  }

  private void createHttpContext(Context context, TimeoutSupplier timeoutSupplier) {
    handler.addTimeoutSupplier(timeoutSupplier);
    handler.setReply(context.getReply());
  }

  private static boolean isEquals(Reply currentReply, Reply reply) {
    return currentReply.getCode() == reply.getCode()
        && currentReply.getMessage().equals(reply.getMessage());
  }

  private void tryAddSupplier(Context context, Reply reply, TimeoutSupplier timeoutSupplier)
      throws InterruptedException {
    if (isEquals(context.getReply(), reply)) handler.addTimeoutSupplier(timeoutSupplier);
    else
      synchronized (lock) {
        while (waiting) lock.wait(1L);

        waiting = true;
        addSupplier(context, timeoutSupplier);
      }
  }
}
