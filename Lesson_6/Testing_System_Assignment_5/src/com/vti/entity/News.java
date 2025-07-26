package com.vti.entity;

public class News implements INews {
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;
    private int[] Rates = new int[3];

    // Constructors
    public News() {}

    public News(int ID, String title, String publishDate, String author, String content) {
        this.ID = ID;
        this.Title = title;
        this.PublishDate = publishDate;
        this.Author = author;
        this.Content = content;
    }

    // Getters and Setters
    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getTitle() { return Title; }
    public void setTitle(String title) { this.Title = title; }

    public String getPublishDate() { return PublishDate; }
    public void setPublishDate(String publishDate) { this.PublishDate = publishDate; }

    public String getAuthor() { return Author; }
    public void setAuthor(String author) { this.Author = author; }

    public String getContent() { return Content; }
    public void setContent(String content) { this.Content = content; }

    public float getAverageRate() { return AverageRate; }

    public int[] getRates() { return Rates; }
    public void setRates(int[] rates) { this.Rates = rates; }

    @Override
    public void Display() {
        System.out.println("Title: " + Title);
        System.out.println("Publish Date: " + PublishDate);
        System.out.println("Author: " + Author);
        System.out.println("Content: " + Content);
        System.out.println("Average Rate: " + AverageRate);
    }

    @Override
    public float Calculate() {
        int sum = 0;
        for (int rate : Rates) {
            sum += rate;
        }
        AverageRate = (float) sum / 3;
        return AverageRate;
    }
}
