package com.example.onlinelibrary;

public class SubjectListItem {

    private String text_subject;
    private int image_subject;

    public String getText_subject() {
        return text_subject;
    }

    public void setText_subject(String text_subject) {
        this.text_subject = text_subject;
    }


    public SubjectListItem(String text_subject, int image_subject) {
        this.text_subject = text_subject;
        this.image_subject = image_subject;
    }

    public int getImage_subject() {
        return image_subject;
    }

    public void setImage_subject(int image_subject) {
        this.image_subject = image_subject;
    }

}
