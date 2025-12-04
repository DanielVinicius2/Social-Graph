
package Grafos;
import java.util.*;

public class GrafoSocial {

    private final Map<String, List<String>> amigos = new HashMap<>();
    private final boolean direcionado;

    public GrafoSocial(boolean direcionado) {
        this.direcionado = direcionado;
    }

    public void adicionarPessoa(String nome) {
        amigos.putIfAbsent(nome, new ArrayList<>());
    }

    public void adicionarRelacionamento(String p1, String p2) {
        amigos.get(p1).add(p2);
        if (!direcionado) {
            amigos.get(p2).add(p1);
        }
    }

    public void exibirRede() {
        System.out.println("\n==== REDE SOCIAL GERADA ====");
        for (String pessoa : amigos.keySet()) {
            System.out.println(pessoa + " conhece → " + amigos.get(pessoa));
        }
    }

    // BFS
    public List<String> bfs(String inicio) {
        List<String> ordem = new ArrayList<>();
        Set<String> visitado = new HashSet<>();
        Queue<String> fila = new LinkedList<>();

        fila.add(inicio);

        while (!fila.isEmpty()) {
            String atual = fila.poll();

            if (!visitado.contains(atual)) {
                visitado.add(atual);
                ordem.add(atual);

                for (String viz : amigos.getOrDefault(atual, new ArrayList<>())) {
                    if (!visitado.contains(viz)) {
                        fila.add(viz);
                    }
                }
            }
        }
        return ordem;
    }

    // DFS
    public List<String> dfs(String inicio) {
        List<String> ordem = new ArrayList<>();
        Set<String> visitado = new HashSet<>();
        dfsRec(inicio, visitado, ordem);
        return ordem;
    }

    private void dfsRec(String atual, Set<String> visitado, List<String> ordem) {
        visitado.add(atual);
        ordem.add(atual);

        for (String amigo : amigos.getOrDefault(atual, new ArrayList<>())) {
            if (!visitado.contains(amigo)) {
                dfsRec(amigo, visitado, ordem);
            }
        }
    }

    // -------------------------------
    // PROGRAMA INTERATIVO
    // -------------------------------
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            GrafoSocial rede = new GrafoSocial(false);
            
            System.out.println("===== CRIAÇÃO DA REDE SOCIAL =====");
            System.out.print("Quantas pessoas deseja inserir? ");
            int n = sc.nextInt();
            sc.nextLine(); // limpar buffer
            
            List<String> cadastradas = new ArrayList<>();
            
            for (int i = 1; i <= n; i++) {
                System.out.print("\nDigite o nome da pessoa " + i + ": ");
                String nome = sc.nextLine();
                rede.adicionarPessoa(nome);
                cadastradas.add(nome);
                
                // Perguntar com quem ela se relaciona (entre os já cadastrados)
                if (cadastradas.size() > 1) {
                    System.out.println("Com quais dessas pessoas " + nome + " se relaciona?");
                    System.out.println(cadastradas);
                    
                    System.out.println("Digite os nomes separados por vírgula (ou deixe vazio caso não relacione): ");
                    String entrada = sc.nextLine().trim();
                    
                    if (!entrada.isEmpty()) {
                        String[] relacoes = entrada.split(",");
                        for (String r : relacoes) {
                            String pessoaRelacionada = r.trim();
                            if (cadastradas.contains(pessoaRelacionada) && !pessoaRelacionada.equals(nome)) {
                                rede.adicionarRelacionamento(nome, pessoaRelacionada);
                            }
                        }
                    }
                }
            }
            
            // Exibir rede final
            rede.exibirRede();
            
            // BFS
            System.out.print("\nDigite uma pessoa para iniciar BFS: ");
            String inicioBFS = sc.nextLine();
            System.out.println("BFS: " + rede.bfs(inicioBFS));
            
            // DFS
            System.out.print("\nDigite uma pessoa para iniciar DFS: ");
            String inicioDFS = sc.nextLine();
            System.out.println("DFS: " + rede.dfs(inicioDFS));
        }
    }
}



