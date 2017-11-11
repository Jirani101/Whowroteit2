package com.example.jelani.whowroteit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private EditText mBookInput;
    private TextView mAuthorTitle, mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = (EditText)findViewById(R.id.bookInput);
        mAuthorTitle = (TextView)findViewById(R.id.authorText);
        mTitleText = (TextView)findViewById(R.id.textTitle);
    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        Log.i(TAG,"Searched " + queryString);


    }
}
