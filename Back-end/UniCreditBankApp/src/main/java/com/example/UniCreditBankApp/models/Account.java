package com.example.UniCreditBankApp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "accounts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "accountMoney"),
                @UniqueConstraint(columnNames = "accountName"),
                @UniqueConstraint(columnNames = "accountNumber"),
                @UniqueConstraint(columnNames = "moneyType")
        })
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private Integer accountMoney;

    @NotBlank
    @Size(max = 50)
    private String accountName;

    @NotBlank
    @Size(max = 50)
    private Integer accountNumber;

    @NotBlank
    @Size(max = 5)
    private String moneyType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_account",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Set<Account> accounts = new HashSet<>();

    public Account() {
    }

    public Account(Integer accountMoney, String accountName, Integer accountNumber, String moneyType) {
        this.accountMoney = accountMoney;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.moneyType = moneyType;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Integer accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

}