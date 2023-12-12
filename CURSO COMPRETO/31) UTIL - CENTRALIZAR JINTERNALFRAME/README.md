# UTIL - CENTRALIZAR JINTERNALFRAME
Para centralizar um `JInternalFrame` em um `JDesktopPane` dentro de um `JFrame`, você pode usar o método `setLocation` e `setBounds`. Aqui está um exemplo de como centralizar um `JInternalFrame`:

```java
import javax.swing.*;
import java.awt.*;

public class ExemploCentralizarJInternalFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exemplo Centralizar JInternalFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JDesktopPane desktopPane = new JDesktopPane();
            frame.setContentPane(desktopPane);

            // Criar um JInternalFrame
            JInternalFrame internalFrame = new JInternalFrame("JInternalFrame", true, true, true, true);
            internalFrame.setSize(300, 200);

            // Centralizar o JInternalFrame no JDesktopPane
            centralizarInternalFrame(desktopPane, internalFrame);

            internalFrame.setVisible(true);
            desktopPane.add(internalFrame);

            frame.setVisible(true);
        });
    }

    private static void centralizarInternalFrame(JDesktopPane desktopPane, JInternalFrame internalFrame) {
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = internalFrame.getSize();

        int x = (desktopSize.width - frameSize.width) / 2;
        int y = (desktopSize.height - frameSize.height) / 2;

        internalFrame.setLocation(x, y);
    }
}
```

Neste exemplo, a função `centralizarInternalFrame` calcula a posição central para o `JInternalFrame` com base nas dimensões do `JDesktopPane` e do próprio `JInternalFrame`. Certifique-se de chamar esta função sempre que o tamanho do `JInternalFrame` ou do `JDesktopPane` for alterado.

A função `SwingUtilities.invokeLater` é usada para garantir que a interface gráfica seja manipulada no segmento de despacho de eventos da Swing.

Essa é uma maneira simples de centralizar um `JInternalFrame`, e você pode adaptar esse código conforme necessário para a estrutura específica do seu aplicativo.