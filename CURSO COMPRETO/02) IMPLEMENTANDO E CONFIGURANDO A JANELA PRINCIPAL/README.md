# IMPLEMENTANDO E CONFIGURANDO A JANELA PRINCIPAL
Para implementar e configurar a janela principal (JFrame) em um projeto Java Swing, você pode seguir os passos a seguir. Vou fornecer um exemplo básico para ilustrar a criação de uma janela principal com alguns componentes.

## 1. Criar a Janela Principal:
1. **Crie um Novo JFrame:**
   - No NetBeans, clique com o botão direito no pacote desejado.
   - Selecione "New" > "JFrame Form".
   - Dê um nome à classe (por exemplo, `JanelaPrincipal`) e clique em "Finish".

2. **Adicionar Componentes à Janela:**
   - Abra o arquivo `JanelaPrincipal.java`.
   - No modo de design, você pode arrastar e soltar componentes da paleta para a janela. Adicione um rótulo, um botão, ou outros componentes conforme necessário.

3. **Configurar Propriedades e Layout:**
   - Configure as propriedades dos componentes (como texto, nome, etc.).
   - Ajuste o layout da janela conforme necessário (usando layouts como BorderLayout, FlowLayout, etc.).

## 2. Configurar a Janela Principal para Inicializar a Aplicação:
1. **Abra a Classe Principal do Projeto:**
   - Localize a classe principal do seu projeto (normalmente aquela que contém o método `main`).
   - Esta classe pode ter sido criada automaticamente quando você iniciou um novo projeto.

2. **Modificar o Método `main`:**
   - Dentro do método `main`, crie uma instância da sua janela principal e torne-a visível.

   Exemplo:

   ```java
   public class MinhaAplicacao {

       public static void main(String[] args) {
           java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                   new JanelaPrincipal().setVisible(true);
               }
           });
       }
   }
   ```

## 3. Adicionar Lógica de Eventos (Opcional):
1. **Tratamento de Eventos:**
   - Se você precisar adicionar lógica quando um botão for clicado ou outro evento ocorrer, você pode adicionar ouvintes de eventos.
   - Por exemplo, adicionar um ouvinte de evento para um botão:

   ```java
   meuBotao.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           // Lógica a ser executada quando o botão for clicado
           System.out.println("Botão clicado!");
       }
   });
   ```

## 4. Executar a Aplicação:
1. **Configurar a Classe Principal:**
   - Certifique-se de que a classe principal do seu projeto (aquela com o método `main`) esteja configurada corretamente.

2. **Executar a Aplicação:**
   - Clique no botão "Run" (verde) ou pressione `Shift + F6` para executar a aplicação.

Isso cria uma janela principal com os componentes que você adicionou e configura a lógica de inicialização no método `main`. A partir daqui, você pode expandir seu projeto adicionando mais janelas, componentes, e lógica conforme necessário.

