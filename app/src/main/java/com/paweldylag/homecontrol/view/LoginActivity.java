package com.paweldylag.homecontrol.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.paweldylag.homecontrol.R;
import com.paweldylag.homecontrol.app.App;
import com.paweldylag.homecontrol.app.exception.LoginException;
import com.paweldylag.homecontrol.presenter.LoginPresenter;
import com.paweldylag.homecontrol.presenter.LoginPresenterImpl;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

  private LoginPresenter mLoginPresenter;

  // UI references.
  private AutoCompleteTextView mLoginView;
  private EditText mPasswordView;
  private View mProgressView;
  private View mLoginFormView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);
      // Set up the login form.
      mLoginView = (AutoCompleteTextView) findViewById(R.id.email);

      mPasswordView = (EditText) findViewById(R.id.password);
      mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
          @Override
          public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
              if (id == R.id.login || id == EditorInfo.IME_NULL) {
                  attemptLogin();
                  return true;
              }
              return false;
          }
      });

      Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
      mEmailSignInButton.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View view) {
             attemptLogin();
          }
      });

      mLoginFormView = findViewById(R.id.login_form);
      mProgressView = findViewById(R.id.login_progress);
      mLoginPresenter = new LoginPresenterImpl(this, App.getServiceProvider().getAccountRepository());

  }

  private void attemptLogin() {
      mLoginView.setError(null);
      mPasswordView.setError(null);

      String login = mLoginView.getText().toString();
      String password = mPasswordView.getText().toString();

      mLoginPresenter.attemptLogin(login, password);
  }


  @Override
  public void showEmptyLogin() {
    mLoginView.requestFocus();
    mLoginView.setError("Login must not be empty.");
  }

  @Override
  public void showEmptyPassword() {
    mPasswordView.requestFocus();
    mPasswordView.setError("Password must not be empty.");
  }

  @Override
  public void showWrongPassword() {
    mPasswordView.requestFocus();
    mPasswordView.setError("Password is wrong.");
  }

  @Override
  public void proceedWithLogin() {
    Intent intent = new Intent(this, RoomListActivity.class);
    startActivity(intent);
    finish();
  }

  @Override
  public void showProgress(final boolean show) {
    // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
    // for very easy animations. If available, use these APIs to fade-in
    // the progress spinner.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
      int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

      mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
      mLoginFormView.animate().setDuration(shortAnimTime).alpha(
          show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
      });

      mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
      mProgressView.animate().setDuration(shortAnimTime).alpha(
          show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
      });
    } else {
      // The ViewPropertyAnimator APIs are not available, so simply show
      // and hide the relevant UI components.
      mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
      mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
    }
  }

  @Override
  public void showError(LoginException e) {
    Toast.makeText(this, "Error! Code: " + e.getCode(), Toast.LENGTH_SHORT).show();
  }
}

