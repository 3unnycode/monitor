package com.xiaoseller.monitor.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoseller.monitor.Monitor;
import com.xiaoseller.monitor.MonitorPoint;

public final class MonitorImpl implements Monitor {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public MonitorImpl() {
	}

	public void writePoint(MonitorPoint point) {
		try {
			if (point != null && point.getMonitorKey() != null && point.getMonitorKey() != "") {
				logger.info(MonitorPoint.PREFIX + point.toString());
			}
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Boolean value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Map<String, String> tags, Boolean value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addTag(tags).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, String value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Map<String, String> tags, String value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addTag(tags).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Integer value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Map<String, String> tags, Integer value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addTag(tags).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Long value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Map<String, String> tags, Long value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addTag(tags).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Double value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

	public void writePoint(String monitorKey, Map<String, String> tags, Double value) {
		try {
			MonitorPoint point = MonitorPoint.monitorKey(monitorKey).addTag(tags).addField("val", value).build();
			this.writePoint(point);
		} catch (Exception ex) {
		}
	}

}
