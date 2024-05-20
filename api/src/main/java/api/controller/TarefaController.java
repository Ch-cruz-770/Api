package api.controller;

import api.dto.TarefaDTO;
import api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> findAll() {
        List<TarefaDTO> tarefas = tarefaService.findAll();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> findById(@PathVariable Long id) {
        TarefaDTO Tarefa = tarefaService.findById(id);
        return new ResponseEntity<>(Tarefa, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> insert(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO novaTarefa = tarefaService.insert(tarefaDTO);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> update(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaAtualizada = tarefaService.update(id, tarefaDTO);
        return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tarefaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
