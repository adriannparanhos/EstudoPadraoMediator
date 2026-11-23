package chat;

/**
 * Declara o contrato de comunicação centralizado.
 * Os objetos Colleague (Usuários) só conhecem esta interface, e nunca uns aos outros.
 */
public interface ChatMediator {
    void enviarMensagem(String msg, Usuario remetente);
    void adicionarUsuario(Usuario usuario);
}
