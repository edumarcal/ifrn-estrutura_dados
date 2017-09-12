// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_generica;

/**
 *
 * @author papejajr
 */
public class Arvore extends Travessia implements IArvore
{
    protected No root;
    //protected Integer h; // Number maxim node in level tree
    
    @Override
    public Integer size() {
        return size(root);        
    }
    
    private Integer size(No current)
    {
        if (current == null)
            return 0;
        else
            return(size(current.getFilhoEsquerdo()) + 1 + size(current.getFilhoDireito()));
    }
    
    // Altura em O(n)
    @Override
    public Integer height(No no)
    {
        if (isInternal(no))
        {
            return 0;
        }
        else
        {
            int h = 0;
            for(Object w : children(no))
            {
                h = Integer.max(h, height(no));
            }
            return 1 + h;
        }
    }

    // Altura em O(n^2)
    public Integer height2(No no)
    {
        int h = 0;
        for (Object w : nos())
        {
            if (isExternal((No) w))
            {
                h = Integer.max(h, depth((No) w));
            }
        }
        return h;
    }
    
    @Override
    public boolean isEmpty()
    {
        return root == null;
    }

    @Override
    public Iterable elements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable nos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Iterable children(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if (isRoot(no))
            return 0;
        else
            return 1 + depth(parent(no));
    }

    @Override
    public Object replace(No no, No obj)
    {
        no.setElement(obj);
        return no;
    }    
}
