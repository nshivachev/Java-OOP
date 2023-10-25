package solidEx.appenders;

import solidEx.layouts.Layout;
import solidEx.loggers.ReportLevel;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout, ReportLevel reportLevelThreshold) {
        super(layout, reportLevelThreshold);
    }

    @Override
    public void append(String timeStamp, ReportLevel reportLevel, String message) {
        if (reportLevel.ordinal() >= reportLevelThreshold.ordinal()) {
            System.out.println(layout.format(timeStamp, reportLevel, message));
            count++;
        }
    }
}
