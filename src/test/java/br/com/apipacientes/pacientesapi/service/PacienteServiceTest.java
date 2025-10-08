package br.com.apipacientes.pacientesapi.service;

import br.com.apipacientes.pacientesapi.Paciente;
import br.com.apipacientes.pacientesapi.repository.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    void deveRetornarListaDePacientes_QuandoListarTodos() {

        Paciente paciente1 = new Paciente();
        paciente1.setId(1L);
        paciente1.setNome("João da Silva");

        Paciente paciente2 = new Paciente();
        paciente2.setId(2L);
        paciente2.setNome("Maria Oliveira");

        List<Paciente> listaDePacientesMock = Arrays.asList(paciente1, paciente2);

        when(pacienteRepository.findAll()).thenReturn(listaDePacientesMock);

        List<Paciente> resultado = pacienteService.listarTodosPacientes();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("João da Silva", resultado.get(0).getNome());
        assertSame(listaDePacientesMock, resultado);
    }

    @Test
    void deveChamarMetodoSaveDoRepositorio_QuandoCadastrarPaciente() {

        Paciente pacienteParaSalvar = new Paciente();
        pacienteParaSalvar.setNome("Carlos Andrade");

        pacienteService.cadastrarPaciente(pacienteParaSalvar);

        verify(pacienteRepository, times(1)).save(any(Paciente.class)); //verifica se foi realizado, não o retorno
    }

    @Test
    void AtualizarPaciente_QuandoExistirId () {
        Long idPacienteExistente = 1L;
        Paciente pacienteParaAlterar = new Paciente();
        pacienteParaAlterar.setNome("Novo Nome");
        pacienteParaAlterar.setEndereco("Novo Endereco");

        Paciente pacienteoriginal = new Paciente();
        pacienteoriginal.setNome("Nome Antigo");
        pacienteoriginal.setEndereco("Antigo Endereco");

        when(pacienteRepository.findById(idPacienteExistente)).thenReturn(Optional.of(pacienteoriginal));

        pacienteService.atualizarPaciente(idPacienteExistente, pacienteParaAlterar);

        verify(modelMapper).map(pacienteParaAlterar, pacienteoriginal);

        verify(pacienteRepository).save(pacienteoriginal);
    }

    @Test
    @DisplayName("Exceção quando Id do paciente não existir")

    void excecaoquandopacientenaoexiste (){
        Long idInexistente = 99L;
        Paciente pacienteParaAlterar = new Paciente();

        when(pacienteRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            pacienteService.atualizarPaciente(idInexistente,pacienteParaAlterar);
        });

        verify(pacienteRepository, never()).save(any(Paciente.class));


    }
}



