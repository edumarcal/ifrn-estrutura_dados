// Agradeço a DEUS pelo dom do conhecimento

package aula12.arvore_avl;

import aula06.arvore_generica.No;
import aula10.arvore_binaria_pesquisa.BinarySearchTree;

/**
 *
 * @author papejajr
 */
public class ArvoreAVL extends BinarySearchTree implements IArvoreAVL
{
    @Override
    public void rotacaoSimplesEsquerda(No no) {
        System.err.println(no.getElement());
        No y = no.getFilhoDireito();
        if(y == null)
        {
            System.out.println("The tree cannot be left rotated");
            return;
        }
        no.setFilhoDireito(y.getFilhoEsquerdo());//Turn y's left subtree into x's subtree
        if (y.getFilhoEsquerdo() != null) {
            y.getFilhoEsquerdo().setPai(no);

        }
        y.setPai(no.getPai());
        if (no.getPai() == null) {
            root = y;
        } else if (no == no.getPai().getFilhoEsquerdo()) {
            no.getPai().setFilhoEsquerdo(y);
        } else {
            no.getPai().setFilhoDireito(y);
        }
        y.setFilhoEsquerdo(no);
        no.setPai(y);
    }

    @Override
    public void rotacaoSimplesDireita(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void rotacaoDuplaEsquerda(No no) {
        rotacaoSimplesDireita(no);
        rotacaoSimplesEsquerda(no);
    }

    @Override
    public void rotacaoDuplaDireita(No no) {
        rotacaoSimplesEsquerda(no);
        rotacaoSimplesDireita(no);
    }
       
    @Override
    public void atualizarFB(No no)
    {
        no.setFB(calcFB(no));
        if (no.getFB() <= -2)
        {
            //System.out.println("Rotação Simples a Esquerda");
            rotacaoSimplesEsquerda(no);
        }
        System.out.println("No:" + no.getElement() + "\tFB:" + no.getFB());
    }

    private int calcFB(No no)
    {
        //return height0(no.getFilhoEsquerdo()) - height0(root) + 1;
        return height0(no.getFilhoEsquerdo()) - height0(no.getFilhoDireito());        
    }
    
    @Override
    public void insert(No no) {
        super.insert(root, no);
        atualizarFB(no);
    }

    @Override
    public No search(No no) {
        return super.search(root, no);
    }

    @Override
    public No remove(No element) {
        No no = super.remove(element);
        
        if (no != null)
            atualizarFB(no);
        
        return no;
    } 
}
