package br.com.apipacientes.pacientesapi;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(column = "nome")
    private String nome;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "cpf")
    private String cpf;

    @CsvBindByName(column = "sexo")
    private String sexo;

    @CsvBindByName(column = "cep")
    private String cep;

    @CsvBindByName(column = "endereco")
    private String endereco;

    @CsvBindByName(column = "num_endereco")
    @Column(name = "num_endereco")
    private Integer numEndereco;

    @CsvBindByName(column = "complemento")
    private String complemento;

    @CsvBindByName(column = "bairro")
    private String bairro;

    @CsvBindByName(column = "cidade")
    private String cidade;

    @CsvBindByName(column = "estado")
    private String estado;

    @CsvBindByName(column = "nome_mae")
    @Column(name = "nome_mae")
    private String nomeMae;

    @CsvBindByName(column = "telefone_celular")
    @Column(name = "telefone_celular")
    private String telefoneCelular;

    @CsvBindByName(column = "telefone_responsavel")
    @Column(name = "telefone_responsavel")
    private String telefoneResponsavel;

    @CsvBindByName(column = "num_cartao_sus")
    @Column(name = "num_cartao_sus")
    private String numeroCartaoSus;

    @CsvBindByName(column = "data_nascimento")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @CsvBindByName(column = "eh_tabagista")
    @Column(name = "eh_tabagista")
    private Boolean ehTabagista;

    @CsvBindByName(column = "eh_etilista")
    @Column(name = "eh_etilista")
    private Boolean ehEtilista;

    @CsvBindByName(column = "tem_lesao_suspeita")
    @Column(name = "tem_lesao_suspeita")
    private Boolean temLesaoSuspeita;

    @CsvBindByName(column = "participa_smart_monitor")
    @Column(name = "participa_smart_monitor")
    private Boolean participaSmartMonitor;
}