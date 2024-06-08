package visao;

import controle.CidadeControle;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import util.ValidarCampo;

public class CidadeVisao extends FormPadrao {

    public JLabel jlUf;
    public JLabel jlCep;

    public JTextField jcbUf;
    public JTextField jtfCep;

    //Construtor
    public CidadeVisao() {
        setTitle("Cadastro de Cidade");
        consultaVisao();

    }

    @Override
    public void inicializarComponentes() {

        //UF
        jlUf = new JLabel("UF");
        jlUf.setBounds(9, 60, 50, 25);
        jpnFormulario.add(jlUf);

        jcbUf = new JTextField();
        jcbUf.setBounds(9, 80, 70, 25);
        jpnFormulario.add(jcbUf);

        //CEP
        jlCep = new JLabel("CEP");
        jlCep.setBounds(110, 60, 100, 25);
        jpnFormulario.add(jlCep);

        jtfCep = new JTextField();
        jtfCep.setBounds(110, 80, 200, 25);
        jpnFormulario.add(jtfCep);
    }

    //Instancia de Controle
    CidadeControle cic = new CidadeControle();

    @Override
    public void salvarVisao() {
        ValidarCampo validacaoVisao = new ValidarCampo();

        jtfCep = validacaoVisao.validarCep(jtfCep);

        if (jtfCep.getForeground().equals(Color.red)) {
            JOptionPane.showMessageDialog(this, "CEP inválido.");
            jtfCep.requestFocus();
            return;
        }

        cic.salvarControle(jtfId.getText(), jtfDescricao.getText(), jcbUf.getText(),
                validacaoVisao.ajustaCepInt(jtfCep.getText()));
    }

    @Override
    public void criarTabela() {
        tabela = utilTabela.criarTabela(
                jpnConsulta,
                new Object[]{60, 500, 60, 150},
                new Object[]{"centro", "esquerda", "esquerda", "esquerda"},
                new Object[]{"ID", "Descrição", "UF", "CEP"}
        );
        modelo = (DefaultTableModel) tabela.getModel();
    }

    @Override
    public void consultaVisao() {
        modelo.setNumRows(0);
        cic.consultarControle(jtfConsulta.getText(), modelo);

    }

    @Override
    public void atualizarFormulario() {
        jtfId.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        jtfDescricao.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        jcbUf.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        jtfCep.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
    }

    @Override
    public void excluirVisao() {
        cic.excluirControle(Integer.parseInt(jtfId.getText()));
    }

    @Override
    void habilitaCampos(boolean estado) {
        jtfDescricao.setEnabled(estado);
        jcbUf.setEnabled(estado); 
        jtfCep.setEnabled(estado); 
        
    }

    @Override
    void limpaCampos() {
        jtfDescricao.setText("");
        jcbUf.setText("");
        jtfCep.setText("");
    }

}
