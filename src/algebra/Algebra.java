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
public class Algebra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Matriz matriz = new Matriz();
        matriz.opciones();
        Menu menu = new Menu();
        menu.inicio(matriz.coeficientes, matriz.independientes);
    }
    
}
