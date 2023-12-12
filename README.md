# CURSO DE JAVA SWING
👨‍⚖️JAVA SWING É UMA BIBLIOTECA GRÁFICA PARA CRIAÇÃO DE INTERFACES DE USUÁRIO EM APLICATIVOS JAVA. ELA FORNECE UM CONJUNTO DE COMPONENTES E CLASSES QUE PERMITEM A CRIAÇÃO DE JANELAS, BOTÕES, CAIXAS DE DIÁLOGO E OUTROS ELEMENTOS VISUAIS EM PROGRAMAS JAVA.

[![GitHub Repo stars](https://img.shields.io/badge/VILHALVA-GITHUB-03A9F4?logo=github)](https://github.com/VILHALVA) 
[![GitHub Repo stars](https://img.shields.io/badge/VEJA%20OS-VIDEOS-03A9F4?logo=youtube)](https://www.youtube.com/@vilhalva100/search?query=JAVA%20SWING)

[![GitHub Repo stars](https://img.shields.io/badge/VEJA-DOCUMENTAÇÃO-03A9F4?logo=google)](https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/package-summary.html) 
[![GitHub Repo stars](https://img.shields.io/badge/LINGUAGEM%20DE-PROGRAMAÇÃO-03A9F4?logo=google)](https://github.com/VILHALVA/CURSO-DE-JAVA)
<br>

[![GitHub Repo stars](https://img.shields.io/badge/-PLAYLIST%20DO%20YOUTUBE-blueviolet)](https://youtube.com/playlist?list=PLwH4Cv_WLhLbc4H-aOh3xFywPGxhaso_b&si=P4Qve44T_F_BQQQR)

<img src="https://dashboard.snapcraft.io/site_media/appmedia/2022/09/icon.svg_gw9Uhzy.png" align="center" width="280"> <br>

![](https://i.imgur.com/waxVImv.png)

# CONCEITO:
O Java Swing é um conjunto de bibliotecas gráficas para o desenvolvimento de interfaces gráficas de usuário (GUIs) em Java. Ele faz parte do pacote javax.swing, e é uma extensão da biblioteca AWT (Abstract Window Toolkit). Swing fornece uma ampla variedade de componentes gráficos, como botões, caixas de texto, listas, tabelas, entre outros, que podem ser utilizados para criar aplicações desktop interativas e visualmente atraentes.

Aqui estão alguns conceitos-chave relacionados ao Java Swing:

1. **Componentes Swing:**
   - **JFrame:** Representa a janela principal da aplicação.
   - **JPanel:** Um contêiner usado para organizar e agrupar outros componentes.
   - **JButton:** Um botão que pode ser clicado.
   - **JTextField:** Uma área de texto para entrada de dados.
   - **JLabel:** Uma etiqueta de texto.
   - **JComboBox:** Uma caixa de combinação para seleção de itens em uma lista suspensa.

2. **Layouts:**
   - Define a organização e disposição dos componentes na interface.
   - Exemplos incluem BorderLayout, FlowLayout, GridLayout, etc.

3. **Eventos:**
   - Swing utiliza o modelo de programação de eventos.
   - Eventos podem ser associados a ações do usuário, como clicar em botões ou digitar texto.

4. **Threads:**
   - Interfaces gráficas devem ser manipuladas em uma thread separada (a Event Dispatch Thread) para garantir a responsividade da interface.

5. **Swing vs AWT:**
   - AWT é a biblioteca mais antiga e Swing é uma extensão mais recente.
   - Swing é mais flexível e fornece uma aparência mais consistente em diferentes plataformas.

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

