# SINTAXE DO JAVA SWING:
## BOTÕES SIMPLES:
Aqui está um exemplo simples de um programa Swing que cria uma janela com um botão:

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploSwing {

    public static void main(String[] args) {
        // Criar uma instância de JFrame
        JFrame frame = new JFrame("Exemplo Swing");

        // Criar um botão
        JButton button = new JButton("Clique-me!");

        // Adicionar um ouvinte de evento ao botão
        button.addActionListener(e -> {
            // Exibir uma mensagem quando o botão for clicado
            JOptionPane.showMessageDialog(frame, "Você clicou no botão!");
        });

        // Adicionar o botão ao conteúdo da janela
        frame.getContentPane().add(button);

        // Configurar o fechamento padrão da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o tamanho da janela
        frame.setSize(300, 200);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
```
Este código Java cria uma simples interface gráfica usando a biblioteca Swing. Aqui está uma explicação linha por linha:

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
```
- Importa as classes necessárias da biblioteca Swing para criar uma janela, um botão e uma caixa de diálogo de mensagem.

```java
public class ExemploSwing {
```
- Declara uma classe chamada `ExemploSwing`, que será o ponto de entrada do programa.

```java
    public static void main(String[] args) {
```
- O método `main` é o ponto de entrada do programa Java.

```java
        // Criar uma instância de JFrame
        JFrame frame = new JFrame("Exemplo Swing");
```
- Cria uma nova instância de `JFrame`, que é uma janela na interface gráfica, com o título "Exemplo Swing".

```java
        // Criar um botão
        JButton button = new JButton("Clique-me!");
```
- Cria um novo botão com o texto "Clique-me!".

```java
        // Adicionar um ouvinte de evento ao botão
        button.addActionListener(e -> {
            // Exibir uma mensagem quando o botão for clicado
            JOptionPane.showMessageDialog(frame, "Você clicou no botão!");
        });
```
- Adiciona um ouvinte de evento ao botão. Quando o botão é clicado, uma mensagem será exibida usando `JOptionPane.showMessageDialog`.

```java
        // Adicionar o botão ao conteúdo da janela
        frame.getContentPane().add(button);
```
- Adiciona o botão ao conteúdo da janela (`JFrame`).

```java
        // Configurar o fechamento padrão da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```
- Configura o comportamento padrão da janela quando o botão de fechar é clicado. Neste caso, o programa será encerrado.

```java
        // Configurar o tamanho da janela
        frame.setSize(300, 200);
```
- Configura o tamanho da janela para 300 pixels de largura e 200 pixels de altura.

```java
        // Tornar a janela visível
        frame.setVisible(true);
    }
}
```
- Torna a janela visível, exibindo-a na tela.

## JANELA:
Aqui está um exemplo simples de Java Swing que cria uma janela com um campo de texto e um botão que exibe uma mensagem quando clicado:

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploSwing {

    public static void main(String[] args) {
        // Criar uma instância de JFrame
        JFrame frame = new JFrame("Exemplo Swing");

        // Criar um painel
        JPanel panel = new JPanel();
        
        // Criar um rótulo
        JLabel label = new JLabel("Digite seu nome:");

        // Criar um campo de texto
        JTextField textField = new JTextField(15);

        // Criar um botão
        JButton button = new JButton("Clique-me!");

        // Adicionar um ouvinte de evento ao botão
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter o texto do campo de texto
                String nome = textField.getText();
                // Exibir uma mensagem de boas-vindas com o nome digitado
                JOptionPane.showMessageDialog(frame, "Olá, " + nome + "!");
            }
        });

        // Adicionar componentes ao painel
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Adicionar o painel à janela
        frame.getContentPane().add(panel);

        // Configurar o fechamento padrão da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o tamanho da janela
        frame.setSize(300, 150);

        // Centralizar a janela na tela
        frame.setLocationRelativeTo(null);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
```

Neste exemplo, uma janela é criada com um campo de texto, um rótulo (label) e um botão. Quando o botão é clicado, uma caixa de diálogo é exibida com uma mensagem de boas-vindas contendo o texto digitado no campo de texto.

Vamos explicar o código passo a passo:

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
```
- Esta parte do código importa as classes necessárias da biblioteca Swing, bem como as classes necessárias para lidar com eventos de ação.

```java
public class ExemploSwing {
```
- Aqui é declarada a classe `ExemploSwing`, que será o ponto de entrada do programa.

```java
    public static void main(String[] args) {
```
- Este é o método `main`, que é o ponto de entrada do programa Java.

```java
        // Criar uma instância de JFrame
        JFrame frame = new JFrame("Exemplo Swing");
```
- Cria uma nova instância de `JFrame`, que é uma janela na interface gráfica, com o título "Exemplo Swing".

```java
        // Criar um painel
        JPanel panel = new JPanel();
```
- Cria um novo `JPanel`, que é um contêiner que pode ser usado para organizar outros componentes Swing.

```java
        // Criar um rótulo
        JLabel label = new JLabel("Digite seu nome:");
```
- Cria um novo `JLabel` com o texto "Digite seu nome:", que será exibido na interface gráfica.

```java
        // Criar um campo de texto
        JTextField textField = new JTextField(15);
```
- Cria um novo `JTextField` com espaço para 15 caracteres, onde o usuário pode digitar o seu nome.

```java
        // Criar um botão
        JButton button = new JButton("Clique-me!");
```
- Cria um novo `JButton` com o texto "Clique-me!", que será usado para acionar uma ação na interface gráfica.

```java
        // Adicionar um ouvinte de evento ao botão
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter o texto do campo de texto
                String nome = textField.getText();
                // Exibir uma mensagem de boas-vindas com o nome digitado
                JOptionPane.showMessageDialog(frame, "Olá, " + nome + "!");
            }
        });
```
- Adiciona um ouvinte de evento ao botão. Quando o botão é clicado, a ação `actionPerformed` é executada. Dentro desta ação, o texto do campo de texto é obtido e uma caixa de diálogo `JOptionPane.showMessageDialog` é exibida, saudando o usuário pelo nome digitado.

```java
        // Adicionar componentes ao painel
        panel.add(label);
        panel.add(textField);
        panel.add(button);
```
- Adiciona o rótulo, o campo de texto e o botão ao painel.

```java
        // Adicionar o painel à janela
        frame.getContentPane().add(panel);
```
- Adiciona o painel à área de conteúdo da janela.

```java
        // Configurar o fechamento padrão da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```
- Configura o comportamento padrão da janela quando o botão de fechar é clicado. Neste caso, o programa será encerrado.

```java
        // Configurar o tamanho da janela
        frame.setSize(300, 150);
```
- Configura o tamanho da janela para 300 pixels de largura e 150 pixels de altura.

```java
        // Centralizar a janela na tela
        frame.setLocationRelativeTo(null);
```
- Centraliza a janela na tela.

```java
        // Tornar a janela visível
        frame.setVisible(true);
```
- Torna a janela visível, exibindo-a na tela.