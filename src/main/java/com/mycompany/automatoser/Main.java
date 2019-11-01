/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

/**
 *
 * @author aluno
 */
public class Automatos {
    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();
        
        //TODO TRATAR:
        //---> ER.confere(ER.LETRA, " a"); colocar brancos antes e depois
        //---> ER.confere(ER.RAIZ, "2^(1/2)"); colocar \\( e \\)
        //---> ER.confere(ER.DIA, "02"); colocar 2 digitos e acrescentar o 0 antes com ?
        //---> ER.confere(ER.MES, "02"); colocar 2 digitos e acrescentar o 0 antes com ?
                
        
        ER.confere(ER.BRANCO, "     ");
        ER.confere(ER.BRANCOS, "     ");
        ER.confere(ER.BRANCO, "");
        ER.confere(ER.BRANCO, " ");
        
        
        
    }
    
}
