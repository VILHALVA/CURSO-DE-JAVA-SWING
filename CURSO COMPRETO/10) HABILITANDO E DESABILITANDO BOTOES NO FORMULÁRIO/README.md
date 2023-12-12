# HABILITANDO E DESABILITANDO BOTOES NO FORMULÁRIO
Para habilitar e desabilitar botões em um formulário Java Swing, você pode usar o método `setEnabled(boolean)` disponível em componentes `JButton`. Aqui está um exemplo que mostra como habilitar e desabilitar botões em resposta a eventos:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    private JButton botao1;
    private JButton botao2;
    private JButton botaoFechar;

    public JanelaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Crie os botões
        botao1 = new JButton("Botão 1");
        botao2 = new JButton("Botão 2");
        botaoFechar = new JButton("Fechar");

        // Adicione ouvintes de eventos aos botões
        botao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JanelaPrincipal.this, "Botão 1 clicado!");
                habilitarDesabilitarBotoes(false); // Desabilita os botões após o clique
            }
        });

        botao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JanelaPrincipal.this, "Botão 2 clicado!");
                habilitarDesabilitarBotoes(true); // Habilita os botões após o clique
            }
        });

        // Adicione um ouvinte de eventos para o botão Fechar
        botaoFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para fechar o formulário
                dispose();
            }
        });

        // Configure o layout da janela principal
        setLayout(new FlowLayout());

        // Adicione os botões à janela
        add(botao1);
        add(botao2);
        add(botaoFechar);

        pack();
    }

    // Método para habilitar ou desabilitar os botões
    private void habilitarDesabilitarBotoes(boolean habilitar) {
        botao1.setEnabled(habilitar);
        botao2.setEnabled(habilitar);
        botaoFechar.setEnabled(habilitar);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
}
```

Neste exemplo, o método `habilitarDesabilitarBotoes` é usado para alterar o estado de habilitação dos botões. Quando o "Botão 1" é clicado, ele desativa os botões, e quando o "Botão 2" é clicado, ele os reativa. Essa é apenas uma abordagem e pode ser adaptada conforme necessário, dependendo dos requisitos específicos da sua aplicação.