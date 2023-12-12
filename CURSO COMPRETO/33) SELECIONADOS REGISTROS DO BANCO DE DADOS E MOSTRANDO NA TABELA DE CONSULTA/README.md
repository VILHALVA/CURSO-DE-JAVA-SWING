# SELECIONADOS REGISTROS DO BANCO DE DADOS E MOSTRANDO NA TABELA DE CONSULTA
Para exibir registros selecionados do banco de dados em uma tabela de consulta usando Java Swing, você precisará de uma combinação de classes de modelo, banco de dados e GUI. Vou fornecer um exemplo básico usando JDBC para acessar o banco de dados e exibir os resultados em uma `JTable`.

Aqui está um exemplo simples com uma tabela `TipoContatoVisao` e um botão para carregar os registros do banco de dados:

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabelaConsultaExemplo {

    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Consulta Tabela Exemplo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel panel = new JPanel(new BorderLayout());

            // Criar a tabela e o modelo
            DefaultTableModel modeloTabela = new DefaultTableModel();
            JTable tabela = new JTable(modeloTabela);

            // Adicionar a tabela a um painel de rolagem
            JScrollPane scrollPane = new JScrollPane(tabela);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Adicionar botão para carregar registros do banco de dados
            JButton carregarButton = new JButton("Carregar Registros");
            carregarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carregarRegistrosDoBanco(modeloTabela);
                }
            });

            JPanel botoesPanel = new JPanel();
            botoesPanel.add(carregarButton);
            panel.add(botoesPanel, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static void carregarRegistrosDoBanco(DefaultTableModel modeloTabela) {
        Connection conexao = null;

        try {
            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            // Consulta SQL para obter registros da tabela TipoContatoVisao
            String consultaSQL = "SELECT * FROM TipoContatoVisao";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Limpar a tabela antes de adicionar novos registros
                modeloTabela.setRowCount(0);

                // Adicionar registros à tabela
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String descricao = resultSet.getString("descricao");

                    // Adicionar uma nova linha à tabela
                    modeloTabela.addRow(new Object[]{id, descricao});
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Tratar a exceção apropriadamente
        } finally {
            // Fechar a conexão com o banco de dados
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Tratar a exceção apropriadamente
                }
            }
        }
    }
}
```

Certifique-se de substituir `"seu_banco_de_dados"`, `"seu_usuario"` e `"sua_senha"` pelos detalhes específicos do seu ambiente de banco de dados.

Este exemplo cria uma tabela `JTable` usando `DefaultTableModel` e um botão para carregar registros do banco de dados quando clicado. O método `carregarRegistrosDoBanco` realiza a consulta SQL e atualiza o modelo da tabela com os resultados.

Adapte este exemplo conforme necessário para a estrutura específica do seu banco de dados e a lógica de consulta desejada. Lembre-se de que este é um exemplo básico, e em uma aplicação real, você precisará adicionar mais funcionalidades e lidar com situações de erro de forma mais robusta.