package visao;

import controle.TipoContatoControle;
import javax.swing.table.DefaultTableModel;


public class TipoContatoVisao extends FormPadrao {

    
    //Construtor
    public TipoContatoVisao(){
        setTitle("Cadastro de Tipo de contato");
        consultaVisao();
    }

    @Override
    public void inicializarComponentes() {

    }

    //Instancia de controle
    TipoContatoControle tcc = new TipoContatoControle();

    @Override
    public void salvarVisao() {
        tcc.salvarControle(jtfId.getText(), jtfDescricao.getText());
    }

    @Override
    public void criarTabela() {
        tabela = utilTabela.criarTabela(
                jpnConsulta,
                new Object[] {60, 620},
                new Object[]{"centro","esquerda"}, 
                new Object[]{"ID", "Descrição"}
        );
        modelo = (DefaultTableModel) tabela.getModel();
    }

    @Override
    public void consultaVisao() {
        modelo.setNumRows(0);
        tcc.consultarControle(jtfConsulta.getText(), modelo);
    }

    @Override
    public void atualizarFormulario() {
        jtfId.setText((String)tabela.getValueAt(tabela.getSelectedRow(),0).toString());
        jtfDescricao.setText((String)tabela.getValueAt(tabela.getSelectedRow(),1).toString());
    }

    @Override
    public void excluirVisao() {
        tcc.excluirControle(Integer.parseInt(jtfId.getText()));
    }

    @Override
    void habilitaCampos(boolean estado) {
        jtfDescricao.setEnabled(estado);
    }

    @Override
    void limpaCampos() {
        jtfDescricao.setText("");
    }
}
