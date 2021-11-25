package org.iesfm.examen1accesodatos.pojos;

import java.util.Date;
import java.util.Objects;

public class Account {
    private String iban;
    private int ownerId;
    private double balance;
    private Date openDate;

    public Account(String iban, int ownerId, double balance, Date openDate) {
        this.iban = iban;
        this.ownerId = ownerId;
        this.balance = balance;
        this.openDate = openDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return ownerId == account.ownerId && Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(openDate, account.openDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, ownerId, balance, openDate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", ownerId=" + ownerId +
                ", balance=" + balance +
                ", openDate=" + openDate +
                '}';
    }
}
