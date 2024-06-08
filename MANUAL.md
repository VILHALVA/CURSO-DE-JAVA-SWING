# MANUAL
## 1. INSTALAÇÃO DO NETBEANS IDE
O NetBeans IDE é uma IDE popular para desenvolvimento Java.

### WINDOWS, MACOS E LINUX:
1. Acesse o [site oficial do NetBeans](https://netbeans.apache.org/download/index.html).
2. Baixe a versão mais recente do NetBeans IDE.
3. Execute o instalador baixado e siga as instruções na tela para concluir a instalação.
4. Após a instalação, abra o NetBeans IDE.

## 2. CRIANDO UM PROJETO JAVA COM JAVA SWING
### PASSO A PASSO PARA CRIAR UM PROJETO NO NETBEANS:
1. Abra o NetBeans IDE.
2. Clique em "File" > "New Project".
3. Selecione "Java" na categoria e "Java Application" como tipo de projeto. Clique em "Next".
4. Nomeie seu projeto (por exemplo, `SwingExample`) e clique em "Finish".

### CRIANDO UMA NOVA CLASSE COM INTERFACE GRÁFICA JAVA SWING:
1. No painel do lado esquerdo (Projects), clique com o botão direito sobre a pasta "Source Packages" do seu projeto.
2. Selecione "New" > "Java Class".
3. Nomeie a classe (por exemplo, `Main`) e clique em "Finish".

### ESCREVENDO O CÓDIGO:
No arquivo da classe `Main.java`, escreva o código para criar uma interface gráfica Java Swing. Aqui está um exemplo básico:
```java
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Criando uma nova janela
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Criando um rótulo
        JLabel label = new JLabel("Hello, World!");
        
        // Adicionando o rótulo à janela
        frame.getContentPane().add(label);
        
        // Configurando o tamanho da janela
        frame.setSize(300, 200);
        
        // Centralizando a janela na tela
        frame.setLocationRelativeTo(null);
        
        // Exibindo a janela
        frame.setVisible(true);
    }
}
```

### EXECUTANDO O PROJETO:
1. Clique com o botão direito sobre o nome do projeto no painel do lado esquerdo (Projects).
2. Selecione "Run" para executar o projeto.
3. Uma janela com a mensagem "Hello, World!" será exibida.

## CONCLUSÃO:
Agora você tem o NetBeans IDE instalado e configurado, e criou um projeto Java com uma interface gráfica usando Java Swing. A partir daqui, você pode explorar mais sobre o desenvolvimento de aplicativos desktop em Java e as possibilidades oferecidas pelo Java Swing para criar interfaces gráficas interativas.