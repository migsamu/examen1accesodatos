package org.iesfm.examen1accesodatos.jdbc;

import org.iesfm.examen1accesodatos.dao.MovementDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;


public class JDBCMovementDAO implements MovementDAO {

    private static final String DELETE_MOVEMENT = "DELETE FROM Movement WHERE id=:id";

    private NamedParameterJdbcTemplate jdbc;

    public JDBCMovementDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public boolean delete(int id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);

        return jdbc.update(DELETE_MOVEMENT, params) == 1;
    }
}
