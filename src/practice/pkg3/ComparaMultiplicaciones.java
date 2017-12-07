package practice.pkg3;
import java.math.BigInteger;

class comparaMultiplicaciones {
    public static void main(String[] args) {
        int limite = 2458;
        String valor = "";
        for (int i = 0; i < 2458; i++) {
            valor+="9";
        }
        BigInteger[] datosM = new BigInteger[6];

        datosM[0] = new BigInteger("100");
        datosM[1] = new BigInteger("1000");
        datosM[2] = new BigInteger("8960");
        datosM[3] = new BigInteger("100000");
        datosM[4] = new BigInteger("1000000");
        datosM[5] = new BigInteger(valor);

        BigInteger[] datosN = new BigInteger[6];

        datosN[0] = new BigInteger("80");
        datosN[1] = new BigInteger("632");
        datosN[2] = new BigInteger("7155");
        datosN[3] = new BigInteger("85746");
        datosN[4] = new BigInteger("941552");
        datosN[5] = new BigInteger("1973131");

        Multiplicacion[] metodos = {new SumasSucesivas(), new MultiplicacionEgipcia(),
                new MultiplicacionRusa()};

        DatosEstadisticos[][] datosSalida = calculadorEstadisticas.matrizEstadisticas(metodos,
                datosN, datosM);
        
        muestraDatosSalida(obtenerNombreMetodos(metodos), datosSalida);
    }

    private static String[] obtenerNombreMetodos(Multiplicacion[] metodos) {
        String[] nombres = new String[metodos.length];
        for (int i = 0; i < metodos.length; i++) {
            nombres[i] = metodos[i].nombreMetodo();
        }
        return nombres;
    }

    private static void muestraDatosSalida(String[] nombreMetodos, DatosEstadisticos[][] datosSalida) {
        muestraTiempos(nombreMetodos, datosSalida);
        muestraResultados(nombreMetodos, datosSalida);
    }

    private static void muestraTiempos(String[] nombreMetodos, DatosEstadisticos[][] datosSalida) {
        System.out.println("Tiempos de ejecución de los " + nombreMetodos.length + " algoritmos:");
        System.out.println("");
        System.out.print("Tamaño de la ristra:       ");
        for (String nombre : nombreMetodos) {
            System.out.print(nombre + "             ");
        }
        System.out.println("");

        for (int i = 0; i < datosSalida[0].length; i++) {
            if(i == 5){
                String valoraux = "1";
                for (int lim = 0; lim < 2457; lim++) {
                    valoraux+="0";
                }               
                String valor = "";
                for (int a = 0; a < 2458; a++) {
                    valor+="9";
                }
                BigInteger aux = new BigInteger(valor);                       
                String s = aux.divideAndRemainder(new BigInteger(valoraux))[0].toString();
                int s1 = aux.divideAndRemainder(new BigInteger(valoraux))[1].toString().length();
                        
                System.out.printf("%20s", s+"*10^"+s1);
            } else{
                System.out.printf("%20d", datosSalida[0][i].getOrden());
            }
            
            for (DatosEstadisticos[] aDatosSalida : datosSalida) {
                if (aDatosSalida[i].getError()) System.out.printf("%20s", "-------");
                else System.out.printf("%20f", aDatosSalida[i].getTiempo());
            }
            System.out.println("");
        }
        
            System.out.println("\n");
    }

    
    private static void muestraResultados(String[] nombreMetodos, DatosEstadisticos[][] datosSalida) {
        System.out.println("Resultados de las multiplicaciones:");
        System.out.println("");
        System.out.print("Tamaño de la ristra:       ");
        for (String nombre : nombreMetodos) {
            System.out.print(nombre + "             ");
        }
        System.out.println("");

        for (int i = 0; i <3; i++) {
            System.out.printf("%20d", datosSalida[0][i].getOrden());
            for (DatosEstadisticos[] aDatosSalida : datosSalida) {
                if (aDatosSalida[i].getError()) System.out.printf("%20s", "-------");
                else{

                    System.out.printf("%20s", aDatosSalida[i].getResultado());
                }
            }
            System.out.println("");
        }
    }
}
