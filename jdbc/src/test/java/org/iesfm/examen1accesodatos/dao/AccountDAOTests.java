package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.BankConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BankConfiguration.class })
public class AccountDAOTests {

    @Autowired
    private AccountDAO accountDAO;



}
