package co.edu.uniquindio.programacion3.recursividad.clase;

public class MainClase {

    public static void main(String[] args) {
        //imprimirFibonacci();
        int[] arreglo = {1,2,3,5,3,2,3};
        int valorBuscar = 3;
        int resultado = 0;
        int indice = 0;
        resultado = contarApariciones(arreglo, valorBuscar,indice);
        System.out.println("Numero de apariciones: "+resultado);
    }

    private static int contarApariciones(int[] arreglo, int valorBuscar, int indice) {
        if(indice == arreglo.length-1){
            if(arreglo[indice]== valorBuscar){
                return 1;
            }else{
                return 0;
            }
        }else{
            if(arreglo[indice] == valorBuscar){
                return contarApariciones( arreglo,valorBuscar,indice+1)+1;
            }else{
                return contarApariciones(arreglo, valorBuscar, indice+1);
            }
        }
    }

    private static int contarApariciones2(int[] arreglo, int valorBuscar, int indice) {
        if(indice == arreglo.length-1){
            return verificarValorBuscado(arreglo, valorBuscar, indice);
        }else{
            if(arreglo[indice] == valorBuscar){
                return contarApariciones( arreglo,valorBuscar,indice+1)+1;
            }else{
                return contarApariciones(arreglo, valorBuscar, indice+1);
            }
        }
    }


    private static int verificarValorBuscado(int[] arreglo, int valorBuscar, int indice) {
       return arreglo[indice]== valorBuscar ? 1 : 0;
    }

    private static int verificarValorBuscado2(int[] arreglo, int valorBuscar, int indice) {
        if(arreglo[indice]== valorBuscar){
            return 1;
        }else{
            return 0;
        }
    }

    private static void imprimirFibonacci() {

        System.out.println("0,1,1,2,3");
    }
}
