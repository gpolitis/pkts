/**
 * 
 */
package io.pkts.framer;

import io.pkts.buffer.Buffer;
import io.pkts.frame.Frame;
import io.pkts.frame.SDPFrame;
import io.pkts.protocol.Protocol;

import java.io.IOException;


/**
 * There is really not much to do in order to frame an SDP since it doesn't
 * contain any payload by itself.
 * 
 * @author jonas@jonasborjesson.com
 */
public final class SDPFramer implements Framer {
    private final FramerManager framerManager;

    public SDPFramer(final FramerManager framerManager) {
        this.framerManager = framerManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Protocol getProtocol() {
        return Protocol.SDP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SDPFrame frame(final Frame parent, final Buffer buffer) throws IOException {
        // nothing really to frame in the case of SDP.
        // just assuming that everything is ok
        return new SDPFrame(this.framerManager, parent.getPcapGlobalHeader(), parent, buffer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean accept(final Buffer data) {
        // TODO: check what fields are mandatory in the SDP
        // and make sure that one of them exists or whatever
        return false;
    }
}