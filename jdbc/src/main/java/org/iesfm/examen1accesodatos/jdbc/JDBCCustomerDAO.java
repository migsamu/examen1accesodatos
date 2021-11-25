package org.iesfm.examen1accesodatos.jdbc;

import org.iesfm.examen1accesodatos.dao.CustomerDAO;
import org.iesfm.examen1accesodatos.pojos.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;

public class JDBCCustomerDAO implements CustomerDAO {


    private static final String SELECT_CUSTOMER_BY_IBAN =
            "SELECT c.* FROM Customer c" +
                    "INNER JOIN Account a ON c.nif=a.owner_id" +
                    "WHERE a.iban=:iban";

    private static final String UPDATE_CUSTOMER_BY_NIF =
            "UPDATE Customer SET name =:name, surname=:surname, cp=:cp WHERE nif=:nif";


    private NamedParameterJdbcTemplate jdbc;

    public JDBCCustomerDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public boolean updateByNif(Customer customer) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("nif", customer.getNif());
        params.put("name", customer.getName());
        params.put("surname", customer.getSurname());
        params.put("cp", customer.getCp());

        return jdbc.update(UPDATE_CUSTOMER_BY_NIF, params) == 1;
    }

    @Override
    public Customer getCustomerByIban(String iban) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("a.iban", iban);
        try {
            return jdbc.queryForObject(
                    SELECT_CUSTOMER_BY_IBAN,
                    params,
                    (rs, rowNum) -> new Customer(
                            rs.getInt("id"),
                            rs.getString("nif"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getInt("cp")
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
