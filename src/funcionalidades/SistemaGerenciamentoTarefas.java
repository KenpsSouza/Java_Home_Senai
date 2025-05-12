package funcionalidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Aplicação de gerenciamento de tarefas
 * Este programa demonstra vários conceitos fundamentais de Java:
 * - Classes e objetos
 * - Herança e polimorfismo
 * - Coleções (ArrayList)
 * - Manipulação de datas
 * - Entrada/saída via console
 * - Tratamento de exceções
 * - Enumerações
 * - Expressões lambda
 */
public class SistemaGerenciamentoTarefas {

    /**
     * Método principal que inicia a aplicação
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}

/**
 * Enum para representar a prioridade da tarefa
 */
enum Prioridade {
    BAIXA(1),
    MEDIA(2),
    ALTA(3),
    URGENTE(4);

    private final int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    // Método para obter a prioridade a partir de um valor numérico
    public static Prioridade fromValor(int valor) {
        for (Prioridade p : Prioridade.values()) {
            if (p.getValor() == valor) {
                return p;
            }
        }
        return BAIXA; // Valor padrão caso não seja encontrado
    }
}

/**
 * Enum para representar o status da tarefa
 */
enum Status {
    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA("Concluída"),
    CANCELADA("Cancelada");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

/**
 * Classe base que representa uma tarefa
 */
class Tarefa {
    private static int contadorId = 1; // Contador estático para gerar IDs únicos
    
    private int id;
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataVencimento;
    private Prioridade prioridade;
    private Status status;

    /**
     * Construtor para criar uma nova tarefa
     */
    public Tarefa(String titulo, String descricao, LocalDate dataVencimento, Prioridade prioridade) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = LocalDate.now();
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
        this.status = Status.PENDENTE; // Status padrão
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Verifica se a tarefa está atrasada
     */
    public boolean estaAtrasada() {
        return dataVencimento.isBefore(LocalDate.now()) && status != Status.CONCLUIDA;
    }

    /**
     * Calcula quantos dias faltam até o vencimento
     */
    public long diasAteVencimento() {
        return java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), dataVencimento);
    }

    /**
     * Representação textual da tarefa
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ID: %d | %s", id, titulo));
        sb.append(String.format("\nDescricão: %s", descricao));
        sb.append(String.format("\nCriada em: %s | Vence em: %s", 
                dataCriacao.format(formatter), dataVencimento.format(formatter)));
        sb.append(String.format("\nPrioridade: %s | Status: %s", prioridade, status.getDescricao()));
        
        if (estaAtrasada()) {
            sb.append(" [ATRASADA!]");
        } else if (status != Status.CONCLUIDA) {
            sb.append(String.format(" [Faltam %d dias]", diasAteVencimento()));
        }
        
        return sb.toString();
    }
}

/**
 * Subclasse que representa uma tarefa com etapas
 */
class TarefaComEtapas extends Tarefa {
    private List<String> etapas;
    private List<Boolean> etapasConcluidas;

    /**
     * Construtor de TarefaComEtapas
     */
    public TarefaComEtapas(String titulo, String descricao, LocalDate dataVencimento, 
                          Prioridade prioridade, List<String> etapas) {
        super(titulo, descricao, dataVencimento, prioridade);
        this.etapas = new ArrayList<>(etapas);
        
        // Inicializa todas as etapas como não concluídas
        this.etapasConcluidas = new ArrayList<>();
        for (int i = 0; i < etapas.size(); i++) {
            etapasConcluidas.add(false);
        }
    }

    /**
     * Marca uma etapa como concluída
     */
    public void marcarEtapaConcluida(int indiceEtapa) {
        if (indiceEtapa >= 0 && indiceEtapa < etapas.size()) {
            etapasConcluidas.set(indiceEtapa, true);
            
            // Se todas as etapas forem concluídas, marca a tarefa como concluída
            boolean todasConcluidas = true;
            for (boolean concluida : etapasConcluidas) {
                if (!concluida) {
                    todasConcluidas = false;
                    break;
                }
            }
            
            if (todasConcluidas) {
                setStatus(Status.CONCLUIDA);
            } else if (getStatus() != Status.EM_ANDAMENTO) {
                setStatus(Status.EM_ANDAMENTO);
            }
        }
    }

    /**
     * Calcula o progresso da tarefa em porcentagem
     */
    public int calcularProgresso() {
        if (etapas.isEmpty()) return 0;
        
        int concluidas = 0;
        for (boolean concluida : etapasConcluidas) {
            if (concluida) concluidas++;
        }
        
        return (concluidas * 100) / etapas.size();
    }

    /**
     * Representação textual da tarefa com etapas
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("\nProgresso: %d%%", calcularProgresso()));
        sb.append("\nEtapas:");
        
        for (int i = 0; i < etapas.size(); i++) {
            sb.append(String.format("\n %d. %s [%s]", 
                    i + 1, 
                    etapas.get(i), 
                    etapasConcluidas.get(i) ? "✓" : " "));
        }
        
        return sb.toString();
    }

    /**
     * Getters e setters específicos
     */
    public List<String> getEtapas() {
        return new ArrayList<>(etapas);
    }

    public List<Boolean> getEtapasConcluidas() {
        return new ArrayList<>(etapasConcluidas);
    }
}

/**
 * Classe que gerencia a interação com o usuário e controla o sistema
 */
class Sistema {
    private final Scanner scanner;
    private final List<Tarefa> tarefas;
    private boolean executando;

    /**
     * Construtor do Sistema
     */
    public Sistema() {
        this.scanner = new Scanner(System.in);
        this.tarefas = new ArrayList<>();
        this.executando = true;
    }

    /**
     * Inicia o sistema e exibe o menu principal
     */
    public void iniciar() {
        carregarDadosExemplo(); // Carrega alguns dados de exemplo
        
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE TAREFAS ===");
        System.out.println("Bem-vindo ao sistema de gerenciamento de tarefas!");
        
        while (executando) {
            exibirMenu();
            int opcao = lerOpcao();
            processarOpcao(opcao);
        }
        
        scanner.close();
        System.out.println("\nSistema encerrado. Obrigado por usar o Sistema de Gerenciamento de Tarefas!");
    }

    /**
     * Carrega alguns dados de exemplo para demonstração
     */
    private void carregarDadosExemplo() {
        tarefas.add(new Tarefa(
                "Comprar mantimentos", 
                "Ir ao mercado para comprar alimentos da semana", 
                LocalDate.now().plusDays(2), 
                Prioridade.MEDIA));
        
        List<String> etapasApresentacao = new ArrayList<>();
        etapasApresentacao.add("Criar slides");
        etapasApresentacao.add("Preparar demonstração");
        etapasApresentacao.add("Ensaiar apresentação");
        etapasApresentacao.add("Preparar respostas para possíveis perguntas");
        
        TarefaComEtapas tarefaApresentacao = new TarefaComEtapas(
                "Preparar apresentação", 
                "Apresentação do novo projeto para o cliente", 
                LocalDate.now().plusDays(5), 
                Prioridade.ALTA,
                etapasApresentacao);
        
        tarefaApresentacao.marcarEtapaConcluida(0); // Marca "Criar slides" como concluído
        tarefas.add(tarefaApresentacao);
        
        tarefas.add(new Tarefa(
                "Pagar conta de luz", 
                "Pagar a conta de luz deste mês", 
                LocalDate.now().minusDays(1), // Tarefa atrasada
                Prioridade.URGENTE));
    }

    /**
     * Exibe o menu principal para o usuário
     */
    private void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Listar todas as tarefas");
        System.out.println("2. Adicionar nova tarefa simples");
        System.out.println("3. Adicionar tarefa com etapas");
        System.out.println("4. Alterar status de uma tarefa");
        System.out.println("5. Atualizar etapas de uma tarefa");
        System.out.println("6. Filtrar tarefas por status");
        System.out.println("7. Filtrar tarefas por prioridade");
        System.out.println("8. Visualizar tarefas atrasadas");
        System.out.println("9. Excluir tarefa");
        System.out.println("10. Pesquisar tarefa por título");
        System.out.println("0. Sair");
        System.out.print("\nDigite sua opção: ");
    }

    /**
     * Lê a opção escolhida pelo usuário e trata possíveis erros
     */
    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            // Retorna uma opção inválida se o usuário não digitar um número
            return -1;
        }
    }

    /**
     * Processa a opção escolhida pelo usuário
     */
    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 0:
                executando = false;
                break;
            case 1:
                listarTarefas();
                break;
            case 2:
                adicionarTarefaSimples();
                break;
            case 3:
                adicionarTarefaComEtapas();
                break;
            case 4:
                alterarStatusTarefa();
                break;
            case 5:
                atualizarEtapasTarefa();
                break;
            case 6:
                filtrarTarefasPorStatus();
                break;
            case 7:
                filtrarTarefasPorPrioridade();
                break;
            case 8:
                listarTarefasAtrasadas();
                break;
            case 9:
                excluirTarefa();
                break;
            case 10:
                pesquisarTarefaPorTitulo();
                break;
            default:
                System.out.println("Opção inválida! Por favor, tente novamente.");
        }
    }

    /**
     * Lista todas as tarefas cadastradas
     */
    private void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== LISTA DE TAREFAS ===");
        for (Tarefa tarefa : tarefas) {
            System.out.println("\n" + tarefa);
            System.out.println("---------------------------");
        }
    }

    /**
     * Adiciona uma nova tarefa simples
     */
    private void adicionarTarefaSimples() {
        System.out.println("\n=== ADICIONAR NOVA TAREFA ===");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine().trim();
        
        LocalDate dataVencimento = lerData("Data de vencimento (dd/MM/yyyy): ");
        
        Prioridade prioridade = lerPrioridade();
        
        Tarefa novaTarefa = new Tarefa(titulo, descricao, dataVencimento, prioridade);
        tarefas.add(novaTarefa);
        
        System.out.println("\nTarefa adicionada com sucesso!");
    }

    /**
     * Adiciona uma nova tarefa com etapas
     */
    private void adicionarTarefaComEtapas() {
        System.out.println("\n=== ADICIONAR TAREFA COM ETAPAS ===");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine().trim();
        
        LocalDate dataVencimento = lerData("Data de vencimento (dd/MM/yyyy): ");
        
        Prioridade prioridade = lerPrioridade();
        
        List<String> etapas = new ArrayList<>();
        System.out.println("Digite as etapas (deixe em branco para encerrar):");
        
        int numeroEtapa = 1;
        while (true) {
            System.out.print("Etapa " + numeroEtapa + ": ");
            String etapa = scanner.nextLine().trim();
            
            if (etapa.isEmpty()) {
                break;
            }
            
            etapas.add(etapa);
            numeroEtapa++;
        }
        
        if (etapas.isEmpty()) {
            System.out.println("É necessário pelo menos uma etapa. Operação cancelada!");
            return;
        }
        
        TarefaComEtapas novaTarefa = new TarefaComEtapas(titulo, descricao, dataVencimento, prioridade, etapas);
        tarefas.add(novaTarefa);
        
        System.out.println("\nTarefa com etapas adicionada com sucesso!");
    }

    /**
     * Altera o status de uma tarefa
     */
    private void alterarStatusTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== ALTERAR STATUS DE TAREFA ===");
        
        Tarefa tarefa = selecionarTarefa();
        if (tarefa == null) return;
        
        System.out.println("\nStatus atual: " + tarefa.getStatus().getDescricao());
        System.out.println("\nSelecione o novo status:");
        System.out.println("1. Pendente");
        System.out.println("2. Em andamento");
        System.out.println("3. Concluída");
        System.out.println("4. Cancelada");
        
        System.out.print("\nDigite sua opção: ");
        int opcao = lerOpcao();
        
        switch (opcao) {
            case 1:
                tarefa.setStatus(Status.PENDENTE);
                break;
            case 2:
                tarefa.setStatus(Status.EM_ANDAMENTO);
                break;
            case 3:
                tarefa.setStatus(Status.CONCLUIDA);
                break;
            case 4:
                tarefa.setStatus(Status.CANCELADA);
                break;
            default:
                System.out.println("Opção inválida! Status não alterado.");
                return;
        }
        
        System.out.println("\nStatus alterado com sucesso!");
    }

    /**
     * Atualiza as etapas de uma tarefa
     */
    private void atualizarEtapasTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== ATUALIZAR ETAPAS DE TAREFA ===");
        
        // Filtramos apenas tarefas com etapas
        List<Tarefa> tarefasComEtapas = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa instanceof TarefaComEtapas) {
                tarefasComEtapas.add(tarefa);
            }
        }
        
        if (tarefasComEtapas.isEmpty()) {
            System.out.println("\nNão há tarefas com etapas cadastradas.");
            return;
        }
        
        System.out.println("\nSelecione a tarefa:");
        for (int i = 0; i < tarefasComEtapas.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tarefasComEtapas.get(i).getTitulo());
        }
        
        System.out.print("\nDigite o número da tarefa (0 para cancelar): ");
        int opcao = lerOpcao();
        
        if (opcao < 1 || opcao > tarefasComEtapas.size()) {
            System.out.println("Operação cancelada ou opção inválida.");
            return;
        }
        
        TarefaComEtapas tarefaSelecionada = (TarefaComEtapas) tarefasComEtapas.get(opcao - 1);
        List<String> etapas = tarefaSelecionada.getEtapas();
        List<Boolean> etapasConcluidas = tarefaSelecionada.getEtapasConcluidas();
        
        System.out.println("\nEtapas da tarefa '" + tarefaSelecionada.getTitulo() + "':");
        for (int i = 0; i < etapas.size(); i++) {
            System.out.printf("%d. %s [%s]\n", 
                    i + 1, 
                    etapas.get(i), 
                    etapasConcluidas.get(i) ? "✓" : " ");
        }
        
        System.out.print("\nDigite o número da etapa a ser alterada (0 para cancelar): ");
        int etapaOpcao = lerOpcao();
        
        if (etapaOpcao < 1 || etapaOpcao > etapas.size()) {
            System.out.println("Operação cancelada ou opção inválida.");
            return;
        }
        
        int indiceEtapa = etapaOpcao - 1;
        boolean statusAtual = etapasConcluidas.get(indiceEtapa);
        
        System.out.printf("A etapa '%s' está %s. Deseja marcá-la como %s? (S/N): ", 
                etapas.get(indiceEtapa), 
                statusAtual ? "concluída" : "pendente",
                statusAtual ? "pendente" : "concluída");
        
        String resposta = scanner.nextLine().trim().toUpperCase();
        
        if (resposta.equals("S")) {
            if (!statusAtual) {
                tarefaSelecionada.marcarEtapaConcluida(indiceEtapa);
                System.out.println("\nEtapa marcada como concluída!");
            } else {
                // Aqui precisamos de acesso direto, poderia ser implementado um método na classe
                System.out.println("\nFuncionalidade de desmarcar etapa não está disponível.");
            }
        } else {
            System.out.println("\nOperação cancelada.");
        }
    }

    /**
     * Filtra tarefas por status
     */
    private void filtrarTarefasPorStatus() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== FILTRAR TAREFAS POR STATUS ===");
        System.out.println("1. Pendente");
        System.out.println("2. Em andamento");
        System.out.println("3. Concluída");
        System.out.println("4. Cancelada");
        
        System.out.print("\nDigite sua opção: ");
        int opcao = lerOpcao();
        
        Status statusFiltro;
        switch (opcao) {
            case 1:
                statusFiltro = Status.PENDENTE;
                break;
            case 2:
                statusFiltro = Status.EM_ANDAMENTO;
                break;
            case 3:
                statusFiltro = Status.CONCLUIDA;
                break;
            case 4:
                statusFiltro = Status.CANCELADA;
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        System.out.println("\n=== TAREFAS COM STATUS: " + statusFiltro.getDescricao() + " ===");
        boolean encontrou = false;
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == statusFiltro) {
                System.out.println("\n" + tarefa);
                System.out.println("---------------------------");
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma tarefa encontrada com este status.");
        }
    }

    /**
     * Filtra tarefas por prioridade
     */
    private void filtrarTarefasPorPrioridade() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== FILTRAR TAREFAS POR PRIORIDADE ===");
        System.out.println("1. Baixa");
        System.out.println("2. Média");
        System.out.println("3. Alta");
        System.out.println("4. Urgente");
        
        System.out.print("\nDigite sua opção: ");
        int opcao = lerOpcao();
        
        if (opcao < 1 || opcao > 4) {
            System.out.println("Opção inválida!");
            return;
        }
        
        Prioridade prioridadeFiltro = Prioridade.fromValor(opcao);
        
        System.out.println("\n=== TAREFAS COM PRIORIDADE: " + prioridadeFiltro + " ===");
        boolean encontrou = false;
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getPrioridade() == prioridadeFiltro) {
                System.out.println("\n" + tarefa);
                System.out.println("---------------------------");
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma tarefa encontrada com esta prioridade.");
        }
    }

    /**
     * Lista tarefas atrasadas
     */
    private void listarTarefasAtrasadas() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== TAREFAS ATRASADAS ===");
        boolean encontrou = false;
        
        // Usando uma expressão lambda para ordenar por prioridade
        List<Tarefa> tarefasAtrasadas = new ArrayList<>();
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.estaAtrasada()) {
                tarefasAtrasadas.add(tarefa);
                encontrou = true;
            }
        }
        
        // Ordenando por prioridade (mais alta primeiro)
        tarefasAtrasadas.sort(Comparator.comparing(t -> t.getPrioridade().getValor() * -1));
        
        for (Tarefa tarefa : tarefasAtrasadas) {
            System.out.println("\n" + tarefa);
            System.out.println("---------------------------");
        }
        
        if (!encontrou) {
            System.out.println("Não há tarefas atrasadas.");
        }
    }

    /**
     * Exclui uma tarefa
     */
    private void excluirTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== EXCLUIR TAREFA ===");
        
        Tarefa tarefa = selecionarTarefa();
        if (tarefa == null) return;
        
        System.out.print("\nTem certeza que deseja excluir a tarefa '" + tarefa.getTitulo() + "'? (S/N): ");
        String confirmacao = scanner.nextLine().trim().toUpperCase();
        
        if (confirmacao.equals("S")) {
            tarefas.remove(tarefa);
            System.out.println("\nTarefa excluída com sucesso!");
        } else {
            System.out.println("\nOperação cancelada.");
        }
    }

    /**
     * Pesquisa uma tarefa por título
     */
    private void pesquisarTarefaPorTitulo() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas cadastradas.");
            return;
        }
        
        System.out.println("\n=== PESQUISAR TAREFA POR TÍTULO ===");
        System.out.print("Digite o termo de pesquisa: ");
        String termo = scanner.nextLine().trim().toLowerCase();
        
        if (termo.isEmpty()) {
            System.out.println("Termo de pesquisa inválido!");
            return;
        }
        
        System.out.println("\nResultados da pesquisa:");
        boolean encontrou = false;
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().toLowerCase().contains(termo)) {
                System.out.println("\n" + tarefa);
                System.out.println("---------------------------");
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma tarefa encontrada com o termo: " + termo);
        }
    }

    /**
     * Método auxiliar para selecionar uma tarefa da lista
     */
    private Tarefa selecionarTarefa() {
        System.out.println("\nSelecione a tarefa:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tarefas.get(i).getTitulo());
        }
        
        System.out.print("\nDigite o número da tarefa (0 para cancelar): ");
        int opcao = lerOpcao();
        
        if (opcao < 1 || opcao > tarefas.size()) {
            System.out.println("Operação cancelada ou opção inválida.");
            return null;
        }
        
        return tarefas.get(opcao - 1);
    }

    /**
     * Método auxiliar para ler uma data do usuário
     */
    private LocalDate lerData(String mensagem) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = null;
        
        while (data == null) {
            try {
                System.out.print(mensagem);
                String entrada = scanner.nextLine().trim();
                data = LocalDate.parse(entrada, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido! Use o formato dd/MM/yyyy.");
            }
        }
        
        return data;
    }

    /**
     * Método auxiliar para ler a prioridade do usuário
     */
    private Prioridade lerPrioridade() {
        System.out.println("Selecione a prioridade:");
        System.out.println("1. Baixa");
        System.out.println("2. Média");
        System.out.println("3. Alta");
        System.out.println("4. Urgente");
        
        while (true) {
            System.out.print("Digite sua opção: ");
            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                if (opcao >= 1 && opcao <= 4) {
                    return Prioridade.fromValor(opcao);
                } else {
                    System.out.println("Opção inválida! Digite um número entre 1 e 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }
}




/**
*Conceitos demonstrados neste código
*
1 Orientação a Objetos

Classes e objetos
Herança (TarefaComEtapas estendendo Tarefa)
Encapsulamento (atributos privados com getters/setters)
Polimorfismo (sobrescrita do método toString)
2 Estruturas de Dados

 ArrayList para gerenciar coleções
Enumerações (Prioridade e Status)
3 Tratamento de Exceções

Try-catch para tratamento de erros de entrada
4 Manipulação de Datas

Uso da API Java Time (LocalDate)
Formatação de datas
5 Interface de Usuário

Menu interativo
Sistema de console com entrada/saída de dados
6 Programação Funcional

Uso de expressões lambda e Comparator
Lógica de Negócios

Verificação de tarefas atrasadas
Cálculo de progresso das etapas
Filtragem de tarefas por diferentes critérios
Este projeto serve como um bom exemplo de aplicação Java com várias funcionalidades práticas e demonstra diversos conceitos fundamentais da linguagem.

*/