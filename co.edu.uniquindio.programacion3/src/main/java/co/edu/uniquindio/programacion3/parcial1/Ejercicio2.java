package co.edu.uniquindio.programacion3.parcial1;

import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args) {
        String[][] arreglo = {
                {"454", "1010", "4141", "4444", "243"},
                {"100", "2163", "5456", "222", "444"},
                {"1001", "0", "99", "111", "5654"},
                {"13", "89", "6", "112", "555"},
        };
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
        System.out.println("Arreglo:");

        recorrerMatriz(arreglo,arreglo.length-1,0,listaNumeros);
       imprimirArray(listaNumeros,0);
    }

    public static void recorrerMatriz(String[][] matriz, int i, int j, ArrayList<Integer> listaNumeros){

        if(i<0&&j<matriz[0].length){
            return;
        }

//
        if(j<matriz[i].length){
            //System.out.print(matriz[i][j]+"  ");
            if(verificarSumaDigitos(Integer.parseInt(matriz[i][j]))>10){
            listaNumeros.add(verificarSumaDigitos(Integer.parseInt(matriz[i][j])));
            }
            recorrerMatriz(matriz,i,j+1,listaNumeros);

        }else if(i<=matriz.length-1){
            //System.out.println();
            recorrerMatriz(matriz,i-1,0,listaNumeros);

        }
    }

    public static int verificarSumaDigitos(int n){

        if(n<10){
            return  n;
        }else {
            return  n%10+ verificarSumaDigitos(n/10);
        }

    }
    public static void imprimirArray(ArrayList<Integer> arr, int indice){
            if(indice==arr.size()-1){
                System.out.println(arr.get(indice));
            }else{
                System.out.println(arr.get(indice));
                imprimirArray(arr,indice+1);

            }

    }

}
