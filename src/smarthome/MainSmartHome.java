package smarthome;

/**
 * Demonstra na prática como diferentes tipos de objetos (Colleagues heterogêneos:
 * Despertador, Sensor, Cafeteira, Cortina, ArCondicionado, Luz) interagem sem que
 * nenhum deles possua referência direta para os demais.
 */
public class MainSmartHome {
    public static void main(String[] args) {
        executarDemo();
    }

    public static void executarDemo() {
        HubSmartHome hub = new HubSmartHome();

        Despertador despertador = new Despertador(hub, "Despertador Cabeceira");
        SensorPresenca sensorSala = new SensorPresenca(hub, "Sensor de Presenca Principal");
        Cafeteira cafeteira = new Cafeteira(hub, "Cafeteira Cozinha");
        CortinaAutomatizada cortina = new CortinaAutomatizada(hub, "Cortina Quarto");
        ArCondicionado ar = new ArCondicionado(hub, "Ar-Condicionado Split");
        LuzInteligente luz = new LuzInteligente(hub, "Luz Smart Quarto");

        hub.registrarDispositivos(cafeteira, cortina, ar, luz);

        despertador.tocarAlarmeManha();

        sensorSala.detectarAusenciaProlongada();

        despertador.ativarModoDormir();

        System.out.println("\n[Reflexao para Estudo - Slides 22 e 23]:");
        System.out.println(" - Alto Reuso (Slide 22): O Despertador nao sabe que existe uma Cafeteira!");
        System.out.println("   Podemos vender a classe Despertador para outro sistema sem levar Cafeteira junto.");
        System.out.println(" - Cuidado com o God Object (Slide 23): Repare no switch/case do HubSmartHome.");
        System.out.println("   Se o Hub crescer demais, podemos extrair cada rotina para objetos Command!");
        System.out.println("=================================================================\n");
    }
}
