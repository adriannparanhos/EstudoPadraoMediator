package trafegoaereo;

/**
 *Colleague Abstrato: Aeronave.
 * Guarda apenas a referência para a Torre de Controle (TorreMediator).
 */
public abstract class Aeronave {
    protected TorreMediator torre;
    protected String codigoVoo;

    public Aeronave(TorreMediator torre, String codigoVoo) {
        this.torre = torre;
        this.codigoVoo = codigoVoo;
    }

    public abstract void pedirParaPousar();
    public abstract void liberarPista();
    public abstract void receberComunicadoTorre(String mensagem);

    public String getCodigoVoo() {
        return codigoVoo;
    }
}
