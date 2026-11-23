package antipadrao;

/**
 * O ANTI-PADRÃO: Testando o Forte Acoplamento.
 *
 * Observe como a configuração manual de contatos explode à medida que
 * novos objetos entram no sistema.
 */
public class MainAcoplado {
    public static void main(String[] args) {
        executarDemo();
    }

    public static void executarDemo() {
        UsuarioAcoplado ana = new UsuarioAcoplado("Ana");
        UsuarioAcoplado joao = new UsuarioAcoplado("Joao");
        UsuarioAcoplado maria = new UsuarioAcoplado("Maria");

        // ACOPLAMENTO CAÓTICO (N x N):
        // Todo mundo precisa adicionar todo mundo manualmente!
        ana.adicionarContato(joao);
        ana.adicionarContato(maria);

        joao.adicionarContato(ana);
        joao.adicionarContato(maria);

        maria.adicionarContato(ana);
        maria.adicionarContato(joao);

        ana.enviarParaTodos("Oi pessoal! Que codigo dificil de manter!");
        joao.enviarParaTodos("Concordo! Se entrar mais 1 pessoa, todos nos precisamos adiciona-la manualmente.");

        System.out.println("\n[Analise Matematica - Slide 6]:");
        System.out.println(" - Com 3 usuarios: 3 * (3 - 1) / 2 = 3 conexoes bidirecionais (6 referencias em listas!).");
        System.out.println(" - Com 10 usuarios: 10 * (10 - 1) / 2 = 45 conexoes diretas (90 referencias espalhadas!).");
        System.out.println("=================================================================\n");
    }
}
