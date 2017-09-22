// Agradeço a DEUS pelo dom do conhecimento

package aula10.arvore_binaria_pesquisa;

import aula06.arvore_generica.Arvore;
import aula06.arvore_generica.No;

/**
 *
 * @author papejajr
 */
public class BinarySearchTree extends Arvore implements IBinarySearchTree {
    
    @Override
    public No search(No position, No element)
    {
        if (root == null)
            return null;
        else if ((int) element.getElement() < (int) position.getElement())
            return search(position.getFilhoEsquerdo(), element);
        else if ((int) element.getElement() > (int) position.getElement())
            return search(position.getFilhoDireito(), element);
        else
            return position;
    }

    @Override
    public void insert(No position, No element) {
        if (root == null)
        {
            root = element;
            root.setPai(root);
        }
        else
        {
            if ((int) position.getElement() > (int) element.getElement())
            {
                if (hasLeft(position))
                {
                    position = leftChild(position);
                    insert(position, element);
                }
                else
                {
                    position.setFilhoEsquerdo(element);
                    element.setPai(position);
                }                
            }
            else
            {
                if (hasright(position))
                {
                    position = rightChild(position);
                    insert(position, element);
                }
                else
                {
                    position.setFilhoDireito(element);
                    element.setPai(position);
                }
            } 
        }
    }

    @Override
    public No remove(No element) {
        No noDrop = search(root, element);

        // remove raiz unico elemento na arvore
        if(noDrop.equals(root) && !hasLeft(noDrop) && !hasright(noDrop))
        {
            No r = root;
            root = null;
            return r;
        }
        
        // 1 caso No Folha 
        if (!hasLeft(noDrop) && !hasright(noDrop))
        {
            //System.out.println("Caso 1");
            if((int) noDrop.getElement() < (int)noDrop.getPai().getElement())
            {
                if (hasLeft(noDrop.getPai()))
                {
                    if (noDrop.getPai().getFilhoEsquerdo().equals(noDrop))
                    {
                        //System.out.println("FL");
                        noDrop.getPai().setFilhoEsquerdo(null);
                    }
                }
            }
            else if(hasright(noDrop.getPai()))
            {
                if(noDrop.getPai().getFilhoDireito().equals(noDrop))
                {
                    //System.out.println("FR");
                    noDrop.getPai().setFilhoDireito(null);
                }
            }
            noDrop.setPai(null);
            return noDrop;
        }
        else
        {
            // 2 Caso excluindo o No que tem um filho
            if (hasLeft(noDrop) && !hasright(noDrop))
            {
                //System.out.println("Caso 2L");
                if (noDrop.getPai().equals(root) && size() == 2) // remove root
                {
                    noDrop.setPai(root);
                    root = noDrop.getFilhoEsquerdo();
                } 
                else if ((int)noDrop.getElement() > (int) root.getElement())
                {
                    noDrop.getFilhoEsquerdo().setPai(noDrop.getPai());
                    noDrop.getPai().setFilhoDireito(noDrop.getFilhoEsquerdo());
                }
                else
                {
                    noDrop.getFilhoEsquerdo().setPai(noDrop.getPai());
                    noDrop.getPai().setFilhoEsquerdo(noDrop.getFilhoEsquerdo());
                }
                return noDrop;
            }
            else if(hasright(noDrop) && !hasLeft(noDrop))
            {
                System.out.println("Caso 2R");
                if (noDrop.getPai().equals(root) && size() == 2)
                {
                    noDrop.setPai(root);
                    root = noDrop.getFilhoDireito();
                }
                else if((int) noDrop.getElement() < (int) root.getElement())
                {
                    noDrop.getFilhoDireito().setPai(noDrop.getPai());
                    noDrop.getPai().setFilhoEsquerdo(noDrop.getFilhoDireito());
                }
                else
                {
                    noDrop.getFilhoDireito().setPai(noDrop.getPai());
                    noDrop.getPai().setFilhoDireito(rightChild(noDrop));
                }

                return noDrop;
            }
            // 3 Caso excluindo No com dois filhos
            else
            {
                int i = 0;
                //System.err.println("SIZE " + size());
                //System.err.println("H "+height(noDrop));
                //System.err.println("E "+noDrop.getElement());
                
                int size = height(noDrop);
                
                No temp = noDrop.getFilhoDireito();
                boolean flag;
                while (i < size-1)
                {                        
                    if (hasLeft(temp))
                    {
                        //System.err.println("TEM FL + " + temp.getFilhoEsquerdo().getElement());
                        temp = temp.getFilhoEsquerdo();
                        flag = true;
                    }
                    else if(hasright(temp))
                    {
                        //System.err.println("TEM FR + " + temp.getFilhoDireito().getElement());
                        temp = temp.getFilhoDireito();
                        flag = false;
                    }
                    else
                    {
                        break;
                    }
                    
                    if(flag && i != 1)
                    {
                        break;
                    }
                    i++;
                }
                
                //System.err.println(flag);
                //System.err.println(temp.getElement());
                noDrop.setElement(temp.getElement());
                ///*
                if (temp.getPai().getFilhoEsquerdo().equals(temp))
                {
                    if(hasLeft(temp))
                    {
                        //System.err.println("FE + " + temp.getPai().getFilhoEsquerdo().getElement());
                        temp.getPai().setFilhoEsquerdo(temp.getFilhoEsquerdo());
                    }
                    else if(hasright(temp))
                    {
                        //System.err.println("FR + " + temp.getPai().getFilhoDireito().getElement());
                        temp.getPai().setFilhoEsquerdo(temp.getFilhoDireito());
                    }
                    else
                    {
                        temp.getPai().setFilhoEsquerdo(null);
                    }
                }
                else
                {
                    if(hasright(temp))
                    {
                        //System.err.println("FR + " + temp.getPai().getFilhoDireito().getElement());
                        temp.getPai().setFilhoEsquerdo(temp.getFilhoDireito());
                    }
                    else if(hasLeft(temp))
                    {
                        //System.err.println("FE + " + temp.getPai().getFilhoEsquerdo().getElement());
                        temp.getPai().setFilhoEsquerdo(temp.getFilhoEsquerdo());
                    }
                    else
                    {
                        temp.getPai().setFilhoDireito(null);
                    }
                }

                return noDrop;
         }
        }
    }

    public No leftChild(No no)
    {
        return no.getFilhoEsquerdo();
    }

    public No rightChild(No no)
    {
        return no.getFilhoDireito();
    }

    public boolean hasLeft(No no)
    {
        return leftChild(no) != null;
    }

    public boolean hasright(No no)
    {
        return rightChild(no) != null;
    }    
}
