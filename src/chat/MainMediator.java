package chat;

/**
 * Veja como o registro agora é único e centralizado (1 x N).
 * Se 10 usuários entrarem na sala, fazemos apenas 10 chamadas a sala.adicionarUsuario().
 */
public class MainMediator {
    public static void main(String[] args) {
        executarDemo();
    }

    public static void executarDemo() {
        ChatMediator sala = new SalaDeChat();

        Usuario ana = new UsuarioChat(sala, "Ana");
        Usuario joao = new UsuarioChat(sala, "Joao");
        Usuario maria = new UsuarioChat(sala, "Maria");
        Usuario carlos = new UsuarioChat(sala, "Carlos");

        sala.adicionarUsuario(ana);
        sala.adicionarUsuario(joao);
        sala.adicionarUsuario(maria);
        sala.adicionarUsuario(carlos);

        ana.enviar("Ola pessoal, reuniao as 14h!");
        carlos.enviar("Perfeito, Ana! Acabei de entrar na equipe e ja recebi a mensagem sem ninguem precisar me adicionar manualmente.");

        System.out.println("\n[Beneficio Arquitetural - Slide 22 (SOLID)]:");
        System.out.println(" - SRP: A regra de roteamento de mensagens esta isolada em SalaDeChat.");
        System.out.println(" - OCP: Podemos criar um Bot ou um UsuarioVIP ou uma SalaDeChatModerada sem alterar UsuarioChat!");
        System.out.println("=================================================================\n");
    }
}
