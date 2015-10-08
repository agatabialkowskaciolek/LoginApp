package com.example.agata.loginapp;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Agata on 2015-10-06.
 */
public class ValidationLoginClass {

    EditText ed1;
    EditText ed2;
    Context conext;
    ValidatorListener vl;


    public ValidationLoginClass(Context context, EditText ed1, EditText ed2, ValidatorListener vl) {
        this.conext = context;
        this.ed1 = ed1;
        this.ed2 = ed2;
        this.vl = vl;
    }

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

    public boolean isLegalPassword(String pass) {
        String str;

        if (!pass.matches(".*[A-Z].*")) return false;

        if (!pass.matches(".*[a-z].*")) return false;

        if (!pass.matches(".*\\d.*")) return false;

        // if (!pass.matches(".*[~!.......].*")) return false;

        return true;
    }

    public void checkValidations() {

        if (ed1.getText().toString().equals("") || ed2.getText().toString().equals("")) {

            Toast.makeText(conext, "Pole login lub hasło jest puste", Toast.LENGTH_SHORT).show();

        } else if (!isLegalPassword(ed2.getText().toString())) {
            Toast.makeText(conext, "hasło musi mieć!!", Toast.LENGTH_SHORT).show();


        } else if (!isEmailValid(ed1.getText().toString())) {

            Toast.makeText(conext, "login musi zawierac @", Toast.LENGTH_SHORT).show();
        } else {

            vl.onSuccess();

        }
    }

    public interface ValidatorListener {
        void onSuccess();
    }
}