package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //permite hacer consultas a una BBDD como recuperación (SELECT), inserción (INSERT), actualización (UPDATE), y borrado (DELETE) de datos.
public interface IUserRepository extends JpaRepository<UserModel, Long> {
}
