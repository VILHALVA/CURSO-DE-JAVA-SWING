package util;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Tabela {

    public JTable criarTabela(JPanel jpn, Object[] largura, Object[] pos, Object[] col) throws NullPointerException {
        
        JTable tabela = new JTable(new DefaultTableModel());
        tabela.setVisible(true);

        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();    

    
        tabela.setFont(new Font("Arial", Font.BOLD, 11));
        JScrollPane jsp = new JScrollPane(tabela);
        tabela.setRowHeight(25);
        jsp.setBounds(10, 40, 680, 120);
        jsp.setVisible(true);
        jpn.add(jsp);
      

        // Ordenando ao clicar no titulo da coluna da tabela
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modeloTabela);
        tabela.setRowSorter(sorter);             
       
        //Adicionando coluna
        for (int i = 0; i < col.length; i++) {
            modeloTabela.addColumn(col[i]);
        }

        //Criando objeto para alinhamento dos dados dentro da tabela
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

        //Adicionando as posiçoes
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);

        //Trabalhando com as colunas 
        for (int i = 0; i < largura.length; i++) {
            if (pos[i].equals("centro")) {
                pos[i] = centro;
            }
            if (pos[i].equals("direita")) {
                pos[i] = direita;
            }
            if (pos[i].equals("esquerda")) {
                pos[i] = esquerda;
            }

            tabela.getColumnModel().getColumn(i).setMaxWidth(
                    Integer.parseInt(largura[i].toString())
            );

            tabela.getColumnModel().getColumn(i).setCellRenderer(
                    (TableCellRenderer) pos[i]);

        }
        return tabela;
    }
}
