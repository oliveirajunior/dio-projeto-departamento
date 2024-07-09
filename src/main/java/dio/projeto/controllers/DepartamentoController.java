package dio.projeto.controllers;

import dio.projeto.entities.Departamento;
import dio.projeto.repositories.DepartametnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartametnoRepository repository;

    @GetMapping
    public List<Departamento> listar() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Departamento filtrar(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Departamento inserir(Departamento departamento) {
        return repository.save(departamento);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Departamento alterar (@PathVariable Long id, @RequestBody Departamento departamento){
        Departamento departamento1 = repository.findById(id).get();
        departamento1.setNome(departamento.getNome());
        return repository.save(departamento1);
    }
}
