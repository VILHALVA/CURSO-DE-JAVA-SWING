# HABILITANDO E DESABILITANDO CAMPOS
Para habilitar e desabilitar campos de texto (ou qualquer outro componente) em Java Swing, você pode usar o método `setEnabled(boolean)` disponível em componentes Swing. Aqui está um exemplo onde um botão habilita e desabilita campos de texto em resposta a eventos:

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

        // Adicione um ouvinte de eventos para o botão
        botaoHabilitarDesabilitar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para habilitar ou desabilitar campos
                habilitarDesabilitarCampos();
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
        add(botaoHabilitarDesabilitar);

        pack();
    }

    private void habilitarDesabilitarCampos() {
        // Lógica para habilitar ou desabilitar campos
        boolean habilitar = !campoNome.isEnabled(); // Inverte o estado atual

        campoNome.setEnabled(habilitar);
        campoEmail.setEnabled(habilitar);
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

Neste exemplo, os campos de texto `campoNome` e `campoEmail` são inicialmente desabilitados (`setEnabled(false)`), e o botão "Habilitar/Desabilitar" alterna o estado de habilitação dos campos quando é clicado.

Você pode adaptar essa lógica conforme necessário para atender aos requisitos específicos do seu aplicativo.