package practice.pkg3;
import java.math.BigInteger;

class DatosEstadisticos {
    private float tiempo;
    private boolean error;
    private BigInteger orden;
    private BigInteger resultado;

    public DatosEstadisticos() {
        tiempo = 0;
        error = false;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    public void setError() {
        error = true;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public BigInteger getOrden() {
        return orden;
    }

    public boolean getError() {
        return error;
    }

    public BigInteger getResultado() {
        return resultado;
    }

    public void setResultado(BigInteger resultadomulti) {
        resultado = resultadomulti;
    }
}