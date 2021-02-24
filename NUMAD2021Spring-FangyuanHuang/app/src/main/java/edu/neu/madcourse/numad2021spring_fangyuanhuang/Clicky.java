package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Clicky extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky);
    }

    public void ClickyClickA(View view) {
        TextView ClickyText = findViewById(R.id.ClickyText);
        ClickyText.setText("Pressed: A");
    }

    public void ClickyClickB(View view) {
        TextView ClickyText = findViewById(R.id.ClickyText);
        ClickyText.setText("Pressed: B");
    }

    public void ClickyClickC(View view) {
        TextView ClickyText = findViewById(R.id.ClickyText);
        ClickyText.setText("Pressed: C");
    }

    public void ClickyClickD(View view) {
        TextView ClickyText = findViewById(R.id.ClickyText);
        ClickyText.setText("Pressed: D");
    }

    public void ClickyClickE(View view) {
        TextView ClickyText = findViewById(R.id.ClickyText);
        ClickyText.setText("Pressed: E");
    }

    public void ClickyClickF(View view) {
        TextView ClickyText = findViewById(R.id.ClickyText);
        ClickyText.setText("Pressed: F");
    }
}
