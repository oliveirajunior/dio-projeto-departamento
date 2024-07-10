package dio.projeto.services;

import dio.projeto.dtos.DepartamentoDTO;
import dio.projeto.entities.Departamento;
import dio.projeto.repositories.DepartametnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartametnoRepository repository;

    public List<DepartamentoDTO> listar(){
        List<Departamento> departamentoList = repository.findAll();
        List<DepartamentoDTO> dtoList = new ArrayList<>();

        for(Departamento d : departamentoList){
            dtoList.add(new DepartamentoDTO(d));
        }

        return dtoList;

    }

     public DepartamentoDTO filtrar(Long id){
        Departamento departamento = repository.findById(id).get();
        return new DepartamentoDTO(departamento);
    }

    public DepartamentoDTO inserir(DepartamentoDTO dto){
        Departamento departamento = new Departamento();
        copyDtoToEntity(dto, departamento);
        repository.save(departamento);
        return new DepartamentoDTO(departamento);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public DepartamentoDTO alterar(Long id, DepartamentoDTO dto){
        Departamento departamento = repository.findById(id).get();
        copyDtoToEntity(dto, departamento);
        repository.save(departamento);
        return new DepartamentoDTO(departamento);
    }

    //Conversor DTO para Entity
    private void copyDtoToEntity(DepartamentoDTO dto, Departamento entity){
        entity.setNome(dto.getNome());
    }
}

