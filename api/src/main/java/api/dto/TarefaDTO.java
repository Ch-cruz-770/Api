package api.dto;

import lombok.Data;

@Data
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;
}
