# CRIANDO UM JINTERNALFRAME E SUBDIVIDINDO A TELA
Para criar um `JInternalFrame` e subdividir a tela em uma aplicação Java Swing, você pode usar um layout de contêiner adequado, como `JSplitPane`, para dividir a área de trabalho. Aqui está um exemplo básico:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    private JDesktopPane desktopPane;

    public JanelaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        desktopPane = new JDesktopPane();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Crie e adicione janelas internas
        criarJanelaInterna("Janela Interna 1");
        criarJanelaInterna("Janela Interna 2");

        // Crie um JSplitPane para dividir a área de trabalho
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, desktopPane, criarPainelDireito());
        splitPane.setDividerLocation(300);  // Define a localização inicial do divisor

        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);

        pack();
    }

    private JPanel criarPainelDireito() {
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BorderLayout());

        JButton botao = new JButton("Clique-me!");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica quando o botão for clicado
                criarJanelaInterna("Nova Janela Interna");
            }
        });

        painelDireito.add(botao, BorderLayout.NORTH);
        return painelDireito;
    }

    private void criarJanelaInterna(String titulo) {
        JInternalFrame internalFrame = new JInternalFrame(titulo, true, true, true, true);
        internalFrame.setSize(200, 200);

        // Adicione componentes à janela interna, se necessário

        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
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

1. `JDesktopPane` é usado como o contêiner principal.
2. Um `JSplitPane` é utilizado para dividir a área de trabalho. Ele tem dois componentes: o `JDesktopPane` à esquerda e um `JPanel` à direita, que contém um botão.
3. Cada vez que o botão é clicado, uma nova `JInternalFrame` é criada e adicionada ao `JDesktopPane`.

Este é apenas um exemplo básico, e você pode ajustá-lo conforme necessário para atender aos requisitos específicos da sua aplicação. Note que o uso de um layout de divisão (`JSplitPane`) pode ser adaptado de acordo com a necessidade de divisão horizontal ou vertical da área de trabalho.