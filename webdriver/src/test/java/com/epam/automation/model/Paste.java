package com.epam.automation.model;

import java.util.Objects;

public class Paste {
    private String title;
    private String text;
    private String highlighting;
    private String expiration;

    public Paste(String title, String text, String highlighting, String expiration) {
        this.title = title;
        this.text = text;
        this.highlighting = highlighting;
        this.expiration = expiration;
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

    public String getHighlighting() {
        return highlighting;
    }

    public void setHighlighting(String highlighting) {
        this.highlighting = highlighting;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Paste{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", highlighting='" + highlighting + '\'' +
                ", expiration='" + expiration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paste paste = (Paste) o;
        return title.equals(paste.title) &&
                text.equals(paste.text) &&
                Objects.equals(highlighting, paste.highlighting) &&
                expiration.equals(paste.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, highlighting, expiration);
    }
}

