package solidEx;

import solidEx.appenders.Appender;
import solidEx.appenders.ConsoleAppender;
import solidEx.appenders.FileAppender;
import solidEx.appenders.XmlAppender;
import solidEx.layouts.Layout;
import solidEx.layouts.SimpleLayout;
import solidEx.layouts.XmlLayout;
import solidEx.loggers.Logger;
import solidEx.loggers.MessageLogger;
import solidEx.loggers.ReportLevel;
import solidEx.utilities.LogFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static List<Appender> appenders = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int appendersCount = Integer.parseInt(scanner.nextLine());

        while (appendersCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String appenderType = tokens[0];
            String layoutType = tokens[1];

            Layout layout = createLayout(layoutType);
            ReportLevel appenderReportLevel = getAppenderReportLevel(tokens);
            Appender appender = createAppender(appenderType, layout, appenderReportLevel);

            appenders.add(appender);
        }

        List<String> commands = new ArrayList<>();

        String line;

        while (!"END".equalsIgnoreCase(line = scanner.nextLine())) {
            commands.add(line);
        }

        Logger logger = new MessageLogger(appenders);

        commands.forEach(command -> logMessage(logger, command));

        System.out.println(logger);
    }

    private static void logMessage(Logger logger, String command) {
        String[] tokens = command.split("\\|");

        ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
        String timeStamp = tokens[1];
        String message = tokens[2];

        switch (reportLevel) {
            case INFO -> logger.logInfo(timeStamp, message);
            case WARNING -> logger.logWarning(timeStamp, message);
            case ERROR -> logger.logError(timeStamp, message);
            case CRITICAL -> logger.logCritical(timeStamp, message);
            case FATAL -> logger.logFatal(timeStamp, message);
        }
    }

    private static Appender createAppender(String appenderType, Layout layout, ReportLevel appenderReportLevel) {
        return switch (appenderType) {
            case "ConsoleAppender" -> new ConsoleAppender(layout, appenderReportLevel);
            case "FileAppender" -> new FileAppender(layout, appenderReportLevel, new LogFile());
            case "XmlAppender" -> new XmlAppender(layout, appenderReportLevel);
            default -> throw new IllegalArgumentException("Unexpected appender type: " + appenderType);
        };
    }

    private static ReportLevel getAppenderReportLevel(String[] tokens) {
        return tokens.length == 2
                ? ReportLevel.INFO
                : ReportLevel.valueOf(tokens[2]);
    }

    private static Layout createLayout(String layoutType) {
        return layoutType.equals("SimpleLayout")
                ? new SimpleLayout()
                : new XmlLayout();
    }
}
