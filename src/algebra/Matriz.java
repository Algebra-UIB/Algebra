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
public class Matriz {
    
    private int col, row, opcion, aux;
    public double[][] coeficientes, ampliada;
    public double[] independientes;
    private final Teclado t = new Teclado();
    
    public void opciones(){
        
        System.out.println("******************************************************************");        
        System.out.println("*Como le gustaria introducir el SEL?                             *");
        System.out.println("******************************************************************");  
        System.out.println("*                                                                *");
        System.out.println("*1) Matriz ampliada.                                             *");
        System.out.println("*2) Matriz de coeficientes y Vector de terminos independientes.  *");
        System.out.println("*                                                                *");
        System.out.println("******************************************************************");
        opcion = t.leerInt();
        while(opcion != 1 && opcion != 2){
            
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2.");
            opcion = t.leerInt();
        }
        System.out.println("Ha elegido la opcion: " + opcion);
        System.out.println("Desea continuar?");
        System.out.println("1) Si.");
        System.out.println("2) No.");
        aux = t.leerInt();
        while(aux != 1 && aux != 2){
            
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2.");
            aux = t.leerInt();
        }
        if(aux == 2){
            
            opciones();
        } else if(aux == 1){
            
            if(opcion == 1){
                
                matrizAmpliada();
            } else if(opcion == 2){
                
                matrizVector();
            }
        } 
    }
    
    private void matrizAmpliada(){
       
        System.out.println("Introduzca el numero de columnas de la matriz ampliada:");
        col = t.leerInt();
        while(col < 2){
            System.out.println("Por favor, introduzca al menos 2 columnas.");
            col = t.leerInt();
        }
        System.out.println("Introduzca el numero de filas de la matriz ampliada:");
        row = t.leerInt();
        while(row < 2){
            System.out.println("Por favor, introduzca al menos 2 filas.");
            row = t.leerInt();
        }
        ampliada = new double[row][col];
        coeficientes = new double[row][col-1];
        independientes = new double[row]; 
        int a = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
                System.out.println("Introduzca el valor de la posicion [" + (i+1) +"][" + (j+1) + "]:");
                ampliada[i][j] = t.leerDouble();
                if(j == col-1 && a < row){
                    
                    independientes[a] = ampliada[i][j];
                    a++;
                } else {
                    
                    coeficientes[i][j] = ampliada[i][j];
                }
                
            }            
        }
        System.out.println("Es correcta la matriz?");
        for (int i = 0; i < row; i++) {
            System.out.print("(");
            for (int j = 0; j < col; j++) {
                
                if((j<(col-1))&&(j>0)){
                    System.out.print(", ");
                }
                if(j==(col-1)){
                    System.out.print("| ");
                }
                System.out.print(ampliada[i][j]);
            }
            System.out.print(")\n");
            
        }
        System.out.println("1) Si.");
        System.out.println("2) No.");
        opcion = t.leerInt();
        while(opcion != 1 && opcion != 2){
            
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2.");
            opcion = t.leerInt();
        }
        if(opcion == 2){
            
            System.out.println("");
            matrizAmpliada();
        }
        
    }
    
    private void matrizVector(){
     
        System.out.println("Introduzca el numero de columnas de la matriz de coeficientes:");
        col = t.leerInt();
        while(col<2){
            System.out.println("Por favor, introduzca al menos 2 columnas.");
            col = t.leerInt();
        }
        System.out.println("Introduzca el numero de filas de la matriz de coeficientes:");
        row = t.leerInt();
        while(row<2){
            System.out.println("Por favor, introduzca al menos 2 filas.");
            row = t.leerInt();
        }
        ampliada = new double[row][col+1];
        coeficientes = new double[row][col];
        independientes = new double[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {  
                
                System.out.println("Introduzca el valor de la posicion [" + (i+1) +"][" + (j+1) + "] en la matriz de coeficientes:");
                coeficientes[i][j] = t.leerDouble();
            }
        }
        System.out.println("");
        for (int i = 0; i < row; i++) {
            
            System.out.println("Introduzca el valor de la posicion [" + (i+1) +"] en el vector de terminos independientes:"); 
            independientes[i] = t.leerDouble(); 
        }
        System.out.println("");
        System.out.println("Son correctos los siguientes datos?");
        System.out.println("Matriz de coeficientes:");
        for (int i = 0; i < row; i++) {
            System.out.print("(");
            for (int j = 0; j < col; j++) {
                System.out.print(coeficientes[i][j]);
                if(j<(col-1)){
                    System.out.print(", ");
                }
            }
            System.out.print(")\n");
            
        }
        System.out.println("");
        System.out.println("Vector de terminos independientes:");
        System.out.print("(");
        for (int i = 0; i < row; i++) {
            System.out.print(independientes[i]);
            if(i<(row-1)){
                System.out.print(", ");
            }                       
        }
        System.out.println(")\n");
        System.out.println("1) Si.");
        System.out.println("2) No.");
        opcion = t.leerInt();
        while(opcion != 1 && opcion != 2){
            
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2.");
            opcion = t.leerInt();
        }
        if(opcion == 2){
            
            System.out.println("");
            matrizVector();
        }
    }
}
