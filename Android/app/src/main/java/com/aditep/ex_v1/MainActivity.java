package com.aditep.ex_v1;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvResult, tv1;
    EditText editText1;
    EditText editText2;
    Button btncalulate;
    RadioGroup rdGroup;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {

            Toast.makeText(this, "Menu Setting ok", Toast.LENGTH_SHORT).show();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Toast.makeText(MainActivity.this, "Width = " + width + "height = " + height, Toast.LENGTH_SHORT).show();

    }

    private void initInstances() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        tv1 = (TextView) findViewById(R.id.tv1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        btncalulate = (Button) findViewById(R.id.btncalulate);
        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);

        btncalulate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btncalulate) {

            DatabaseReference mRootRef;
            mRootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference mUsersRef = mRootRef.child("users");
            DatabaseReference mMessagesRef = mRootRef.child("messages");

            mUsersRef.child("id-1234").setValue("Aditep");
            int val1 = 0, val2 = 0, sum = 0;

            try {
                val1 = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException e) {
            }
            try {
                val2 = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException e) {
            }

            switch (rdGroup.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    tv1.setText("+");
                    sum = val1 + val2;
                    break;
                case R.id.rbMinus:
                    tv1.setText("-");
                    sum = val1 - val2;
                    break;
                case R.id.rbMultiply:
                    tv1.setText("*");
                    sum = val1 * val2;
                    break;
                case R.id.rbDivide:
                    tv1.setText("/");
                    sum = val1 / val2;
                    break;
            }
            tvResult.setText(sum + "");
            Log.d("Calcuation", "Result = " + sum);
            Toast.makeText(MainActivity.this, "Result = " + sum, Toast.LENGTH_SHORT).show();
        }

    }
}

