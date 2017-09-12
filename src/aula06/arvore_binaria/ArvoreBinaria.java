// Agradeço a DEUS pelo dom do conhecimento

package aula06.arvore_binaria;

import aula06.arvore_generica.Arvore;
import aula06.arvore_generica.No;

/**
 *
 * @author papejajr
 */
class ArvoreBinaria extends Arvore implements IArvoreBinaria
{    
    @Override
    public No leftChild(No no) {
        return no.getFilhoEsquerdo();
    }

    @Override
    public No rightChild(No no) {
        return no.getFilhoDireito();
    }

    @Override
    public boolean hasLeft(No no) {
        return leftChild(no) != null;
    }

    @Override
    public boolean hasright(No no) {
        return rightChild(no) != null;
    }

    @Override
    public void addChild(No position, No no)
    {
        if (super.root == null)
        {
            super.root = no;
        }
        else
        {
            if ((int) position.getElement() > (int) no.getElement())
            {
                //System.out.println("Esquerdo");
                //System.out.print("Pi: " + position.getElement() + "\t");
                //System.out.print("N: " + no.getElement() + "\t");
                //System.out.println("isCL: " + hasLeft(position));
                if (hasLeft(position))
                {
                    position = leftChild(position);
                    addChild(position, no);
                }
                else
                {
                    position.setFilhoEsquerdo(no);
                    no.setPai(position);
                    //System.out.println("Pf: " + position.getElement() + " => " + position.getFilhoEsquerdo().getElement());
                }
                
            }
            else
            {
                //System.out.println("Direito");
                //System.out.println("P: " + position.getElement());
                //System.out.println("N: " + no.getElement());
                //System.out.println("isCL: " + hasright(position));
                if (hasright(position))
                {
                    position = rightChild(position);
                    addChild(position, no);
                }
                else
                {
                    position.setFilhoDireito(no);
                    no.setPai(position);
                }
            } 
        }
    }

    @Override
    public No dropChild(No no)
    {
        No noDrop = search(root, no);
        
        // 1 caso No Folha
        if (leftChild(noDrop) == null && rightChild(noDrop) == null)
        {
            System.out.println("Caso 1");
            noDrop.getPai().setFilhoEsquerdo(null);
            noDrop.getPai().setFilhoDireito(null);
            noDrop.setPai(null);
            //noDrop = null;
        }
        else
        {
            System.err.println(noDrop.getElement());
            System.err.println("E: " + noDrop.getFilhoEsquerdo());
            System.err.println("R: " + noDrop.getFilhoDireito().getElement());
            
            // 2 Caso excluindo o No que tem um filho
            if (hasright(noDrop) && !hasLeft(noDrop))
            {
                System.out.println("Caso 2L");
                noDrop.getPai().setFilhoEsquerdo(leftChild(noDrop));
                noDrop.setFilhoEsquerdo(null);
                return noDrop;
            }
            else if(hasLeft(noDrop) && !hasright(noDrop))
            {
                //noDrop.getPai().setFilhoEsquerdo(rightChild(noDrop));
                noDrop.getPai().setFilhoDireito(rightChild(noDrop));
                
                
                System.out.println("Caso 2R");                
                return noDrop;
            }
            
            // 3 Caso excluindo No com dois filhos
            if(hasright(noDrop))
            {
                System.out.println("Caso 3L");
                noDrop.getPai().setFilhoDireito(rightChild(noDrop));
                return noDrop;
            }
            else if (hasLeft(noDrop))
            {
                System.out.println("Caso 3R");
                noDrop.getPai().setFilhoEsquerdo(leftChild(noDrop));
                return noDrop;
            }
                
        }
        
        return noDrop;
    }
    
    private No search(No current, No no)
    {
        if (current != null)
        {
            if(current.equals(no))
                return current;
            
            if((int)current.getElement() > (int)no.getElement())
            {
                current = current.getFilhoEsquerdo();
                search(current, no);
            }
            else
            {
                current = current.getFilhoDireito();
                search(current, no);
            }
        }
 
        return current;
    }
    
}
