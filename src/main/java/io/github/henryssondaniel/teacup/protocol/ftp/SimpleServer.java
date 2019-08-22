package io.github.henryssondaniel.teacup.protocol.ftp;

import io.github.henryssondaniel.teacup.core.Server;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Context;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Request;
import java.util.List;
import java.util.function.Supplier;

public interface SimpleServer extends Server {
  /**
   * Removes the supplier from the context.
   *
   * @param supplier the supplier
   */
  void removeSupplier(Supplier<List<Request>> supplier);

  /**
   * Sets the context to the server and returns a supplier.
   *
   * @param context the context
   * @return the supplier
   */
  Supplier<List<Request>> setContext(Context context);
}
