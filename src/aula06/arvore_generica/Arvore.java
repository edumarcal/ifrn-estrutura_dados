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

    @Override
    public void printTree()
    {     
        int nivel = height(root); // Calcula a quantidade de niveis da arvore
        int qtdNosPossiveis; // Guarda a quantidade de nos possivel
        int qtdEspacoInicio; // Guarda o valor que representa a sequencia de impressao do espaco
        int qtdEspacoEntre = 0; // Guarda o valor que representa a sequencia de impressao do espaco entre os nos
        int qtdIteracaoEntre; // Guarda o valor que representa
        String espaco = " "; // Guarda o elemento separador da impressao
        No currentNo = root; // Guarda o no corrente da iteração
        No current; // Guarda o no anterior da iteração
        int loopNivel  = nivel; // Guarda o estado do nivel da arvore
        
        // Roda pé da impressão
        System.err.println("-----------------------------------------------------------------");
        System.err.print("ALTURA: " + height(root));
        System.err.print("\tNIVEL: " + (nivel - 1));
        System.err.print("\tTAMANHO: " + size());
        System.err.println("\tNOS_POSSIVEIS: " + ((int) Math.pow(2, nivel) -1));

        for (int i = 0; i < loopNivel; i++)
        {                   
            nivel = height(currentNo); // Calcula a altura do no
            qtdNosPossiveis = (int) Math.pow(2, nivel) -1; // Calcula a quantidade de nos possiveis            
            qtdEspacoInicio =  qtdNosPossiveis -1; // Calculo para impressao do espaco
            
            for (int j = 0; j < qtdEspacoInicio; j++) // Imprime os espaço de inicio
                System.out.print(espaco);
            
            qtdIteracaoEntre = (int) Math.pow(2, i); // Calculo para determinar a quantidade de nos possiveis deste nivel
            
            System.err.println(" ");
            System.err.print("Ciclo: " + (i + 1) + " ");
            
            for (int j = 0; j < qtdIteracaoEntre; j++)
            {
                current = getElementByLevel(i, j, qtdIteracaoEntre);
                
                System.err.print(" = ");
                System.err.print(current == null ? current : current.getElement());
                System.err.print(" ");
                
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
            
            // Atualiza a referencia do proximo elemento
            currentNo = currentNo.getFilhoEsquerdo() == null ?
                    currentNo.getFilhoDireito() :
                    currentNo.getFilhoEsquerdo();
            
            // Atualiza o valor de espacamento entre os nos
            qtdEspacoEntre = qtdEspacoInicio + 1;
        }
        
        System.err.println("-----------------------------------------------------------------");
    }
    
    private No getElementByLevel(int level, int sentido, int iteracao)
    {
        if (level != 0)
            System.err.print("|"+sentido+ " N(" + level + ")| ");
        
        No retorno = root;
        
        if (level != 0)
        {
            if (level == 1)
            {
                if (sentido == 0)
                {
                    retorno = retorno == null ?
                            null :
                            retorno.getFilhoEsquerdo();
                }
                else
                {
                    retorno = retorno == null ?
                            null :
                            retorno.getFilhoDireito();
                }
            }
            else if (sentido < iteracao / 2)
            {
                System.err.print("L");
                if (sentido % 2 == 0)
                {
                    System.err.print("E ");
                    for (int i = 0; i < level; i++)
                       retorno = retorno == null ?
                            null :
                            retorno.getFilhoEsquerdo();
                }
                else
                {
                    System.err.print("D ");
                    for (int i = 0; i < level-1; i++)
                    {
                        retorno = retorno == null ?
                            null :
                            retorno.getFilhoEsquerdo();
                    }
                    
                    // Pega o filho a direira da esquerda
                    retorno = retorno == null ?
                        null :
                        retorno.getFilhoDireito();
                }
            }
            else
            {
                /*
                System.err.print("R");
                if (sentido % 2 == 0)
                {
                    System.err.print("E ");
                    for (int i = 0; i < level; i++)
                    {
                        retorno = retorno == null ?
                            null :
                            retorno.getFilhoDireito();
                        System.err.println(retorno);
                    }
                    
                    // Pega o filho a esquerda da direita
                    retorno = retorno == null ?
                        null :
                        retorno.getFilhoEsquerdo();
                }
                else
                {
                    System.err.print("D ");
                    for (int i = 0; i < level; i++)
                        retorno = retorno == null ?
                            null :
                            retorno.getFilhoDireito();
                }
                */
                
                System.err.print("R");
                if (sentido % 2 == 0)
                {
                    System.err.print("E ");
                    for (int i = 0; i < level -1; i++)
                    {
                        retorno = retorno == null ?
                            null :
                            retorno.getFilhoDireito();
                    }
                    
                    // Pega o no esquerdo da sub-arvore direita
                    retorno = retorno == null ?
                            null :
                            retorno.getFilhoEsquerdo();
                }
                else
                {
                    System.err.print("D ");
                    for (int i = 0; i < level; i++)
                    {
                        retorno = retorno == null ?
                            null :
                            retorno.getFilhoDireito();
                    }
                }
            }
        }
        return retorno;
    }
    
    private No getElementByLevel_Backup(int level, int sentido, int iteracao)
    {
        No retorno = root;
        if (level != 0)    
        ///*    
            //if (sentido < iteracao / 2)
            if (sentido < iteracao / 2)
            {
                //System.err.println("*" + iteracao + "*");
                for (int i = 1; i <= iteracao; i++)
                {
                    if (i % 2 == 0)
                        if (retorno != null)
                        {
                            retorno = retorno.getFilhoEsquerdo();
                            //if (retorno != null) System.err.println("L " + i +" Esquerda " + retorno.getElement());
                        }
                    else
                        if (retorno != null)
                        {
                            retorno = retorno.getFilhoDireito();
                            //if (retorno != null) System.err.println("L " + i +" Direita " + retorno.getElement());
                        }
                }
                System.err.print("Esquerda ");
                System.err.println(retorno == null ? retorno : retorno.getElement());
            }
            else
            {
                //System.err.println("*" + iteracao + "*");
                for (int i = 1; i <= iteracao; i++)
                {
                    if (i % 2 == 0)
                        if (retorno != null)
                        {
                            retorno = retorno.getFilhoDireito();
                            //if (retorno != null) System.err.println("D " + i +" Direita " + retorno.getElement());
                        }
                    else
                        if (retorno != null)
                        {
                            retorno = retorno.getFilhoEsquerdo();
                            //if (retorno != null) System.err.println("D " + i +" Esquerda " + retorno.getElement());
                        }
                }
                System.err.print("Direita ");
                System.err.println(retorno == null ? retorno : retorno.getElement());
            }
        //*/
        return retorno;
    }
}
