package com.soyphea.builder;

public class BankAccount {

    private String accountName;
    private Long accountNo;
    private double balance;
    private String branch;

    public BankAccount(){
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public static class Builder {

        private String accountName;
        private Long accountNo;
        private double balance;
        private String branch;

        public Builder(Long accountNo) {
            this.accountNo = accountNo;
        }

        public Builder accountName(String accountName){
            this.accountName = accountName;
            return this;
        }
        public Builder withBalance(double balance){
            this.balance = balance;
            return this;
        }

        public Builder branch(String branch){
            this.branch = branch;
            return this;
        }
        BankAccount build(){
            BankAccount bankAccount = new BankAccount();
            bankAccount.accountNo = this.accountNo;
            bankAccount.accountName = this.accountName;
            bankAccount.balance = this.balance;
            bankAccount.branch = this.branch;
            return bankAccount;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountName='" + accountName + '\'' +
                ", accountNo=" + accountNo +
                ", balance=" + balance +
                ", branch='" + branch + '\'' +
                '}';
    }

    public static void main(String args[]){
        BankAccount bankAccount = new BankAccount.Builder(100L)
                .accountName("Phea Soy")
                .build();
        System.out.println("Bank account:"+bankAccount);
    }
}
