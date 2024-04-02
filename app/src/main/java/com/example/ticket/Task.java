package com.example.ticket;

public class Task {
    private int fk_iduser;
    private String title;
    private String text;

    public Task (int fk_iduser, String title, String text){
        this.title=title;
        this.fk_iduser=fk_iduser;
        this.text=text;

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

    @Override
    public String toString() {
        return "Task{" +
                "fk_iduser=" + fk_iduser +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
