// Agradeço a DEUS pelo dom do conhecimento

package aula04;

/**
 *
 * @author papejajr
 */
public class DoubleList implements IDoubleList
{
    private No first, last;
    private int length;

    public DoubleList()
    {
        this.length = 0;
    }
    
    @Override
    public int size()
    {
        return this.length;
    }

    @Override
    public boolean isEmpty()
    {
        return this.first == null;
    }

    @Override
    public boolean isFirst(Object o)
    {
        return this.first.equals(o);
    }

    @Override
    public boolean isLast(Object o)
    {
        return this.last.equals(o);
    }

    @Override
    public Object frist()
    {
        return this.first;
    }

    @Override
    public Object last()
    {
        return this.last;
    }

    @Override
    public Object before(Object o)
    {
        No no = (No) o;
        return no.getLeft();
    }

    @Override
    public Object after(Object o)
    {
        No no = (No) o;
        return no.getRight();
    }

    @Override
    public void replaceElement(Object p, Object o) throws EDoubleList
    {
        if (isEmpty())
            throw new EDoubleList("Lista duplamente ligada vazia");
        
        No current = this.first;
        for (int i = 0; i < size(); i++) {
            if(current.equals(p))
            {
                current.setElement(o);
                break;
            }
            current = current.getRight();
        }
    }

    @Override
    public void swapElements(Object p, Object o) throws EDoubleList {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertBefore(Object p, Object o)
    {
        No current = this.first;
        while(current != null)
        {
            if (current.equals(p))
            {
                No no = (No) o;             
                no.setLeft(current.getLeft());
                no.setRight(current);
                
                if (current.equals(this.first))
                    this.first = no;
                else
                    current.setLeft(no);
                break;
            }
        }
        this.length++;
    }

    @Override
    public void insertAfter(Object p, Object o)
    {
        No current = this.first;
        while(current != null)
        {
            if (current.equals(p))
            {
                No no = (No) o;             
                no.setRight(current.getRight());
                no.setLeft(current);
                current.setRight(no);
                break;
            }
            current = current.getRight();
        }
        this.length++;
    }

    @Override
    public void insertFirst(Object o)
    {
        if (isEmpty())
        {
            this.first = (No) o;
            this.last = this.first;
        }
        else
        {
            No head = (No) o;
            head.setRight(this.first);
            this.first = head;
        }
        this.length++;
    }

    @Override
    public void insertLast(Object o)
    {
        if (isEmpty())
        {
            this.first = (No) o;
            this.last = this.first;
        }
        else
        {
            if (size() == 1)
            {
                this.last = (No) o;
                this.last.setLeft(this.first);
                this.first.setRight(this.last);
                //System.out.println(last + "\t" + last.getLeft() + "\t" + last.getRight());
                //System.err.println(first + "\t" + first.getLeft() + "\t" + first.getRight());
            }
            else
            {
                No tail = (No) o;
                this.last.setRight(tail);
                tail.setLeft(this.last.getLeft());
                this.last = tail;
            }
        }
        this.length++;
    }

    @Override
    public Object remove(Object o) throws EDoubleList
    {
        if (isEmpty())
            throw new EDoubleList("Lista duplamente ligada vazia");
        
        if (size() == 1)
        {
            No r = this.first;
            this.first = null;
            this.last = null;
            this.length--;
            return r;
        }             
        No element = (No) this.search(o);
        if (element != null)
        {
            No no = element;
            no.getLeft().setRight(no.getRight());
        }
        this.length--;
        return element;
    }   

    @Override
    public Object search(Object o)
    {
        No current = this.first;
        while (current != null)
        {
            if (current.equals(o))
                return current;
            current = current.getRight();
        }
        return null;
    }
}