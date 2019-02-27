package org.techtown.project1;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RatingBar;

public class Comment implements Parcelable {
    String id;
    String comment;
    String time;
    String recommend;
    String report;
    float bar;
    int resId;

    public Comment(String id, String comment, String time, String recommend, String report, float bar, int resId) {
        this.id = id;
        this.comment = comment;
        this.time = time;
        this.recommend = recommend;
        this.report = report;
        this.bar = bar;
        this.resId = resId;
    }

    public Comment(Parcel src){
        id = src.readString();
        comment = src.readString();
        time = src.readString();
        recommend = src.readString();
        report = src.readString();
        bar = src.readFloat();
        resId = src.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Comment createFromParcel(Parcel src) {
            return new Comment(src);
        }
        public Comment[] newArray(int size){
            return new Comment[size];
        }

    };

    @Override
    public int describeContents() {
            return 0;
            }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(comment);
            dest.writeString(time);
            dest.writeString(recommend);
            dest.writeString(report);
            dest.writeFloat(bar);
            dest.writeInt(resId);
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

    public float getBar(){
        return bar;
    }

    public void setBar(float Bar){
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
