// Agradeço a DEUS pelo dom do conhecimento

package aula06;

/**
 *
 * @author papejajr
 */
public class Arvore implements IArvore
{

    @Override
    public Integer size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Altura em O(n)
    @Override
    public Integer height(No no) {
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
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public No root() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public No parent(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable children(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExternal(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Object replace(No no, No obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
