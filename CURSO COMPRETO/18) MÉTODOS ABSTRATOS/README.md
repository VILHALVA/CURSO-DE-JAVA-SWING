# MÉTODOS ABSTRATOS
Métodos abstratos em Java são métodos que não têm uma implementação na classe em que são declarados. Em vez disso, eles são destinados a serem implementados pelas subclasses que herdam da classe abstrata. Aqui está um exemplo mais genérico para ilustrar como você pode usar métodos abstratos:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe abstrata com método abstrato
public abstract class FormularioAbstrato extends JFrame {

    protected JLabel rotuloNome;
    protected JTextField campoNome;
    protected JButton botaoLimpar;

    public FormularioAbstrato() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField(20);
        botaoLimpar = new JButton("Limpar");

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chama o método abstrato
                limparCampos();
            }
        });

        setLayout(new FlowLayout());

        add(rotuloNome);
        add(campoNome);
        add(botaoLimpar);

        pack();
    }

    // Método abstrato
    protected abstract void limparCampos();

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Não podemos instanciar diretamente a classe abstrata
                // FormularioAbstrato formulario = new FormularioAbstrato(); // Erro de compilação
            }
        });
    }
}

// Classe concreta que herda de FormularioAbstrato
public class FormCadastro extends FormularioAbstrato {

    private JButton botaoCadastrar;

    public FormCadastro() {
        initComponents();
    }

    private void initComponents() {
        botaoCadastrar = new JButton("Cadastrar");

        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });

        add(botaoCadastrar);

        pack();
    }

    // Implementação do método abstrato
    protected void limparCampos() {
        campoNome.setText("");
    }

    private void cadastrar() {
        String nome = campoNome.getText();
        JOptionPane.showMessageDialog(this, "Cadastro realizado!\nNome: " + nome);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastro().setVisible(true);
            }
        });
    }
}
```

Neste exemplo:

- `FormularioAbstrato` é uma classe abstrata que contém um método abstrato chamado `limparCampos()`. Esta classe pode conter outros métodos não abstratos que são compartilhados por todas as subclasses.
- `FormCadastro` herda de `FormularioAbstrato` e fornece uma implementação concreta para o método `limparCampos()`, que é chamado quando o botão "Limpar" é pressionado.

Os métodos abstratos são úteis para criar uma estrutura comum em uma hierarquia de classes, garantindo que determinados métodos sejam implementados nas subclasses, sem fornecer uma implementação padrão na classe abstrata.