package smarthome;

/**
 * ConcreteColleague: Despertador Inteligente.
 * Quando o alarme toca ou o modo soneca/noite é ativado, ele apenas avisa o Mediator.
 */
public class Despertador extends Dispositivo {

    public Despertador(SmartHomeMediator mediator, String nome) {
        super(mediator, nome);
    }

    public void tocarAlarmeManha() {
        System.out.println("\n[Despertador: " + nome + "] TRIMMM! Alarme das 07:00 disparou!");
        mediator.notificar(this, "ALARME_MANHA");
    }

    public void ativarModoDormir() {
        System.out.println("\n[Despertador: " + nome + "] Usuario ativou o Modo Dormir (23:00).");
        mediator.notificar(this, "MODO_DORMIR");
    }
}
