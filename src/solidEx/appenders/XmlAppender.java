package solidEx.appenders;

import solidEx.layouts.Layout;
import solidEx.loggers.ReportLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class XmlAppender extends BaseAppender {
    public XmlAppender(Layout layout, ReportLevel reportLevelThreshold) {
        super(layout, reportLevelThreshold);
    }

    @Override
    public void append(String timeStamp, ReportLevel reportLevel, String message) {
        try {
            File xmlFile = new File("logs.xml");

            if (!xmlFile.exists()) {
                xmlFile.createNewFile();
            }

            Files.writeString(Path.of("logs.xml"),
                    layout.format(timeStamp, reportLevel, message), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
