package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idPaciente = resultSet.getLong("idPaciente");
        Integer valorOriginal = resultSet.getInt("valorOriginal");
        Integer valorDescuento = resultSet.getInt("valorDescuento");
        Integer descuento = resultSet.getInt("descuento");
        Boolean efectivo = resultSet.getBoolean("efectivo");
        LocalDate fechaCita = resultSet.getDate("fechaCita").toLocalDate();

        return new DtoCita(id, idPaciente, valorOriginal, valorDescuento, descuento, efectivo, fechaCita);
    }
}
