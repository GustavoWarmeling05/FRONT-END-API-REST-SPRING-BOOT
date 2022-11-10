package com.devfapesc.api.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devfapesc.api.entities.User;
import com.devfapesc.api.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    /* Busca todos as pessoas */
    @GetMapping
    public List<User> buscaTodos() {
        return repository.findAll();
    }

    /* Busca os Usuarios pelo Id */
    @GetMapping(value = "/{id}")
    public User buscaPorId(@PathVariable Long id) {
        User resultado = repository.findById(id).get();
        return resultado;
    }

    /* Inseri os Usuarios */
    @PostMapping
    public User inserirUsuario(@RequestBody User user) {
        return repository.save(user);
    }
    
    /* Edita os Usuarios */
    @PutMapping
    public User editarUsuario(@RequestBody User user) {
        return repository.save(user);
    }    

    /* Deleta os Usuarios */
    @DeleteMapping(value = "/{id}")
    public Optional<User> excluiUsuario (@PathVariable Long id) {
        Optional<User> usuarioDel = repository.findById(id);
        repository.deleteById(id);
        return usuarioDel; 
    }


}
