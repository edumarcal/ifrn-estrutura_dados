// Agradeço a DEUS pelo dom do conhecimento

package aula05;

import aula04.DoubleList;
import aula04.No;

/**
 *
 * @author papejajr
 */
public class Sequencia extends DoubleList implements ISequencia
{    

    @Override
    public void elementAtRank(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void replaceAtRank(int r, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAtRank(int r, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAtRank(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object atRank(int r)
    {
        No no;
        if (r <= size()/2)
        {
            no = (No) frist();
            for (int i = 0; i < r; i++)
            {
                no = no.getRight();
            }
        }
        else
        {
            no = (No) last();
            for (int i = 0; i < size()-r-1; i++)
            {
                no = no.getLeft();
            }
        }
        return no;
        
    }

    @Override
    public int rankOf(Object o) {
        No no = (No) frist();
        no = no.getRight();
        int r = 0;
        while(no != o && no != last())
        {
            no = no.getRight();
            r++;
        }
        return r;
    }
}
