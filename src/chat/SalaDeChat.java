package chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa a coordenação e mantém a lista de colegas ativos.
 * Transforma o relacionamento N x N em 1 x N (Slide 8).
 */
public class SalaDeChat implements ChatMediator {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void adicionarUsuario(Usuario u) {
        this.usuarios.add(u);
    }

    @Override
    public void enviarMensagem(String msg, Usuario remetente) {
        for (Usuario u : this.usuarios) {
            if (u != remetente) {
                u.receber("[" + remetente.getNome() + " disse]: " + msg);
            }
        }
    }
}
