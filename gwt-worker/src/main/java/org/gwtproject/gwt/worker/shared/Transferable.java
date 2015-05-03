package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.TransferableJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;

/**
 * Marker interface for objects which can be transfered to
 * worker without copying (to improve performance)
 */
@SingleJsoImpl(TransferableJsoImpl.class)
public interface Transferable {

}
