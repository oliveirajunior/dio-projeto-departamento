package dio.projeto.dtos;

import dio.projeto.entities.Departamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepartamentoDTO {

    private Long id;
    @Size(min = 5, max = 30, message = "O campo NOME precisa ter entre 5 e 30 caracteres")
    @NotBlank(message = "O campo NOME é obrigtório")
    private String nome;

    public DepartamentoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public DepartamentoDTO(Departamento entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
