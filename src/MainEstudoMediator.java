import antipadrao.MainAcoplado;
import chat.MainMediator;
import smarthome.MainSmartHome;
import trafegoaereo.MainTrafegoAereo;

import java.util.Scanner;

/**
 * LABORATÓRIO INTERATIVO DE ESTUDO: DESIGN PATTERN MEDIATOR (GoF)
 * Classe principal que integra todos os conceitos e projetos dos slides
 */
public class MainEstudoMediator {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("--todos")) {
            rodarTodosOsExemplos();
            exibirResumoTeoricoSlides();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            exibirCabecalhoMenu();
            System.out.print("Escolha uma opcao de estudo (0-7): ");
            String entrada = scanner.nextLine().trim();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            System.out.println();
            switch (opcao) {
                case 1:
                    MainAcoplado.executarDemo();
                    break;
                case 2:
                    MainMediator.executarDemo();
                    break;
                case 3:
                    MainSmartHome.executarDemo();
                    break;
                case 4:
                    MainTrafegoAereo.executarDemo();
                    break;
                case 5:
                    exibirResumoTeoricoSlides();
                    break;
                case 6:
                    executarQuizDeRevisao(scanner);
                    break;
                case 7:
                    rodarTodosOsExemplos();
                    break;
                case 0:
                    System.out.println("Bons estudos! \"O Mediator troca a complexidade de uma rede caotica pela simplicidade de um hub centralizado.\" (Slide 25)");
                    break;
                default:
                    System.out.println("[!] Opcao invalida. Digite um numero de 0 a 7.\n");
            }
        }
        scanner.close();
    }

    private static void exibirCabecalhoMenu() {
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|       LABORATORIO DE ESTUDO: DESIGN PATTERN MEDIATOR (GoF)        |");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("| 1. Anti-Padrao: Sala de Chat Acoplada (N x N)      |");
        System.out.println("| 2. Exemplo 01 : Sala de Chat com Mediator (1 x N)  |");
        System.out.println("| 3. Exemplo 02 : Smart Home (Automacao Residencial) |");
        System.out.println("| 4. Exemplo 03 : Torre de Controle de Trafego Aereo |");
        System.out.println("| 5. Resumo Teorico & Comparativo (Observer/Facade)  |");
        System.out.println("| 6. [Revisao]      Quiz Interativo para Testar Conhecimentos       |");
        System.out.println("| 7. [Executar Tudo] Rodar todos os exemplos praticos em sequencia  |");
        System.out.println("| 0. Sair                                                           |");
        System.out.println("+-------------------------------------------------------------------+");
    }

    public static void rodarTodosOsExemplos() {
        MainAcoplado.executarDemo();
        MainMediator.executarDemo();
        MainSmartHome.executarDemo();
        MainTrafegoAereo.executarDemo();
    }

    public static void exibirResumoTeoricoSlides() {
        System.out.println("=================================================================");
        System.out.println(" RESUMO TEORICO COMPLETO DOS SLIDES (PARA REVISAO DE PROVA)");
        System.out.println("=================================================================");
        System.out.println("1. CLASSIFICACAO GoF:");
        System.out.println("   - Padrao COMPORTAMENTAL.");
        System.out.println("   - Definicao: \"Define um objeto que encapsula a forma como um conjunto");
        System.out.println("     de objetos interage. Promove acoplamento fraco ao evitar que os");
        System.out.println("     objetos se refiram uns aos outros explicitamente.\"");
        System.out.println();
        System.out.println("2. MATEMATICA DO ACOPLAMENTO:");
        System.out.println("   - Sem Mediator (Rede N x N): N * (N - 1) / 2 conexoes (10 objetos = 45 conexoes).");
        System.out.println("   - Com Mediator (Estrela 1 x N): Apenas N conexoes (10 objetos = 10 conexoes).");
        System.out.println();
        System.out.println("3. OS 4 PARTICIPANTES DA ARQUITETURA UML:");
        System.out.println("   - Mediator (Interface): Contrato de comunicacao (ex: ChatMediator, SmartHomeMediator).");
        System.out.println("   - ConcreteMediator: Coordena e guarda os colegas (ex: SalaDeChat, HubSmartHome).");
        System.out.println("   - Colleague (Classe Abstrata): Guarda referencia protegida do Mediator (ex: Usuario, Dispositivo).");
        System.out.println("   - ConcreteColleague: Componentes reais do dominio (ex: UsuarioChat, Cafeteira, Despertador).");
        System.out.println();
        System.out.println("4. ONDE JA EXISTE NO JAVA SDK?:");
        System.out.println("   - java.util.Timer (metodos schedule() coordenam tarefas em background).");
        System.out.println("   - java.util.concurrent.ExecutorService (gerencia submissao de Runnables/Callables).");
        System.out.println("   - Java Swing / JavaFX (ButtonGroup e Controllers MVC).");
        System.out.println();
        System.out.println("5. MEDIATOR vs. OBSERVER vs. FACADE:");
        System.out.println("   - Mediator : Multidirecional (Centralizada) -> Elimina conexoes diretas entre colegas do mesmo nivel.");
        System.out.println("   - Observer : Unidirecional (Broadcast)      -> Notifica assinantes dinamicamente sobre mudancas de estado.");
        System.out.println("   - Facade   : Unidirecional (Cliente->Sub)   -> Apenas simplifica a interface de um subsistema complexo.");
        System.out.println();
        System.out.println("6. SOLID E O PERIGO DO 'GOD OBJECT':");
        System.out.println("   - SOLID: Atende SRP (regra de interacao isolada), OCP (novos mediadores sem tocar nos colegas) e Alto Reuso.");
        System.out.println("   - Perigo (God Object): O ConcreteMediator pode acumular dezenas de if/else e virar um monolito interno.");
        System.out.println("   - Dica Pratica: Combinar Mediator com Command ou Observer para mante-lo enxuto.");
        System.out.println("=================================================================\n");
    }

    private static void executarQuizDeRevisao(Scanner scanner) {
        System.out.println("=================================================================");
        System.out.println(" QUIZ DE REVISAO: PADRAO MEDIATOR (4 PERGUNTAS DOS SLIDES)");
        System.out.println("=================================================================");
        int acertos = 0;

        // Pergunta 1
        System.out.println("\n1) Se um sistema possui 10 objetos que precisam se comunicar entre si,");
        System.out.println("   quantas conexoes diretas existem SEM Mediator vs. COM Mediator?");
        System.out.println("   a) 100 sem Mediator / 10 com Mediator");
        System.out.println("   b) 45 sem Mediator / 10 com Mediator");
        System.out.println("   c) 20 sem Mediator / 1 com Mediator");
        System.out.print("   Sua resposta (a/b/c): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("b")) {
            System.out.println("   [CORRETO!] Formula sem Mediator: N*(N-1)/2 = 10*9/2 = 45. Com Mediator: N = 10.");
            acertos++;
        } else {
            System.out.println("   [INCORRETO] A resposta certa e 'b': 45 sem Mediator (N*(N-1)/2) e 10 com Mediator (N).");
        }

        // Pergunta 2
        System.out.println("\n2) Qual participante da arquitetura UML guarda a referencia protegida");
        System.out.println("   da interface Mediator para que as subclasses possam aciona-lo?");
        System.out.println("   a) ConcreteMediator");
        System.out.println("   b) Colleague (Classe Abstrata)");
        System.out.println("   c) Cliente (Main)");
        System.out.print("   Sua resposta (a/b/c): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("b")) {
            System.out.println("   [CORRETO!] A classe abstrata Colleague (ex: Usuario ou Dispositivo) guarda 'protected Mediator mediator;'.");
            acertos++;
        } else {
            System.out.println("   [INCORRETO] A resposta certa e 'b': Colleague (Classe Abstrata).");
        }

        // Pergunta 3
        System.out.println("\n3) Qual a principal diferenca entre Mediator e Facade?");
        System.out.println("   a) O Mediator tem comunicacao multidirecional centralizada entre colegas do mesmo nivel;");
        System.out.println("      o Facade e unidirecional (Cliente -> Subsistema) apenas para simplificar uma interface.");
        System.out.println("   b) O Facade e comportamental e o Mediator e estrutural.");
        System.out.println("   c) Nao ha diferenca, sao dois nomes para o mesmo padrao.");
        System.out.print("   Sua resposta (a/b/c): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("a")) {
            System.out.println("   [CORRETO!] O Mediator coordena colegas no mesmo nivel; o Facade apenas cria uma fachada simples para um subsistema.");
            acertos++;
        } else {
            System.out.println("   [INCORRETO] A resposta certa e 'a'.");
        }

        // Pergunta 4
        System.out.println("\n4) Qual e o maior ponto de atencao (anti-padrao/risco) ao usar o Mediator?");
        System.out.println("   a) Consumo excessivo de memoria RAM pelas interfaces.");
        System.out.println("   b) O ConcreteMediator crescer demais com dezenas de regras if/else e virar um 'God Object' (Objeto Deus).");
        System.out.println("   c) Impossibilidade de usar heranca nos Colleagues.");
        System.out.print("   Sua resposta (a/b/c): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("b")) {
            System.out.println("   [CORRETO!] Por isso o Slide 23 recomenda combinar o Mediator com Command ou Observer quando ele crescer.");
            acertos++;
        } else {
            System.out.println("   [INCORRETO] A resposta certa e 'b': o perigo do God Object (Objeto Deus).");
        }

        System.out.println("\n-----------------------------------------------------------------");
        System.out.println(" Resultado do Quiz: Voce acertou " + acertos + " de 4 perguntas!");
        System.out.println("-----------------------------------------------------------------\n");
    }
}
