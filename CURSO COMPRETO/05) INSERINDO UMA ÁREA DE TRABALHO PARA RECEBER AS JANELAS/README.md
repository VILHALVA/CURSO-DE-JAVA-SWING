# INSERINDO UMA ÁREA DE TRABALHO PARA RECEBER AS JANELAS
Para criar uma área de trabalho que possa receber várias janelas internas (também conhecidas como JInternalFrames), você pode usar o componente `JDesktopPane`. Este componente serve como um contêiner para as janelas internas em uma aplicação Swing. Aqui está um exemplo básico de como você pode implementar isso:

```java
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

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
        criarJanelaInterna("Janela Interna 3");

        setContentPane(desktopPane);
        pack();
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
2. `JInternalFrame` é usado para criar janelas internas.
3. O método `criarJanelaInterna` cria e adiciona uma nova janela interna ao `JDesktopPane`.

Você pode personalizar as janelas internas conforme necessário, adicionando componentes, definindo propriedades e adicionando lógica específica para cada uma. Este é apenas um exemplo básico, e você pode expandi-lo com base nos requisitos da sua aplicação.