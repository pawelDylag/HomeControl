package com.paweldylag.homecontrol.presenter;


import com.paweldylag.homecontrol.app.exception.LoginException;
import com.paweldylag.homecontrol.app.service.AccountRepository;
import com.paweldylag.homecontrol.view.LoginView;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class LoginPresenterImpl extends BasePresenter implements LoginPresenter  {

  private LoginView view;
  private AccountRepository accountRepository;

  public LoginPresenterImpl(LoginView view, AccountRepository accountRepository) {
    super();
    this.view = view;
    this.accountRepository = accountRepository;
  }

  @Override
  public void onDestroy() {

  }

  @Override
  public void attemptLogin(String login, String password) {
    view.showProgress(true);
    if (login == null) {
      view.showProgress(false);
      view.showEmptyLogin();
      return;
    }
    if (password == null) {
      view.showProgress(false);
      view.showEmptyPassword();
      return;
    }
    accountRepository.login(login, password, new AccountRepository.LoginCallback() {
      @Override
      public void onSuccess() {
        view.proceedWithLogin();
      }

      @Override
      public void onError(LoginException e) {
        view.showProgress(false);
        switch (e.getCode()) {
          case LoginException.ERROR_EMPTY_LOGIN:
            view.showEmptyLogin();
            break;
          case LoginException.ERROR_EMPTY_PASSWORD:
            view.showEmptyPassword();
            break;
          case LoginException.ERROR_WRONG_PASSWORD:
            view.showWrongPassword();
            break;
          default:
            view.showError(e);
        }
      }
    });
  }
}
