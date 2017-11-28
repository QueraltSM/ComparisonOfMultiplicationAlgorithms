package practice.pkg3;
import java.math.BigInteger;

public class SumasSucesivas implements Multiplicacion {

    private final BigInteger UNO = new BigInteger("1");
    private final BigInteger CERO = new BigInteger("0");

    @Override
    public void multiplica(BigInteger n, BigInteger m, DatosEstadisticos datos) {
        datos.setOrden(m);
        long inicio = System.currentTimeMillis();
        datos.setResultado(recursivaSumas(n, m));
        datos.setTiempo((System.currentTimeMillis() - inicio) / 1000);
    }

    private BigInteger recursivaSumas(BigInteger n, BigInteger m) {
        if (m.compareTo(CERO) == 0) {
            return CERO;
        }

        return (n.add(recursivaSumas(n, m.subtract(UNO))));
    }

    @Override
    public String nombreMetodo() {
        return "Sumas Sucesivas";
    }

}
