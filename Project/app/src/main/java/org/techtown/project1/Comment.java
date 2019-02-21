package org.techtown.project1;

import android.media.Rating;
import android.widget.RatingBar;

public class Comment {
    String id;
    String comment;
    String time;
    String recommend;
    String report;
    int bar;
    int resId;

    public Comment(String id, String comment, String time, String recommend, String report, int bar, int resId) {
        this.id = id;
        this.comment = comment;
        this.time = time;
        this.recommend = recommend;
        this.report = report;
        this.bar = bar;
        this.resId = resId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getBar(){
        return bar;
    }

    public void setBar(int Bar){
        this.bar = Bar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                ", time='" + time + '\'' +
                ", recommend='" + recommend + '\'' +
                ", report='" + report + '\'' +
                '}';
    }
}
