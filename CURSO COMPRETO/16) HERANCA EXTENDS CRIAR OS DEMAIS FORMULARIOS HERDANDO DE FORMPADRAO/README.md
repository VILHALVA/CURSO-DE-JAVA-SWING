# HERANCA EXTENDS CRIAR OS DEMAIS FORMULARIOS HERDANDO DE FORMPADRAO
Vamos criar uma classe `FormPadrao` que contém alguns componentes comuns e, em seguida, criar um formulário específico (`FormCadastro`) que herda dessa classe. Aqui está um exemplo:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPadrao extends JFrame {

    protected JLabel rotuloNome;
    protected JTextField campoNome;
    protected JButton botaoLimpar;

    public FormPadrao() {
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

    protected void limparCampos() {
        campoNome.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPadrao().setVisible(true);
            }
        });
    }
}
```

Agora, criaremos um formulário específico chamado `FormCadastro` que herda de `FormPadrao`:

```java
public class FormCadastro extends FormPadrao {

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

        // Adiciona o botãoCadastrar além dos componentes já presentes em FormPadrao
        add(botaoCadastrar);

        pack();
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

- `FormPadrao` contém um rótulo, um campo de texto e um botão "Limpar".
- `FormCadastro` herda de `FormPadrao` e adiciona um botão "Cadastrar" com sua própria lógica de cadastro.

Você pode criar outros formulários herdados de `FormPadrao` seguindo uma abordagem semelhante. Isso facilita a reutilização de código comum e permite que você se concentre na implementação específica de cada formulário.