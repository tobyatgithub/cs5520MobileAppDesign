package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebServiceActivity extends AppCompatActivity {
    private EditText urlEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: how do I fix editText width by percentage of parent width?
        setContentView(R.layout.activity_web_service);

        urlEditText = (EditText) findViewById(R.id.url_editText);

    }


}
