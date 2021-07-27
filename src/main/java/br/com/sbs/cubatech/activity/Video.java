package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import static br.com.sbs.cubatech.validation.Validator.*;

@Entity
@Table(name = "video")
@PrimaryKeyJoinColumn(name = "activity_id")
public class Video extends Activity{

    private String url;
    @Column(name = "durationInMinutes")
    private Integer duration;
    @Column(columnDefinition = "TEXT")
    private String transcription;

    @Deprecated
    public Video(){

    }

    public Video(String title, String urlCode,  Lesson lesson, String url) {
        super(title, urlCode,  lesson);
        notEmptyOrNull(url, "Video: UrlCode");
        this.url = url;

    }
}
