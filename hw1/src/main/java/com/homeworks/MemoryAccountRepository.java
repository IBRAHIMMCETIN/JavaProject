package com.homeworks;

import java.util.ArrayList;
import java.util.List;

public class MemoryAccountRepository implements AccountRepository{
    private List<Account> database = new ArrayList<>();

    public void save(Account account) {
        
        database.add(account);
    }

    public Account findByUsername(String username) {
        
        for (Account account : database) {
            if (account.getUsername().equals(username)) {
                return account; 
            }
        }
        return null; 
    }

}
