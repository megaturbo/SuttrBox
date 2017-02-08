package ch.foufouillons.suttrbox;

import android.net.Uri;

public class Giggle {

    private String filename;
    private String title;

    public Giggle(String title, String filename){
        this.title = title;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String soundUri) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
