package com.homeworks;

public interface AccountRepository {
    void save(Account account);
    Account findByUsername(String username);
}
