// Agradeço a Deus pelo dom do conhecimento

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
    public No leftChild(No no)
    {
        return no.getFilhoEsquerdo();
    }

    @Override
    public No rightChild(No no)
    {
        return no.getFilhoDireito();
    }

    @Override
    public boolean hasLeft(No no)
    {
        return leftChild(no) != null;
    }

    @Override
    public boolean hasright(No no)
    {
        return rightChild(no) != null;
    }
    
    @Override
    public void addChild(No position, No no) {
        if (super.root == null)
        {
            super.root = no;
        }
        else
        {
            if ((int) position.getElement() < (int) no.getElement())
            {
                if (hasLeft(position))
                    addChild(leftChild(position), no);
                        
                position.setFilhoEsquerdo(no);
            }
            else
            {
                if (hasright(position))
                    addChild(rightChild(position), no);
                position.setFilhoDireito(no);
            }
            
            super.h++; //incrementa o tamanho de nos da arvore
        }
    }
}
