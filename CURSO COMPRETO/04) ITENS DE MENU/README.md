# ITENS DE MENU
Ao criar uma barra de menu em uma aplicação Java Swing, você pode adicionar diversos tipos de itens de menu para oferecer funcionalidades diversas aos usuários. Vou apresentar como adicionar alguns tipos comuns de itens de menu, incluindo JMenuItem, JCheckBoxMenuItem, e JRadioButtonMenuItem.

## 1. JMenuItem (Item de Menu Padrão):
O `JMenuItem` representa um item de menu padrão, geralmente usado para ações simples.

```java
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ...

JMenuItem abrirItem = new JMenuItem("Abrir");
abrirItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Lógica para a ação "Abrir"
        System.out.println("Ação Abrir executada");
    }
});

JMenuItem salvarItem = new JMenuItem("Salvar");
salvarItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Lógica para a ação "Salvar"
        System.out.println("Ação Salvar executada");
    }
});

// Adicione os itens ao menu "Arquivo"
arquivoMenu.add(abrirItem);
arquivoMenu.add(salvarItem);
```

## 2. JCheckBoxMenuItem (Item de Menu com Caixa de Seleção):
O `JCheckBoxMenuItem` permite ao usuário selecionar ou desselecionar uma opção.

```java
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ...

JCheckBoxMenuItem modoNoturnoItem = new JCheckBoxMenuItem("Modo Noturno");
modoNoturnoItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Lógica para alternar o modo noturno
        boolean selecionado = modoNoturnoItem.isSelected();
        System.out.println("Modo Noturno: " + (selecionado ? "Ativado" : "Desativado"));
    }
});

// Adicione o item de modo noturno ao menu "Exibir"
exibirMenu.add(modoNoturnoItem);
```

## 3. JRadioButtonMenuItem (Item de Menu com Botão de Seleção):
O `JRadioButtonMenuItem` é usado em grupos onde apenas um item pode ser selecionado por vez.

```java
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ...

JRadioButtonMenuItem tamanhoPequenoItem = new JRadioButtonMenuItem("Pequeno");
JRadioButtonMenuItem tamanhoMedioItem = new JRadioButtonMenuItem("Médio");
JRadioButtonMenuItem tamanhoGrandeItem = new JRadioButtonMenuItem("Grande");

// Adicione os itens ao grupo de botões
ButtonGroup grupoTamanho = new ButtonGroup();
grupoTamanho.add(tamanhoPequenoItem);
grupoTamanho.add(tamanhoMedioItem);
grupoTamanho.add(tamanhoGrandeItem);

// Adicione os itens ao menu "Formatar"
formatarMenu.add(tamanhoPequenoItem);
formatarMenu.add(tamanhoMedioItem);
formatarMenu.add(tamanhoGrandeItem);

// Adicione ouvintes de evento para cada item, se necessário
tamanhoPequenoItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Lógica para a seleção de tamanho pequeno
        System.out.println("Tamanho Pequeno selecionado");
    }
});
// Adicione ouvintes de evento para os outros itens, se necessário
```

Esses são exemplos básicos para ilustrar a adição de diferentes tipos de itens de menu. Você pode personalizar a lógica associada a cada item de menu conforme necessário para atender aos requisitos específicos da sua aplicação.