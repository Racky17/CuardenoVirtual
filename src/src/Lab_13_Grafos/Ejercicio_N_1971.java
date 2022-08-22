package Lab_13_Grafos;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio_N_1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<List<Integer>> e = new ArrayList<>(); // Para almacenar todas las aristas
        boolean[] visited = new boolean[n]; // Para llevar la cuenta de los nodos visitados

        // Inicializar la lista de la lista
        for(int i=0; i<n; i++){
            e.add(new ArrayList<>());
        }

        // Almacenado todas las aristas
        for(int[] edge: edges){
            e.get(edge[0]).add(edge[1]);
            e.get(edge[1]).add(edge[0]);
        }

        return dfs(n, e, source, destination, visited);
    }

    public boolean dfs(int n, List<List<Integer>> e, int src, int dst, boolean[] visited){
        if(src == dst) return true;    // si el origen es el destino, llegamos
        if(visited[src]) return false; // podría ser un ciclo

        visited[src] = true; // marcar el nodo como visitado

        List<Integer> list = new ArrayList<>();
        list = e.get(src); // obtener todas las aristas del nodo actual

        // Iterar todas las aristas desde el nodo actual
        for(int i: list){
            if(dfs(n, e, i, dst, visited)) return true;
        }

        return false;
    }
}