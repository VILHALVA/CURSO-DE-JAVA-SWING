# DAO SALVAR: INCLUINDO E ALTERANDO REGISTROS NO BANCO DE DADOS
Para incluir e alterar registros no banco de dados usando um padrão DAO (Data Access Object), você precisará adicionar métodos à sua interface `UsuarioDAO` para realizar essas operações e, em seguida, implementar esses métodos na classe `UsuarioDAOImpl`.

Aqui está um exemplo de como você pode fazer isso:

**Interface `UsuarioDAO`:**

```java
import java.util.List;

public interface UsuarioDAO {

    void criarUsuario(Usuario usuario);
    Usuario obterUsuarioPorID(int id);
    List<Usuario> obterTodosUsuarios();
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(int id);

    // Novo método para incluir ou atualizar um usuário no banco de dados
    void salvarUsuario(Usuario usuario);
}
```

**Implementação `UsuarioDAOImpl` (Apenas a parte relevante):**

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conexao; // Supondo que você tenha uma instância de Connection

    // ... outros métodos existentes ...

    @Override
    public void salvarUsuario(Usuario usuario) {
        if (usuario.getId() == 0) {
            // Se o ID for zero, é um novo usuário, então crie um novo registro
            criarUsuario(usuario);
        } else {
            // Se o ID não for zero, é um usuário existente, então atualize o registro
            atualizarUsuario(usuario);
        }
    }

    // Método privado para criar um novo usuário no banco de dados
    private void criarUsuario(Usuario usuario) {
        String sql = "INSERT INTO sua_tabela (nome, email) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente
        }
    }

    // Método privado para atualizar um usuário existente no banco de dados
    private void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE sua_tabela SET nome = ?, email = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setInt(3, usuario.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente
        }
    }
}
```

**Exemplo de uso:**

```java
public class ExemploUsoDAO {

    public static void main(String[] args) {
        // Criar uma instância da classe modelo
        ModeloCadastro modelo = new ModeloCadastro();

        // Criar uma instância da classe DAO
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        // Criar uma instância do controle passando a referência à classe modelo e ao DAO
        InterfaceControle controle = new Controle(modelo, usuarioDAO);

        // Criar um usuário
        Usuario novoUsuario = new Usuario(0, "Novo Usuário", "novo@exemplo.com");

        // Salvar o usuário no banco de dados usando o método salvarUsuario
        controle.salvarUsuarioNoDAO(novoUsuario);
    }
}
```

Este é um exemplo simples de como você pode modificar sua interface e implementação do DAO para incluir ou atualizar registros no banco de dados. Lembre-se de adaptar o código conforme necessário para suas necessidades específicas. Além disso, considere o uso de transações para garantir a consistência do banco de dados em cenários mais complexos.