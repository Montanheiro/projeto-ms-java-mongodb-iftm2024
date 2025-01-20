package com.montanha.mongodb.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.montanha.mongodb.relacionamentos.models.*;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
