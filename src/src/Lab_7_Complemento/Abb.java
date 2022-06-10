package Lab_7_Complemento;

import java.util.LinkedList;

public class Abb {

    class NodoAbb {
        int elemento;
        NodoAbb lchild;
        NodoAbb rchild;

        NodoAbb(int elemento, NodoAbb lchild, NodoAbb rchild) {
            this.elemento = elemento;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        void Print() {
            System.out.println(elemento);
        }
    }

    private NodoAbb laRaiz;

    public Abb() {
        laRaiz = null;
    }

    /* Verifica si existen dos enteros a, b en el ABB tal que a+b =0.
     */
    LinkedList<Integer> datos=new LinkedList<>();
    // si la lista ya posee un dato la funcion borra el dato ingresado para que no se sobre escriba
    public boolean Complemento() {
        if(datos.size()!=0) {
            datos.clear();
        }

        return comple(laRaiz);
    }

    private boolean comple(NodoAbb n) {
        pasarDatos(n);
        for (int i = 0; i < datos.size(); i++) {
            if(datos.contains(-datos.get(i))){
                return true;
            }
        }
        return false;
    }
    private void pasarDatos(NodoAbb nodo){
        if (nodo != null) {
            datos.add(nodo.elemento);
        }
        if(nodo.lchild!=null){
            pasarDatos(nodo.lchild);
        }
        if(nodo.rchild!=null) {
            pasarDatos(nodo.rchild);
        }
    }

    private boolean buscar(NodoAbb n, int nro){
        if(n==null) return false;
        if(n.elemento==nro) return true;
        if(n.elemento<nro) return buscar(n.lchild,nro);
        return buscar(n.rchild,nro);
    }


    //--- Supone que no existe un nodo con valor = elemento----//
    public void Insertar(int elemento) {
        laRaiz = InsertaenAbb(laRaiz, elemento);
    }

    private NodoAbb InsertaenAbb(NodoAbb nodo, int elemento) {
        if (nodo == null)
            return new NodoAbb(elemento, null, null);
        else if (elemento < nodo.elemento)
            nodo.lchild = InsertaenAbb(nodo.lchild, elemento);
        else
            nodo.rchild = InsertaenAbb(nodo.rchild, elemento);
        return nodo;
    }

    // -- Supone que el elemento esta en el arbol----//
    public void Eliminar(int elemento) {
        laRaiz = EliminaenAbb(laRaiz, elemento);
    }

    private NodoAbb EliminaenAbb(NodoAbb nodo, int elemento) {
        if (nodo.elemento == elemento) {
            if (nodo.lchild == null && nodo.rchild == null)
                return null;
            else if (nodo.lchild == null)
                return nodo.rchild;
            else if (nodo.rchild == null)
                return nodo.lchild;
            else {
                nodo.elemento = MayorElemento(nodo.lchild);
                nodo.lchild = EliminaenAbb(nodo.lchild, nodo.elemento);
            }
        } else if (nodo.elemento > elemento)
            nodo.lchild = EliminaenAbb(nodo.lchild, elemento);
        else
            nodo.rchild = EliminaenAbb(nodo.rchild, elemento);
        return nodo;
    }

    private int MayorElemento(NodoAbb nodo) {
        if (nodo.rchild == null)
            return nodo.elemento;
        else
            return MayorElemento(nodo.rchild);
    }

    public void Imprimir() {
        ImprimeAbb(laRaiz, " ");
    }

    private void ImprimeAbb(NodoAbb n, String tab) {
        if (n != null) {
            System.out.println(tab + n.elemento);
            ImprimeAbb(n.lchild, tab + "  ");
            ImprimeAbb(n.rchild, tab + "  ");
        }
    }
}
