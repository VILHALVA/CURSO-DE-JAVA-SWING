# CONTROLE ENVIANDO AS INFORMAÇÕES DO MODELO PARA A CLASSE DAO
Se você tem um controle que interage com um modelo e deseja enviar as informações do modelo para a classe DAO (Data Access Object), você pode criar métodos no controle para realizar essas operações. Vamos modificar o exemplo anterior para incluir um método no controle que interage com o DAO para realizar operações de persistência.

Primeiro, aprimoraremos a interface `InterfaceControle`:

```java
import java.util.List;

// Interface de controle
public interface InterfaceControle {

    void enviarDadosParaModelo(String dados);
    List<String> obterDadosDoModelo();
    void limparModelo();

    // Novo método para enviar dados do modelo para a classe DAO
    void salvarDadosNoDAO();
}
```

Agora, vamos atualizar a classe de controle (`Controle`) para incluir a lógica de interação com o DAO:

```java
public class Controle implements InterfaceControle {

    private ModeloCadastro modelo;
    private UsuarioDAO usuarioDAO; // Referência à interface DAO

    public Controle(ModeloCadastro modelo, UsuarioDAO usuarioDAO) {
        this.modelo = modelo;
        this.usuarioDAO = usuarioDAO;
    }

    // Implementação dos métodos da interface
    public void enviarDadosParaModelo(String dados) {
        modelo.adicionarUsuario(dados);
    }

    public List<String> obterDadosDoModelo() {
        return modelo.getListaUsuarios();
    }

    public void limparModelo() {
        modelo.limparUsuarios();
    }

    // Implementação do novo método para salvar dados no DAO
    public void salvarDadosNoDAO() {
        List<String> dados = modelo.getListaUsuarios();
        
        // Itera sobre os dados do modelo e salva no DAO
        for (String dado : dados) {
            Usuario usuario = new Usuario(dado); // Supondo que os dados são nomes de usuários
            usuarioDAO.criarUsuario(usuario);
        }
    }
}
```

Agora, você precisará ter uma implementação adequada para a interface `UsuarioDAO`. Vamos atualizar a interface `UsuarioDAO` e criar uma implementação básica:

```java
import java.util.List;

// Atualização da interface DAO
public interface UsuarioDAO {

    void criarUsuario(Usuario usuario);
    Usuario obterUsuarioPorID(int id);
    List<Usuario> obterTodosUsuarios();
    void atualizarUsuario(Usuario usuario);
    void excluirUsuario(int id);

    // Novo método para criar vários usuários
    void criarUsuarios(List<Usuario> usuarios);
}

// Implementação básica do DAO
public class UsuarioDAOImpl implements UsuarioDAO {

    private List<Usuario> bancoDeDadosUsuarios;

    public UsuarioDAOImpl(List<Usuario> bancoDeDadosUsuarios) {
        this.bancoDeDadosUsuarios = bancoDeDadosUsuarios;
    }

    @Override
    public void criarUsuario(Usuario usuario) {
        bancoDeDadosUsuarios.add(usuario);
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
        // Implementação da atualização
    }

    @Override
    public void excluirUsuario(int id) {
        // Implementação da exclusão
    }

    // Implementação do novo método para criar vários usuários
    @Override
    public void criarUsuarios(List<Usuario> usuarios) {
        bancoDeDadosUsuarios.addAll(usuarios);
    }
}
```

Neste exemplo, introduzimos um novo método na interface `UsuarioDAO` chamado `criarUsuarios`, que permite criar vários usuários de uma vez. A implementação correspondente em `UsuarioDAOImpl` adiciona todos os usuários fornecidos à lista.

Por fim, ao chamar `salvarDadosNoDAO` no controle, ele obtém os dados do modelo e os envia para o DAO para persistência.

Lembre-se de que esta é uma implementação básica, e em uma aplicação real, você precisaria adaptar a lógica para suas necessidades específicas e considerar transações, tratamento de erros, etc.