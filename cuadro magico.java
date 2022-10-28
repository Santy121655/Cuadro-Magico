import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fatt
 */
public class CuadroMagico {
    
    public static int [][] leerMatriz (int r, int c) throws IOException{
        int [][] matriz = new int[r][c];
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        
        for(int i = 0; i < matriz.length; i++){ //renglones
            for(int j = 0; j < matriz[0].length; j++){ //columnas en el renglón 0
                System.out.println("Escribe el elemento[" + i + "]["+ j + "]:");
                entrada = bufer.readLine();
                matriz[i][j] = Integer.parseInt(entrada);
            }
        }
        return matriz;
    }
    

//empieza la parte de las sumas 
    public static int sumarRenglones(int[][]a,int i){
        int s=0;
    for (int j = 0; j < a[0].length; j++) {
   s += a[i][j];
}
     System.out.println("La suma del renglo es: " + s);
    return s;
    
    }
    
    public static int sumarColumnas(int[][]a, int j){
    int s=0;
    for (int i = 0; i < a.length; i++) {
        s += a[i][j];
    }
        System.out.println("La suma de la columna es: " + s);
    return s;
    }
    
    
    public static int sumarDiagonal1(int[][]a){
   int diagonal = 0;
    	for(int i=0;i<a.length;i++) {
    		for(int j=0;j<a[0].length;j++) {
    			if(i==j) {
    				diagonal += a[i][j];
    			}
    		}
    	}
    	System.out.println("La suma de la diagonal 1 es: " + diagonal);
    	return diagonal;
    }
   public static int sumarDiagonal2(int[][]a){
  int diagonal2 = 0;
    	for(int i=0;i<a.length;i++) {
    		for(int j=0;j<a[0].length;j++) {
    			if(i+j == (a.length - 1)) {
    				diagonal2 += a[i][j];
    			}
    		}
    	}
    	System.out.println("La suma de la diagonal 2 es: " + diagonal2);
    	return diagonal2;
    }
   //comparamos con el pivote
   public static int pivote;
   
   public static void comparar(int[][] a){
       int s;
       
       for(int i =0; i<a.length; i++){
           s = sumarRenglones(a,i);
           if(i == 0)
               pivote = s;
           else
               if(pivote != s){
                   System.out.println("No es un cuadro magico");
          System.exit(1);
               }
       } 
           for(int j =0; j<a[0].length; j++){
           s = sumarColumnas(a,j);
           if(pivote != s){
               System.out.println("No es un cuadro magico");
               System.exit(1);
           }
                   
           }
           s = sumarDiagonal1(a);
           if(pivote != s){
               System.out.println("No es un cuadro magico");
               System.exit(1);
           }
           
           s = sumarDiagonal2(a);
           if(pivote != s){
                   System.out.println("No es un cuadro magico");
                   System.exit(1);
           }
           System.out.println("Si es un cuadro magico");
   }
   
 public static void imprimirMatriz(int[][] a){
    	
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.printf(" %4d ",a[i][j]);
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) throws IOException {
    int b = 0;
        int r, c, SumR, SumC, SumD, SumD2, cmp;
        int[][] matriz;
         
        
        BufferedReader bufer= new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        
        System.out.println("Programa que dice si es un cuadro magico o no :3");
        System.out.println("Escribe el numero de renglones de la matriz: ");
        entrada = bufer.readLine(); 
        r = Integer.parseInt(entrada);
        System.out.println("Escribe el numero de las columnas de la matriz: ");
        entrada = bufer.readLine();
        
        c = Integer.parseInt(entrada);
        
        if(r != c){
        	
            System.out.println("No se puede calcular la suma de matrices.");
            System.out.println("Porque el valor de renglones no es igual al de columnas.");
            System.exit(1);
        }
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Lectura de datos de la matriz: "); 
        matriz = leerMatriz(r, c);     
               
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Los resultados son: ");
        System.out.println("Matriz: ");
        imprimirMatriz(matriz);
        

        comparar(matriz);
    }
    
}