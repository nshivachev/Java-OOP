package solidEx.appenders;

import solidEx.layouts.Layout;
import solidEx.loggers.ReportLevel;

public abstract class BaseAppender implements Appender {
    Layout layout;
    ReportLevel reportLevelThreshold;
    int count;

    public BaseAppender(Layout layout, ReportLevel reportLevelThreshold) {
        this.layout = layout;
        this.reportLevelThreshold = reportLevelThreshold;
        this.count = 0;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(), layout.getClass().getSimpleName(), reportLevelThreshold, count);
    }
}
