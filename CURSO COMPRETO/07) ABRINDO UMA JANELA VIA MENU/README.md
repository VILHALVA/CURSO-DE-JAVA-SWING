# ABRINDO UMA JANELA VIA MENU
Para abrir uma `JInternalFrame` quando um item de menu é selecionado, você precisa adicionar um `ActionListener` ao item de menu correspondente. Aqui está um exemplo simples onde uma nova `JInternalFrame` é aberta quando o item de menu "Abrir Janela Interna" é selecionado:

```java
import javax.swing.*;
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

        // Crie a barra de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenuItem abrirJanelaItem = new JMenuItem("Abrir Janela Interna");

        // Adicione um ActionListener ao item de menu
        abrirJanelaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaInterna("Nova Janela Interna");
            }
        });

        // Adicione o item de menu ao menu "Arquivo"
        arquivoMenu.add(abrirJanelaItem);

        // Adicione o menu à barra de menu
        menuBar.add(arquivoMenu);

        // Configure a barra de menu na janela principal
        setJMenuBar(menuBar);

        // Configure a área de trabalho
        setLayout(new BorderLayout());
        add(desktopPane, BorderLayout.CENTER);

        pack();
    }

    private void abrirJanelaInterna(String titulo) {
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

1. Um item de menu "Abrir Janela Interna" é adicionado ao menu "Arquivo".
2. Um `ActionListener` é associado a esse item de menu.
3. Quando o item de menu é selecionado, o método `abrirJanelaInterna` é chamado para criar e exibir uma nova `JInternalFrame`.

Você pode expandir essa lógica para adicionar mais itens de menu com diferentes funcionalidades ou criar uma hierarquia mais complexa de janelas internas dependendo dos requisitos da sua aplicação.