package smarthome;

/**
 * - Passo 1: Classe A (ex: Despertador ou Sensor) sofre uma ação e invoca notificar() no Mediator.
 * - Passo 2: ConcreteMediator (HubSmartHome) avalia o evento e aplica regras de roteamento.
 * - Passo 3: Mediator aciona métodos específicos nos Colegas B, C e D (Cafeteira, Cortina, ArCondicionado).
 */
public interface SmartHomeMediator {
    void notificar(Dispositivo remetente, String evento);
}
