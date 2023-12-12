# INSERINDO COMPONENTES PADRAO NO FORMULARIO DE CADASTRO
Ao criar um formulário de cadastro em Java Swing, você pode adicionar vários componentes padrão, como rótulos (JLabel), campos de texto (JTextField), botões (JButton), e assim por diante. Aqui está um exemplo básico de um formulário de cadastro com alguns componentes padrão:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioCadastro extends JFrame {

    private JLabel rotuloNome;
    private JTextField campoNome;
    private JLabel rotuloEmail;
    private JTextField campoEmail;
    private JButton botaoCadastrar;

    public FormularioCadastro() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Crie os componentes
        rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField(20);

        rotuloEmail = new JLabel("Email:");
        campoEmail = new JTextField(20);

        botaoCadastrar = new JButton("Cadastrar");

        // Adicione um ouvinte de eventos para o botão Cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para o botão Cadastrar
                cadastrar();
            }
        });

        // Configure o layout do formulário
        setLayout(new GridLayout(4, 2)); // Um layout de grade simples

        // Adicione os componentes ao formulário
        add(rotuloNome);
        add(campoNome);
        add(rotuloEmail);
        add(campoEmail);
        add(new JLabel()); // Espaço vazio para espaçamento
        add(new JLabel()); // Espaço vazio para espaçamento
        add(botaoCadastrar);

        pack();
    }

    private void cadastrar() {
        // Lógica para tratar o clique no botão Cadastrar
        String nome = campoNome.getText();
        String email = campoEmail.getText();

        // Exemplo simples: exibir as informações cadastradas
        JOptionPane.showMessageDialog(this, "Cadastro realizado!\nNome: " + nome + "\nEmail: " + email);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioCadastro().setVisible(true);
            }
        });
    }
}
```

Neste exemplo, são utilizados rótulos (`JLabel`) para identificar os campos e campos de texto (`JTextField`) para permitir que o usuário insira informações. O botão "Cadastrar" (`JButton`) possui um ouvinte de eventos associado para executar uma ação (no caso, o método `cadastrar`) quando é clicado.

Essa é apenas uma estrutura básica. Você pode adicionar mais componentes conforme necessário, como rótulos para outros campos, campos de senha, menus suspensos (JComboBox), entre outros, dependendo dos requisitos do seu formulário de cadastro.