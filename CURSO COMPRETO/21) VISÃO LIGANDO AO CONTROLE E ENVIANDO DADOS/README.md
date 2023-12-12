# VISÃO: LIGANDO AO CONTROLE E ENVIANDO DADOS
Se você deseja estabelecer uma relação entre a visão (normalmente representada por uma interface gráfica) e o controle, e também enviar dados da visão para o controle, você pode seguir uma abordagem onde a visão tem uma referência ao controle e, ao interagir com a interface gráfica, ela chama métodos no controle para processar os dados. Vamos criar um exemplo básico para ilustrar essa interação:

Vamos criar uma interface gráfica simples (`Visao`) e um controle correspondente (`Controle`). A interface gráfica terá um botão, e quando o botão for clicado, ela enviará uma mensagem para o controle.

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Interface de controle
interface InterfaceControle {
    void processarDados(String dados);
}

// Controle que implementa a interface
class Controle implements InterfaceControle {

    // Implementação do método da interface
    public void processarDados(String dados) {
        System.out.println("Dados recebidos no controle: " + dados);
        // Lógica de processamento aqui...
    }
}

// Interface gráfica que interage com o controle
class Visao extends JFrame {

    private JButton botao;

    // Referência ao controle
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
                controle.processarDados("Dados da interface gráfica");
            }
        });

        setLayout(new FlowLayout());

        add(botao);

        pack();
    }

    public static void main(String[] args) {
        // Cria uma instância do controle
        InterfaceControle controle = new Controle();

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

- `InterfaceControle` é a interface que declara um método `processarDados`.
- `Controle` é a classe de controle que implementa a `InterfaceControle`.
- `Visao` é a interface gráfica que possui um botão. Quando o botão é clicado, ela chama o método `processarDados` no controle, passando os dados da interface gráfica.

Esta é uma abordagem básica e pode ser expandida conforme necessário para atender aos requisitos específicos da sua aplicação.