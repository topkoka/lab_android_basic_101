package com.aditep.ex_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int sum = 0;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        sum = intent.getIntExtra("result", 0);

        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("y");
        int z = bundle.getInt("z");

        CoordinateSerializable c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable");

        CoordinateParcelable c3 = intent.getParcelableExtra("cParcelable");
        initInstances();
    }

    private void initInstances() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText("Result =" + sum);
    }
}
