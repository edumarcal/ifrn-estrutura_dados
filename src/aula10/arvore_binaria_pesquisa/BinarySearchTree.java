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
    public No search(No position, No element) {
        if (super.root == null)
        {
            return null;
        } 
        else
        {
            if (key(element) < (int) position.getElement())
            {
                return search(position.getFilhoEsquerdo(), element);
            } else if (key(element) > (int) position.getElement()){
                return search(position.getFilhoDireito(), element);
            } else {
                return position;
            }

        }
    }

    @Override
    public void insert(No position, No element) {
        if (super.root == null)
        {
            super.root = element;
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
        
        if(element.equals(root))
        {
            if(hasright(root))
            {
               root = root.getFilhoDireito();
               root.setPai(null);
            }
        }
        else
        {
                // 1 caso No Folha
            if (leftChild(noDrop) == null && rightChild(noDrop) == null)
            {
                //System.out.println("Caso 1");
                noDrop.getPai().setFilhoEsquerdo(null);
                noDrop.getPai().setFilhoDireito(null);
                noDrop.setPai(null);
            }
            else
            {
                // 2 Caso excluindo o No que tem um filho
                if (hasright(noDrop) && !hasLeft(noDrop))
                {
                    //System.out.println("Caso 2R");
                    noDrop.getPai().setFilhoDireito(rightChild(noDrop));
                    noDrop.setFilhoDireito(null);
                    return noDrop;
                }
                else if(hasLeft(noDrop) && !hasright(noDrop))
                {
                    //System.out.println("Caso 2L");                
                    noDrop.getPai().setFilhoEsquerdo(leftChild(noDrop));
                    noDrop.setFilhoEsquerdo(null);             
                    return noDrop;
                }
                // 3 Caso excluindo No com dois filhos
                else
                {
                    if((int)noDrop.getElement() < (int)root.getElement())
                    {
                        //System.out.print("Caso 3L\t");
                        noDrop.getPai().setFilhoEsquerdo(rightChild(noDrop));
                    }
                    else
                    {
                        //System.out.print("Caso 3R\t");
                        noDrop.getPai().setFilhoDireito(rightChild(noDrop));
                    }

                    rightChild(noDrop).setPai(noDrop.getPai());
                    rightChild(noDrop).setFilhoEsquerdo(leftChild(noDrop));
                    leftChild(noDrop).setPai(rightChild(noDrop));

                    noDrop.setPai(null);

                    return noDrop;
                }  
            }
        }
        
        
        return noDrop;
    }

    public No leftChild(No no) {
        return no.getFilhoEsquerdo();
    }

    public No rightChild(No no) {
        return no.getFilhoDireito();
    }

    public boolean hasLeft(No no) {
        return leftChild(no) != null;
    }

    public boolean hasright(No no) {
        return rightChild(no) != null;
    }    

    public Integer key(No no)
    {
        return (Integer) no.getElement();
    }
}
