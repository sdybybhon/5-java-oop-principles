package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    private static final ArrayList<Logger> loggers = new ArrayList<>();
    private final String name;
    private LogLevel currentLevel = LogLevel.DEBUG;
    private final List<MessageHandler> handlers = new ArrayList<>();

    public enum LogLevel {
        DEBUG(0), INFO(1), WARNING(2), ERROR(3);

        private final int level;

        LogLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    private Logger(String name) {
        this.name = name;
    }

    public static Logger getLogger(String name) {
        for (Logger logger : loggers) {
            if (logger.name.equals(name)) {
                return logger;
            }
        }
        Logger newLogger = new Logger(name);
        loggers.add(newLogger);
        return newLogger;
    }

    public void setLevel(LogLevel level) {
        this.currentLevel = level;
    }

    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    public void log(LogLevel level, String message) {
        if (level.getLevel() >= currentLevel.getLevel()) {
            String formattedMessage = formatMessage(level, message);
            for (MessageHandler handler : handlers) {
                handler.handleMessage(formattedMessage);
            }
        }
    }

    private String formatMessage(LogLevel level, String message) {
        String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return String.format("[%s] %s %s %s - %s", level.name(), date, time, name, message);
    }

    // Методы для логирования
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
