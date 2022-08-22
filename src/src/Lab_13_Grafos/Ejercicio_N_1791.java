package Lab_13_Grafos;

public class Ejercicio_N_1791 {

    //1791: Encontrar el centro de la estrella de grafo
    /*
    El método revisará uno de los lados de las primeras dos filas de la matriz en busca de revisar
    si estos poseen un valor en comun entre sus columnas, si esto ocurre, entonces retornara
    el valor comun, si no, retornara -1.
     */

    class Solution {
        public int findCenter(int[][] edges) {
            return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
        }
    }
}
