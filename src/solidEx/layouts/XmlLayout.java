package solidEx.layouts;

import solidEx.loggers.ReportLevel;

public class XmlLayout implements Layout {
    @Override
    public String format(String timeStamp, ReportLevel reportLevel, String message) {
        return String.format("<log>\n" +
                "   <date>%s</date>\n" +
                "   <level>%s</level>\n" +
                "   <message>%s</message>\n" +
                "</log>", timeStamp, reportLevel, message);
    }
}
