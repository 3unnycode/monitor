package com.xiaoseller.monitor.dubbo;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.store.DataStore;
import com.xiaoseller.monitor.Monitor;
import com.xiaoseller.monitor.MonitorFactory;
import com.xiaoseller.monitor.MonitorPoint;

public class DubboMonitor {
	//@Value("${app.code}")
	private String systemCode;

	@PostConstruct
	public void init() {
		new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(new Runnable() {

			public void run() {
				monitor();
			}
		}, 1000, 1000, TimeUnit.MILLISECONDS);
	}

	public void monitor() {
		DataStore dataStore = ExtensionLoader.getExtensionLoader(DataStore.class).getDefaultExtension();
		Map<String, Object> executors = dataStore.get(Constants.EXECUTOR_SERVICE_COMPONENT_KEY);
		for (Map.Entry<String, Object> entry : executors.entrySet()) {
			String port = entry.getKey();
			ExecutorService executor = (ExecutorService) entry.getValue();
			if (executor != null && executor instanceof ThreadPoolExecutor) {
				ThreadPoolExecutor tp = (ThreadPoolExecutor) executor;
				Monitor monitor = MonitorFactory.connect();
				monitor.writePoint(
						MonitorPoint.monitorKey("wireless.dubbo.threadpool.active").addTag("systemCode", systemCode)
								.addTag("port", port).addField("val", tp.getActiveCount()).build());
			}
		}
	}
}
