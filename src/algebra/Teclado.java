/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebra;

import java.util.Scanner;
/**
 *
 * @author elsho
 */
public class Teclado {
    
    private final Scanner keyboard = new Scanner(System.in);
    
    public int leerInt(){
        while(!keyboard.hasNextInt()){
        
            keyboard.next();
            System.out.println("Opcion incorrecta, por favor introduzca un entero.");
        }
        return keyboard.nextInt(); 
    }
    
    public double leerDouble(){
        while(!keyboard.hasNextDouble()){
        
            keyboard.next();
            System.out.println("Opcion incorrecta, por favor introduzca un real.");
        }
        return keyboard.nextDouble();       
    }
}
