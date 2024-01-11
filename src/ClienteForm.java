import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteForm {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField enderecoField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField cnpjField;
    private JButton salvarButton;
    private JButton cancelarButton;

    public ClienteForm() {

        initComponents();

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    String sql = "INSERT INTO ClienteDBO (nome, endereco, email, telefone, cnpj) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, nomeField.getText());
                    preparedStatement.setString(2, enderecoField.getText());
                    preparedStatement.setString(3, emailField.getText());
                    preparedStatement.setString(4, telefoneField.getText());
                    preparedStatement.setString(5, cnpjField.getText());
                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!");
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione aqui a lógica para cancelar a operação, se necessário
                JOptionPane.showMessageDialog(null, "Operação cancelada");
            }
        });
    }

    private void initComponents() {
        mainPanel = new JPanel();
        nomeField = new JTextField();
        enderecoField = new JTextField();
        emailField = new JTextField();
        telefoneField = new JTextField();
        cnpjField = new JTextField();
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        // Configurar layout para um componente por linha
        mainPanel.setLayout(new GridLayout(6, 2));
        mainPanel.add(new JLabel("Nome:"));
        mainPanel.add(nomeField);
        mainPanel.add(new JLabel("Endereço:"));
        mainPanel.add(enderecoField);
        mainPanel.add(new JLabel("Email:"));
        mainPanel.add(emailField);
        mainPanel.add(new JLabel("Telefone:"));
        mainPanel.add(telefoneField);
        mainPanel.add(new JLabel("CNPJ:"));
        mainPanel.add(cnpjField);
        mainPanel.add(salvarButton);
        mainPanel.add(cancelarButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Cadastro de Cliente");
                frame.setJMenuBar(createMenuBar());
                frame.setContentPane(new ClienteForm().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);  // Configurar o tamanho da janela
                frame.setVisible(true);
            }
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

        // Adicionar ActionListener para itens de menu específicos
        imprimirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir a caixa de diálogo de impressão do Windows
                PrinterJob job = PrinterJob.getPrinterJob();
                if (job.printDialog()) {
                    // Lógica para impressão
                    // ...
                }
            }
        });

        sobreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para exibir a tela "Sobre"
                JOptionPane.showMessageDialog(null,
                        "Autor: Wellington Neves\nVersão: 1.0",
                        "Sobre",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return menuBar;
    }
}
