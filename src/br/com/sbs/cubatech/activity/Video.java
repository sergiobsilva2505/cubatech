package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import java.time.LocalTime;

public class Video extends Activity{

    private String url;
    private LocalTime duration; // todo duration in minutes Integer
    private String transcription;

    public Video(Long id, String title, String urlCode, Boolean active, Integer order, Lesson lesson, String url, LocalTime duration, String transcription) {  // todo somente obrigatorio
        super(id, title, urlCode, active, order, lesson);
        this.url = url;
        this.duration = duration;
        this.transcription = transcription;
    }
}
