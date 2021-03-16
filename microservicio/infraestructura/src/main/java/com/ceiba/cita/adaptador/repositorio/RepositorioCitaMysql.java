package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public class RepositorioCitaMysql implements RepositorioCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cita", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "cita", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "cita", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "cita", value = "obtenerCedula")
    private static String sqlObtenerCedula;

    @SqlStatement(namespace = "cita", value = "existe")
    private static String sqlExiste;

    public RepositorioCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cita cita) {
        return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear);
    }

    @Override
    public void actualizar(Cita cita) {
        this.customNamedParameterJdbcTemplate.actualizar(cita, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long idPaciente, LocalDate fechaCita) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPaciente", idPaciente);
        paramSource.addValue("fechaCita", fechaCita);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public Integer obtenerCedula(Long idPaciente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPaciente", idPaciente);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerCedula, paramSource, Integer.class);
    }
}
