package com.montanha.mongodb.relacionamentos.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.List;

@Data
@Document(collection = "cursos")
public class Curso {
    @Id
    private String id;
    private String nome;

    @DBRef
    private List<Estudante> estudantes;
}

