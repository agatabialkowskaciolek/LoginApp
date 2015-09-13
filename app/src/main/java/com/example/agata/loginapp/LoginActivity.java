package com.example.agata.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY = "0";
    public static final String SETTING_INFOS = "SETTING_Infos";
    public static final String NAME = "NAME";
    public static final String PASSWORD = "PASSWORD";
    public String userLogin;
    public EditText loginEditText;
    private EditText passwordEditText;

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
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

        Button buttonLogin = (Button) findViewById(R.id.loginButton);
        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);
        String userLogin = settings.getString(NAME, "");
        String password = settings.getString(PASSWORD, "");

        if (!userLogin.isEmpty() && !password.isEmpty()) {
            loginEditText.setText(userLogin);
            passwordEditText.setText(password);
        }

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

    public boolean isLegalPassword(String pass) {
        String str;

        if (!pass.matches(".*[A-Z].*")) return false;

        if (!pass.matches(".*[a-z].*")) return false;

        if (!pass.matches(".*\\d.*")) return false;

        // if (!pass.matches(".*[~!.......].*")) return false;

        return true;
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";


        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public void onClickButtonLogin(View view) {


        String password;
        TextView incorrectLogin;
        TextView incorrectPassword;

        userLogin = loginEditText.getText().toString();
        password = passwordEditText.getText().toString();
        incorrectLogin = (TextView) findViewById(R.id.missingAtLoginTextView);
        incorrectPassword = (TextView) findViewById(R.id.incorrectPasswordTextView);
        String incorrectPasswordString = incorrectPassword.getText().toString();


        if (userLogin.equals("") || password.equals("")) {

            Toast.makeText(this, "Pole login lub hasło jest puste", Toast.LENGTH_SHORT).show();
                        /*  Intent mainAppIntent = new Intent(this,AppActivity.class);
                startActivity(mainAppIntent);*/
        }
        /*else if (!userLogin.contains("@")){
            Toast.makeText(this, "login musi zawierac @", Toast.LENGTH_SHORT).show();
        }*/
        else if (!isLegalPassword(password)) {
            Toast.makeText(this, "hasło musi mieć!!", Toast.LENGTH_SHORT).show();


        } else if (!isEmailValid(userLogin)) {

            Toast.makeText(this, "login musi zawierac @", Toast.LENGTH_SHORT).show();
        } else {

            SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);

            settings.edit()
                    .putString(NAME, loginEditText.getText().toString())
                    .putString(PASSWORD, passwordEditText.getText().toString())
                    .apply();


            Intent mainAppIntent = new Intent(this, MainActivity.class);
            mainAppIntent.putExtra("username", userLogin);
            // intent.putExtra("username",edUsername.getText().toString());
            startActivity(mainAppIntent);


        }


    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}


