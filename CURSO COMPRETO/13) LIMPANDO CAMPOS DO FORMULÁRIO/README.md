# LIMPANDO CAMPOS DO FORMULÁRIO
Para limpar os campos de um formulário em Java Swing, você pode simplesmente definir o texto dos campos de texto (`JTextField`) como uma string vazia (`""`). Aqui está um exemplo de como modificar o código anterior para adicionar um botão que limpa os campos do formulário:

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
    private JButton botaoHabilitarDesabilitar;
    private JButton botaoLimparCampos;

    public FormularioCadastro() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Crie os componentes
        rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField(20);
        campoNome.setEnabled(false); // Inicia desabilitado

        rotuloEmail = new JLabel("Email:");
        campoEmail = new JTextField(20);
        campoEmail.setEnabled(false); // Inicia desabilitado

        botaoHabilitarDesabilitar = new JButton("Habilitar/Desabilitar");
        botaoLimparCampos = new JButton("Limpar Campos");

        // Adicione ouvintes de eventos para os botões
        botaoHabilitarDesabilitar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para habilitar ou desabilitar campos
                habilitarDesabilitarCampos();
            }
        });

        botaoLimparCampos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para limpar os campos
                limparCampos();
            }
        });

        // Configure o layout do formulário
        setLayout(new GridLayout(5, 2)); // Um layout de grade simples

        // Adicione os componentes ao formulário
        add(rotuloNome);
        add(campoNome);
        add(rotuloEmail);
        add(campoEmail);
        add(new JLabel()); // Espaço vazio para espaçamento
        add(new JLabel()); // Espaço vazio para espaçamento
        add(botaoHabilitarDesabilitar);
        add(botaoLimparCampos);

        pack();
    }

    private void habilitarDesabilitarCampos() {
        // Lógica para habilitar ou desabilitar campos
        boolean habilitar = !campoNome.isEnabled(); // Inverte o estado atual

        campoNome.setEnabled(habilitar);
        campoEmail.setEnabled(habilitar);
    }

    private void limparCampos() {
        // Lógica para limpar os campos
        campoNome.setText("");
        campoEmail.setText("");
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

Neste exemplo, foi adicionado um novo botão chamado "Limpar Campos". Quando esse botão é clicado, o método `limparCampos()` é chamado, o qual define o texto dos campos de texto como uma string vazia, efetivamente limpando-os.