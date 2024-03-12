package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//Pueden tener dependencias inyectadas
@Service //es la capa de servicio, es donde se coloca la lógica de negocio, operaciones o funciones que son importantes para la ejecución de los requerimientos del negocio.
public class UserService {

    @Autowired //realiza inyeccion de dependencias, se puede colocar sobre campos, métodos setter, y constructores.
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }

        UserModel user = optionalUser.get();

        // Validar datos (opcional)
        if (request.getFirstName() != null) {
            user.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        // Realiza la actualización en la base de datos
        UserModel updatedUser = userRepository.save(user);

        return updatedUser;
    }

    public UserModel patchById(UserModel request, Long id){
        Optional<UserModel> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        UserModel user = optionalUser.get();

        if(request.getFirstName() != null){
            user.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null){
            user.setLastName(request.getLastName());
        }
        if(request.getEmail() != null){
            user.setEmail(request.getEmail());
        }

        UserModel patchedUser = userRepository.save(user);

        return patchedUser;

    }

    public Boolean deleteUSer(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
