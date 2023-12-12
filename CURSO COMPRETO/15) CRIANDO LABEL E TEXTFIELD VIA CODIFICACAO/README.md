# CRIANDO LABEL E TEXTFIELD VIA CODIFICACAO
Para criar uma `JLabel` e um `JTextField` via codificação em Java Swing, você pode instanciar esses componentes e adicioná-los ao contêiner desejado (por exemplo, um `JPanel` ou o próprio `JFrame`). Aqui está um exemplo simples:

```java
import javax.swing.*;
import java.awt.*;

public class ExemploCriacaoLabelTextField extends JFrame {

    private JLabel rotuloNome;
    private JTextField campoNome;

    public ExemploCriacaoLabelTextField() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Crie a JLabel
        rotuloNome = new JLabel("Nome:");

        // Crie a JTextField
        campoNome = new JTextField(20);

        // Configure o layout do JFrame
        setLayout(new FlowLayout());

        // Adicione a JLabel e a JTextField ao JFrame
        add(rotuloNome);
        add(campoNome);

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExemploCriacaoLabelTextField().setVisible(true);
            }
        });
    }
}
```

Neste exemplo:

- Uma `JLabel` chamada `rotuloNome` é criada com o texto "Nome:".
- Um `JTextField` chamado `campoNome` é criado com uma largura de 20 colunas.
- Ambos os componentes são adicionados ao `JFrame`.

Você pode ajustar as propriedades desses componentes conforme necessário, como definir fontes, tamanhos, alinhamentos, etc. Este é apenas um exemplo básico, e você pode expandi-lo conforme os requisitos específicos do seu projeto.