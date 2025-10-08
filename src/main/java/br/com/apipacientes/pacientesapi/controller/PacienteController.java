package br.com.apipacientes.pacientesapi.controller;
import br.com.apipacientes.pacientesapi.Paciente;
import br.com.apipacientes.pacientesapi.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    //READ
    @GetMapping
    public List<Paciente> listarTodosPacientes(){
        return pacienteService.listarTodosPacientes();
    };

    //CREATE
    @PostMapping
    public void cadastrarPacientes (@RequestBody Paciente paciente){
        pacienteService.cadastrarPaciente(paciente);
    }

    //UPDATE (FUNCIONA COM PUT E PATCH, UMA VEZ QUE USA MODELMAPPER)
    @PatchMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente dadosAtualizados){
        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id, dadosAtualizados);
        return ResponseEntity.ok(pacienteAtualizado);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPaciente(@PathVariable Long id){
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    //IMPORTAR CSV
    @PostMapping("/importar")
    ResponseEntity<String>importarCsv(@RequestParam("file") MultipartFile file){
        try {
            pacienteService.importarCsv(file);
            return ResponseEntity.ok().body("CSV importado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao importar CSV: " + e.getMessage());
        }
    }
}
