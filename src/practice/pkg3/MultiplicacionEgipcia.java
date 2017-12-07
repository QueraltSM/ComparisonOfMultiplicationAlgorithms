package practice.pkg3;
import java.math.BigInteger;

public class MultiplicacionEgipcia implements Multiplicacion {
    private final BigInteger DOS = new BigInteger("2");
    private BigInteger[] resultado;

    @Override
    public void multiplica(BigInteger n, BigInteger m, DatosEstadisticos datos) {
        datos.setOrden(m);
        resultado = new BigInteger[]{new BigInteger("0"), new BigInteger("0")};
        long inicio = System.nanoTime();
        recursivaEgipcia(n, m, new BigInteger("1"));
        datos.setTiempo((float) ((System.nanoTime() - inicio) / 1000000.));
        datos.setResultado(resultado[0]);
    }

    private BigInteger[] recursivaEgipcia(BigInteger n, BigInteger m, BigInteger doble1) {
        if (doble1.compareTo(m) == 1) return resultado;
                 resultado = recursivaEgipcia(n, m, doble1.multiply(DOS));

        if  (resultado[1].add(doble1).compareTo(m) != 1) return new BigInteger[]
                {resultado[0].add(n.multiply(doble1)), resultado[1].add(doble1)};
        return resultado;
    }

    @Override
    public String nombreMetodo() {
        return "Egipcia";
    }
}
