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
        int loopNivel  = nivel; // Guarda o estado do nivel da arvore
        
        System.err.println("-----------------------------------------------------------------");
        System.err.print("ALTURA: " + height(root));
        System.err.print("\tNIVEL: " + (nivel - 1));
        System.err.print("\tTAMANHO: " + (nivel - 1));
        System.err.println("\tNOS_POSSIVEIS: " + ((int) Math.pow(2, nivel) -1));
                
        for (int i = 0; i < loopNivel; i++)
        {                   
            nivel = height(currentNo); // Calcula a altura do no
            qtdNosPossiveis = (int) Math.pow(2, nivel) -1; // Calcula a quantidade de nos possiveis            
            qtdEspacoInicio =  qtdNosPossiveis -1; // Calculo para impressao do espaco

            /*
            System.out.print("NP " + qtdNosPossiveis);
            System.out.print("\tEI " + qtdEspacoInicio);
            System.out.print("\tEE " + qtdEspacoEntre);
            System.out.print("\tEF " + qtdEspacoInicio);
            System.out.print("\tN " + nivel);
            System.out.print("\th " + qtdIteracaoEntre);
            System.out.println("\tL " + loop);
            */
            
            // Imprime os espaço de inicio
            for (int j = 0; j < qtdEspacoInicio; j++)
                System.out.print(espaco);
            
            qtdIteracaoEntre = (int) Math.pow(2, i); // Calculo para determinar a quantidade de nos possiveis deste nivel
                  
            for (int j = 0; j < qtdIteracaoEntre; j++)
            {
                //Imprime o elemento
                if (currentNo != null)
                    System.out.print(currentNo.getElement());
                else
                    System.out.print(espaco);

                for (int z = 0; z < qtdEspacoEntre; z++)
                    System.out.print(espaco);
                    //System.out.print("-");
            }
            
            // Próximo nível
            System.out.println();
 
            currentNo = currentNo.getFilhoDireito();
            
            qtdEspacoEntre = qtdEspacoInicio + 1;
        }
        
        System.err.println("-----------------------------------------------------------------");
    }
}
