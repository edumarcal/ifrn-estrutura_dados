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

    private Integer h = 0;
    
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
                System.out.println("Pi: " + position.getElement());
                System.out.println("N: " + no.getElement());
                //System.out.println("isCL: " + hasLeft(position));
                if (hasLeft(position))
                {
                    //System.out.println("IP: " + position.getElement());
                    //System.out.println("ILP: " + leftChild(position).getElement());
                    position = leftChild(position);
                    addChild(position, no);
                }
                position.setFilhoEsquerdo(no);
                no.setPai(position);
                System.out.println("Pf: " + position.getElement() + " => " + position.getFilhoEsquerdo().getElement());
                System.out.println();
            }
            else
            {
                //System.out.println("Direito");
                //System.out.println("P: " + position.getElement());
                //System.out.println("N: " + no.getElement());
                //System.out.println("isCL: " + hasright(position));
                
                if (hasright(position))
                    addChild(rightChild(position), no);
        
                position.setFilhoDireito(no);
                no.setPai(position);
            } 
        }
        
        h++; //incrementa o tamanho de nos da arvore
        //System.out.println("Size: " + h);
    }

    @Override
    public No dropChild(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Corrigir o erro da referencia do objeto herdado (Arvore)
    @Override
    public Integer size() {
        return this.h;
    }
}
