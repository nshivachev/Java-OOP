package solidEx.appenders;

import solidEx.layouts.Layout;
import solidEx.loggers.ReportLevel;
import solidEx.utilities.File;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout, ReportLevel reportLevelThreshold, File file) {
        super(layout, reportLevelThreshold);
        this.file = file;
    }

    @Override
    public void append(String timeStamp, ReportLevel reportLevel, String message) {
        if (reportLevel.ordinal() >= reportLevelThreshold.ordinal()) {
            file.write(layout.format(timeStamp, reportLevel, message));
            count++;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d", file.getSize());
    }
}
