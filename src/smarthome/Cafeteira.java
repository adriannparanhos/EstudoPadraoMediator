package smarthome;

/**
 * ConcreteColleague: Cafeteira Inteligente.
 */
public class Cafeteira extends Dispositivo {
    private boolean ligada = false;

    public Cafeteira(SmartHomeMediator mediator, String nome) {
        super(mediator, nome);
    }

    public void prepararCafe() {
        this.ligada = true;
        System.out.println("  -> [Cafeteira: " + nome + "] Ligando e preparando cafe expresso fresquinho...");
    }

    public void desligar() {
        if (this.ligada) {
            this.ligada = false;
            System.out.println("  -> [Cafeteira: " + nome + "] Desligando por seguranca.");
        } else {
            System.out.println("  -> [Cafeteira: " + nome + "] Ja esta desligada.");
        }
    }
}
