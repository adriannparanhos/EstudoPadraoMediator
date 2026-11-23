package smarthome;

/**
 * ConcreteColleague: Sensor de Presença / Movimento.
 */
public class SensorPresenca extends Dispositivo {

    public SensorPresenca(SmartHomeMediator mediator, String nome) {
        super(mediator, nome);
    }

    public void detectarAusenciaProlongada() {
        System.out.println("\n[Sensor: " + nome + "] Nenhum movimento detectado na casa por 60 minutos.");
        mediator.notificar(this, "CASA_VAZIA");
    }
}
