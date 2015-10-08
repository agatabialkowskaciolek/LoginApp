package com.example.agata.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY = "0";
    public static final String SETTING_INFOS = "SETTING_Infos";
    public static final String NAME = "NAME";
    public static final String PASSWORD = "PASSWORD";
    public String userLogin;
    public EditText loginEditText;
    Button buttonLogin;
    private EditText passwordEditText;


      /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);
        String userLogin = settings.getString(NAME, "");
        String password = settings.getString(PASSWORD, "");

        if (!userLogin.isEmpty() && !password.isEmpty()) {
            loginEditText.setText(userLogin);
            passwordEditText.setText(password);
        }

        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    onSend();
                }


                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public void onClickButtonLogin(View view) {
        onSend();
    }

    private void onSend() {

        ValidationLoginClass validationLoginClass = new ValidationLoginClass(this, loginEditText, passwordEditText, new ValidationLoginClass.ValidatorListener() {
            @Override
            public void onSuccess() {
                Intent mainAppIntent = new Intent(LoginActivity.this, MainActivity.class);
                mainAppIntent.putExtra("username", userLogin);
                // intent.putExtra("username",edUsername.getText().toString());
                startActivity(mainAppIntent);


                SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);

                settings.edit()
                        .putString(NAME, loginEditText.getText().toString())
                        .putString(PASSWORD, passwordEditText.getText().toString())
                        .apply();
            }
        });

        validationLoginClass.checkValidations();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


}


