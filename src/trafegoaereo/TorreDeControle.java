package trafegoaereo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Gerencia o estado da pista, a fila de espera para pouso e o broadcast de
 * alertas para todas as aeronaves no espaço aéreo.
 */
public class TorreDeControle implements TorreMediator {
    private List<Aeronave> aeronavesNoRadar = new ArrayList<>();
    private Queue<Aeronave> filaEsperaPouso = new LinkedList<>();
    private Aeronave aeronaveNaPista = null;

    @Override
    public void registrarAeronave(Aeronave aeronave) {
        aeronavesNoRadar.add(aeronave);
        System.out.println("[Torre de Controle] Voo " + aeronave.getCodigoVoo() + " entrou no espaco aereo monitorado.");
    }

    @Override
    public boolean solicitarAutorizacaoPouso(Aeronave solicitante) {
        if (aeronaveNaPista == null) {
            aeronaveNaPista = solicitante;
            System.out.println("  [Torre -> Voo " + solicitante.getCodigoVoo() + "] POUSO AUTORIZADO! Pista principal livre.");
            enviarAlertaRadar("Pista ocupada pelo voo " + solicitante.getCodigoVoo() + " em procedimento de pouso.", solicitante);
            return true;
        } else {
            filaEsperaPouso.add(solicitante);
            System.out.println("  [Torre -> Voo " + solicitante.getCodigoVoo() + "] NEGADO TEMPORARIAMENTE. Pista ocupada pelo voo "
                    + aeronaveNaPista.getCodigoVoo() + ". Voce entrou na fila de espera (Posicao " + filaEsperaPouso.size() + ").");
            return false;
        }
    }

    @Override
    public void notificarLiberacaoPista(Aeronave aeronave) {
        if (aeronaveNaPista == aeronave) {
            System.out.println("  [Torre de Controle] Pista principal liberada pelo voo " + aeronave.getCodigoVoo() + ".");
            aeronaveNaPista = null;

            // Se houver aviões aguardando na fila, a Torre autoriza o próximo automaticamente!
            if (!filaEsperaPouso.isEmpty()) {
                Aeronave proximo = filaEsperaPouso.poll();
                System.out.println("  [Torre de Controle] Acionando proximo voo da fila de espera: " + proximo.getCodigoVoo());
                solicitarAutorizacaoPouso(proximo);
            }
        }
    }

    @Override
    public void enviarAlertaRadar(String mensagem, Aeronave origem) {
        for (Aeronave a : aeronavesNoRadar) {
            if (a != origem) {
                a.receberComunicadoTorre(mensagem);
            }
        }
    }
}
