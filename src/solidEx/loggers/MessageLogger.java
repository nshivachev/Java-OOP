package solidEx.loggers;

import solidEx.appenders.Appender;

import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(List<Appender> appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String timeStamp, String message) {
        logMessage(timeStamp, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String timeStamp, String message) {
        logMessage(timeStamp, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String timeStamp, String message) {
        logMessage(timeStamp, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String timeStamp, String message) {
        logMessage(timeStamp, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String timeStamp, String message) {
        logMessage(timeStamp, ReportLevel.FATAL, message);
    }

    private void logMessage(String timeStamp, ReportLevel reportLevel, String message) {
        appenders.forEach(appender -> appender.append(timeStamp, reportLevel, message));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Logger info").append(System.lineSeparator());

        appenders.forEach(appender -> sb.append(appender.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
