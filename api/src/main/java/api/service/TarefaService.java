package api.service;

import api.Tarefa;
import api.dto.TarefaDTO;
import api.repository.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TarefaDTO> findAll() {
        return tarefaRepository.findAll()
                .stream()
                .map(tarefa -> modelMapper.map(tarefa, TarefaDTO.class))
                .collect(Collectors.toList());
    }

    public TarefaDTO findById(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    public TarefaDTO insert(TarefaDTO tarefaDTO) {
        Tarefa tarefa = modelMapper.map(tarefaDTO, Tarefa.class);
        Tarefa novaTarefa = tarefaRepository.save(tarefa);
        return modelMapper.map(novaTarefa, TarefaDTO.class);
    }

    public TarefaDTO update(Long id, TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setConcluida(tarefaDTO.isConcluida());
        Tarefa tarefaAtualizada = tarefaRepository.save(tarefa);
        return modelMapper.map(tarefaAtualizada, TarefaDTO.class);
    }

    public void delete(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefaRepository.delete(tarefa);
    }
}
