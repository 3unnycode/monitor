package com.xiaoseller.monitor;

import com.xiaoseller.monitor.impl.MonitorImpl;

public class MonitorFactory {
	private static Monitor monitor;

    static {
    	monitor = new MonitorImpl();
    }

    public static Monitor connect() {
        return monitor;
    }
}
