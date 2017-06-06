package com.xiaoseller.monitor;

import java.util.Map;

public interface Monitor {
	void writePoint(MonitorPoint point);

    void writePoint(String monitorKey, Boolean value);

    void writePoint(String monitorKey, String value);

    void writePoint(String monitorKey, Integer value);

    void writePoint(String monitorKey, Long value);

    void writePoint(String monitorKey, Double value);

    void writePoint(String monitorKey, Map<String, String> tags, Boolean value);

    void writePoint(String monitorKey, Map<String, String> tags, String value);

    void writePoint(String monitorKey, Map<String, String> tags, Integer value);

    void writePoint(String monitorKey, Map<String, String> tags, Long value);

    void writePoint(String monitorKey, Map<String, String> tags, Double value);
}
