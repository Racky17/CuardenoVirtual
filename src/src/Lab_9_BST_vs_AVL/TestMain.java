package Lab_9_BST_vs_AVL;

import java.util.LinkedList;

public  class TestMain {

    public static void main(String[] args) {
        BSTree nodoBST=new BSTree();
        AvlTree nodoAvl=new AvlTree();

        int nroHelp;

        //Para guardar los numeros a utilizar en los casos
        LinkedList<Integer> nros=new LinkedList<>();
        while(nros.size()<10000){
            //Para que el nro no se repita, al resultado del anterior se le sumará otro random;
            nroHelp=(int)(Math.random()*10000+1);
            if(!nros.contains(nroHelp)){
                nros.add(nroHelp);
            }
        }

        //Lo mismo que en los numeros a utilizar, solo que estos serán los nros que no existen
        LinkedList<Integer> nrosInexistentes=new LinkedList<>();
        while(nrosInexistentes.size()<10000){
            //Para que el nro no se repita, al resultado del anterior se le sumará otro random;
            nroHelp=(int)(Math.random()*100000+1);
            if(!nros.contains(nroHelp)){
                nrosInexistentes.add(nroHelp);
            }
        }

        //INSERCION
        System.out.println("-------------------INSERCION-------------------");
        double startTime=System.nanoTime();
        for (int i=0;i<nros.size();i++){
            nodoBST.insert(nros.get(i));
        }
        double finalTime=System.nanoTime();
        System.out.println("Tiempo de insercion BST: "+(finalTime-startTime)+" nanosegundos");

        startTime=System.nanoTime();
        for (int i=0;i<nros.size();i++){
            nodoBST.insert(nros.get(i));
        }
        finalTime=System.nanoTime();
        System.out.println("Tiempo de insercion AVL: "+(finalTime-startTime)+" nanosegundos");

        //BUSQUEDA DE NROS QUE EXISTEN

        System.out.println("\n\n-------------------BUSQUEDA DE NUMEROS QUE EXISTEN-------------------");

        startTime=System.nanoTime();
        for (int i = 0; i < nros.size(); i++) {
            nodoBST.search(nros.get(i));
        }
        finalTime=System.nanoTime();
        System.out.println("Tiempo de busqueda BST: "+(finalTime-startTime)+" nanosegundos");

        startTime=System.nanoTime();
        for (int i = 0; i < nros.size(); i++) {
            nodoAvl.search(nros.get(i));
        }
        finalTime=System.nanoTime();
        System.out.println("Tiempo de busqueda AVL: "+(finalTime-startTime)+" nanosegundos");


        //BUSQUEDA DE NROS QUE NO EXISTEN

        System.out.println("\n\n-------------------BUSQUEDA DE NUMEROS QUE NO EXISTEN-------------------");

        startTime=System.nanoTime();
        for (int i = 0; i < nrosInexistentes.size(); i++) {
            nodoBST.search(nrosInexistentes.get(i));
        }
        finalTime=System.nanoTime();
        System.out.println("Tiempo de busqueda inexistente BST: "+(finalTime-startTime)+" nanosegundos");

        startTime=System.nanoTime();
        for (int i = 0; i < nros.size(); i++) {
            nodoAvl.search(nrosInexistentes.get(i));
        }
        finalTime=System.nanoTime();
        System.out.println("Tiempo de busqueda inexistente AVL: "+(finalTime-startTime)+" nanosegundos");
    }
}
