package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import javax.persistence.Entity;

import static br.com.sbs.cubatech.validation.Validator.*;


public class Video extends Activity{

    private String url;
    private Integer duration;
    private String transcription;

    public Video(){

    }

    public Video(String title, String urlCode,  Lesson lesson, String url) {
        super(title, urlCode,  lesson);
        notEmptyOrNull(url, "Video: UrlCode");
        this.url = url;

    }
}
