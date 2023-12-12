# DAO: PREPARANDO O FILTRO DE REGISTROS PARA EXIBIÇÃO NA TABELA
Para preparar um filtro de registros para exibição na tabela usando um padrão DAO (Data Access Object), você pode modificar seu método de consulta no DAO para aceitar parâmetros de filtro. Vou mostrar um exemplo simples de como fazer isso.

**1. Modifique a interface `UsuarioDAO` para incluir um método que permita buscar usuários com base em um filtro:**

```java
import java.util.List;

public interface UsuarioDAO {

    void criarUsuario(Usuario usuario);
    Usuario obterUsuarioPorID(int id);
    List<Usuario> obterTodosUsuarios();
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(int id);

    // Novo método para obter usuários com base em um filtro
    List<Usuario> obterUsuariosPorFiltro(String filtro);
}
```

**2. Implemente o método `obterUsuariosPorFiltro` na classe `UsuarioDAOImpl`:**

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conexao; // Supondo que você tenha uma instância de Connection

    // ... outros métodos existentes ...

    @Override
    public List<Usuario> obterUsuariosPorFiltro(String filtro) {
        List<Usuario> usuariosFiltrados = new ArrayList<>();
        String sql = "SELECT * FROM sua_tabela WHERE nome LIKE ?";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + filtro + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String email = resultSet.getString("email");

                    Usuario usuario = new Usuario(id, nome, email);
                    usuariosFiltrados.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente
        }

        return usuariosFiltrados;
    }
}
```

Neste exemplo, o método `obterUsuariosPorFiltro` aceita uma `String` `filtro` que será usada para filtrar os resultados da consulta. O SQL utiliza a cláusula `LIKE` para encontrar registros que contenham o valor fornecido no filtro.

**3. No código que utiliza o DAO e a tabela, modifique o método para aplicar o filtro:**

```java
// ...
// No código que utiliza a tabela e o DAO

String filtro = "Termo de Filtro"; // Substitua isso pelo filtro desejado
List<Usuario> usuariosFiltrados = usuarioDAO.obterUsuariosPorFiltro(filtro);

// Limpar a tabela antes de adicionar novos registros
modeloTabela.setRowCount(0);

// Adicionar registros à tabela
for (Usuario usuario : usuariosFiltrados) {
    modeloTabela.addRow(new Object[]{usuario.getId(), usuario.getNome(), usuario.getEmail()});
}
// ...
```

Esta é uma abordagem básica para adicionar um filtro à sua consulta. Certifique-se de adaptar o código conforme necessário para atender aos requisitos específicos da sua aplicação. Além disso, lembre-se de tratar a entrada do usuário de forma segura para evitar ataques de injeção de SQL. Se possível, considere o uso de consultas parametrizadas para aumentar a segurança.