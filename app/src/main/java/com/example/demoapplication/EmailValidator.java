package com.example.demoapplication;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/**
 * An Email format validator for {@link android.widget.EditText}.
 */
public class EmailValidator implements TextWatcher {
    /**
     * Email validation pattern.
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z\\d+._%\\-]{1,256}" +
                    "@" +
                    "[a-zA-Z\\d][a-zA-Z\\d\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z\\d][a-zA-Z\\d\\-]{0,25}" +
                    ")+"
    );
    private boolean mIsValid = false;
    public boolean isValid() {
        return mIsValid;
    }
    /**
     * Validates if the given input is a valid email address.
     *
     * @param email        The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidEmail(editableText);
    }
    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}
    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}
}