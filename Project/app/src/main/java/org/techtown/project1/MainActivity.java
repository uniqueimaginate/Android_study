package org.techtown.project1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int likeCount = 15;
    int hateCount = 1;

    boolean likeButton = false;
    boolean hateButton = false;

    Button thumbs_up;
    Button thumbs_down;

    TextView thumbs_up_count;
    TextView thumbs_down_count;

    CommentAdapter adapter;

    TextView text1;
    Button seeall;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbs_up = (Button) findViewById(R.id.likeButton);
        thumbs_down = (Button) findViewById(R.id.hateButton);
        thumbs_up_count = (TextView) findViewById(R.id.likeCount);
        thumbs_down_count = (TextView) findViewById(R.id.hateCount);

        thumbs_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeButton == false && hateButton == false) {
                    likeCount += 1;
                    thumbs_up_count.setText(String.valueOf(likeCount));
                    thumbs_up.setBackgroundResource(R.drawable.ic_thumb_up_selected);
                } else if (likeButton == true && hateButton == false) {
                    likeCount -= 1;
                    thumbs_up_count.setText(String.valueOf(likeCount));
                    thumbs_up.setBackgroundResource(R.drawable.ic_thumb_up);
                } else {
                    likeCount += 1;
                    hateCount -= 1;
                    thumbs_down_count.setText(String.valueOf(hateCount));
                    thumbs_down.setBackgroundResource(R.drawable.ic_thumb_down);
                    thumbs_up.setBackgroundResource(R.drawable.ic_thumb_up_selected);
                    hateButton = !hateButton;
                }
                thumbs_up_count.setText(String.valueOf(likeCount));
                likeButton = !likeButton;
            }
        });

        thumbs_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeButton == false && hateButton == false) {
                    hateCount += 1;
                    thumbs_down_count.setText(String.valueOf(hateCount));
                    thumbs_down.setBackgroundResource(R.drawable.ic_thumb_down_selected);
                } else if (likeButton == false && hateButton == true) {
                    hateCount -= 1;
                    thumbs_down_count.setText(String.valueOf(hateCount));
                    thumbs_down.setBackgroundResource(R.drawable.ic_thumb_down);
                } else {
                    likeCount -= 1;
                    hateCount += 1;
                    thumbs_up_count.setText(String.valueOf(likeCount));
                    thumbs_up.setBackgroundResource(R.drawable.ic_thumb_up);
                    thumbs_down.setBackgroundResource(R.drawable.ic_thumb_down_selected);
                    likeButton = !likeButton;
                }
                thumbs_down_count.setText(String.valueOf(hateCount));
                hateButton = !hateButton;
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        adapter = new CommentAdapter();
        adapter.addItem(new Comment("kym77**", "적당히 재밌다. 오랜만에 잠 안오는 영화 잘 봤네요.", "10분전","추천  0","신고하기", 5 ,R.drawable.user1));

        listView.setAdapter(adapter);

        text1 = (TextView) findViewById(R.id.text1);
        seeall = (Button) findViewById(R.id.seeall);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"눌렸습니다.", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(getApplicationContext(), CommentWrite.class);
                startActivityForResult(intent, 101);
            }
        });
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "눌렸습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ViewAllComment.class);
                ArrayList<Comment> data = new ArrayList<Comment>();
                for(int i=0; i<adapter.getCount(); i++) {
                    data.add((Comment) adapter.getItem(i));
                }
                intent.putParcelableArrayListExtra("data", data);
                startActivityForResult(intent,102);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 101){
            if(intent != null){
                String contents = intent.getStringExtra("contents");
                float ratingNum = intent.getFloatExtra("rating", 0.0f);
                adapter.addItem(new Comment("kym77**", contents, "10분전", "추천  0", "신고하기", ratingNum, R.drawable.user1 ));
                listView.setAdapter(adapter);
            }
        }
    }

    class CommentAdapter extends BaseAdapter {

        ArrayList<Comment> items = new ArrayList<Comment>();

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        public void addItem(Comment item){
            items.add(item);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentView view = new CommentView(getApplicationContext());

            Comment item = items.get(position);
            view.setBar(item.getBar());
            view.setComment(item.getComment());
            view.setId(item.getId());
            view.setImage(item.getResId());
            view.setTime(item.getTime());
            view.setRecommend(item.getRecommend());
            view.setReport(item.getReport());
            return view;
        }
    }
}


