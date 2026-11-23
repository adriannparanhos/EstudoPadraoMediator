package trafegoaereo;

/**
 * Não possui nenhuma referência a outros aviões no espaço aéreo.
 */
public class VooComercial extends Aeronave {

    public VooComercial(TorreMediator torre, String codigoVoo) {
        super(torre, codigoVoo);
    }

    @Override
    public void pedirParaPousar() {
        System.out.println("\n[Voo " + codigoVoo + " -> Torre] Solicitando autorizacao de pouso.");
        torre.solicitarAutorizacaoPouso(this);
    }

    @Override
    public void liberarPista() {
        System.out.println("\n[Voo " + codigoVoo + " -> Torre] Pouso concluido. Pista liberada (no finger).");
        torre.notificarLiberacaoPista(this);
    }

    @Override
    public void receberComunicadoTorre(String mensagem) {
        System.out.println("  [Radio de Bordo - Voo " + codigoVoo + "] Recebido da Torre: " + mensagem);
    }
}
