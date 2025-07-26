package com.vti.entity;

public class Department {
    private int id;
    private String name;

    // Constructor không có parameters
    public Department() {
    }

    // Constructor với 1 parameter nameDepartment, default id = 0
    public Department(String name) {
        this.id = 0;
        this.name = name;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
