package org.techtown.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllComment extends AppCompatActivity {
    CommentAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_comment);

        TextView text1 = (TextView) findViewById(R.id.text1);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommentWrite.class);
                startActivityForResult(intent, 103);
            }
        });


        listView = (ListView) findViewById(R.id.listView);
        adapter = new CommentAdapter();
        Intent intent = getIntent();
        ArrayList<Comment> data = intent.getParcelableArrayListExtra("data");
        for(int i=0; i<data.size(); i++){
            adapter.addItem(data.get(i));
        }
        listView.setAdapter(adapter);

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
