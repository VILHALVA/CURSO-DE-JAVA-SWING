# INTERFACES
Em Java, uma interface é uma coleção de métodos abstratos e constantes (variáveis finais) que podem ser implementados por classes. As interfaces são usadas para definir contratos que as classes devem seguir, permitindo a implementação de funcionalidades específicas em diferentes classes sem herança múltipla.

Aqui está um exemplo básico de como usar interfaces:

```java
// Exemplo de interface
interface FormularioInterface {
    void limparCampos(); // Método abstrato
}

// Classe que implementa a interface
public class FormCadastro implements FormularioInterface {

    private String nome;

    // Implementação do método da interface
    public void limparCampos() {
        this.nome = ""; // Limpar o campo específico da classe
    }

    public static void main(String[] args) {
        FormCadastro formulario = new FormCadastro();
        formulario.limparCampos();
        System.out.println("Campos limpos.");
    }
}
```

Neste exemplo:

- `FormularioInterface` é uma interface com um método abstrato `limparCampos()`.
- `FormCadastro` é uma classe que implementa `FormularioInterface`. A classe fornece uma implementação específica para o método `limparCampos()`.

Ao implementar uma interface, a classe deve fornecer uma implementação concreta para todos os métodos definidos na interface. Isso cria um contrato que as classes que implementam a interface devem seguir.

Além dos métodos abstratos, interfaces podem ter constantes (variáveis finais) e, a partir do Java 8, podem conter métodos com implementação padrão (métodos concretos).

```java
// Exemplo de interface com método padrão
interface MensagemInterface {
    void exibirMensagem(); // Método abstrato

    default void saudacao() {
        System.out.println("Olá!"); // Método com implementação padrão
    }
}

// Classe que implementa a interface com método padrão
public class MinhaClasse implements MensagemInterface {

    // Implementação do método abstrato
    public void exibirMensagem() {
        System.out.println("Mensagem da classe.");
    }

    public static void main(String[] args) {
        MinhaClasse minhaInstancia = new MinhaClasse();
        minhaInstancia.exibirMensagem(); // Método implementado pela classe
        minhaInstancia.saudacao(); // Método padrão da interface
    }
}
```

Aqui, `MensagemInterface` tem um método abstrato `exibirMensagem()` e um método padrão `saudacao()`. `MinhaClasse` implementa `MensagemInterface` e fornece uma implementação concreta para `exibirMensagem()`. A classe também herda o método padrão `saudacao()` da interface.