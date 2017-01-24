package com.paweldylag.homecontrol.presenter;

import android.os.Build;

import com.paweldylag.homecontrol.BuildConfig;
import com.paweldylag.homecontrol.app.exception.LoginException;
import com.paweldylag.homecontrol.app.service.AccountRepository;
import com.paweldylag.homecontrol.view.LoginView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class LoginPresenterImplTest {

  // ===========================================================
  // TESTS
  // ===========================================================

  @Test
  public void shows_info_when_wrong_password() {
    // given
    LoginView view = mock(LoginView.class);
    LoginPresenter presenter = new LoginPresenterImpl(view, new DummyAccountRepository());
    String login = "wrong";
    String password = "wrong";

    // when
    presenter.attemptLogin(login, password);

    // then
    verify(view).showWrongPassword();
  }

  @Test
  public void shows_info_when_empty_login() {
    // given
    LoginView view = mock(LoginView.class);
    LoginPresenter presenter = new LoginPresenterImpl(view, new DummyAccountRepository());
    String login = "";
    String password = "password";

    // when
    presenter.attemptLogin(login, password);

    // then
    verify(view).showEmptyLogin();
  }

  @Test
  public void shows_info_when_empty_password() {
    // given
    LoginView view = mock(LoginView.class);
    LoginPresenter presenter = new LoginPresenterImpl(view, new DummyAccountRepository());
    String login = "login";
    String password = "";

    // when
    presenter.attemptLogin(login, password);

    // then
    verify(view).showEmptyPassword();
  }

  @Test
  public void proceed_with_login_when_data_valid() {
    // given
    LoginView view = mock(LoginView.class);
    LoginPresenter presenter = new LoginPresenterImpl(view, new DummyAccountRepository());
    String login = "login";
    String password = "password";

    // when
    presenter.attemptLogin(login, password);

    // then
    verify(view).proceedWithLogin();
  }



  // ===========================================================
  // METHODS AND SUPPORT CLASSES
  // ===========================================================

  public static class DummyAccountRepository implements AccountRepository {

    private final String login = "login";
    private final String password = "password";

    @Override
    public void login(String login, String password, LoginCallback callback) {
      if (login == null || login.isEmpty()) {
        callback.onError(new LoginException(LoginException.ERROR_EMPTY_LOGIN, ""));
      } else {
        if (login.equals(this.login) && password.equals(this.password)) {
          callback.onSuccess();
        } else {
          callback.onError(new LoginException(LoginException.ERROR_WRONG_PASSWORD, ""));
        }

      }
    }
  }

}