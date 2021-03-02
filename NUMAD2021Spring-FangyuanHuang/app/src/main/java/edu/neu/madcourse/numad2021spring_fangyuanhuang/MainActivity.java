package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showAbout(View view) {
        TextView AboutString = findViewById(R.id.textView);
        AboutString.setText(R.string.my_info);
    }

    public void goToClickyActivity(View view) {
        Intent intent = new Intent(this, Clicky.class);
        startActivity(intent);
    }

    public void goToLickCollector(View view) {
        Intent intent = new Intent(this, LinkCollector.class);
        startActivity(intent);
    }
}