package Lab_13_Grafos;

public class Ejecicio_N_997 {

        public int findJudge(int n, int[][] trust) {

            int v[] =new int[n+1];
            //Con una lista ya creada con tamaño n+1 se itera sobre ella para disminuir el primer digito en 1 y disminuir el segund tambn en 1
            for(int[] i:trust) {
                v[i[1]]++;
                v[i[0]]--;
            }
            //luego se hace un recorrido del arreglo v donde si algun valor dentro de tal aregloo es igual a n-1 se retorna tal valor sino retorna -1
            for(int i=1;i<=n;i++) {
                if(v[i]==n-1)
                    return i;
            }
            return -1;
        }
    }
