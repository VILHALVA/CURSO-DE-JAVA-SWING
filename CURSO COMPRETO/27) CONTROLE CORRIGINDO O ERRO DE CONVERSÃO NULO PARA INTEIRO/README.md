# CONTROLE CORRIGINDO O ERRO DE CONVERSÃO NULO PARA INTEIRO
Se você está enfrentando um erro relacionado à conversão de `null` para inteiro, pode ser necessário ajustar a lógica do seu programa para lidar com valores possivelmente nulos de maneira segura. Vou fornecer algumas sugestões para corrigir esse tipo de problema.

1. **Verificar se o ID é nulo antes da conversão:**

   Antes de converter um valor para inteiro, verifique se ele não é nulo:

   ```java
   @Override
   public Usuario obterUsuarioPorID(Integer id) {
       if (id != null) {
           // Implementação da busca por ID
       }
       return null; // ou outra lógica para tratar o ID nulo
   }
   ```

2. **Usar o tipo `Integer` ao invés de `int` para permitir nulos:**

   Se possível, altere a assinatura do método para usar `Integer` ao invés de `int` para permitir que o ID seja nulo:

   ```java
   @Override
   public Usuario obterUsuarioPorID(Integer id) {
       if (id != null) {
           // Implementação da busca por ID
       }
       return null; // ou outra lógica para tratar o ID nulo
   }
   ```

3. **Lidando com valores nulos em outros métodos:**

   Certifique-se de revisar outros métodos em que você pode estar lidando com valores nulos e aplique lógica semelhante para evitar exceções de `NullPointerException`.

Além disso, se você estiver usando Java 8 ou superior, considere utilizar a classe `Optional` para tornar o código mais seguro em relação a valores nulos. Aqui está um exemplo para o método `obterUsuarioPorID`:

```java
import java.util.Optional;

// ...

@Override
public Optional<Usuario> obterUsuarioPorID(Integer id) {
    return Optional.ofNullable(id)
                   .map(this::buscarUsuarioNoBancoDeDados);
}

private Usuario buscarUsuarioNoBancoDeDados(Integer id) {
    // Implementação da busca por ID
    // Retorna o usuário ou null se não encontrado
}
```

Essa abordagem permite que você trabalhe com um `Optional` e evite valores nulos. O método `map` será chamado somente se o ID não for nulo.

Espero que essas sugestões ajudem a resolver o problema relacionado à conversão de `null` para inteiro em sua aplicação. 