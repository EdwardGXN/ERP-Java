import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorForm {
    private JPanel mainPanel;
    private JTextField cnpjField;
    private JTextField nomeField;
    private JTextField enderecoField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField whatsappField;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JButton whatsappButton;

    public FornecedorForm() {
        initComponents();

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    String sql = "INSERT INTO FornecedorDBO (cnpj, nome, endereco, email, telefone, whatsapp) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, cnpjField.getText());
                    preparedStatement.setString(2, nomeField.getText());
                    preparedStatement.setString(3, enderecoField.getText());
                    preparedStatement.setString(4, emailField.getText());
                    preparedStatement.setString(5, telefoneField.getText());
                    preparedStatement.setString(6, whatsappField.getText());
                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!");
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar o fornecedor!");
                }
            }
        });

        cancelarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Operação cancelada"));

        whatsappButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://wa.me/" + whatsappField.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o WhatsApp!");
            }
        });
    }
// Aqui pra baixo é mexer e dá ruim! Deixa queto do jeito que tá. Deus sabe o que faz.

    private void initComponents() {
        mainPanel = new JPanel();
        cnpjField = new JTextField();
        nomeField = new JTextField();
        enderecoField = new JTextField();
        emailField = new JTextField();
        telefoneField = new JTextField();
        whatsappField = new JTextField();
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");
        whatsappButton = new JButton("Abrir WhatsApp");
        whatsappButton.setBackground(new Color(144, 238, 144));

        mainPanel.setLayout(new GridLayout(0, 2));
        mainPanel.add(new JLabel("CNPJ:"));
        mainPanel.add(cnpjField);
        mainPanel.add(new JLabel("Nome:"));
        mainPanel.add(nomeField);
        mainPanel.add(new JLabel("Endereço:"));
        mainPanel.add(enderecoField);
        mainPanel.add(new JLabel("Email:"));
        mainPanel.add(emailField);
        mainPanel.add(new JLabel("Telefone:"));
        mainPanel.add(telefoneField);
        mainPanel.add(new JLabel("WhatsApp:"));
        mainPanel.add(whatsappField);
        mainPanel.add(salvarButton);
        mainPanel.add(cancelarButton);
        mainPanel.add(whatsappButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cadastro de Fornecedor");
            frame.setJMenuBar(createMenuBar());
            frame.setContentPane(new FornecedorForm().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setVisible(true);
        });
    }

    private static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenuItem salvarItem = new JMenuItem("Salvar");
        JMenuItem imprimirItem = new JMenuItem("Imprimir");
        JMenuItem sairItem = new JMenuItem("Sair");

        JMenu ajudaMenu = new JMenu("Ajuda");
        JMenuItem sobreItem = new JMenuItem("Sobre");

        arquivoMenu.add(salvarItem);
        arquivoMenu.add(imprimirItem);
        arquivoMenu.addSeparator();
        arquivoMenu.add(sairItem);

        ajudaMenu.add(sobreItem);

        menuBar.add(arquivoMenu);
        menuBar.add(ajudaMenu);

        // Itens do menu, falta adicionar funções completas.
        imprimirItem.addActionListener(e -> imprimirFormulario());
        sobreItem.addActionListener(e -> mostrarSobre());

        return menuBar;
    }

    private static void imprimirFormulario() {
        PrinterJob job = PrinterJob.getPrinterJob();
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, "Falha na impressão: " + ex.getMessage());
            }
        }
    }

    private static void mostrarSobre() {
        JOptionPane.showMessageDialog(null, "Autor: Wellington Neves\nVersão 1.0", "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }
}

// Adicionar conexões e auxiliares abaixo
