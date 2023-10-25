package solidEx.layouts;

import solidEx.loggers.ReportLevel;

public interface Layout {
    String format(String timeStamp, ReportLevel reportLevel, String message);
}
