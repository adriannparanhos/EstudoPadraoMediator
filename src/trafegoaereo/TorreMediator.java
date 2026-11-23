package trafegoaereo;

/**
 * "Sem conversa paralela: Aviões não negociam pousos entre si.
 *  Torre como Mediador: Recebe status e dita ordens de pista.
 *  Segurança e Escala: Novos aviões entram sem conhecer os demais."
 */
public interface TorreMediator {
    void registrarAeronave(Aeronave aeronave);
    boolean solicitarAutorizacaoPouso(Aeronave aeronave);
    void notificarLiberacaoPista(Aeronave aeronave);
    void enviarAlertaRadar(String mensagem, Aeronave origem);
}
