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
public class ExpressaoRegular {
    
   //TODO VARIAVEL SIMPLES
    public String BRANCO, BRANCOS, UNDERLINE, UNDERLINES;
    public String LETRA, LETRAS;
    public String TIPOVARIAVEL, VARIAVEL, ESTRUTURA;
    public String NUMERO, NUMEROS, INTEIRO, FRACAO, DECIMAL, EXPONENCIAL, RAIZ, RAIZQ, POTENCIA, REAL;
    public String DIA, MES, ANO, DATA;
    public String VETOR, VETORCOMP, VETORCLASSE;
    public String CALLCLASS, PARAMETRO, PARAMETROSIMPLES, METODO, CLASSECAMPO, CLASSECAMPOS, DESIGNADOR, RETURN;
    public String SINAL, INTERIOREXP, EXPMAT, ESTRUTEXP;
        
    public ExpressaoRegular(){
        BRANCO = "(\\s)";
        BRANCOS = BRANCO + "*"; // *: ocorre 0 ou mais vezes
        UNDERLINE = "(\\_)";
        UNDERLINES = "((\\_)*)";
        
        LETRA = "([a-zA-Z])";
        LETRAS = "(" + LETRA + "*)";
                
        NUMERO = "([0-9])";
        NUMEROS = "(" + NUMERO + "*)";
        INTEIRO = "((-?|\\+?)" + NUMEROS + ")"; // ?: ocorre 0 ou 1 vez
        FRACAO = "(" + NUMEROS + "/" + NUMEROS + ")";
        DECIMAL = "(\\.|\\," + NUMEROS + ")";
        EXPONENCIAL = "(E\\^" + INTEIRO + ")";
        RAIZ = "(" + NUMEROS + "\\^" + FRACAO + ")";
        RAIZQ = "(√" + NUMEROS + ")";
        POTENCIA = "(" + NUMEROS + "\\^" + NUMEROS + ")";
        //QUAL MAIS O REAL ENGLOBA?
        REAL = "(" + NUMEROS + "|" + INTEIRO + "|" + FRACAO + "|" + DECIMAL + "|" + RAIZ + "|" + RAIZQ + ")";
        
        //TEM MAIS TIPOS DE VARIAVEIS E DE ESTRUTURAS
        TIPOVARIAVEL = "(int|String|float|char|double|boolean|void)";
        VARIAVEL = "(((" + LETRAS + NUMEROS + ")*)|(" + LETRAS + UNDERLINES + LETRAS + ")|(" + UNDERLINES + 
                LETRAS + ")|(" + LETRAS + ")|(" + "(" + UNDERLINES + "("+ LETRAS + NUMEROS + ")*)))";
        ESTRUTURA = "(if|else|else if|elseif|for|while|do)";
        
        DIA = "(([1-9])" + "|([1|2](" + NUMERO + "))" + "|(30|31))"; //ATENÇÃO no jeito que coloca o |
        MES = "([1-9]|10|11|12)";
        ANO = "(" + NUMERO + NUMERO + NUMERO + NUMERO + ")";
        DATA = "(" + NUMERO + "\\/" + MES + "\\/" + ANO + ")";
        
        //VERIFICAR SE VETOR PODE SER COM _ NO INTERIOR
        VETOR = "(" + VARIAVEL + "\\[" + VARIAVEL + "\\]" + ")";
        //vetor[x].vetor[y].dfd.sda ou vetor[x].y
        VETORCOMP = "(" + VETOR + "((" + "\\." + VARIAVEL + "|" + VETOR + ")*))";

        //int soma(int a,int b);
        METODO = "(" + TIPOVARIAVEL + BRANCOS + VARIAVEL + "\\(" + TIPOVARIAVEL + BRANCOS + VARIAVEL + "\\," + 
                BRANCOS + TIPOVARIAVEL + BRANCOS + VARIAVEL + "\\)" + ")";
        //produto.nome (classe acessando um campo)
        CLASSECAMPO = "(" + LETRAS + "\\." + VARIAVEL + ")";
        //produto.livros[i].autor; (classe acessando varios campos)
        CLASSECAMPOS = "(" + LETRAS + "((" + "\\." + VARIAVEL + "|" + VETOR + ")*))";
        //lista[ponto.x]; 
        VETORCLASSE = "(" + VARIAVEL + "\\[" + VARIAVEL + "\\." + VARIAVEL + "\\]" + ")";
        
        //??
        //nome de variável, nome de classe, nome de função, nome de vetor
        DESIGNADOR = "(" + VARIAVEL + "|" + METODO + "|" + VETOR + "|" + CLASSECAMPO + ")";
        
        //soma(a,b);
        PARAMETROSIMPLES = "(" + VARIAVEL + "\\(" + BRANCOS + VARIAVEL + "\\," + BRANCOS + BRANCOS + VARIAVEL + "\\)" + ")";
        //soma(int a, int b);
        PARAMETRO = "(" + VARIAVEL + "\\(" + TIPOVARIAVEL + BRANCOS + VARIAVEL + "\\," + BRANCOS + 
                TIPOVARIAVEL + BRANCOS + VARIAVEL + "\\)" + ")";
        //int soma(int a,int b);
        METODO = "(" + TIPOVARIAVEL + BRANCOS + PARAMETRO + ")";
        
        RETURN = "(" + "return" + BRANCOS + "(" + VARIAVEL + "|" + VETOR + "|" + VETORCOMP + "|" + NUMEROS + ")" + ";" + ")";
        
        //produto()
        CALLCLASS = "(" + LETRAS + "\\(" + BRANCOS + "\\)" + ")";
       
        SINAL = "(" + "\\+" + "|" + "-" + "|" + "\\/" + "|" + "\\*" + "|" + "=" + "|" + "!=" + "|" + 
                ">" + "|" + "<" + "|" + ">=" + "|" + "<=" + ")";
        //soma(5,6) – ponto.x
        INTERIOREXP = "(" + NUMEROS + "|" + LETRAS + "|" + VARIAVEL + "|" + PARAMETROSIMPLES + "|" + VETOR + "|" + 
                CLASSECAMPO + "|" + CLASSECAMPOS + "|" + VETORCOMP + "|" + DESIGNADOR + ")";
        //produto.nome + vet[4] * t
        EXPMAT = "((" + "\\(?" +  INTERIOREXP + BRANCOS + SINAL + BRANCOS + INTERIOREXP + "\\)?" + ")*)";
        //if((2*i) < (vet[4]*7))
        ESTRUTEXP = "(" + ESTRUTURA + "\\(" + BRANCOS + EXPMAT + BRANCOS + "\\))";
        
        
        
    }
    
    public void confere(String expressao, String sentenca) {
        //Verifica se a sentença possui 1 espaço (BRANCO) ou vários (BRANCOS).
        if((expressao.equals(BRANCO) && sentenca.matches(expressao)) || 
                (expressao.equals(BRANCOS) && sentenca.matches(expressao))) {
            System.out.println("W: '" + sentenca + "' ACEITA por: " + expressao);
        }else if(sentenca.isEmpty()) {
            //Não é possível verificar se a sentença for "".
            System.err.println("Sentença vazia.\n");
        }else {
            //Se não for pra verificar com a expressão BRANCO/BRANCOS e não for uma sentença vazia, verifica aqui as outras expressões
            if(sentenca.matches(expressao)) {
                System.out.println("W: '" + sentenca + "' ACEITA por: " + expressao);
            }else {
                System.err.println("W: '" + sentenca + "' rejeita por: " + expressao);
            }
            //System.err.println("Expressão não está em branco.");
        }
    }
    
}

//ROTEIRO 1: data sem ano já será rejeitada por estar faltando elemento na expressão
