package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.pojos.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> getAccountsByNif(String nif);

    Account getAccountByIban(String iban);

    boolean insert(Account account);

}
