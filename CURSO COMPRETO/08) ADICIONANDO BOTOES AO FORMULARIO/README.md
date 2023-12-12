# ADICIONANDO BOTOES AO FORMULARIO
Se você deseja adicionar botões a um formulário (ou JFrame) em uma aplicação Java Swing, você pode fazer isso de maneira semelhante à adição de outros componentes. Aqui está um exemplo básico de como adicionar botões a uma janela principal:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    private JButton botao1;
    private JButton botao2;

    public JanelaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Crie os botões
        botao1 = new JButton("Botão 1");
        botao2 = new JButton("Botão 2");

        // Adicione ouvintes de eventos aos botões
        botao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para o clique no Botão 1
                JOptionPane.showMessageDialog(JanelaPrincipal.this, "Botão 1 clicado!");
            }
        });

        botao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para o clique no Botão 2
                JOptionPane.showMessageDialog(JanelaPrincipal.this, "Botão 2 clicado!");
            }
        });

        // Configure o layout da janela principal
        setLayout(new FlowLayout());
        
        // Adicione os botões à janela
        add(botao1);
        add(botao2);

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

Neste exemplo:

1. Dois botões (`botao1` e `botao2`) são criados e adicionados à janela principal.
2. Os botões são configurados com ouvintes de eventos (`ActionListener`) para responder aos cliques do usuário.
3. Quando um botão é clicado, uma mensagem de diálogo é exibida para indicar qual botão foi clicado.

Você pode expandir esse exemplo adicionando mais botões, personalizando a lógica dos ouvintes de eventos e ajustando o layout conforme necessário para atender aos requisitos específicos da sua aplicação.