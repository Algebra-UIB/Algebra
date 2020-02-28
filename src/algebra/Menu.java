/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebra;

/**
 *
 * @author elsho
 */
public class Menu {
    
    private int opcion, aux;
    private final Teclado t = new Teclado();
    private final Algoritmos a = new Algoritmos();
    
    
    public void inicio(double[][] A, double[] b){
        
        System.out.println("******************************************************************");        
        System.out.println("*Como le gustaria resolver el SEL?                             *");
        System.out.println("******************************************************************");  
        System.out.println("*                                                                *");
        System.out.println("*1) Gauss.                                                       *");
        System.out.println("*2) Gauss con pivotaje parcial.                                  *");
        System.out.println("*                                                                *");
        System.out.println("******************************************************************");   
        opcion = t.leerInt();
        while(opcion != 1 && opcion != 2){
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2:");
            opcion = t.leerInt();
        }
        System.out.println("");
        System.out.println("Ha elegido la opcion " + opcion + ", desea continuar?");
        System.out.println("1) Si.");
        System.out.println("2) No.");
        aux = t.leerInt();
        while(aux!=1 && aux!=2){
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2:");
            aux = t.leerInt();
        }
        System.out.println("");
        if(aux == 1){    
              
            switch(opcion){
                case 1: 
                    System.out.println("Vamos a resolver el SEL mediante Gauss:\n");
                    a.gauss(A, b);
                    break;
                case 2:
                    System.out.println("Vamos a resolver el SEL mediante Gauss con pivotaje parcial:\n");
                    a.gaussPivotajeParcial(A, b);
            }
        } else if(aux == 2){
            inicio(A, b);
        }
    }
    
}
