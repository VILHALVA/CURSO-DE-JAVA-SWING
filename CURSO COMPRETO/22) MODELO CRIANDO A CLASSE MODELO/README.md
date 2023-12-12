# MODELO CRIANDO A CLASSE MODELO
No contexto de padrões de design como o padrão Model-View-Controller (MVC), a classe modelo representa a lógica de negócios e os dados da aplicação. Vamos criar uma classe modelo simples para representar um exemplo de cadastro de usuários.

```java
import java.util.ArrayList;
import java.util.List;

// Classe modelo para representar um cadastro de usuários
public class ModeloCadastro {

    private List<String> listaUsuarios;

    public ModeloCadastro() {
        this.listaUsuarios = new ArrayList<>();
    }

    // Método para adicionar um usuário à lista
    public void adicionarUsuario(String usuario) {
        listaUsuarios.add(usuario);
    }

    // Método para obter a lista de usuários
    public List<String> getListaUsuarios() {
        return listaUsuarios;
    }

    // Método para limpar a lista de usuários
    public void limparUsuarios() {
        listaUsuarios.clear();
    }

    // Outros métodos de lógica de negócios podem ser adicionados conforme necessário
}
```

Neste exemplo:

- `ModeloCadastro` é a classe modelo que contém a lógica de negócios relacionada ao cadastro de usuários.
- `adicionarUsuario` adiciona um usuário à lista.
- `getListaUsuarios` retorna a lista de usuários.
- `limparUsuarios` limpa a lista de usuários.

Esta é apenas uma classe modelo básica. Dependendo dos requisitos específicos da sua aplicação, você pode adicionar mais funcionalidades e métodos conforme necessário.

Na arquitetura MVC, a classe modelo é geralmente responsável por manipular e armazenar dados, enquanto as classes de visão (interfaces gráficas) cuidam da apresentação e as classes de controle gerenciam a interação entre a visão e o modelo. Esta separação de responsabilidades facilita a manutenção e a evolução da aplicação.