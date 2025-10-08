package br.com.apipacientes.pacientesapi.repository;

import br.com.apipacientes.pacientesapi.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository  extends JpaRepository<Paciente,Long> {
    Long Id(Long id);
}
