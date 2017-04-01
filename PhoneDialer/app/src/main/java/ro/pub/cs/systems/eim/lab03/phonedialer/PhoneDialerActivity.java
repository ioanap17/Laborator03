package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.v4.content.ContextCompat;
import android.Manifest;


public class PhoneDialerActivity extends AppCompatActivity {

    private EditText text = null;

    private ButtonOnClickListener buttonOnClickListener = new ButtonOnClickListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        text = (EditText) findViewById(R.id.editText2);


        ImageButton deleteButton = (ImageButton) findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = text.getText().toString();
                if(phoneNumber.length() > 0){
                    text.setText(phoneNumber.substring(0, phoneNumber.length() - 1));
                }
            }
        });

        ImageButton callButton = (ImageButton) findViewById(R.id.button_call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = text.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                } else {
                    ActivityCompat.requestPermissions(PhoneDialerActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });

        ImageButton hangButton = (ImageButton) findViewById(R.id.button_hangup);
        hangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                finish();
            }
        });

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(buttonOnClickListener);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(buttonOnClickListener);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(buttonOnClickListener);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(buttonOnClickListener);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(buttonOnClickListener);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(buttonOnClickListener);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(buttonOnClickListener);
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(buttonOnClickListener);
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(buttonOnClickListener);
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(buttonOnClickListener);
        Button button_star = (Button) findViewById(R.id.button_star);
        button_star.setOnClickListener(buttonOnClickListener);
        Button button_diez = (Button) findViewById(R.id.button_diez);
        button_diez.setOnClickListener(buttonOnClickListener);
    }

    private class ButtonOnClickListener implements  View.OnClickListener{
        @Override
        public void onClick(View v) {
            text.setText(text.getText().toString() + ((Button)v).getText().toString());
        }
    }
}
