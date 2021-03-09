package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


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

    public void startClickyActivity(View view) {
        Intent intent = new Intent(this, ClickyActivity.class);
        startActivity(intent);
    }

    public void startLickCollectorActivity(View view) {
        Intent intent = new Intent(this, LinkCollectorActivity.class);
        startActivity(intent);
    }

    public void startLocatorActivity(View view) {
        Intent intent = new Intent(this, LocatorActivity.class);
        startActivity(intent);
    }

    public void startWebServiceActivity(View view) {
        Intent intent = new Intent(this, WebServiceActivity.class);
        startActivity(intent);
    }
}