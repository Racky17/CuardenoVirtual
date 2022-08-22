package Lab_16_Hashing;

public class Hashing {

    class Nodo{
        int key;
        public Nodo(int k) {
            key = k;
        }
    }

    Nodo [] T;

    public Hashing(int m) {
        T = new Nodo[m];
        for(int i = 0; i < m; i++) T[i] = null;
    }

    // Implementar
    // return true si fue posible insertar
    // false en otro caso
    public boolean insertar(int key) {
        //se crea variable int i y j, al igual que un Nodo
        int i =0, j;
        Nodo x = new Nodo(key);
        /*En un ciclo establecerá j como el método h de la clave y el valor i y mientras
        el valor del arreglo T en la posición j sea null, este insertará en nodo x en dicha posición y el método
        retornará true.
        Sino aumentará el valor de i hasta que sea igual al tamaño de T.
         */
        while(i!=T.length){
            j= h(key,i);
            if(T[j]==null){
                T[j] = x;
                return true;
            }else{
                i++;
            }
        }
        //Si termina el ciclo while solamente retornará false.

        return false;
    }

    // Implementar
    // Si la clave no existe, return null
    public Nodo buscar(int key) {
        //Establece ints i y j.
        int i=0,j=0;
        /*
        Mientras el i no sea igual a la longitud de T, j sera igual al método h con key y el
        valor de i.
        Tras ello si el valor de T en j es null o la clave del nodo en dicha posición no coincide con key
        aumentará en valor de i, si es igual a key, se devolverá el nodo en la posicion de j de T.
         */
        while(i!=T.length){
            j=h(key,i);
            if(T[j]==null || T[j].key!=key){
                i++;
            }else if(T[j].key==key){
                return T[j];
            }
        }
        //En caso de que completen el ciclo sin encontrar el nodo, se retornará null.
        return null;
    }

    // Implementar
    // return true si fue posible eliminar
    // false en otro caso
    public boolean eliminar(int key) {
        //Se establece el int j, cuyo valor será el método h de key y un valor i.
        int j=0;
        /*Se hace un ciclo, donde se crea el nodo x como el nodo en la posición j de T y en caso de
        que key coincida con la clave del nodo x, este será asignado en el arreglo como null, para luego
        retornar true.
         */

        for(int i=0; i<T.length; i++){
            j=h(key,i);
            Nodo x = T[j];
            if(key == x.key){
                T[j]=null;
                return true;
            }
        }
        //En caso de que no encuentre el nodo por eliminar, retorna false.
        return false;
    }
    //Método para calcular el factor de carga de un hashing.
    public double chargeFactor(){
        //Asigna una variable para la cantidad de nodos usados por el hashing.
        int cant = 0;
        /*En ciclo aumenta la cantidad de cant, por cada espacio en el arreglo T
        que no este vacío
         */
        for(int i=0; i<T.length; i++){
            if(T[i]!=null){
                cant++;
            }
        }
        //Finalmente retorna el valor de cant dividido por el tamaño de T.
        return cant/T.length;
    }

    int h(int k, int i) {
        return (h1(k) + (i * h2(k))) % T.length;
    }

    int h1(int k) {
        return k % T.length;
    }

    int h2(int k) {
        return 1 + (k % (T.length-1));
    }

    /*
A) ¿Qué ocurre con las funciones de inserción, búsqueda y eliminación cuando el factor de carga es cercano a 1?
R.- "Para la función de inserción, el tiempo de retraso aumentará a medida que aumente el factor porque
El método tomaría más para encontrar un espacio vacío para el nodo. La función de investigación también aumentará, porque
El método llevará más tiempo si hay más espacios utilizados con números similares, pero la función de eliminación continuará siendo la misma,
Como independientemente del número de nodos utilizados, buscara por completo el hashing para eliminar la clave solicitada.

B) Describa los pasos a realizar para duplicar el tamaño de la tabla Hash y reducir el factor de carga. ¿Para qué
valor de 𝛼 es necesario realizar este proceso?
R.- "Los pasos a realizar serían que: Primero en el método de inserción se verificaría si el factor de carga es 1 después
de Agreguar el último nodo, si es cierto, dirijira el método de duplicación de la tabla hash, donde se creara un arreg
lo para copiar los datos del hashing y el arreglo T se recrearía en un tamaño doble, para finalmente agregar
Por el mismo método de inserción con cada llave almacenada en los nodos del arreglo de copia. Es por eso que el valor de
𝛼 Debería ser exactamente 1, porque implicaría  que el hash esta lleno y necesitaría más espacio para reducir
el valor."
 */

}