package org.iesfm.examen1accesodatos.jdbc;

import org.iesfm.examen1accesodatos.dao.AccountDAO;
import org.iesfm.examen1accesodatos.pojos.Account;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;

public class JDBCAccountDAO implements AccountDAO {

    private static final String SELECT_ACCOUNTS_BY_NIF =
            "SELECT a.* FROM Account a" +
                    "INNER JOIN Customer c ON c.nif=a.owner_id" +
                    "WHERE c.nif=:nif";
    ;
    private static final String INSERT_ACCOUNT =
            "INSERT INTO Account (iban, owner_id, balance,open_date) VALUES (:iban, :ownerId, :balance, :openDate)";
    private static final String SELECT_ACCOUNT_BY_IBAN = "SELECT * FROM Account WHERE iban=:iban";


    private NamedParameterJdbcTemplate jdbc;

    public JDBCAccountDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Account> getAccountsByNif(String nif) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("nif", nif);

        return jdbc.query(SELECT_ACCOUNTS_BY_NIF, params, (rs, n) ->
                new Account(
                        rs.getString("iban"),
                        rs.getInt("owner_id"),
                        rs.getDouble("balance"),
                        rs.getDate("open_date")
                ));
    }

    @Override
    public Account getAccountByIban(String iban) {

        HashMap<String, Object> params = new HashMap<>();
        params.put("iban", iban);
        try {
            return jdbc.queryForObject(
                    SELECT_ACCOUNT_BY_IBAN,
                    params,
                    (rs, rowNum) -> new Account(
                            rs.getString("iban"),
                            rs.getInt("owner_id"),
                            rs.getDouble("balance"),
                            rs.getDate("open_date")
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public boolean insert(Account account) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("iban", account.getIban());
        params.put("ownerId", account.getOwnerId());
        params.put("balance", account.getBalance());
        params.put("openDate", account.getOpenDate());

        try {
            jdbc.update(INSERT_ACCOUNT, params);
            return true;
        } catch (DuplicateKeyException | EmptyResultDataAccessException e) {
            return false;
        }

    }

}
