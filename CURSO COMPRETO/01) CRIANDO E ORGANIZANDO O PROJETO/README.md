# CRIANDO E ORGANIZANDO O PROJETO
Ao criar e organizar um projeto Java Swing no NetBeans IDE, você pode seguir estas etapas para começar:

## 1. Criar um Projeto Java Swing:
1. **Abra o NetBeans:**
   - Inicie o NetBeans IDE.

2. **Criar um Novo Projeto:**
   - Clique em "File" > "New Project".
   - Escolha a categoria "Java" e o tipo "Java Application".
   - Clique em "Next".

3. **Configurar o Projeto:**
   - Dê um nome ao seu projeto.
   - Escolha o diretório onde deseja salvar o projeto.
   - Escolha a versão do Java que deseja usar.
   - Clique em "Finish".

## 2. Adicionar um JFrame:
1. **Adicionar um JFrame ao Projeto:**
   - No painel de projetos, clique com o botão direito no pacote onde deseja adicionar o JFrame.
   - Selecione "New" > "JFrame Form".
   - Preencha o nome da classe.
   - Clique em "Finish".

2. **Editar o JFrame:**
   - O NetBeans abrirá o JFrame no modo de design.
   - Adicione componentes (botões, rótulos, campos de texto, etc.) ao seu JFrame.
   - Configure propriedades e layouts conforme necessário.

## 3. Estrutura do Projeto:
O NetBeans organiza automaticamente a estrutura do projeto. Dentro do pacote, você terá a classe principal do projeto e as classes adicionais, como JFrames ou outros componentes Swing.

Por exemplo, a estrutura pode parecer com algo assim:

```
MeuProjeto
|-- Source Packages
|   `-- meu.pacote
|       |-- MinhaAplicacao.java (classe principal)
|       `-- MinhaJanela.java (JFrame)
`-- Other Sources
    `-- resources
        `-- icones
            `-- meuicone.png
```

## 4. Executar a Aplicação:
1. **Configurar o Main Class:**
   - No explorador de projetos, clique com o botão direito no projeto.
   - Escolha "Properties".
   - Em "Run", selecione a classe principal (normalmente a classe principal é aquela com o método `main`).

2. **Executar a Aplicação:**
   - Clique no botão verde "Run" na barra de ferramentas ou pressione `Shift + F6`.
   - Isso iniciará a aplicação e abrirá a janela definida pelo JFrame principal.

## 5. Outras Considerações:
- **Organização de Pacotes:**
  - Considere organizar seu código em pacotes lógicos para facilitar a manutenção.
  - Crie pacotes para diferentes partes da aplicação, como "gui" para interfaces gráficas e "model" para lógica de negócios.

- **Controle de Versão:**
  - Se estiver usando controle de versão, inicialize o repositório dentro do diretório do seu projeto.

Essas são orientações básicas para começar. Dependendo das necessidades específicas do seu projeto, você pode precisar adicionar mais funcionalidades, como tratamento de eventos, persistência de dados, entre outras coisas.