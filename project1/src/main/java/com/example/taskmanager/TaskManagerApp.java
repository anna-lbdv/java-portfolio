package com.example.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManagerApp {
    private static List<Task> tasks = new ArrayList<>();  // Список завдань
    private static int nextId = 1;  // Авто-ID
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Менеджер завдань (Мій TODO List) ===");
        boolean running = true;

        while (running) {  // Нескінченний цикл до виходу
            showMenu();  // Показати меню
            System.out.print("Оберіть опцію: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());  // Читаємо число
            } catch (NumberFormatException e) {
                System.out.println("Помилка: Введіть число! (Повторіть)");
                continue;  // Назад у цикл
            }

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listAllTasks();
                    break;
                case 3:
                    listUnfinishedTasks();  // З Streams!
                    break;
                case 4:
                    markAsDone();
                    break;
                case 5:
                    deleteTask();
                    break;
                case 6:
                    running = false;
                    System.out.println("Вихід. До побачення!");
                    break;
                default:
                    System.out.println("Невірний вибір! Спробуйте 1–6.");
            }
        }
        scanner.close();  // Закриваємо сканер
    }

    // Показати меню
    private static void showMenu() {
        System.out.println("\n=== МЕНЮ ===");
        System.out.println("1. Додати завдання");
        System.out.println("2. Показати всі завдання");
        System.out.println("3. Показати незавершені (Streams)");
        System.out.println("4. Позначити як виконане");
        System.out.println("5. Видалити завдання");
        System.out.println("6. Вихід");
    }

    // Додати завдання
    private static void addTask() {
        System.out.print("Введіть опис: ");
        String desc = scanner.nextLine();
        if (desc.trim().isEmpty()) {
            System.out.println("Опис не може бути порожнім!");
            return;
        }
        Task newTask = new Task(nextId++, desc, false);
        tasks.add(newTask);
        System.out.println("✅ Додано: " + newTask);
    }

    // Всі завдання (for-each цикл)
    private static void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 Немає завдань.");
            return;
        }
        System.out.println("\n=== Всі завдання ===");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Незавершені (Streams — фільтр!)
    private static void listUnfinishedTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 Немає завдань.");
            return;
        }
        System.out.println("\n=== Незавершені завдання (фільтр Streams) ===");
        tasks.stream()  // Починаємо потік
                .filter(task -> !task.isDone())  // Lambda: тільки !done
                .forEach(System.out::println);  // Виводимо кожен
    }

    // Позначити виконеним
    private static void markAsDone() {
        if (tasks.isEmpty()) {
            System.out.println("📭 Немає завдань.");
            return;
        }
        System.out.print("ID завдання: ");
        int id = getIntInput();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                System.out.println("✅ Позначено: " + task);
                return;
            }
        }
        System.out.println("❌ Завдання з ID " + id + " не знайдено.");
    }

    // Видалити (Streams removeIf)
    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("📭 Немає завдань.");
            return;
        }
        System.out.print("ID завдання: ");
        int id = getIntInput();
        boolean removed = tasks.removeIf(task -> task.getId() == id);  // Streams: видаляємо за умовою
        if (removed) {
            System.out.println("🗑️ Видалено!");
        } else {
            System.out.println("❌ Не знайдено.");
        }
    }

    // Helper: Безпечний ввід int (try-catch)
    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Помилка: Введіть число!");
            return -1;  // Якщо помилка, повертаємо -1
        }
    }
}