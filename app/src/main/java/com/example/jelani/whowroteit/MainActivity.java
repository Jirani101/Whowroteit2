package com.example.jelani.whowroteit;

import android.content.Context;
import android.hardware.input.InputManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private EditText mBookInput;
    private TextView mAuthorTitle, mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = findViewById(R.id.bookInput);
        mAuthorTitle = findViewById(R.id.authorText);
        mTitleText = findViewById(R.id.textTitle);
    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();

        //For hiding the keyboard when the search input is clicked
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        //Checking the network state and empty field case
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0) {
            new FetchBook(mTitleText, mAuthorTitle).execute(queryString);
            mAuthorTitle.setText("");
            mTitleText.setText(R.string.loading);

        } else {
            if (queryString.length() == 0) {
                mAuthorTitle.setText("");
                mTitleText.setText("Please enter a search term");
            } else {
                mAuthorTitle.setText("");
                mTitleText.setText("Please check your network connection and try again");
            }

        }


    }
}
