package com.example.dell.hi_kitu;

import android.media.Image;

/**
 * Created by dell on 16-Jun-17.
 */

public class Posts {

    String title;
    String content;
    int photo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public Posts(String title, String content, int photo) {

        this.title = title;
        this.content = content;
        this.photo = photo;
    }
}
