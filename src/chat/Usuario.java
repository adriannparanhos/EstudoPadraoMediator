package chat;

/**
 * Componente base que guarda a referência protegida da interface Mediator.
 * Repare no Slide 8 ("Corte de Dependências"): não existe mais List<Usuario> aqui dentro!
 */
public abstract class Usuario {
    protected ChatMediator mediator;
    protected String nome;

    public Usuario(ChatMediator med, String nome) {
        this.mediator = med;
        this.nome = nome;
    }

    public abstract void enviar(String msg);
    public abstract void receber(String msg);

    public String getNome() {
        return nome;
    }
}
