package com.vti.entity;

public abstract class Phone {
    private Contact[] contacts;
    private int size;
    
    public static class Contact {
        private String name;
        private String number;
        
        public Contact(String name, String number) {
            this.name = name;
            this.number = number;
        }
        
        public String getName() {
            return name;
        }
        
        public String getNumber() {
            return number;
        }
        
        public void setNumber(String number) {
            this.number = number;
        }
        
        @Override
        public String toString() {
            return name + ": " + number;
        }
    }
    
    public Phone() {
        this.contacts = new Contact[100];
        this.size = 0;
    }
    
    public abstract void insertContact(String name, String phone);
    public abstract void removeContact(String name);
    public abstract void updateContact(String name, String newPhone);
    public abstract void searchContact(String name);
    
    protected Contact[] getContacts() {
        return contacts;
    }
    
    protected int getSize() {
        return size;
    }
    
    protected void setSize(int size) {
        this.size = size;
    }
}