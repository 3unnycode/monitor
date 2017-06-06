package com.xiaoseller.monitor;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class MonitorPoint {
	public static final String PREFIX = "^I^MonitorPoint^I^";

    private String retentionPolicy = "dafault";

    private String monitorKey;
    private Map<String, String> tags;  //监控指标标签，用来做筛选标记
    private Map<String, Object> fields;  //监控指标具体监控指标值
    private Long time;

    public String getMonitorKey() {
        return monitorKey;
    }

    public void setMonitorKey(String monitorKey) {
        this.monitorKey = monitorKey;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getRetentionPolicy() {
        return retentionPolicy;
    }

    public void setRetentionPolicy(String retentionPolicy) {
        this.retentionPolicy = retentionPolicy;
    }

    public MonitorPoint() {

    }

    public static Builder monitorKey(final String monitorKey) {
        return new Builder(monitorKey);
    }

    public static final class Builder {
        private String retentionPolicy = "dafault";
        private final String monitorKey;
        private Map<String, String> tags = new TreeMap<String, String>();
        private TimeUnit precision = TimeUnit.NANOSECONDS;
        private Map<String, Object> fields = new TreeMap<String, Object>();
        private Long time;

        Builder(final String monitorKey) {
            this.monitorKey = monitorKey;
        }

        public Builder addTag(final String tagName, final String value) {
            tags.put(tagName, value);
            return this;
        }

        public Builder addTag(final Map<String, String> tagsToAdd) {
            checkArgument(tagsToAdd);
            for (Map.Entry<String, String> tag : tagsToAdd.entrySet()) {
                addTag(tag.getKey(), tag.getValue());
            }
            return this;
        }

        public Builder addField(final String field, final Boolean value) {
            checkArgument(value);
            fields.put(field, value);
            return this;
        }

        public Builder addField(final String field, final Long value) {
            checkArgument(value);
            fields.put(field, value);
            return this;
        }

        public Builder addField(final String field, final Double value) {
            checkArgument(value);
            fields.put(field, value);
            return this;
        }

        public Builder addField(final String field, final Integer value) {
            checkArgument(value);
            fields.put(field, value);
            return this;
        }

        public Builder addField(final String field, final String value) {
            checkArgument(value);
            fields.put(field, value);
            return this;
        }

        public Builder setRp(final String rp) {
            checkArgument(rp);
            retentionPolicy = rp;
            return this;
        }

        private static void checkArgument(Object arg) {
            if (arg == null) {
                throw new IllegalArgumentException("Tag or Field value cannot be null");
            }
        }

        public MonitorPoint build() {
            MonitorPoint point = new MonitorPoint();
            point.setMonitorKey(this.monitorKey);
            point.setFields(this.fields);
            point.setTags(this.tags);
            point.setTime(System.currentTimeMillis());
            point.setRetentionPolicy(this.retentionPolicy);
            return point;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("monitorKey:");
        builder.append(this.monitorKey);
        builder.append(";time:");
        builder.append(this.time);
        builder.append(";tags:");
        builder.append(this.tags);
        builder.append(";fields:");
        builder.append(this.fields);
        builder.append(";rp:");
        builder.append(retentionPolicy);
        return builder.toString();
    }
}
