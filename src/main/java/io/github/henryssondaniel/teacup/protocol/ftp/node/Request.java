package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.protocol.Node;

/**
 * Request.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Request
    extends Node<io.github.henryssondaniel.teacup.protocol.ftp.server.Request> {}
