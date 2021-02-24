package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void convertCurrency(View view) {
//        EditText dollarText = findViewById(R.id.dollarText);
//        TextView textView = findViewById(R.id.converResult);
//
//        if (!dollarText.getText().toString().equals("")) {
//            float dollarValue = Float.valueOf(dollarText.getText().toString());
//            float euroValue = dollarValue * 0.85F;
//            textView.setText(
//                    String.format(Locale.getDefault(), "%.2f", euroValue));
//        } else {
//            textView.setText(R.string.no_value_string);
//        }
//    }

    public void showAbout(View view) {
        TextView AboutString = findViewById(R.id.textView);
        AboutString.setText(R.string.my_info);
    }

}