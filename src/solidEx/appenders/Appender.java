package solidEx.appenders;

import solidEx.loggers.ReportLevel;

public interface Appender {
    void append(String timeStamp, ReportLevel reportLevel, String message);
}
