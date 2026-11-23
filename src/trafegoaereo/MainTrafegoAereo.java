package trafegoaereo;

/**
 * EXEMPLO 03: Analogia Clássica - Controle de Tráfego Aéreo.
 * Demonstra como a Torre de Controle coordena a disputa por um recurso crítico (a pista)
 * entre múltiplas aeronaves sem que um avião precise conhecer ou negociar com outro.
 */
public class MainTrafegoAereo {
    public static void main(String[] args) {
        executarDemo();
    }

    public static void executarDemo() {
        TorreMediator torreGuarulhos = new TorreDeControle();

        Aeronave latam = new VooComercial(torreGuarulhos, "LA-3040");
        Aeronave gol = new VooComercial(torreGuarulhos, "G3-1522");
        Aeronave azul = new VooComercial(torreGuarulhos, "AD-4100");

        torreGuarulhos.registrarAeronave(latam);
        torreGuarulhos.registrarAeronave(gol);
        torreGuarulhos.registrarAeronave(azul);

        // 1. LATAM pede para pousar (Pista está livre -> Autorizado!)
        latam.pedirParaPousar();

        // 2. GOL pede para pousar enquanto LATAM ainda está na pista (-> Vai para a fila!)
        gol.pedirParaPousar();

        // 3. AZUL também pede para pousar (-> Vai para a fila na posição 2!)
        azul.pedirParaPousar();

        // 4. LATAM libera a pista -> A Torre automaticamente autoriza o próximo da fila (GOL)!
        latam.liberarPista();

        // 5. GOL libera a pista -> A Torre automaticamente autoriza a AZUL!
        gol.liberarPista();

        System.out.println("=================================================================\n");
    }
}
