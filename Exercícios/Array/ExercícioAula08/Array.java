


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
import javax.swing.*;

public class Array {

    static JTextArea saidaArea = new JTextArea();
    static int  counter;
    

    static int[] vet= new int[10];

    static String saida = "Itens do array na ordem original\n";

    // acrescenta valores originais do array ao String saida
    public static void main(String[] args) {
        levet();
        for (counter = 0; counter < vet.length; counter++) saida += "   " + vet[counter];

            inverte();  // inverte o array
            saida += "\n\nItens do array em ordem inversa\n";
            // acrescenta valores ordenados do array ao String saida
            for (counter = 0; counter < vet.length; counter++) {
                saida += "   " + vet[counter];
            }
            bubbleSort(vet);
            saida += "\n\nItens do array ordenados\n";
            // acrescenta valores ordenados do array ao String saida
            for (counter = 0; counter < vet.length; counter++) {
                saida += "   " + vet[counter];
            }
            
            saida += "\n\n";
            

            saidaArea.setText(saida);
            levalor();

            JOptionPane.showMessageDialog(null, saidaArea, "Programa de ordenação dos elementos de um array", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        

    }

    public static void levet() {
        String numStr;
        for (int i = 0; i < vet.length; i++) {
            numStr = JOptionPane.showInputDialog("Digite o um No Inteiro");
            vet[i] = Integer.parseInt(numStr);
        }
    }

    public static void inverte() {
        int temp, tam = vet.length;

        for (int i = 0; i < tam/2; i++) {
            temp = vet[i];
            vet[i] = vet[(tam - 1) - i];
            vet[(tam - 1) - i] = temp;
        }
    }

    public static void bubbleSort(int array2[]) {
        // laço para controlar o número de passagens
        for (int passagem = 1; passagem < array2.length; passagem++) {
            // laço para controlar o número de comparações
            for (int elemento = 0; elemento < array2.length - 1;
                    elemento++) {
                // compara elementos adjacentes e os troca de lugar se
                // o primeiro elemento for maior que o segundo elemento
                if (array2[elemento] > array2[elemento + 1]) {
                    troca(array2, elemento, elemento + 1);
                }
            }  // fim do laço para controlar comparações
        }  // fim do laço para controlar passagens
    }  // fim do método bubleSort

    public static void troca(int array3[], int prim, int sec) {
        int elemento;  // área de armazenamento temporário para troca
        elemento = array3[prim];
        array3[prim] = array3[sec];
        array3[sec] = elemento;
    }

    public static void levalor() {
        String numStr = JOptionPane.showInputDialog("Digite o número a encontrar");
        int valor = Integer.parseInt(numStr);

        if (busca_binaria(vet, valor, 0, vet.length - 1) == true) {
            JOptionPane.showMessageDialog(null, saidaArea, "O Valor está no vetor", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, saidaArea, "O Valor não está no vetor", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }

    public static boolean busca_binaria(int vetor[], int valor, int baixo, int alto) {
        int meio;
        if (baixo > alto) {
            return false;
        }

        meio = (alto + baixo) / 2;

        if (valor == vetor[meio]) {
            return true;
        }
        if (valor < vetor[meio]) {
            return busca_binaria(vetor, valor, baixo, meio - 1);
        } else {
            return busca_binaria(vetor, valor, meio + 1, alto);
        }

//return false;
    }

}
