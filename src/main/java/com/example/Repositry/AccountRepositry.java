package com.example.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.query.Entity.Account;

public interface AccountRepositry extends JpaRepository<Account, String> {

}
