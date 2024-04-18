package com.example.ticket;

public class Task {
    private int fk_iduser;
    private String title;
    private String text;

    private String date;

    public Task (int fk_iduser, String title, String text, String date){
        this.title=title;
        this.fk_iduser=fk_iduser;
        this.text=text;
        this.date=date;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "fk_iduser=" + fk_iduser +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
