package antipadrao;

import java.util.ArrayList;
import java.util.List;

/**
 * Problemas demonstrados aqui
 * 1. Spaghetti Code: Cada objeto precisa guardar uma lista de todos os outros usuários.
 * 2. Acoplamento N x N: Fórmula de conexões diretas = N * (N - 1) / 2.
 *    Com 10 objetos, temos 45 conexões diretas!
 * 3. Baixo Reuso e Efeito Cascata: Se a assinatura de receber() mudar, ou se
 *    quisermos criar regras de filtragem, teremos que alterar a própria classe UsuarioAcoplado.
 */
public class UsuarioAcoplado {
    private String nome;

    // O grande problema: a classe precisa conhecer e guardar todos os outros usuários diretamente!
    private List<UsuarioAcoplado> contatos = new ArrayList<>();

    public UsuarioAcoplado(String nome) {
        this.nome = nome;
    }

    public void adicionarContato(UsuarioAcoplado amigo) {
        this.contatos.add(amigo);
    }

    public void enviarParaTodos(String msg) {
        System.out.println("\n" + this.nome + " enviando mensagem para todos...");
        for (UsuarioAcoplado amigo : contatos) {
            amigo.receber(msg, this.nome);
        }
    }

    public void receber(String msg, String remetente) {
        System.out.println("  -> " + this.nome + " recebeu de " + remetente + ": " + msg);
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeContatos() {
        return contatos.size();
    }
}
