package com.example.chatiniciante;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "id_mensagem_extra";
    public final static int TEXT_REQUEST = 2222;

    private TextView mTextView1;
    private TextView mTextView2;
    private EditText mEditTextMensagem;
    private Button mButtonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView1 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mEditTextMensagem = findViewById(R.id.editTextMensagem);
        mButtonEnviar = findViewById(R.id.button);

        mButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSegundaTela = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intentSegundaTela);

                String message = mEditTextMensagem.getText().toString();
                intentSegundaTela.putExtra(EXTRA_MESSAGE, message);

                startActivityForResult(intentSegundaTela, TEXT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case TEXT_REQUEST:
                if (resultCode == RESULT_OK) {
                    String message = data.getStringExtra("MESSAGE");
                    mTextView2.setText(message);
                }
        }

    }


}