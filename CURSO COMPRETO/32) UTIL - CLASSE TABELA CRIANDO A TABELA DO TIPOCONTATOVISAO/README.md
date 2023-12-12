# UTIL - CLASSE TABELA CRIANDO A TABELA DO TIPOCONTATOVISAO
Para criar uma tabela do tipo `JTable` em uma aplicação Swing, você precisa definir um modelo de tabela (`TableModel`) que gerenciará os dados e a exibição da tabela. Aqui está um exemplo básico para criar uma tabela do tipo `TipoContatoVisao`:

```java
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TipoContatoTableModel extends AbstractTableModel {

    private List<TipoContatoVisao> tiposContato;
    private String[] colunas = {"ID", "Descrição"};

    public TipoContatoTableModel() {
        this.tiposContato = new ArrayList<>();
    }

    public void adicionarTipoContato(TipoContatoVisao tipoContato) {
        tiposContato.add(tipoContato);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void limparTiposContato() {
        tiposContato.clear();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return tiposContato.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoContatoVisao tipoContato = tiposContato.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return tipoContato.getId();
            case 1:
                return tipoContato.getDescricao();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
}
```

Neste exemplo, a classe `TipoContatoTableModel` estende `AbstractTableModel` e fornece implementações para os métodos necessários, como `getRowCount`, `getColumnCount`, `getValueAt`, e outros. Ela também possui métodos adicionais para adicionar tipos de contato e limpar a tabela.

Agora, você pode usar esta tabela em conjunto com um `JTable` em sua interface gráfica Swing. Aqui está um exemplo básico de como você pode fazer isso:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploTabelaTipoContato {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exemplo Tabela TipoContatoVisao");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel panel = new JPanel(new BorderLayout());

            // Criar a tabela e o modelo
            TipoContatoTableModel tipoContatoTableModel = new TipoContatoTableModel();
            JTable tabela = new JTable(tipoContatoTableModel);

            // Adicionar a tabela a um painel de rolagem
            JScrollPane scrollPane = new JScrollPane(tabela);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Adicionar botões para adicionar e limpar tipos de contato
            JButton adicionarButton = new JButton("Adicionar TipoContato");
            adicionarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TipoContatoVisao novoTipoContato = new TipoContatoVisao(1, "Novo Tipo");
                    tipoContatoTableModel.adicionarTipoContato(novoTipoContato);
                }
            });

            JButton limparButton = new JButton("Limpar Tabela");
            limparButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tipoContatoTableModel.limparTiposContato();
                }
            });

            JPanel botoesPanel = new JPanel();
            botoesPanel.add(adicionarButton);
            botoesPanel.add(limparButton);
            panel.add(botoesPanel, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
```

Neste exemplo, criamos um `JTable` com o modelo `TipoContatoTableModel`. Além disso, adicionamos botões para adicionar e limpar tipos de contato. Quando o botão "Adicionar TipoContato" é clicado, um novo tipo de contato é adicionado à tabela. Quando o botão "Limpar Tabela" é clicado, todos os tipos de contato na tabela são removidos.

Adapte este exemplo conforme necessário para a estrutura específica do seu aplicativo. Certifique-se de fornecer dados reais do seu modelo `TipoContatoVisao` ao utilizar a tabela em sua aplicação real.