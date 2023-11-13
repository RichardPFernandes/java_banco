import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class UsuarioResource {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    try {
    Connection         connManager = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java",
                    "root",
                    ""
                );
            System.out.println("Conexão estabelecida!");
            PreparedStatement ps = connManager.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }
            ps.close();
            rs.close();
            int opcao = 0;
            do{
            System.out.println("Digite a opção desejada");
            System.out.println("0 - Inserir");
            System.out.println("1 - Alterar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Logar");
            System.out.println("5 - Sair");


            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Inserir");
                    System.out.println("Digite o nome");
                    String nome = sc.nextLine();
                    System.out.println("Digite o email");
                    String email = sc.nextLine();
                    System.out.println("Digite a senha");
                    String senha = sc.nextLine();
                    Usuario usuario = new Usuario(nome, email, senha);
                    UsuarioRepository.inserir(usuario, connManager);
                    
                    break;
                case 1:
                    System.out.println("Alterar");
                    List<Usuario> usuarios = UsuarioRepository.vizualizar(connManager);
                    for(Usuario usuarioList: usuarios){
                        System.out.println(usuarioList);
                    }
                    System.out.println("Digite o id do usuario que deseja alterar");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome do usuario que deseja alterar");
                    nome = sc.nextLine();
                    System.out.println("Digite o email do usuario que deseja alterar");
                    email = sc.nextLine();
                    System.out.println("Digite a senha do usuario que deseja alterar");
                    senha = sc.nextLine();
                    usuario = new Usuario(id, nome, email, senha);
                    UsuarioRepository.Editar(usuario, connManager);
    
                    break;
                case 2:
                    System.out.println("Excluir");
                    usuarios = UsuarioRepository.vizualizar(connManager);
                    for(Usuario usuarioList: usuarios){
                        System.out.println(usuarioList);
                    }
          
                    System.out.println("Digite o id do usuario que deseja excluir");
                    id = sc.nextInt();
                    UsuarioRepository.Excluir(id, connManager);
           
                    break;
                case 3:
                    System.out.println("Visualizar");
                    usuarios = UsuarioRepository.vizualizar(connManager);
                    for(Usuario usuarioList: usuarios){
                        System.out.println(usuarioList);
                    }

                    break;
                case 4:
                    System.out.println("Logar");
                    System.out.println("Digite o email");
                    email = sc.nextLine();
                    System.out.println("Digite a senha");
                    senha = sc.nextLine();
                    usuario = new Usuario(email, senha);
                    UsuarioRepository.Logar(usuario, connManager);
                    break;
                case 5:
                    System.out.println("Sair"); 
                    break;

                default:
                    break;
            }
        }while(opcao != 5);
            connManager.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}