# BARRA DE MENU E MENUS PRINCIPAIS
A adição de uma barra de menu e menus principais em uma aplicação Java Swing é um componente essencial para fornecer uma interface de usuário organizada e fácil de usar. Aqui está um exemplo de como você pode implementar uma barra de menu com menus principais em sua aplicação:

## 1. Adicionando uma Barra de Menu à Janela Principal:
1. Abra sua classe `JanelaPrincipal.java` (ou o nome que você deu à sua janela principal).

2. Declare e inicialize a barra de menu no construtor da sua janela:

```java
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends javax.swing.JFrame {

    private JMenuBar menuBar;
    private JMenu arquivoMenu;
    private JMenu editarMenu;
    private JMenuItem abrirItem;
    private JMenuItem salvarItem;
    // Adicione mais itens de menu conforme necessário

    public JanelaPrincipal() {
        initComponents();
        inicializarMenuBar();
    }

    private void inicializarMenuBar() {
        // Criação da barra de menu
        menuBar = new JMenuBar();

        // Criação de menus
        arquivoMenu = new JMenu("Arquivo");
        editarMenu = new JMenu("Editar");

        // Criação de itens de menu
        abrirItem = new JMenuItem("Abrir");
        salvarItem = new JMenuItem("Salvar");
        // Adicione mais itens de menu conforme necessário

        // Adiciona itens ao menu "Arquivo"
        arquivoMenu.add(abrirItem);
        arquivoMenu.add(salvarItem);
        // Adicione mais itens ao menu "Arquivo" conforme necessário

        // Adiciona menus à barra de menu
        menuBar.add(arquivoMenu);
        menuBar.add(editarMenu);

        // Define a barra de menu para a janela principal
        setJMenuBar(menuBar);
    }

    // ... Outros métodos e componentes da sua janela principal
}
```

## 2. Adicionando Lógica aos Itens de Menu:
Adicione ouvintes de eventos para responder às ações do usuário ao clicar nos itens de menu. Por exemplo, se você quiser que algo aconteça quando o usuário clicar em "Abrir" ou "Salvar", você pode adicionar lógica dentro dos ouvintes de eventos associados a esses itens.

```java
abrirItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Lógica para a ação "Abrir"
        System.out.println("Ação Abrir executada");
    }
});

salvarItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Lógica para a ação "Salvar"
        System.out.println("Ação Salvar executada");
    }
});
```

## 3. Executando a Aplicação:
Certifique-se de que a classe principal do seu projeto (aquela com o método `main`) está configurada corretamente e execute a aplicação. A barra de menu e os menus principais devem aparecer na parte superior da sua janela.

Lembre-se de que esse é apenas um exemplo básico e você pode expandir essa estrutura adicionando mais menus, itens de menu e lógica associada conforme necessário para atender aos requisitos específicos da sua aplicação.