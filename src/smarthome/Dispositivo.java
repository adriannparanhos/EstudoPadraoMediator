package smarthome;

/**
 * Representa qualquer dispositivo inteligente (Sensor, Botão, Eletrodoméstico).
 * Graças ao Mediator (Slide 22 - Alto Reuso de Classes), um dispositivo não
 * conhece nenhum outro dispositivo da casa. Ele só conhece o Hub!
 */
public abstract class Dispositivo {
    protected SmartHomeMediator mediator;
    protected String nome;

    public Dispositivo(SmartHomeMediator mediator, String nome) {
        this.mediator = mediator;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
