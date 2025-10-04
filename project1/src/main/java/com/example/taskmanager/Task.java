package com.example.taskmanager;

public class Task {
    private int id;
    private String description;
    private boolean done;

    // Порожній конструктор
    public Task() {}

    // Конструктор з параметрами
    public Task(int id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    // Геттери та сеттери
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    // toString
    @Override
    public String toString() {
        return "Завдання [ID=" + id + ", Опис='" + description + "', Виконане=" + (done ? "Так" : "Ні") + "]";
    }
}