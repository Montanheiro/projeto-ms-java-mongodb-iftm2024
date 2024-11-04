package com.montanha.user_api.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.montanha.user_api.models.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class User {
    
    @Field("nome")
    private String nome;
    @Field("cpf")
    private String cpf;
    @Field("endereco")
    private String endereco;
    @Field("email")
    private String email;
    @Field("telefone")
    private String telefone;
    @Field("dataCadastro")
    private LocalDateTime dataCadastro;

}
