package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.BankConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BankConfiguration.class})
public class MovementDAOTests {

    @Autowired
    private MovementDAO movementDAO;

    @Test
    public void delete() {
        movementDAO.delete(2);
    }
}
