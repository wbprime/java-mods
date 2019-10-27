package im.wangbo.java.usecases.guice;

import com.google.common.collect.Maps;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.Map;

@Singleton
public class Database {
  private final Map<String, Account> accounts = Maps.newHashMap();

  @Inject
  Database() {}

  Account getAccount(final String username) {
    return accounts.computeIfAbsent(username, Account::new);
  }

  static final class Account {
    private final String username;
    private BigDecimal balance = BigDecimal.ZERO;

    Account(final String username) {
      this.username = username;
    }

    String username() {
      return username;
    }

    BigDecimal balance() {
      return balance;
    }

    void deposit(final BigDecimal decimal) {
      this.balance = this.balance.add(decimal);
    }

    void withdraw(final BigDecimal decimal) {
      this.balance = this.balance.subtract(decimal);
    }
  }
}
