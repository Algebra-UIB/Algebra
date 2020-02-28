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
public class Algoritmos {
    
    private static final double EPSILON = 1e-10;
    private final Teclado keyboard = new Teclado();
    int aux;
    // Gaussian elimination with partial pivoting
    public void gaussPivotajeParcial(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("La matriz es singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
            System.out.print("El conjunto de soluciones es: (");
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]);
                if(i<(x.length-1)){
                    System.out.print(", ");
                }
                
            }
        System.out.print(")\n");
        System.out.println("Quiere ver la matriz en forma escalonada?");
        System.out.println("1) Si.");
        System.out.println("2) No.");
        aux = keyboard.leerInt();
        while(aux!=1 && aux!=2){
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2:");
            aux = keyboard.leerInt();
        }
        System.out.println("");
        if(aux == 1){               
            for (int i = 0; i < A.length; i++) {
                System.out.print("(");
                for (int j = 0; j < A[0].length+1; j++) {
                    if(j<(A[0].length)){
                        System.out.print(A[i][j]);
                    }
                    if(j<(A[0].length)){
                        System.out.print(", ");
                    }
                    if(j == (A[0].length)){
                        System.out.print("| ");
                        System.out.print(b[i]);
                    }
                }
                System.out.print(")\n");
            }
        }
    }

    public void gauss(double[][] A, double[] b){
        int n = b.length;

        for (int p = 0; p < n; p++) {
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        System.out.print("El conjunto de soluciones es: (");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            if(i<(x.length-1)){
                System.out.print(", ");
            }               
        }
        System.out.print(")\n");
        System.out.println("Quiere ver la matriz en forma escalonada?");
        System.out.println("1) Si.");
        System.out.println("2) No.");
        aux = keyboard.leerInt();
        while(aux!=1 && aux!=2){
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2:");
            aux = keyboard.leerInt();
        }
        System.out.println("");
        if(aux == 1){               
            for (int i = 0; i < A.length; i++) {
                System.out.print("(");
                for (int j = 0; j < A[0].length+1; j++) {
                    if(j<(A[0].length)){
                        System.out.print(A[i][j]);
                    }
                    if(j<(A[0].length)){
                        System.out.print(", ");
                    }
                    if(j == (A[0].length)){
                        System.out.print("| ");
                        System.out.print(b[i]);
                    }
                }
                System.out.print(")\n");
            }
        }                    
    }
    
    public void gaussPivotajeCompleto(double[][] A, double[] b){
        
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("La matriz es singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
            System.out.print("El conjunto de soluciones es: (");
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]);
                if(i<(x.length-1)){
                    System.out.print(", ");
                }
                
            }
        System.out.print(")\n");
        System.out.println("Quiere ver la matriz en forma escalonada?");
        System.out.println("1) Si.");
        System.out.println("2) No.");
        aux = keyboard.leerInt();
        while(aux!=1 && aux!=2){
            System.out.println("Opcion incorrecta, por favor introduzca 1 o 2:");
            aux = keyboard.leerInt();
        }
        System.out.println("");
        if(aux == 1){               
            for (int i = 0; i < A.length; i++) {
                System.out.print("(");
                for (int j = 0; j < A[0].length+1; j++) {
                    if(j<(A[0].length)){
                        System.out.print(A[i][j]);
                    }
                    if(j<(A[0].length)){
                        System.out.print(", ");
                    }
                    if(j == (A[0].length)){
                        System.out.print("| ");
                        System.out.print(b[i]);
                    }
                }
                System.out.print(")\n");
            }
        }        
    }
}


