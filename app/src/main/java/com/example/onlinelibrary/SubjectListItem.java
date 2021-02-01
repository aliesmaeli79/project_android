package com.example.onlinelibrary;

public class SubjectListItem {

    private int text_image;
    private int image_subject;

    public int getText_image() {
        return text_image;
    }

    public void setText_image(int text_image) {
        this.text_image = text_image;
    }

    public SubjectListItem(int text_image, int image_subject) {
        this.text_image = text_image;
        this.image_subject = image_subject;
    }

    public int getImage_subject() {
        return image_subject;
    }

    public void setImage_subject(int image_subject) {
        this.image_subject = image_subject;
    }

}
