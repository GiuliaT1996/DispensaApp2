package com.dispensa.service;

import android.util.Log;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class AuthenticationService {

    public void registerUser() {
        AuthSignUpOptions options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.email(), "gtincano@gmail.com")
                .build();
        Amplify.Auth.signUp("username123", "password", options,
                result -> Log.i("AuthQuickStart", "Result: " + result),
                error -> Log.e("AuthQuickStart", "Sign up failed", error)
        );
        confirmation();

    }

    private void confirmation() {
        Amplify.Auth.confirmSignUp(
                "username123",
                "496512",
                result -> Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete"),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }

    public void signIn() {
        Amplify.Auth.signIn(
                "username123",
                "password",
                result -> Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete"),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }

    public void checkConnection() {
        Amplify.Auth.fetchAuthSession(
                result -> Log.i("AmplifyQuickstart", result.toString()),
                error -> Log.e("AmplifyQuickstart", error.toString())
        );
    }

}
