package dio.projeto.controllers;

import dio.projeto.entities.Usuario;
import dio.projeto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Usuario filtrar(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Usuario inserir(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Usuario alterar(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuario1 = repository.findById(id).get();
        usuario1.setNome(usuario.getNome());
        usuario1.setDepartamento(usuario.getDepartamento());
        return repository.save(usuario1);
    }
}


























