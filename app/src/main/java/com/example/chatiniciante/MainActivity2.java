package com.example.chatiniciante;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.chatiniciante.MainActivity.TEXT_REQUEST;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTextMessage;
    private EditText mEditTextMensagem2;
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mEditTextMensagem2 = findViewById(R.id.editText_second);
        mButton2 = findViewById(R.id.button_second);

        final Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        mTextMessage = findViewById(R.id.text_message);
        mTextMessage.setText(message);

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View view) {

                String message = mEditTextMensagem2.getText().toString();
                Intent intentPrimeiraTela = new Intent(MainActivity2.this, MainActivity.class);
                intentPrimeiraTela.putExtra("MESSAGE", message);
                setResult(Activity.RESULT_OK, intentPrimeiraTela);
                finish();

            }
        });
    }

}