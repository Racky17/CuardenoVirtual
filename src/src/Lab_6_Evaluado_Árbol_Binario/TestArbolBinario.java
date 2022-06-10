package Lab_6_Evaluado_Árbol_Binario;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

//CREADORES Y  DESARROLLADORES:
//Rodrigo Jara Y Leonardo Labrador


public class TestArbolBinario {

    public static void main(String[] args) {
        // write your code here

        Scanner tcld = new Scanner(System.in);
        Stack<ArbolBinario> nodos = new Stack<>();
        for (int i = 0; i < 10; i++) {
            nodos.add(new ArbolBinario(i));
        }
        // voy emparejando de a dos nodos para construir el árbol
        while (nodos.size() > 1) {
            ArbolBinario iz = nodos.pop();
            ArbolBinario der = nodos.pop();
            nodos.push(new ArbolBinario(iz.dato + der.dato, iz, der));
        }
        ArbolBinario raiz = nodos.pop();
        System.out.println("Altura del arbol: " + raiz.altura());
        System.out.println("Tamaño del arbol (total de nodos): " + raiz.size());
        raiz.tree();

        ArbolBinario[] nodos2 = new ArbolBinario[32];
        for (int i = 0; i < nodos2.length; i++) {
            nodos2[i] = new ArbolBinario(i);
        }
        ArbolBinario raiz2 = generaBinario(nodos2, 0, 31);
        System.out.println("Altura del arbol: " + raiz2.altura());
        System.out.println("Tamaño del arbol (total de nodos): " + raiz2.size());
        raiz2.tree();
        System.out.println("Ingrese el minimo del rango de la raiz 1");
        int minimo = tcld.nextInt();
        System.out.println("Ingrese el maximo del rango de la raiz 1");
        int maximo = tcld.nextInt();
        LinkedList<ArbolBinario> nodosDentroRango1 = new LinkedList<>();

        nodosDentroRango1 = raiz.rango(minimo, maximo);
        if (nodosDentroRango1.size() != 0){

            for (ArbolBinario nodo : nodosDentroRango1) {
                System.out.print("[");
                System.out.print(nodo.dato);
                System.out.print("] ");
            }
            System.out.println("");
        }else {
            System.out.println("dentro de la raiz 1 no existe nodos dentro de los rangos señalados...");
        }

        System.out.println("Ingrese el minimo del rango de la raiz 2");
        int minimo2 = tcld.nextInt();
        System.out.println("Ingrese el maximo del rango de la raiz 2");
        int maximo2 = tcld.nextInt();
        LinkedList<ArbolBinario> nodosDentroRango2 = new LinkedList<>();

        nodosDentroRango2 = raiz2.rango(minimo2, maximo2);
        if (nodosDentroRango2.size() != 0){
            for (ArbolBinario nodo : nodosDentroRango2) {
                System.out.print("[");
                System.out.print(nodo.dato);
                System.out.print("] ");
            }
            System.out.println("");
        }else {
            System.out.println("dentro de la raiz 2 no existe nodos dentro de los rangos señalados...");
        }
    }

    public static ArbolBinario generaBinario(ArbolBinario[] nodos, int i, int j) {
        if (i > j) {
            // caso base
            return null;
        }
        int mitad = (i + j) / 2;
        nodos[mitad].iz = generaBinario(nodos, i, mitad - 1);
        nodos[mitad].der = generaBinario(nodos, mitad + 1, j);
        return nodos[mitad];
    }
}
//CREADORES Y  DESARROLLADORES:
//Rodrigo Jara Y Leonardo Labrador