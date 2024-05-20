package api;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

@Data                         /*ANOTAÇÃO ADICIONA OS "getters, setters, tostring, equals, hashCode" AUTOMATICAMENTE*/
@Entity
@Table(name = "tarefas")
@JsonInclude                   /*Ajuda a controlar a inclusão e exclusão de propriedades nulas do JSON*/
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;


}
