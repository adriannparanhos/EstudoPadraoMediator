package chat;

/**
 * Classe real do domínio que executa tarefas e aciona o mediador.
 */
public class UsuarioChat extends Usuario {

    public UsuarioChat(ChatMediator med, String nome) {
        super(med, nome);
    }

    @Override
    public void enviar(String msg) {
        System.out.println("\n" + this.nome + " enviou: " + msg);
        mediator.enviarMensagem(msg, this);
    }

    @Override
    public void receber(String msg) {
        System.out.println("  -> " + this.nome + " recebeu: " + msg);
    }
}
