package smarthome;

/**
 * ConcreteColleague: Cortina Automatizada.
 */
public class CortinaAutomatizada extends Dispositivo {
    private boolean aberta = false;

    public CortinaAutomatizada(SmartHomeMediator mediator, String nome) {
        super(mediator, nome);
    }

    public void abrir() {
        this.aberta = true;
        System.out.println("  -> [Cortina: " + nome + "] Abrindo cortinas para entrada de luz natural.");
    }

    public void fechar() {
        this.aberta = false;
        System.out.println("  -> [Cortina: " + nome + "] Fechando cortinas para privacidade/escurecimento.");
    }
}
