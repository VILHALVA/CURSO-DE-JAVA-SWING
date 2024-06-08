package visao;

import controle.ContatoControle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ContatoVisao extends FormPadrao {

    public JLabel jlApelido;
    public JTextField jtfApelido;

    public JLabel jlEmail;
    public JTextField jtfEmail;

    public JLabel jlDdd;
    public JTextField jtfDdd;

    public JLabel jlTelefone;
    public JTextField jtfTelefone;
    
    public JLabel jlIdCidade;
    public JTextField jtfIdCidade;
    
    
    //Construtor
    public ContatoVisao() {
        setTitle("Cadastro de Contatos");
        consultaVisao();
    }

    @Override
    public void inicializarComponentes() {
        //Apelido
        jlApelido = new JLabel("Apelido");
        jlApelido.setBounds(9, 60, 50, 25);
        jpnFormulario.add(jlApelido);

        jtfApelido = new JTextField();
        jtfApelido.setBounds(9, 80, 250, 25);
        jpnFormulario.add(jtfApelido);

        //Email
        jlEmail = new JLabel("Email");
        jlEmail.setBounds(300, 60, 50, 25);
        jpnFormulario.add(jlEmail);

        jtfEmail = new JTextField();
        jtfEmail.setBounds(300, 80, 350, 25);
        jpnFormulario.add(jtfEmail);

        //DDD
        jlDdd = new JLabel("DDD");
        jlDdd.setBounds(9, 110, 50, 25);
        jpnFormulario.add(jlDdd);

        jtfDdd = new JTextField();
        jtfDdd.setBounds(9, 130, 50, 25);
        jpnFormulario.add(jtfDdd);

        //Telefone
        jlTelefone = new JLabel("Telefone");
        jlTelefone.setBounds(100, 110, 50, 25);
        jpnFormulario.add(jlTelefone);

        jtfTelefone = new JTextField();
        jtfTelefone.setBounds(100, 130, 150, 25);
        jpnFormulario.add(jtfTelefone);
        
        //IdCidade
        jlIdCidade = new JLabel("IdCidade");
        jlIdCidade.setBounds(300, 110, 50, 25);
        jpnFormulario.add(jlIdCidade);

        jtfIdCidade = new JTextField();
        jtfIdCidade.setBounds(300, 130, 150, 25);
        jpnFormulario.add(jtfIdCidade);
    }

    //Instancia de Controle
    ContatoControle cc = new ContatoControle();

    @Override
    public void salvarVisao() {
        cc.salvarControle(jtfId.getText(), jtfDescricao.getText(), jtfApelido.getText(), jtfEmail.getText(), jtfDdd.getText(), jtfTelefone.getText(), jtfIdCidade.getText());
    }

    @Override
    public void criarTabela() {
        tabela = utilTabela.criarTabela(
                jpnConsulta,
                new Object[]{60, 200, 100, 150, 50, 150, 150},
                new Object[]{"centro", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda"},
                new Object[]{"ID", "Descrição", "Apelido", "Email", "DDD", "Telefone", "Cidade"}
        );
        modelo = (DefaultTableModel) tabela.getModel();
    }

    @Override
    public void consultaVisao() {
        modelo.setNumRows(0);
        cc.consultarControle(jtfConsulta.getText(), modelo);
    }

    @Override
    public void atualizarFormulario() {
        jtfId.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        jtfDescricao.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        jtfApelido.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        jtfEmail.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        jtfDdd.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
        jtfTelefone.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 5).toString()); 
        jtfIdCidade.setText((String) tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
    }

    @Override
    public void excluirVisao() {
        cc.excluirControle(Integer.parseInt(jtfId.getText()));
    }

    @Override
    void habilitaCampos(boolean estado) {
        jtfDescricao.setEnabled(estado);
        jtfApelido.setEnabled(estado);
        jtfEmail.setEnabled(estado);
        jtfDdd.setEnabled(estado);
        jtfTelefone.setEnabled(estado);
        jtfIdCidade.setEnabled(estado);
    }

    @Override
    void limpaCampos() {
        jtfDescricao.setText("");
        jtfApelido.setText("");
        jtfEmail.setText("");
        jtfDdd.setText("");
        jtfTelefone.setText("");
        jtfIdCidade.setText("");
    }

}
