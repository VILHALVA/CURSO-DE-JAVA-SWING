# MANUAL

---

## USANDO O NETBEANS IDE:
### 1. INSTALAÇÃO:
O NetBeans IDE é uma IDE popular para desenvolvimento Java.

#### WINDOWS, MACOS E LINUX:
1. Acesse o [site oficial do NetBeans](https://netbeans.apache.org/download/index.html).
2. Baixe a versão mais recente do NetBeans IDE.
3. Execute o instalador baixado e siga as instruções na tela para concluir a instalação.
4. Após a instalação, abra o NetBeans IDE.

### 2. CRIANDO UM PROJETO:
#### PASSO A PASSO:
1. Abra o NetBeans IDE.
2. Clique em "File" > "New Project".
3. Selecione "Java" na categoria e "Java Application" como tipo de projeto. Clique em "Next".
4. Nomeie seu projeto (por exemplo, `SwingExample`) e clique em "Finish".

#### CRIANDO UMA NOVA CLASSE COM INTERFACE GRÁFICA:
1. No painel do lado esquerdo (Projects), clique com o botão direito sobre a pasta "Source Packages" do seu projeto.
2. Selecione "New" > "Java Class".
3. Nomeie a classe (por exemplo, `Main`) e clique em "Finish".

#### ESCREVENDO O CÓDIGO:
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

#### EXECUTANDO O PROJETO:
1. Clique com o botão direito sobre o nome do projeto no painel do lado esquerdo (Projects).
2. Selecione "Run" para executar o projeto.
3. Uma janela com a mensagem "Hello, World!" será exibida.

### CONCLUSÃO:
Agora você tem o NetBeans IDE instalado e configurado, e criou um projeto Java com uma interface gráfica usando Java Swing. A partir daqui, você pode explorar mais sobre o desenvolvimento de aplicativos desktop em Java e as possibilidades oferecidas pelo Java Swing para criar interfaces gráficas interativas.

---

## USANDO O MVN:
O **Maven** (`mvn`) é uma ferramenta popular de automação de build e gerenciamento de dependências para projetos Java. Ele facilita o processo de construir, testar e empacotar seus projetos, além de gerenciar bibliotecas externas (dependências) de forma centralizada.

### O QUE É O `MVN`?
- **Maven** é uma ferramenta de **build** e **gerenciamento de dependências** para projetos Java.
- Ele automatiza o processo de compilação, teste, empacotamento (como gerar arquivos `.jar` ou `.war`), e gestão de dependências externas que seu projeto usa.
- Ele segue uma estrutura padrão para projetos Java e permite configurar dependências externas no arquivo `pom.xml`.

### 1. INSTALANDO O MAVEN:
#### A) BAIXAR O MAVEN:
1. Acesse o site oficial do Maven: [Download do Maven](https://maven.apache.org/download.cgi).
2. Baixe a versão binária mais recente (`apache-maven-x.x.x-bin.zip`).

#### B) INSTALAR O MAVEN:
1. **Descompacte** o arquivo baixado para um diretório em seu sistema, por exemplo: `C:\Program Files\Apache\maven`.

#### C) CONFIGURAR O MAVEN NO WINDOWS:
1. Vá ao **Painel de Controle** → **Sistema** → **Configurações Avançadas do Sistema** → **Variáveis de Ambiente**.
2. Em **Variáveis do Sistema**, encontre a variável chamada `Path`, selecione-a e clique em **Editar**.
3. Adicione uma nova entrada com o caminho para a pasta `bin` do Maven, por exemplo:
   ```
   C:\Program Files\Apache\maven\bin
   ```

4. Crie uma nova variável de ambiente chamada `MAVEN_HOME` apontando para o diretório onde você extraiu o Maven, por exemplo:
   ```
   C:\Program Files\Apache\maven
   ```

#### D) VERIFICAR SE O MAVEN ESTÁ INSTALADO CORRETAMENTE:
1. Abra um **novo terminal** (Prompt de Comando ou PowerShell) e digite o comando:
   ```bash
   mvn -v
   ```

Se tudo estiver configurado corretamente, você verá a versão do Maven e do Java instalados no seu sistema.

### 2. CRIANDO UM PROJETO MAVEN:
Agora que o Maven está instalado, vamos criar um projeto simples.

#### A) CRIAR UM NOVO PROJETO MAVEN:
1. Abra o terminal e navegue até o diretório onde você deseja criar o projeto.
2. Execute o comando para criar um projeto Java simples:

   ```bash
   mvn archetype:generate -DgroupId=com.example.app -DartifactId=meu-projeto -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   ```

   Explicação:
   - `groupId`: Identifica o grupo do projeto (geralmente o nome do domínio invertido, como `com.example`).
   - `artifactId`: O nome do seu projeto (neste caso, `meu-projeto`).
   - `archetypeArtifactId`: Tipo de projeto (neste caso, `quickstart` para um projeto Java básico).

3. Navegue até a pasta do projeto gerado:
   ```bash
   cd meu-projeto
   ```

#### B) ESTRUTURA DO PROJETO:
O Maven cria uma estrutura padrão de diretórios:
```
meu-projeto/
  ├── src/
  │   └── main/
  │       └── java/
  │           └── com/
  │               └── example/
  │                   └── app/
  │                       └── App.java  # Classe Java principal
  ├── pom.xml  # Arquivo de configuração Maven
```

#### 3. CONFIGURAR DEPENDÊNCIAS NO `POM.XML`:
O arquivo `pom.xml` é o coração do seu projeto Maven. Ele contém as configurações e dependências que o Maven precisa para compilar e executar seu projeto.

Aqui está um exemplo simples de como configurar uma dependência de uma biblioteca externa (como o JUnit para testes):

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example.app</groupId>
    <artifactId>meu-projeto</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- Dependência para o JUnit (para testes) -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### 4. EXECUTAR COMANDOS BÁSICOS NO MAVEN:
Agora que você tem um projeto, vamos aprender os comandos básicos do Maven.

#### A) COMPILAR O PROJETO:
Para compilar o código-fonte Java, use:
```bash
mvn compile
```

#### B) EXECUTAR TESTES:
Se você tiver testes automatizados, pode executá-los com:
```bash
mvn test
```

#### C) EMPACOTAR O PROJETO:
Para empacotar seu projeto em um arquivo `.jar`, use:
```bash
mvn package
```
Isso criará um arquivo `.jar` no diretório `target/`.

#### D) EXECUTAR O PROJETO JAVA:
Se o seu projeto for uma aplicação Java com um método `main`, você pode rodar o projeto diretamente usando o plugin `exec-maven-plugin`. Primeiro, adicione isso ao seu `pom.xml`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
            <version>3.0.0</version>
            <configuration>
                <mainClass>com.example.app.App</mainClass>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Agora, para executar seu projeto, basta rodar:
```bash
mvn exec:java
```

### CONCLUSÃO:
Com o Maven, todo o processo de construir, gerenciar dependências e empacotar seu projeto Java se torna muito mais simples e automatizado.
