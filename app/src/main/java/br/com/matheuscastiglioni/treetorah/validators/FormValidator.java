package br.com.matheuscastiglioni.treetorah.validators;

import android.widget.EditText;

public class FormValidator {


    public static boolean validateField(EditText field) {
        boolean hasValue = field.getText().toString().trim().length() > 0;
        if (!hasValue) {
            field.setError("Campo obrigatório");
        }
        return hasValue;
    }

}
