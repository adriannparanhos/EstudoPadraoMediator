package smarthome;

/**
 * Centraliza todas as regras de automação residencial (cenas).
 * Veja como este exemplo ilustra perfeitamente o Slide 10 ("Ciclo de Vida de uma Notificação"):
 * - Passo 1: O Despertador ou Sensor invoca mediator.notificar(this, evento).
 * - Passo 2: O HubSmartHome avalia o evento e aplica as regras de roteamento.
 * - Passo 3: O HubSmartHome aciona métodos específicos na Cafeteira, Cortina, Luz e ArCondicionado.
 * Se esta classe começar a acumular centenas de "if/else" para dezenas de dispositivos,
 * ela pode virar um "God Object" (Objeto Deus). em sistemas muito grandes,
 * podemos combinar o Mediator com o padrão Command (ex: Map<String, Command> cenas) ou Observer!
 */
public class HubSmartHome implements SmartHomeMediator {
    private Cafeteira cafeteira;
    private CortinaAutomatizada cortina;
    private ArCondicionado arCondicionado;
    private LuzInteligente luzQuarto;

    public void registrarDispositivos(Cafeteira cafeteira, CortinaAutomatizada cortina,
                                      ArCondicionado arCondicionado, LuzInteligente luzQuarto) {
        this.cafeteira = cafeteira;
        this.cortina = cortina;
        this.arCondicionado = arCondicionado;
        this.luzQuarto = luzQuarto;
    }

    @Override
    public void notificar(Dispositivo remetente, String evento) {
        System.out.println("  [HubSmartHome - Mediator] Evento '" + evento + "' recebido de '" + remetente.getNome() + "'. Roteando acoes...");

        switch (evento) {
            case "ALARME_MANHA":
                cortina.abrir();
                luzQuarto.acender(60);
                cafeteira.prepararCafe();
                arCondicionado.ajustarTemperatura(23);
                break;

            case "MODO_DORMIR":
                cortina.fechar();
                luzQuarto.apagar();
                cafeteira.desligar();
                arCondicionado.ajustarTemperatura(21);
                break;

            case "CASA_VAZIA":
                cortina.fechar();
                luzQuarto.apagar();
                cafeteira.desligar();
                arCondicionado.ativarModoEco();
                break;

            default:
                System.out.println("  [HubSmartHome - Mediator] Evento desconhecido: " + evento);
        }
    }
}
