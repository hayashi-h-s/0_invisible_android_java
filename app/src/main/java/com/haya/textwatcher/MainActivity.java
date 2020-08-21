package com.haya.textwatcher;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        // リスナーを登録
        editText.addTextChangedListener(this);

        textView = findViewById(R.id.text_view);

        String inputStr= textView.toString();

        if (inputStr.equals("0")) {
            textView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // テキスト変更後に変更されたテキストを取り出す
        String inputStr= s.toString();

        // 0が入力されている時は、消える。それ以外は表示
        textView.setText(inputStr);
        if (inputStr.equals("0")) {
            textView.setVisibility(View.INVISIBLE);
        } else {
            textView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}