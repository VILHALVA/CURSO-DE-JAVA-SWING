# INTERFACE DAO
A interface DAO (Data Access Object) é um padrão de design que fornece uma abstração sobre a camada de acesso a dados em um aplicativo. A ideia é separar as operações de acesso a dados do restante da lógica de negócios. Vou criar um exemplo básico de uma interface DAO para operações CRUD (Create, Read, Update, Delete) em uma entidade simples, como um usuário.

Vamos começar com a interface `UsuarioDAO`:

```java
import java.util.List;

// Interface DAO para operações relacionadas a usuários
public interface UsuarioDAO {

    // Cria um novo usuário
    void criarUsuario(Usuario usuario);

    // Obtém um usuário pelo ID
    Usuario obterUsuarioPorID(int id);

    // Obtém todos os usuários
    List<Usuario> obterTodosUsuarios();

    // Atualiza as informações de um usuário
    void atualizarUsuario(Usuario usuario);

    // Exclui um usuário pelo ID
    void excluirUsuario(int id);
}
```

Agora, vamos criar uma classe de implementação simples (`UsuarioDAOImpl`) que implementa a interface `UsuarioDAO`. Note que a implementação real das operações de acesso a dados dependerá do tipo de banco de dados ou mecanismo de armazenamento que você está utilizando.

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Implementação básica de UsuarioDAO
public class UsuarioDAOImpl implements UsuarioDAO {

    // Simula um banco de dados em memória usando um mapa
    private Map<Integer, Usuario> bancoDeDadosUsuarios;

    public UsuarioDAOImpl() {
        this.bancoDeDadosUsuarios = new HashMap<>();
    }

    @Override
    public void criarUsuario(Usuario usuario) {
        bancoDeDadosUsuarios.put(usuario.getId(), usuario);
    }

    @Override
    public Usuario obterUsuarioPorID(int id) {
        return bancoDeDadosUsuarios.get(id);
    }

    @Override
    public List<Usuario> obterTodosUsuarios() {
        return new ArrayList<>(bancoDeDadosUsuarios.values());
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        bancoDeDadosUsuarios.put(usuario.getId(), usuario);
    }

    @Override
    public void excluirUsuario(int id) {
        bancoDeDadosUsuarios.remove(id);
    }
}
```

A classe `UsuarioDAOImpl` utiliza um mapa para simular um banco de dados em memória. Em um ambiente real, você substituiria essas operações por chamadas ao banco de dados ou outro meio de armazenamento persistente.

A classe `Usuario` que é utilizada nas interfaces e implementações pode ser algo como:

```java
// Entidade de usuário
public class Usuario {

    private int id;
    private String nome;
    private String email;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

Este é um exemplo básico para ilustrar a estrutura de uma interface DAO e sua implementação. Dependendo do seu projeto e do contexto em que você está trabalhando, você pode precisar ajustar essa estrutura para atender aos requisitos específicos.