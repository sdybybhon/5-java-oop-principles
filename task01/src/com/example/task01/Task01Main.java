package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        // Создаем логгер
        Logger logger = Logger.getLogger("FirstLogger");

        // Получаем тот же логгер и проверяем, что это один и тот же объект
        Logger sameLogger = Logger.getLogger("FirstLogger");
        System.out.println("Проверка на одинаковость логгеров: " + (logger == sameLogger));
        System.out.println("____________");// тру

        // Проверка уровня DEBUG
        logger.setLevel(Logger.LogLevel.DEBUG);
        System.out.println("Уровень логирования: DEBUG");
        logger.info("Информационное сообщение"); // Видно
        logger.debug("Сообщение должно быть видно"); // Видно
        logger.warning("Сообщение об предупреждении: %s%n", "пум пум пум"); // Видно
        logger.error("Сообщение об ошибке"); // Видно
        System.out.println("____________");
    }
}
