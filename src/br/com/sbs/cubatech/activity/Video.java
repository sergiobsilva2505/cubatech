package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import java.time.LocalTime;

public class Video extends Activity{

    String urlVideo;
    LocalTime duration;
    String transcription;

    public Video(Long id, String title, String urlCode, Boolean active, Integer order, Lesson lesson, String urlVideo, LocalTime duration, String transcription) {
        super(id, title, urlCode, active, order, lesson);
        this.urlVideo = urlVideo;
        this.duration = duration;
        this.transcription = transcription;
    }
}
