package com.example.onlinelibrary;

public class SubjectListItem {

    private String name_subject;

    private int text_image;
    private int image_subject;

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public int getText_image() {
        return text_image;
    }

    public void setText_image(int text_image) {
        this.text_image = text_image;
    }

    public SubjectListItem(int text_image, int image_subject,String name_subject) {
        this.text_image = text_image;
        this.image_subject = image_subject;
        this.name_subject=name_subject;
    }

    public int getImage_subject() {
        return image_subject;
    }

    public void setImage_subject(int image_subject) {
        this.image_subject = image_subject;
    }

}
