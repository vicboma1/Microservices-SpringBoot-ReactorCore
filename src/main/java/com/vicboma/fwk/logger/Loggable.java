package com.vicboma.fwk.logger;

import org.apache.log4j.Logger;

/**
 * Trait
 */
public interface Loggable {

    default Logger getLogger() {
        return Logger.getLogger(this.getClass());
    }
}
