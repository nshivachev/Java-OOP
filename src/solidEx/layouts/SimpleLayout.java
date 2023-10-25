package solidEx.layouts;

import solidEx.loggers.ReportLevel;

public class SimpleLayout implements Layout {
    @Override
    public String format(String timeStamp, ReportLevel reportLevel, String message) {
        return String.format("%s – %s – %s", timeStamp, reportLevel, message);
    }
}
