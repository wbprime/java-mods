package im.wangbo.java.usecases.guice;

import com.google.common.collect.Maps;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Map;

public class Database {
  private final Map<String, Account> accounts = Maps.newHashMap();

  @Inject
  Database() {}

  Account getAccount(String username) {
    return accounts.computeIfAbsent(username, Account::new);
  }

  static final class Account {
    private final String username;
    private BigDecimal balance = BigDecimal.ZERO;

    Account(String username) {
      this.username = username;
    }

    String username() {
      return username;
    }

    BigDecimal balance() {
      return balance;
    }
  }
}
