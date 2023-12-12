# CONTROLE ENVIANDO OS DADOS PARA A CLASSE MODELO ARMAZENAR
Agora, vamos modificar o exemplo anterior para incluir um controle (`Controle`) que recebe dados da visão e os envia para a classe modelo (`ModeloCadastro`) para armazenamento.

```java
import java.util.List;

// Interface de controle
interface InterfaceControle {
    void enviarDadosParaModelo(String dados);
    List<String> obterDadosDoModelo();
    void limparModelo();
}

// Controle que implementa a interface
class Controle implements InterfaceControle {

    // Referência à classe modelo
    private ModeloCadastro modelo;

    public Controle(ModeloCadastro modelo) {
        this.modelo = modelo;
    }

    // Implementação do método da interface para enviar dados para a classe modelo
    public void enviarDadosParaModelo(String dados) {
        modelo.adicionarUsuario(dados);
    }

    // Implementação do método da interface para obter dados da classe modelo
    public List<String> obterDadosDoModelo() {
        return modelo.getListaUsuarios();
    }

    // Implementação do método da interface para limpar a classe modelo
    public void limparModelo() {
        modelo.limparUsuarios();
    }
}
```

Além disso, vamos atualizar a classe `Visao` para utilizar o controle:

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Interface gráfica que interage com o controle
class Visao extends JFrame {

    private JButton botao;
    private InterfaceControle controle;

    public Visao(InterfaceControle controle) {
        this.controle = controle;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botao = new JButton("Enviar Dados");

        // Adiciona um ouvinte de eventos para o botão
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quando o botão é clicado, chama o método do controle
                controle.enviarDadosParaModelo("Dados da interface gráfica");
            }
        });

        setLayout(new java.awt.FlowLayout());

        add(botao);

        pack();
    }

    public static void main(String[] args) {
        // Cria uma instância da classe modelo
        ModeloCadastro modelo = new ModeloCadastro();

        // Cria uma instância do controle passando a referência à classe modelo
        InterfaceControle controle = new Controle(modelo);

        // Cria uma instância da interface gráfica passando a referência ao controle
        Visao visao = new Visao(controle);

        // Configurações adicionais e exibição da interface gráfica
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                visao.setVisible(true);
            }
        });
    }
}
```

Neste exemplo:

- `InterfaceControle` é a interface que declara métodos para enviar dados para a classe modelo (`enviarDadosParaModelo`), obter dados da classe modelo (`obterDadosDoModelo`) e limpar a classe modelo (`limparModelo`).
- `Controle` é a classe de controle que implementa `InterfaceControle`. Essa classe interage com a classe modelo (`ModeloCadastro`).
- `Visao` agora recebe uma referência à interface de controle (`InterfaceControle`) e chama os métodos dessa interface quando o botão é clicado.

Esse exemplo segue uma abordagem mais próxima do padrão Model-View-Controller (MVC), onde a visão interage com o controle, e o controle, por sua vez, interage com a classe modelo para realizar operações relacionadas aos dados e à lógica de negócios.