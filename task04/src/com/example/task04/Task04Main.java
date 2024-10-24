package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyLogger");
        logger.setLevel(Logger.LogLevel.INFO);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        FileHandler fileHandler = new FileHandler("log.txt");
        RotationFileHandler rotationFileHandler = new RotationFileHandler("log_rotation");

        // MemoryHandler в 3 сообщнения по лимиту
        MemoryHandler memoryHandler = new MemoryHandler(consoleHandler, 3);

        logger.addHandler(memoryHandler);
        logger.addHandler(fileHandler);
        logger.addHandler(rotationFileHandler);

        // Логи выводим в MemoryHandler
        logger.debug("Отладочное сообщение: бам бам бам"); // Не видно
        logger.info("Информационное сообщение: пупупу "); // Видно
        logger.warning("Предупреждающее сообщение: овылаолдвыоа"); // Видно
        logger.error("Сообщение об ошибке: qwerty"); // Видно

        // явно вызываем flush, если вдруг у нас сообщений меньше, чем лимит. Иначе у нас просто ничего не будет выводится
        memoryHandler.flush();
    }
}
