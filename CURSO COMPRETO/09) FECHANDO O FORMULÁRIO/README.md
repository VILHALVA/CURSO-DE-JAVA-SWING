# FECHANDO O FORMULÁRIO
Para adicionar um botão que fecha o formulário (JFrame) quando clicado, você pode criar um botão específico para essa finalidade e adicionar um ouvinte de eventos (ActionListener) para processar o fechamento. Aqui está um exemplo adicionando um botão "Fechar" à janela principal:

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
            }
        });

        botao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JanelaPrincipal.this, "Botão 2 clicado!");
            }
        });

        // Adicione um ouvinte de eventos para o botão Fechar
        botaoFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para fechar o formulário
                dispose(); // Este método fecha o formulário
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
}
```

Neste exemplo, o botão "Fechar" tem um ouvinte de eventos que utiliza o método `dispose()` para fechar a janela principal. Isso é uma abordagem comum para fechar uma janela em Swing. Se precisar realizar outras ações ou tiver requisitos mais complexos, você pode adaptar a lógica do ouvinte de eventos conforme necessário.