package practice.pkg3;
import java.math.BigInteger;

public class calculadorEstadisticas {
    public static DatosEstadisticos estadisticasMultiplicacion(Multiplicacion metodo, BigInteger n, BigInteger m) {
        DatosEstadisticos datos = new DatosEstadisticos();

        try {
            metodo.multiplica(n, m, datos);
        } catch (StackOverflowError e) {
            datos.setError();
        }
        return datos;
    }

    public static DatosEstadisticos[] vectorEstadisticas(Multiplicacion metodo, BigInteger[] datosN, BigInteger[] datosM) {
        DatosEstadisticos[] datosSalida = new DatosEstadisticos[datosM.length];
        for (int i = 0; i < datosSalida.length; i++) {

            datosSalida[i] = estadisticasMultiplicacion(metodo, datosN[i], datosM[i]);

        }
        return datosSalida;
    }

    public static DatosEstadisticos[][] matrizEstadisticas(Multiplicacion[] metodos, BigInteger[] datosN, BigInteger[] datosM) {
        DatosEstadisticos[][] datosSalida = new DatosEstadisticos[metodos.length][datosM.length];

        for (int i = 0; i < datosSalida.length; i++) {
            datosSalida[i] = vectorEstadisticas(metodos[i], datosN, datosM);
        }
        
        return datosSalida;
    }
}
