package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {

    private EditText text = null;

    private DeleteButtonOnClickListener button_delete = new DeleteButtonClickListener();

    private class DeleteButtonOnClickListener implements View.OnClickListener{

        @Override
        void OnClick(View view){
            String phoneNumber = text.getText().toString();
            if (phoneNumber.length() > 0) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
                text.setText(phoneNumber);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        EditText text = new EditText(this);
        text.setText("");

        ImageButton deleteButton = (ImageButton) findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(button_delete);
    }
}
