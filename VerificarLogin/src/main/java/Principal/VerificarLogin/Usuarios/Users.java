package Principal.VerificarLogin.Usuarios;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name= "Usuarios")
@Entity(name = "Usuarios")
@EqualsAndHashCode(of="id")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private boolean ativo;


    private String nome;
    @Column(unique = true)
    private String Email;


    private String Senha;


    public Users(DataUsers dados) {
        this.nome = dados.nome();
        this.Email = dados.email();
        this.Senha = dados.senha();
        this.ativo= true;

    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return Email;
    }

    public String getSenha() {
        return Senha;
    }


    public void excluir(){
        this.ativo=false;
    }

}
