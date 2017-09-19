// Agradeço a DEUS pelo dom do conhecimento

package aula10.arvore_binaria_pesquisa;

/**
 *
 * @author papejajr
 */
public class TestMatriz
{
    private static boolean[][] matrizSearch(int level)
    {
        int rows = (int) Math.pow(2,level);
        boolean[][] matriz = new boolean[rows][level];
        int j = 0;
        for (int i = 0; i < rows; i++) {
            for (int z = level - 1; z >= 0; z--) {
               matriz[i][j] = (i / (int) Math.pow(2, z)) % 2 != 0;
               j++;
            }
            j = 0;
        }
        return matriz;
    }
    
    private static void printTruthTable(int n) {
        int rows = (int) Math.pow(2,n);
        System.out.println("N " +n);
        System.out.println("ROWS " + rows);
        for (int i=0; i<rows; i++) {
            for (int j=n-1; j>=0; j--) {
                System.out.print((i/(int) Math.pow(2, j))%2 + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        printTruthTable(3); //enter any natural int
        
        System.out.println("\n\n");
        int level = 3;
        int linha = 8;
        int coluna = level;
        boolean matriz[][] = matrizSearch(level);
        
        for (int i = 0; i < linha; i++)
        {
            System.out.print("[ ");
            for (int j = 0; j < coluna; j++)
            {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("]");
        }
        
    }
}
