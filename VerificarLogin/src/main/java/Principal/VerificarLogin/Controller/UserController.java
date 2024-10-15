package Principal.VerificarLogin.Controller;

import Principal.VerificarLogin.Usuarios.DataUsers;
import Principal.VerificarLogin.Usuarios.UsersRepository;
import Principal.VerificarLogin.Usuarios.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
   public UsersRepository Repositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<Users> CriandoUsuarios(@RequestBody DataUsers dados){
        Repositorio.save(new Users(dados));
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public Page<DataUsers> listar(Pageable paginacao){
        return Repositorio.findAll(paginacao).map(DataUsers::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var user=Repositorio.getReferenceById(id);
        user.excluir();
    }
}
