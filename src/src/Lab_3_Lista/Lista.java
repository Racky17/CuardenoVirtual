package Lab_3_Lista;
class Lista {
    private Nodo laCabeza;
    Lista() {
        laCabeza = null;
    }
    //---Inserta un objeto(int) al comienzo de la lista
    public void InsertaInicio(int o) {
        if (EstaVacia()) laCabeza=new Nodo(o, null);
        else  laCabeza = new Nodo(o, laCabeza);
    }

    //---- Inserta al final ----
    public int Promedio(){
        Nodo n = laCabeza;
        int cant= 0;
        int tam= 0;

        while (n != null){
            cant += n.elObjeto;
            tam++;
            n=n.next;

        }return cant/tam;
    }

    public Lista getMayores(int Promedio){
        Lista l = new Lista();
        Nodo n = laCabeza;
        int Prom = Promedio;
        while (n != null){
            if (n.elObjeto > Prom ){
                l.InsertaFinal(n.elObjeto);
            }n=n.next;
        }return l;
    }

    public boolean InsertarOrdenado(Nodo n){
        Nodo m=laCabeza;
        if (n.elObjeto > m.elObjeto) {
            m.next = n.next;
            n.next = m;
            return true;
        }else{
            n=n.next;
            return false;
        }
    }

    public void InsertaFinal(int o) {
        if (EstaVacia()) laCabeza=new Nodo(o, null);
        else{
            Nodo t;
            for(t = laCabeza; t.next != null; t= t.next) ;;
            t.next = new Nodo(o,null);
        }
    }

    // ---cuenta la cantidad de nodos de la lista (Size)
    public int Size() {
        int tnodos=0;
        for(Nodo t = laCabeza; t !=null; t= t.next)  tnodos++;
        return tnodos;
    }

    //eliminar un nodo de la lista
// Elimina el primer nodo n tal que o.elObjeto==o
    public void Eliminar(int o) {
        if(!EstaVacia()) {
            if(laCabeza.elObjeto==o) laCabeza = laCabeza.next;
            else {
                Nodo p = laCabeza;
                Nodo t = laCabeza.next;
                while (t !=null && t.elObjeto != o)  {
                    p = t ; t = t.next;
                }
                if(t.elObjeto==o) p.next = t.next;
            }
        }
    }

    // Verifica si la lista está vacias;
    public boolean EstaVacia() {
        return laCabeza == null;
    }

    //-----Imprime la lista-----
    void Print() {
        if(laCabeza!=null) Imprimir(laCabeza);
        else System.out.println("Lista Vacia");
    }

    void Imprimir(Nodo m ) {
        if(m !=null) {m.Print(); Imprimir(m.next);}
    }

    //-----Clase Nodo---------
    private class Nodo {
        public int elObjeto;
        public Nodo next;
        public Nodo(int nuevoObjeto, Nodo next)
        {this.elObjeto=nuevoObjeto; this.next = next;}
        void Print(){ System.out.print("- " + elObjeto);}
    }

}