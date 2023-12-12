# CLASSES ABSTRATAS
Classes abstratas em Java são usadas para definir uma estrutura comum para classes derivadas, mas não podem ser instanciadas por si mesmas. Elas geralmente contêm métodos abstratos (métodos sem implementação) que devem ser implementados pelas classes filhas. Vamos criar uma classe abstrata `FormularioAbstrato` com um método abstrato para limpar campos e, em seguida, criar uma classe `FormCadastro` que herda dessa classe e implementa o método abstrato:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe abstrata
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
                limparCampos();
            }
        });

        setLayout(new FlowLayout());

        add(rotuloNome);
        add(campoNome);
        add(botaoLimpar);

        pack();
    }

    // Método abstrato que deve ser implementado pelas classes filhas
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

// Classe que herda de FormularioAbstrato
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

        // Adiciona o botãoCadastrar além dos componentes já presentes em FormularioAbstrato
        add(botaoCadastrar);

        pack();
    }

    // Implementação do método abstrato limparCampos
    protected void limparCampos() {
        campoNome.setText("");
    }

    private void cadastrar() {
        // Lógica de cadastro específica para FormCadastro
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

- `FormularioAbstrato` é uma classe abstrata que contém um método abstrato `limparCampos()`.
- `FormCadastro` herda de `FormularioAbstrato` e implementa o método abstrato `limparCampos()`.

Classes abstratas são úteis para definir uma estrutura comum e garantir que certos métodos sejam implementados por suas classes filhas. Isso ajuda na reutilização de código e na manutenção de uma arquitetura mais organizada em um programa.