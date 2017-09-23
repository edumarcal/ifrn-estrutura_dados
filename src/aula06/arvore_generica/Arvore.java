// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_generica;

/**
 *
 * @author papejajr
 */
public class Arvore extends Travessia implements IArvore
{
    protected No root;
    
    @Override
    public Integer size() {
        return size(root);        
    }
    
    private Integer size(No current)
    {
        return current == null ?
                0 :
                size(current.getFilhoEsquerdo()) + 1 + size(current.getFilhoDireito());
    }  
    
    @Override
    public Integer height(No no)
    {
        return root == null || no == null ?
                0 :
                1 + Math.max(height(no.getFilhoEsquerdo()), height(no.getFilhoDireito()));
    }
   
    @Override
    public boolean isEmpty()
    {
        return root == null;
    }
    
    @Override
    public No root()
    {
        return root;
    }

    @Override
    public No parent(No no) {
        return no.getPai();
    }

    @Override
    public boolean isInternal(No no)
    {
        return !isExternal(no);
    }

    @Override
    public boolean isExternal(No no)
    {
        return no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null;
    }

    @Override
    public boolean isRoot(No no)
    {
        return no.equals(root);
    }

    @Override
    public Integer depth(No no)
    {
        return isRoot(no) ?
                0 :
                1 + depth(parent(no));
    }

    @Override
    public Object replace(No no, No obj)
    {
        no.setElement(obj);
        return no;
    }    

    public void printLabelTree(String step)
    {
        System.out.println("----------------------------------------");
        System.out.println("Step ( "+ step + " )");
        //printTree();
        //System.out.println("----------------------------------------");
    }
    
    @Override
    public void printTree()
    {     
        int nivel = height(root); // Calcula a quantidade de niveis da arvore
        int qtdNosPossiveis; // Guarda a quantidade de nos possivel
        int qtdEspacoInicio; // Guarda o valor que representa a sequencia de impressao do espaco
        int qtdEspacoEntre = 0; // Guarda o valor que representa a sequencia de impressao do espaco entre os nos
        int qtdIteracaoEntre; // Guarda o valor que representa
        String espaco = " "; // Guarda o elemento separador da impressao
        No current; // Guarda o no anterior da iteração
        int loopNivel  = nivel; // Guarda o estado do nivel da arvore
        
        // Rodapé da impressão
        //System.err.println("-----------------------------------------------------------------");
        //System.err.print("ALTURA: " + height(root));
        //System.err.print("\tNIVEL: " + (nivel - 1));
        //System.err.print("\tTAMANHO: " + size());
        //System.err.println("\tNOS_POSSIVEIS: " + ((int) Math.pow(2, nivel) -1));

        for (int i = 0; i < loopNivel; i++)
        {                   
            //nivel = height(currentNo); // Calcula a altura do no
            //nivel--; // Calcula a altura do no
            qtdNosPossiveis = (int) Math.pow(2, nivel) -1; // Calcula a quantidade de nos possiveis            
            qtdEspacoInicio =  qtdNosPossiveis -1; // Calculo para impressao do espaco
            
            for (int j = 0; j < qtdEspacoInicio; j++) // Imprime os espaço de inicio
                System.out.print(espaco);
            
            qtdIteracaoEntre = (int) Math.pow(2, i); // Calculo para determinar a quantidade de nos possiveis deste nivel
            
            //System.err.println(" ");
            //System.err.print("Ciclo: " + (i + 1) + "\n");
            
            for (int j = 0; j < qtdIteracaoEntre; j++)
            {
                            
                current = getElementByLevel(i, j);
                    
                // Imprime o raiz
                if (i == 0)
                {
                    System.out.print(root.getElement());
                    continue;
                }
                
                //Imprime o elemento
                System.out.print(current != null ? current.getElement() : espaco);
                /*
                if (current != null)
                    System.out.print(current.getElement());
                else
                    System.out.print(espaco);
                */
                
                // Imprime os espacos entre os nos
                for (int z = 0; z < qtdEspacoEntre; z++)
                    System.out.print(espaco);
                    //System.out.print("-");
            }
            
            // Próximo nível
            System.out.println();
    
            // Atualiza o valor de espacamento entre os nos
            qtdEspacoEntre = qtdEspacoInicio + 1;
            
            nivel--; // Calcula a altura do no
        }
        
        //System.err.println("-----------------------------------------------------------------");
        System.out.println();
    }
    
    
    private boolean[][] matrizSearch(int level)
    {
        int rows = (int) Math.pow(2,level);
        boolean[][] matriz = new boolean[rows][level];
        int j = 0;
        for (int i = 0; i < rows; i++) {
            for (int z = level - 1; z >= 0; z--) {
               matriz[i][j] = (i / (int) Math.pow(2, z)) % 2 != 0;
               j++;
            }
            j = 0;
        }
        return matriz;
    }
    
    private No getElementByLevel(int level, int sentido)
    {
        No retorno = root;
        
        boolean matriz[][] = matrizSearch(level); //Calculo da Tabela Verdade (Caminho)
        
        for (int i = 0; i < level; i++)
        {
            //System.err.print(matriz[sentido][i]);
            
            if(matriz[sentido][i])
            {
                if (retorno == null)
                    return null;
                else
                    retorno = retorno.getFilhoDireito();
            }
            else
            {
                if (retorno == null)
                    return null;
                else
                    retorno = retorno.getFilhoEsquerdo();
            }

            //System.err.print(" ");
        }
        //System.err.println();
        return retorno;
    }  
}
