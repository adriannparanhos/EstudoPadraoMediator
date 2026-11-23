package smarthome;

/**
 * ConcreteColleague: Sistema de Iluminação Smart LED.
 */
public class LuzInteligente extends Dispositivo {
    private boolean acesa = false;

    public LuzInteligente(SmartHomeMediator mediator, String nome) {
        super(mediator, nome);
    }

    public void acender(int intensidadePorcentagem) {
        this.acesa = true;
        System.out.println("  -> [Luz: " + nome + "] Acesa com intensidade em " + intensidadePorcentagem + "%.");
    }

    public void apagar() {
        this.acesa = false;
        System.out.println("  -> [Luz: " + nome + "] Apagada.");
    }
}
