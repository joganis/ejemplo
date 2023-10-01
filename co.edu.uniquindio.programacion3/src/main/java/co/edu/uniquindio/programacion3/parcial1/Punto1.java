package co.edu.uniquindio.programacion3.parcial1;

public class Punto1 {
    public String[][] campo = {
    						  {" ","E1","A"," ","A"," "," "," ","E1"},
                              {" ","E1","E2"," ","A","E1"," ","E1"," "},
                              {" ", " ", " ", " ", " ", " ", " ", " "," "},
                              {"E1"," ","E1","A"," ","E1","A"," "," "},
                              {"A"," "," A"," "," ","E2","E1"," "," "},
                              {" "," "," "," "," "," "," "," "," "},
                              {" ","A","E1"," ","E1","A"," ","A"," "},
                              {" ","E2"," "," "," ","E1"," "," "," "},
                              {" "," "," ","A"," "," "," ","E2"," "}};
    public static int cantidadE1;
    public static int cantidadE2;
    public static int cantidadA;
    public static void main(String[] args) {
        Punto1 c = new Punto1();
        cantidadE1 = 0;
        cantidadE2 = 0;
        cantidadA = 0;
        c.campo[5][8] = "G";
        c.resuelve(0, 7);
        int cantidadTotal = cantidadE1 + cantidadE2;
        System.out.println(c.imprimirCampo());
        System.out.println("La cantidad de enemigos de tipo uno asesinados fueron de: " + cantidadE1 + "\n"+
        					"La cantidad de enemigos de tipo dos asesinados fueron de: " + cantidadE2 + "\n" + 
        					"La cantidad de enemigos totales es fue de: "+ cantidadTotal + "\n" + 
        					"La cantidad de aliados encontrados fue de: " + cantidadA);
     


    }

    public void resuelve(int x, int y) {
        if (paso(x, y)) {
            campo[x][y] = "S";
        }
    }

    private boolean paso(int x, int y) {

        if (!esValido(x,y)){
            return false;
        }
        if (campo[x][y] == "G") {// si hemos llegado a X quiere decir que hemos encontrado soluci�n
            System.out.println(imprimirCampo());
            return true; // luego, el algoritmo termina
        }
        if (campo[x][y] =="E1"){
            campo[x][y] = "??";
            cantidadE1+=1;
            return false;
        }
        if (campo[x][y] =="E2"){
            campo[x][y] = "??";
            cantidadE2+=1;
            return false;
        }
        if (campo[x][y] =="A"){
            campo[x][y] = "AC";
            cantidadA+=1;
            return false;
        }
        if (campo[x][y] == "A" || campo[x][y] == "f" || campo[x][y] == "??") { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }


        campo[x][y] = "??"; // marcamos la posici�n como visitada (si es la primera, en las coordenadas x e y

        boolean result; // se coloca S de START)

        	result = paso(x, y - 1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiv
            result = paso(x, y + 1);// intentamos ir hacia la DERECHA. Primera llamada recursiva
            result = paso(x + 1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
            result = paso(x - 1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
            

        campo[x][y] = "f"; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atr�s si la soluci�n no se encuentra aqu�


    }

    private boolean esValido(int x, int y) {
        if (x>=0 && x<=campo.length-1 && y>=0 && y<=campo[x].length-1 ){
            return true;
        }
        return false;
    }

    private String imprimirCampo() { // imprimiremos nuestra soluci�n. Debido a que la clase Arrays no tiene implementado
        String salida = "";    // un m�todo toString para arrays bidimensionales, lo programamos a mano
        for (int x = 0; x < campo.length; x++) { // recorremos filas
            for (int y = 0; y < campo[x].length; y++) { // recorremos columnas
                salida += campo[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de l�nea

        }
        return salida;
    }



}