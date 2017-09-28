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
        //System.err.println(no.getElement());        
        No element = no.getFilhoDireito();
        no.setFilhoDireito(element.getFilhoEsquerdo());
        if (element.getFilhoEsquerdo() != null)
        {
            element.getFilhoEsquerdo().setPai(no);
        }
        
        element.setPai(no.getPai());
        if (!hasParent(no))
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
        //System.err.println(no.getElement());
        No element = no.getFilhoEsquerdo();
        no.setFilhoEsquerdo(element.getFilhoDireito());
        if (element.getFilhoDireito() != null)
        {
            element.getFilhoDireito().setPai(no);
        }
        
        element.setPai(no.getPai());
        if (!hasParent(no))
        {
            root = element;
        }
        else if (no == no.getPai().getFilhoDireito())
        {
            no.getPai().setFilhoDireito(element);
        }
        else
        {
            no.getPai().setFilhoEsquerdo(element);
        }
        
        element.setFilhoDireito(no);
        no.setPai(element);
    }
    
    @Override
    public void rotacaoDuplaEsquerda(No no)
    {
        //System.err.print("D = "+rightChild(no).getElement());
        rotacaoSimplesDireita(rightChild(no));
        //System.err.print("E = "+parent(no).getPai().getElement());
        rotacaoSimplesEsquerda(parent(no).getPai());
    }

    @Override
    public void rotacaoDuplaDireita(No no)
    {
        //System.err.print("E = "+leftChild(no).getElement());
        rotacaoSimplesEsquerda(leftChild(no));
        //System.err.print("D = "+no.getElement());
        rotacaoSimplesDireita(no);
    }
       
    @Override
    public void atualizarFB(No no, boolean operacao)
    {
        // Atualiza o fator de balanceamento
        no.setFB(calcFB(no));
        System.out.println("No [ " + no.getElement() + " ] => FB = " + no.getFB());
        
        if(operacao)
        {
            // Critério de parada
            if(hasParent(no))
            {
                parent(no).setFB(calcFB(parent(no)));
                if(parent(no).getFB() == 0)
                    return;
            }

            if(no.getFB() == 2)
            {
                if(leftChild(no).getFB() == -1)
                {
                    System.out.println("Tipo de rotação: RDD [ " + leftChild(no).getElement() + " ]");
                    rotacaoDuplaDireita(no);
                    printTree();
                }
                else
                {
                    System.out.println("Tipo de rotação: RDS [ " + no.getElement() + " ]");
                    rotacaoSimplesDireita(no);
                    printTree();
                }
            }
            else if(no.getFB() == -2)
            {
                if(rightChild(no).getFB() == 1)
                {
                    System.out.println("Tipo de rotação: RDE [ " + rightChild(no).getElement() + " ]");
                    rotacaoDuplaEsquerda(no);
                    printTree();
                }
                else
                {
                    System.out.println("Tipo de rotação: RES [ " + no.getElement() + " ]");
                    rotacaoSimplesEsquerda(no);
                    printTree();
                }
            }

            if(hasParent(no))
            {
                //System.err.println(no.getElement());
                atualizarFB(parent(no), operacao);
            }
            else
            {
                //System.err.println("- "+no.getElement());
                return;
            }
        }
        else
        {
            if(no.getFB() == 2)
            {
                if(leftChild(no).getFB() == -1)
                {
                    System.out.println("Tipo de rotação: RDD [ " + leftChild(no).getElement() + " ]");
                    rotacaoDuplaDireita(no);
                    printTree();
                }
                else
                {
                    System.out.println("Tipo de rotação: RDS [ " + no.getElement() + " ]");
                    rotacaoSimplesDireita(no);
                    printTree();
                }
            }
            else if(no.getFB() == -2)
            {
                if(rightChild(no).getFB() == 1)
                {
                    System.out.println("Tipo de rotação: RDE [ " + rightChild(no).getElement() + " ]");
                    rotacaoDuplaEsquerda(no);
                    printTree();
                }
                else
                {
                    System.out.println("Tipo de rotação: RES [ " + no.getElement() + " ]");
                    rotacaoSimplesEsquerda(no);
                    printTree();
                }
            }

            if(hasParent(no))
            {
                //System.err.println(no.getElement());
                atualizarFB(parent(no), operacao);
            }
            else
            {
                //System.err.println("- "+no.getElement());
                return;
            }
        }
    }

    private int calcFB(No no)
    {
        return height(no.getFilhoEsquerdo()) - height(no.getFilhoDireito());        
    }
    
    @Override
    public void insert(No no)
    {
        super.insert(root, no);
        printTree();
        atualizarFB(no, true);
    }

    @Override
    public No search(No no)
    {
        return super.search(root, no);
    }

    @Override
    public No remove(No element)
    {
        No no = super.remove(element);
        printTree();
        //System.err.println("PAI = "+parent(no).getElement() + "\tFB = "+ calcFB(no.getPai()));
        atualizarFB(parent(no), false);
        return no;
    } 

    @Override
    public boolean hasParent(No no)
    {
        return parent(no) != null;
    }   
}