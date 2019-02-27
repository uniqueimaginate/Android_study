package org.techtown.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class CommentWrite extends AppCompatActivity {
    RatingBar ratingBar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_write);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        editText = (EditText) findViewById(R.id.editText);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            Intent intent = getIntent();

            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void returnToMain(){
        float ratingNum = ratingBar.getRating();
        String contents = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("rating", ratingNum);
        intent.putExtra("contents", contents);
        setResult(RESULT_OK, intent);
        finish();
    }
}
