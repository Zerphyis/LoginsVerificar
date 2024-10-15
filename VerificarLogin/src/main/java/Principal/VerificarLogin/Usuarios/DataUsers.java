package Principal.VerificarLogin.Usuarios;

public record DataUsers(String nome, String email, String senha) {
   public DataUsers(Users users){
        this(users.getNome(), users.getEmail(), users.getSenha());

    }
}
