package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;



// Indica que la clase anotada es un controlador donde cada método devuelve un objeto de dominio en lugar de una vista.
@RestController //Automáticamente serializa objetos de retorno en JSON o XML y los envía de vuelta al cliente, dependiendo de la configuración y de los headers de la solicitud.
@RequestMapping("/user") //e utiliza para mapear solicitudes web a métodos de controlador específicos.
public class UserController {


    //En esta clase se realizan las peticiones HTTP y las rutas

    private final UserService userService;

    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping //este metodo realiza o solicita una peticion web
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }
    @PostMapping//indica que ese método debe ser invocado cuando se realiza una solicitud POST a la URL especificada.
    public UserModel saveUser(@RequestBody UserModel user) {// @RequestBody anotacion que indica que vamos a pasar algo por el body
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserModel> updateUserById(@RequestBody UserModel request, @PathVariable Long id){
        try {
            UserModel updateUser = userService.updateById(request,id);
            return ResponseEntity.ok(updateUser);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


        }
    }

    @DeleteMapping(path = "/{id}")
    public String  deleteById(@PathVariable("id") Long id){
        Boolean ok = this.userService.deleteUSer(id);

        if (ok){
            return "User with id " + id + " was deleted";
        }else {
            return "Error, There´s a problem, we can´t delete Usar " + id;
        }
    }








}
