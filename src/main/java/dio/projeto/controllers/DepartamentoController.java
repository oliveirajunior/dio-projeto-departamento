package dio.projeto.controllers;

import dio.projeto.dtos.DepartamentoDTO;
import dio.projeto.services.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping
    public List<DepartamentoDTO> listar() {
        return service.listar();
    }

    @GetMapping(value = "/{id}")
    public DepartamentoDTO filtrar(@PathVariable Long id) {
        return service.filtrar(id);
    }

    @PostMapping
    public DepartamentoDTO inserir(@Valid @RequestBody DepartamentoDTO dto) {
        return service.inserir(dto);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping(value = "/{id}")
    public DepartamentoDTO alterar (@PathVariable Long id, @Valid @RequestBody DepartamentoDTO dto){
        return service.alterar(id,dto);
    }

}
