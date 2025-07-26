package com.vti.entity;

public class VietnamesePhone extends Phone {
    
    @Override
    public void insertContact(String name, String phone) {
        if (getSize() >= getContacts().length) {
            System.out.println("Danh bạ đã đầy!");
            return;
        }
        
        getContacts()[getSize()] = new Contact(name, phone);
        setSize(getSize() + 1);
        System.out.println("Đã thêm liên hệ: " + name + " - " + phone);
    }
    
    @Override
    public void removeContact(String name) {
        for (int i = 0; i < getSize(); i++) {
            if (getContacts()[i].getName().equalsIgnoreCase(name)) {
                // Dịch chuyển các phần tử về phía trước
                for (int j = i; j < getSize() - 1; j++) {
                    getContacts()[j] = getContacts()[j + 1];
                }
                setSize(getSize() - 1);
                System.out.println("Đã xóa liên hệ: " + name);
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ: " + name);
    }
    
    @Override
    public void updateContact(String name, String newPhone) {
        for (int i = 0; i < getSize(); i++) {
            if (getContacts()[i].getName().equalsIgnoreCase(name)) {
                getContacts()[i].setNumber(newPhone);
                System.out.println("Đã cập nhật số điện thoại của " + name + ": " + newPhone);
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ: " + name);
    }
    
    @Override
    public void searchContact(String name) {
        for (int i = 0; i < getSize(); i++) {
            if (getContacts()[i].getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Tìm thấy: " + getContacts()[i]);
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ: " + name);
    }
    
    public void displayAllContacts() {
        if (getSize() == 0) {
            System.out.println("Danh bạ trống!");
            return;
        }
        
        System.out.println("=== DANH BẠ ===");
        for (int i = 0; i < getSize(); i++) {
            System.out.println((i + 1) + ". " + getContacts()[i]);
        }
    }
}