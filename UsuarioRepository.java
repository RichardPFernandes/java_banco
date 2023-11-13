import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {


    public static void inserir(Usuario usuario, Connection conexao) throws SQLException {
        PreparedStatement inserir = conexao.prepareStatement("INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)");
        
        inserir.setString(1, usuario.getNome());
        inserir.setString(2, usuario.getEmail());
        inserir.setString(3, usuario.getSenha());
        inserir.execute();
        inserir.close();
    }

    public static void Editar(Usuario usuario, Connection conexao) throws SQLException {
        PreparedStatement alterar = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?");
        alterar.setString(1, usuario.getNome());
        alterar.setString(2, usuario.getEmail());
        alterar.setString(3, usuario.getSenha());
        alterar.setInt(4, usuario.getId());
        alterar.execute();
        alterar.close();
    }

    public static List<Usuario> vizualizar(Connection conexao) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement vizualizar = conexao.prepareStatement("SELECT * FROM usuario");
        ResultSet row = vizualizar.executeQuery();
        while (row.next()) {
          Usuario usuario = new Usuario(row.getInt("id"), row.getString("nome"), row.getString("email"), row.getString("senha"));
          usuarios.add(usuario);
        }
        return usuarios;
    }

    public static void Excluir(int id, Connection conexao) throws SQLException {
        PreparedStatement excluir = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");
        excluir.setInt(1, id);
        excluir.execute();
        excluir.close();
    }

    public static void Logar(Usuario usuario, Connection conexao) throws SQLException {
        PreparedStatement logar = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
        logar.setString(1, usuario.getEmail());
        logar.setString(2, usuario.getSenha());
        ResultSet rs3 = logar.executeQuery();
        if (rs3.next()) {
            System.out.println("Logado com sucesso");
        } else {
            System.out.println("Email ou senha incorretos");
        }
        logar.close();
    }
}
