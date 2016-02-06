package com.example.cookmilk.crunchtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CrunchTime extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crunch_time);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText5);
        e6 = (EditText) findViewById(R.id.editText6);
        e7 = (EditText) findViewById(R.id.editText7);
        b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pushUp = 0.0;
                double sitUp = 0.0;
                double jumpJacks = 0.0;
                double jogging = 0.0;
                double calBun = 0.0;
                double singlePushUp = 100.0/350.0;
                double singleSitUp = 100.0/200.0;
                double singleJumpJacks = 100.0/10.0;
                double singleJogging = 100.0/12.0;
                DecimalFormat fmt = new DecimalFormat("#.##");
                String type = e1.getText().toString();
                double repMin = Double.parseDouble(e2.getText().toString());
                if (type.equalsIgnoreCase("pushup")) {
                    calBun = singlePushUp * repMin;
                    pushUp = repMin;
                    sitUp = calBun / singleSitUp;
                    jumpJacks = calBun / singleJumpJacks;
                    jogging = calBun / singleJogging;
                } else if (type.equalsIgnoreCase("situp")) {
                    calBun = singleSitUp * repMin;
                    sitUp = repMin;
                    pushUp = calBun / singlePushUp;
                    jumpJacks = calBun / singleJumpJacks;
                    jogging = calBun / singleJogging;
                } else if (type.equalsIgnoreCase("jumping jacks")) {
                    calBun = singleJumpJacks * repMin;
                    jumpJacks = repMin;
                    pushUp = calBun / singlePushUp;
                    sitUp = calBun / singleSitUp;
                    jogging = calBun / singleJogging;
                } else if (type.equalsIgnoreCase("jogging")) {
                    calBun = singleJogging * repMin;
                    jogging = repMin;
                    pushUp = calBun / singlePushUp;
                    sitUp = calBun / singleSitUp;
                    jumpJacks = calBun / singleJumpJacks;
                }
                e3.setText("" + fmt.format(pushUp) + " rep(s)");
                e4.setText("" + fmt.format(sitUp) + " rep(s)");
                e5.setText("" + fmt.format(jumpJacks) + " minute(s)");
                e6.setText("" + fmt.format(jogging) + " minute(s)");
                e7.setText("" + fmt.format(calBun));
            }
        });
    }
}
