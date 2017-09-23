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
    public void rotacaoSimplesEsquerda(No no)
    {
        No element = no.getFilhoDireito();
        if(!hasright(no))
        {
            return;
        }
        
        no.setFilhoDireito(element.getFilhoEsquerdo());
        if (element.getFilhoEsquerdo() != null)
        {
            element.getFilhoEsquerdo().setPai(no);
        }
        
        element.setPai(no.getPai());
        if (no.getPai() == null)
        {
            root = element;
        }
        else if (no == no.getPai().getFilhoEsquerdo())
        {
            no.getPai().setFilhoEsquerdo(element);
        }
        else
        {
            no.getPai().setFilhoDireito(element);
        }
        
        element.setFilhoEsquerdo(no);
        no.setPai(element);
    }

    @Override
    public void rotacaoSimplesDireita(No no)
    {
        No element = no.getFilhoEsquerdo();
        element.setPai(no.getPai());
        if (no.getPai() != null)
        {
            if (no.getPai().getFilhoEsquerdo()== no)
            {
                no.getPai().setFilhoEsquerdo(element);
            }
            else
            {
                no.getPai().setFilhoDireito(element);
            }
        }
        
        no.setPai(element);
        if (element.getFilhoDireito()!= null)
        {
            element.getFilhoDireito().setPai(no);
            element.setFilhoDireito(no);
        }
        else
        {
            element.setFilhoDireito(no);
            element.getFilhoDireito().setPai(element);
            no.setFilhoEsquerdo(null);
        }
        root = element;
        element.setFB(element.getFB() - 1);
        element.getFilhoDireito().setFB(element.getFilhoDireito().getFB() - 2);
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
    public void atualizarFB(No no, boolean operacao)
    {
        // operacao = TRUE => INSERT | FALSE => REMOVE
        if(operacao)
        {
            //if(no.getFB() == 0)
            //    return;
            
            //if (size() > 3)
            if (hasParent(no))
            {
                /*
                // Criterio de pare
                if(parent(no).getFB() == 0)
                {
                    return;
                }
                */
                
                // sub-arvore esquerda
                if(hasLeft(parent(no)))
                {
                    if(parent(no).getFilhoEsquerdo().equals(no))
                    {
                        parent(no).setFB(parent(no).getFB() + 1); // Add Left Sum 1
                        atualizarFB(parent(no), operacao);
                        
                        if(parent(no).getFB() >= 2)
                        {
                            if(hasright(no))
                            {
                                if(rightChild(no).getFB() == -1)
                                {
                                    System.out.println("Tipo de rotação: RDD [ " + parent(no).getElement() + " ]");
                                    rotacaoDuplaDireita(parent(no));
                                }
                            }
                            else
                            {
                                System.out.println("Tipo de rotação: RDS [ " + parent(no).getElement() + " ]");
                                rotacaoSimplesEsquerda(parent(no));
                            }
                        }
                    }
                }
                // sub-arvore direita
                else if(hasright(parent(no)))
                {
                    if(parent(no).getFilhoDireito().equals(no))
                    {
                        parent(no).setFB(parent(no).getFB() -1); // Add Left Sub 1
                        atualizarFB(parent(no), operacao);
                        
                        if(parent(no).getFB() <= -2)
                        {
                            if(hasLeft(no))
                            {
                                if(leftChild(no).getFB() == -1)
                                {
                                    System.out.println("Tipo de rotação: RDE [ " + parent(no).getElement() + " ]");
                                    rotacaoDuplaEsquerda(parent(no));
                                }
                            }
                            else
                            {
                                System.out.println("Tipo de rotação: RES [ " + parent(no).getElement() + " ]");
                                rotacaoSimplesEsquerda(parent(no));
                            }
                        }
                    }
                }
                
            }
        }
        else // Case remoção
        {
            return;
        }
        
        System.out.println("No [ " + no.getElement() + " ] => FB = " + no.getFB());
    }

    private int calcFB(No no)
    {
        return height(no.getFilhoEsquerdo()) - height(no.getFilhoDireito());        
    }
    
    @Override
    public void insert(No no) {
        super.insert(root, no);
        printTree();
        atualizarFB(no, true);
    }

    @Override
    public No search(No no) {
        return super.search(root, no);
    }

    @Override
    public No remove(No element) {
        No no = super.remove(element);
        
        if (no != null)
            atualizarFB(no, false);
        
        return no;
    } 

    @Override
    public boolean hasParent(No no)
    {
        return parent(no) != null;
    }
}
