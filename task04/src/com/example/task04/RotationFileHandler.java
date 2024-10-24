package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler implements MessageHandler {
    private final String baseFilePath;
    private final DateTimeFormatter formatter;

    public RotationFileHandler(String baseFilePath) {
        this.baseFilePath = baseFilePath;
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm"); //интервал ротации по минутам
    }

    @Override
    public void handleMessage(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String filePath = baseFilePath + "_" + timestamp + ".log";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message);
            writer.write(System.lineSeparator()); // Добавляем новую строку
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
