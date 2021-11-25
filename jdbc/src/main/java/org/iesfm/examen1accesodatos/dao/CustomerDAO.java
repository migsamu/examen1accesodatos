package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.pojos.Customer;

public interface CustomerDAO {

    boolean updateByNif(Customer customer);

    Customer getCustomerByIban(String iban);


}
