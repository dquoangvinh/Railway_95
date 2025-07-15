package com.vti.entity;

public class TypeQuestion {
    public enum TypeName {
        Essay, Multiple_Choice
    }

    private int id;
    private TypeName name;

    public TypeQuestion() {
    }

    public TypeQuestion(int id, TypeName name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeName getName() {
        return name;
    }

    public void setName(TypeName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
