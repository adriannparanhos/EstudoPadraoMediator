package smarthome;

/**
 * ConcreteColleague: Ar-Condicionado Split Inteligente.
 */
public class ArCondicionado extends Dispositivo {
    private boolean ligado = false;
    private int temperatura = 24;

    public ArCondicionado(SmartHomeMediator mediator, String nome) {
        super(mediator, nome);
    }

    public void ajustarTemperatura(int novaTemp) {
        this.ligado = true;
        this.temperatura = novaTemp;
        System.out.println("  -> [Ar-Condicionado: " + nome + "] Ligado e ajustado para " + temperatura + " graus C.");
    }

    public void ativarModoEco() {
        this.ligado = false;
        System.out.println("  -> [Ar-Condicionado: " + nome + "] Desligado (Modo Economia de Energia ativado).");
    }
}
