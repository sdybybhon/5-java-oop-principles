package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {
    private static final ArrayList<Logger> loggers = new ArrayList<>();
    private final String name;
    private LogLevel currentLevel = LogLevel.DEBUG;

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

    // через getLogger проходимся по списку loggers,
    // чтобы найти существующий логгер с указанным именем.
    // Если мы его не нашли, то создаём новый и добавляем его в список.
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

    public String getName() {
        return name;
    }

    public void setLevel(LogLevel level) {
        this.currentLevel = level;
    }

    public LogLevel getLevel() {
        return currentLevel;
    }

    // Методы для каждого уровня логирования
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

    // Методы для форматированного логирования
    public void debug(String format, Object... args) {
        log(LogLevel.DEBUG, format, args);
    }

    public void info(String format, Object... args) {
        log(LogLevel.INFO, format, args);
    }

    public void warning(String format, Object... args) {
        log(LogLevel.WARNING, format, args);
    }

    public void error(String format, Object... args) {
        log(LogLevel.ERROR, format, args);
    }

    // Универсальные методы log для всех уровней
    public void log(LogLevel level, String message) {
        if (level.getLevel() >= currentLevel.getLevel()) {
            System.out.println(formatMessage(level, message));
        }
    }

    public void log(LogLevel level, String format, Object... args) {
        if (level.getLevel() >= currentLevel.getLevel()) {
            System.out.println(formatMessage(level, String.format(format, args)));
        }
    }

    private String formatMessage(LogLevel level, String message) {
        String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return String.format("[%s] %s %s %s - %s", level.name(), date, time, name, message);
    }
}
