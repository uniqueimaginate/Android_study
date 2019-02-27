package org.techtown.project1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class CommentView extends LinearLayout {
    TextView id;
    TextView comment;
    TextView time;
    TextView recommend;
    TextView report;
    RatingBar bar;
    ImageView usericon;

    public CommentView(Context context) {
        super(context);

        init(context);
    }

    public CommentView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_view, this, true);

        id = (TextView) findViewById(R.id.id);
        comment = (TextView)findViewById(R.id.comment);
        time = (TextView) findViewById(R.id.time);
        recommend = (TextView) findViewById(R.id.recommend);
        report = (TextView) findViewById(R.id.report);
        bar = (RatingBar)findViewById(R.id.bar);
        usericon = (ImageView)findViewById(R.id.usericon);
    }

    public void setId(String Id){
        id.setText(Id);
    }

    public void setComment(String Comment){
        comment.setText(Comment);
    }

    public void setBar(float Bar) {
        bar.setRating(Bar);
    }

    public void setTime(String Time) {
        time.setText(Time);
    }

    public void setRecommend(String Recommend){
        recommend.setText(Recommend);
    }

    public void setReport(String Report){
        report.setText(Report);
    }

    public void setImage(int resId){
        usericon.setImageResource(resId);
    }

}
