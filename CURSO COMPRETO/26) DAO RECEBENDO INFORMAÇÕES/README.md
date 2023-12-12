# DAO RECEBENDO INFORMAÇÕES
Para que a classe DAO (Data Access Object) receba informações, você precisa ajustar a interface `UsuarioDAO` e sua implementação `UsuarioDAOImpl`. Vou mostrar como você pode modificar essas classes para receber informações ao realizar operações como criar, obter e atualizar usuários.

Primeiramente, atualizaremos a interface `UsuarioDAO`:

```java
import java.util.List;

public interface UsuarioDAO {

    void criarUsuario(Usuario usuario);
    Usuario obterUsuarioPorID(int id);
    List<Usuario> obterTodosUsuarios();
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(int id);

    // Modificação na interface para receber uma lista de usuários
    void criarUsuarios(List<Usuario> usuarios);
}
```

Agora, na implementação `UsuarioDAOImpl`, você pode ajustar os métodos para receber informações. Vou incluir exemplos nos métodos `criarUsuario` e `atualizarUsuario`:

```java
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private List<Usuario> bancoDeDadosUsuarios;

    public UsuarioDAOImpl() {
        this.bancoDeDadosUsuarios = new ArrayList<>();
    }

    @Override
    public void criarUsuario(Usuario usuario) {
        bancoDeDadosUsuarios.add(usuario);
        System.out.println("Usuário criado no banco de dados: " + usuario);
    }

    @Override
    public Usuario obterUsuarioPorID(int id) {
        // Implementação da busca por ID
        return null;
    }

    @Override
    public List<Usuario> obterTodosUsuarios() {
        return bancoDeDadosUsuarios;
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        // Verifica se o usuário existe na lista
        if (bancoDeDadosUsuarios.contains(usuario)) {
            System.out.println("Usuário atualizado no banco de dados: " + usuario);
        } else {
            System.out.println("Usuário não encontrado no banco de dados.");
        }
    }

    @Override
    public void excluirUsuario(int id) {
        // Implementação da exclusão
    }

    @Override
    public void criarUsuarios(List<Usuario> usuarios) {
        bancoDeDadosUsuarios.addAll(usuarios);
        System.out.println("Usuários criados no banco de dados: " + usuarios);
    }
}
```

Essas são modificações simples para imprimir mensagens indicando que a operação foi realizada no banco de dados simulado. Em uma aplicação real, você substituiria essas mensagens por lógica de persistência em um banco de dados real.

Agora, ao chamar os métodos correspondentes na classe de controle, os dados serão enviados para a classe DAO, e você pode ver mensagens indicando as operações no banco de dados. Por exemplo:

```java
public static void main(String[] args) {
    // Cria uma instância da classe modelo
    ModeloCadastro modelo = new ModeloCadastro();

    // Cria uma instância do DAO
    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    // Cria uma instância do controle passando a referência à classe modelo e ao DAO
    InterfaceControle controle = new Controle(modelo, usuarioDAO);

    // Envia dados para o modelo
    controle.enviarDadosParaModelo("Usuário 1");
    controle.enviarDadosParaModelo("Usuário 2");

    // Salva dados no DAO
    controle.salvarDadosNoDAO();
}
```

Este exemplo envia dados para o modelo, e em seguida, salva esses dados no DAO. As mensagens indicando que os usuários foram criados no banco de dados serão exibidas no console. Lembre-se de adaptar essa lógica conforme necessário para sua aplicação real.