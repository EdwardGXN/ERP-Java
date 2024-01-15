import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

// Incio do codigo. Falta incorporar partes de conexão e execução.
// Metodos de icnlusão, exclusão etc vão ser incorporados após a junção de todo o sistema.

public class SistemaFinanceiro {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Financeiro");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Clientes e Fornecedores", criarClientesFornecedoresPanel());
            tabbedPane.addTab("Contas a Pagar", criarContasPagarPanel());
            tabbedPane.addTab("Contas a Receber", criarContasReceberPanel());
            tabbedPane.addTab("Contas Correntes", criarContasCorrentesPanel());
            tabbedPane.addTab("Relatórios", criarRelatoriosPanel());

            frame.getContentPane().add(tabbedPane);
            frame.setVisible(true);
        });
    }

    private static JPanel criarClientesFornecedoresPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        adicionarHyperlink(panel, "Incluir Clientes", "ClientesDBO");
        adicionarHyperlink(panel, "Importar Planilha de Clientes", "ClientesDBO");
        adicionarHyperlink(panel, "Exibir Todos os Clientes", "ClientesDBO");
        adicionarHyperlink(panel, "Incluir Fornecedores", "FornecedorDBO");
        adicionarHyperlink(panel, "Importar Planilha de Fornecedores", "FornecedorDBO");
        adicionarHyperlink(panel, "Exibir Todos os Fornecedores", "FornecedorDBO");

        return panel;
    }

    private static JPanel criarContasPagarPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        adicionarHyperlink(panel, "Incluir Contas a Pagar", "ContasPagarDBO");
        adicionarHyperlink(panel, "Importar Planilha de Contas a Pagar", "ContasPagarDBO");
        adicionarHyperlink(panel, "Exibir Todas as Contas a Pagar", "ContasPagarDBO");
        adicionarHyperlink(panel, "Registrar Pagamentos", "ContasPagarDBO");

        return panel;
    }

    private static JPanel criarContasReceberPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        adicionarHyperlink(panel, "Incluir Contas a Receber", "ContasReceberDBO");
        adicionarHyperlink(panel, "Importar Planilha de Contas a Receber", "ContasReceberDBO");
        adicionarHyperlink(panel, "Exibir Todas as Contas a Receber", "ContasReceberDBO");
        adicionarHyperlink(panel, "Registrar Recebimentos", "ContasReceberDBO");

        return panel;
    }

    private static JPanel criarContasCorrentesPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        adicionarHyperlink(panel, "Incluir Contas Correntes", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Exibir Todas as Contas Correntes", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Movimentação de Contas Correntes", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Incluir Lançamento", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Incluir Transferência", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Importar Extrato", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Exibir o Extrato das Contas", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Integração com o Banco", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Gerar Remessa da Cobrança", "ContasCorrentesDBO");
        adicionarHyperlink(panel, "Importar Retorno da Cobrança", "ContasCorrentesDBO");

        return panel;
    }

    private static JPanel criarRelatoriosPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2));

        adicionarHyperlink(panel, "Contas a Pagar - Relatório", "ContasPagarDBO");
        adicionarHyperlink(panel, "Pagamentos Realizados", "ContasPagarDBO");
        adicionarHyperlink(panel, "Contas a Receber - Relatório", "ContasReceberDBO");
        adicionarHyperlink(panel, "Recebimentos Realizados", "ContasReceberDBO");
        adicionarHyperlink(panel, "Fluxo de Caixa", "FluxoCaixaDBO");
        adicionarHyperlink(panel, "DRE (Demonstrativo de Resultados)", "DREDBO");
        adicionarHyperlink(panel, "Resumo Executivo", "ResumoExecutivoDBO");
        adicionarHyperlink(panel, "Clientes e Fornecedores", "ClientesFornecedoresDBO");
        adicionarHyperlink(panel, "Atividades dos Usuários", "AtividadesUsuariosDBO");
        adicionarHyperlink(panel, "Comissão de Vendas", "ComissaoVendasDBO");

        return panel;
    }

    private static void adicionarHyperlink(JPanel panel, String texto, String link) {
        JButton botao = new JButton(texto);
        botao.addActionListener(e -> abrirLink(link));
        panel.add(botao);
    }

    private static void abrirLink(String link) {
        switch (link) {
            case "ClientesDBO":
                abrirJanelaConsultaClientes();
                break;
            case "FornecedorDBO":
                abrirJanelaConsultaFornecedores();
                break;
            case "ContasPagarDBO":
                abrirJanelaContasPagar();
                break;
            case "ContasReceberDBO":
                abrirJanelaContasReceber();
                break;
            case "ContasCorrentesDBO":
                abrirJanelaContasCorrentes();
                break;
            case "FluxoCaixaDBO":
                abrirJanelaFluxoCaixa();
                break;
            case "DREDBO":
                abrirJanelaDRE();
                break;
            case "ResumoExecutivoDBO":
                abrirJanelaResumoExecutivo();
                break;
            case "ClientesFornecedoresDBO":
                abrirJanelaRelatorioClientesFornecedores();
                break;
            case "AtividadesUsuariosDBO":
                abrirJanelaAtividadesUsuarios();
                break;
            case "ComissaoVendasDBO":
                abrirJanelaComissaoVendas();
                break;
            default:
                System.out.println("Link não reconhecido: " + link);
        }
    }

    // Falta incluir funções no codigo abaixo, apenas de exemplo interface. (aguardando finalização DB)
    private static void abrirJanelaConsultaClientes() {
        System.out.println("Abrindo janela de consulta de clientes");
    }

    private static void abrirJanelaConsultaFornecedores() {
        System.out.println("Abrindo janela de consulta de fornecedores");
    }

    private static void abrirJanelaContasPagar() {
        System.out.println("Abrindo janela de contas a pagar");
    }

    private static void abrirJanelaContasReceber() {
        System.out.println("Abrindo janela de contas a receber");
    }

    private static void abrirJanelaContasCorrentes() {
        System.out.println("Abrindo janela de contas correntes");
    }

    private static void abrirJanelaFluxoCaixa() {
        System.out.println("Abrindo janela de fluxo de caixa");
    }

    private static void abrirJanelaDRE() {
        System.out.println("Abrindo janela de DRE (Demonstrativo de Resultados)");
    }

    private static void abrirJanelaResumoExecutivo() {
        System.out.println("Abrindo janela de resumo executivo");
    }

    private static void abrirJanelaRelatorioClientesFornecedores() {
        System.out.println("Abrindo janela de relatório de clientes e fornecedores");
    }

    private static void abrirJanelaAtividadesUsuarios() {
        System.out.println("Abrindo janela de atividades dos usuários");
    }

    private static void abrirJanelaComissaoVendas() {
        System.out.println("Abrindo janela de comissão de vendas");
    }


    public static void SistemaFinanceiro(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Financeiro");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Clientes e Fornecedores", criarClientesFornecedoresPanel());
            tabbedPane.addTab("Contas a Pagar", criarContasPagarPanel());
            tabbedPane.addTab("Contas a Receber", criarContasReceberPanel());
            tabbedPane.addTab("Contas Correntes", criarContasCorrentesPanel());
            tabbedPane.addTab("Relatórios", criarRelatoriosPanel());

            frame.getContentPane().add(tabbedPane);
            frame.setVisible(true);
        });
    }
}