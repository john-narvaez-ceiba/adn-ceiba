package com.ceiba.paciente.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import org.springframework.jdbc.core.RowMapper;

public class MapeoPaciente implements RowMapper<DtoPaciente>, MapperResult {

    @Override
    public DtoPaciente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Integer noCedula = resultSet.getInt("noCedula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");

        return new DtoPaciente(id,noCedula,nombre,apellido,direccion,telefono);
    }

}
