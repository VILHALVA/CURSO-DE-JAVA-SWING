package util;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class PosicaoFormulario {

    //--- Abrir o formulário centralizado na tela

    public void abrirFormulario(JInternalFrame janela, JDesktopPane desktop) {
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lIFrame = janela.getWidth();
        int aIFrame = janela.getHeight();
        janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
    public void abrirFormulario(JFrame janela, JDesktopPane desktop) {
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lIFrame = janela.getWidth();
        int aIFrame = janela.getHeight();
        janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        janela.setLocationRelativeTo(null);  
        janela.setVisible(true);
    }    
}
