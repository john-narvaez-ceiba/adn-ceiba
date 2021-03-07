package com.ceiba.configuracion;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.cita.servicio.ServicioEliminarCita;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.ServicioActualizarPaciente;
import com.ceiba.paciente.servicio.ServicioCrearPaciente;
import com.ceiba.paciente.servicio.ServicioEliminarPaciente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPaciente servicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
        return new ServicioCrearPaciente(repositorioPaciente);
    }

    @Bean
    public ServicioEliminarPaciente servicioEliminarPaciente(RepositorioPaciente repositorioPaciente) {
        return new ServicioEliminarPaciente(repositorioPaciente);
    }

    @Bean
    public ServicioActualizarPaciente servicioActualizarPaciente(RepositorioPaciente repositorioPaciente) {
        return new ServicioActualizarPaciente(repositorioPaciente);
    }

    @Bean
    ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita) {
        return new ServicioCrearCita(repositorioCita);
    }

    @Bean
    public ServicioEliminarCita servicioEliminarCita(RepositorioCita repositorioCita) {
        return new ServicioEliminarCita(repositorioCita);
    }

    @Bean
    public ServicioActualizarCita servicioActualizarCita(RepositorioCita repositorioCita) {
        return new ServicioActualizarCita(repositorioCita);
    }
}
