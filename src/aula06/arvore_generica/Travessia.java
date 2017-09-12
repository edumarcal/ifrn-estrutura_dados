// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_generica;

/**
 *
 * @author papejajr
 */
public class Travessia implements ITravessia
{
    
    @Override
    public void preOrder(No no) {        
        if (no != null)
        {
            visit(no);
            preOrder(no.getFilhoEsquerdo());
            preOrder(no.getFilhoDireito());
        }
    }
    
    @Override
    public void inOrder(No no)
    {
        if (no != null)
        {
            inOrder(no.getFilhoEsquerdo());
            visit(no);
            inOrder(no.getFilhoDireito());
        }
    }

    @Override
    public void posOrder(No no)
    {
        if (no != null)
        {
            posOrder(no.getFilhoEsquerdo());
            posOrder(no.getFilhoDireito());
            visit(no);
        }
    }

    @Override
    public void visit(No no)
    {
        System.out.println(no.getElement());
    }
    
}
