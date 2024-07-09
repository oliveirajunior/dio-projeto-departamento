package dio.projeto.dtos;

import dio.projeto.entities.Departamento;
import dio.projeto.entities.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    private Long id;
    @Size(min = 5, max = 30, message = "O campo NOME precisa ter entre 5 e 30 caracteres")
    @NotBlank(message = "O campo NOME é obrigtório")
    private String nome;
    private Departamento departamento;

    public UsuarioDTO(Long id, String nome, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
    }

    public UsuarioDTO(Usuario entity) {
        id = entity.getId();
        nome = entity.getNome();
        departamento = entity.getDepartamento();
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
