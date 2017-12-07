package practice.pkg3;
import java.math.BigInteger;

public class MultiplicacionRusa implements Multiplicacion {
    private final BigInteger DOS = new BigInteger("2");
    private final BigInteger CERO = new BigInteger("0");

    @Override
    public void multiplica(BigInteger n, BigInteger m, DatosEstadisticos datos) {
        datos.setOrden(m);
        long inicio = System.nanoTime();
        datos.setResultado(recursivaRusa(n, m));
        datos.setTiempo((float) ((System.nanoTime() - inicio) / 1000000.));
    }

    private BigInteger recursivaRusa(BigInteger n, BigInteger m) {
        if (n.compareTo(new BigInteger("1")) != -1) {
            if (n.divideAndRemainder(DOS)[1].compareTo(CERO) != 0) {
                return m.add(recursivaRusa(n.divide(DOS), m.multiply(DOS)));
            }
            return recursivaRusa(n.divide(DOS), m.multiply(DOS));
        }
        return CERO;
    }

    @Override
    public String nombreMetodo() {
        return "Rusa";
    }
}
