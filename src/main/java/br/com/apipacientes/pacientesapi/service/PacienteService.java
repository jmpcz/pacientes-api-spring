package br.com.apipacientes.pacientesapi.service;

import br.com.apipacientes.pacientesapi.Paciente;
import br.com.apipacientes.pacientesapi.repository.PacienteRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(Long id, Paciente dadosAtualizados) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente nao encontrado com id " + id));

        modelMapper.map(dadosAtualizados, pacienteExistente);
        return pacienteRepository.save(pacienteExistente);
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public void importarCsv(MultipartFile file) {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {

            List<Paciente> pacientes = new CsvToBeanBuilder<Paciente>(reader)
                    .withType(Paciente.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();

            pacienteRepository.saveAll(pacientes);

        } catch (Exception e) {
            throw new RuntimeException("Falha ao importar e processar o arquivo CSV: " + e.getMessage());
        }
    }
}