package com.emojidex.android_sample.appwithemojidex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emojidex.emojidexandroid.Emojidex;

import static android.R.attr.editable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Emojidex emojidex = Emojidex.getInstance();
        emojidex.initialize(this);
        final TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(emojidex.emojify(emojidex.deEmojify("👯Hello :羽(右):World:羽(左):!")));

        final EditText editText = (EditText)findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editText.removeTextChangedListener(this);

                Emojidex emojidex = Emojidex.getInstance();
                s.replace(0, s.length(), emojidex.emojify(s));

                editText.addTextChangedListener(this);
            }
        });
    }
}
