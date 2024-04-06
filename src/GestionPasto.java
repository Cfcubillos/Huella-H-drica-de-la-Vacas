
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

public class GestionPasto extends JFrame {

    private JTextField txtCodigoFinca;
    private JTextField txtCodigoPotrero;
    private JTextField txtIdPasto;

    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnAtras;

    public GestionPasto() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Pasto en Potreros");

        JLabel lblCodigoFinca = new JLabel("Código de Finca:");
        txtCodigoFinca = new JTextField(10);

        JLabel lblCodigoPotrero = new JLabel("Código de Potrero:");
        txtCodigoPotrero = new JTextField(10);

        JLabel lblIdPasto = new JLabel("ID de Pasto:");
        txtIdPasto = new JTextField(10);

        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarPasto();
            }
        });

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPasto();
            }
        });

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarPasto();
            }
        });

        btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionModulos gestionModulos = new GestionModulos();
                gestionModulos.setVisible(true);
                dispose();
            }
        });

        Box horizontalBoxBtns = Box.createHorizontalBox();
        horizontalBoxBtns.add(Box.createHorizontalGlue());
        horizontalBoxBtns.add(btnInsertar);
        horizontalBoxBtns.add(Box.createHorizontalGlue());
        horizontalBoxBtns.add(btnEliminar);
        horizontalBoxBtns.add(Box.createHorizontalGlue());
        horizontalBoxBtns.add(btnModificar);
        horizontalBoxBtns.add(Box.createHorizontalGlue());
        horizontalBoxBtns.add(btnAtras);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblCodigoFinca)
                                                        .addComponent(lblCodigoPotrero)
                                                        .addComponent(lblIdPasto))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCodigoFinca)
                                                        .addComponent(txtCodigoPotrero)
                                                        .addComponent(txtIdPasto)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(horizontalBoxBtns)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoFinca)
                                        .addComponent(txtCodigoFinca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoPotrero)
                                        .addComponent(txtCodigoPotrero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblIdPasto)
                                        .addComponent(txtIdPasto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horizontalBoxBtns)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        pack();
    }

    private void insertarPasto() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();
            String codigoPotrero = txtCodigoPotrero.getText();
            String idPasto = txtIdPasto.getText();

            // Aquí debes ajustar la sentencia SQL según la estructura de tu tabla Potrero_Pasto
            String sql = "INSERT INTO Potrero_Pasto(Codigo_finca, Codigo_potrero, codigo_pasto) VALUES (?, ?, ?)";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoFinca);
                preparedStatement.setString(2, codigoPotrero);
                preparedStatement.setString(3, idPasto);

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos de pasto insertados correctamente en el potrero.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar datos de pasto en el potrero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void eliminarPasto() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();
            String codigoPotrero = txtCodigoPotrero.getText();
            String idPasto = txtIdPasto.getText();

            // Ajusta la sentencia SQL según la estructura de tu tabla Potrero_Pasto
            String sql = "DELETE FROM Potrero_Pasto WHERE Codigo_finca = ? AND Codigo_potrero = ? AND codigo_pasto = ?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoFinca);
                preparedStatement.setString(2, codigoPotrero);
                preparedStatement.setString(3, idPasto);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Datos de pasto eliminados correctamente del potrero.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún registro de pasto con los datos especificados.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar datos de pasto del potrero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void modificarPasto() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();
            String codigoPotrero = txtCodigoPotrero.getText();
            String idPasto = txtIdPasto.getText();

            // Ajusta la sentencia SQL según la estructura de tu tabla Potrero_Pasto
            String sql = "UPDATE Potrero_Pasto SET Codigo_finca=?, Codigo_potrero=? WHERE Codigo_pasto=?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoFinca);
                preparedStatement.setString(2, codigoPotrero);
                preparedStatement.setString(3, idPasto);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Datos de pasto modificados correctamente en el potrero.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún registro de pasto con los datos especificados.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar datos de pasto en el potrero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionPasto().setVisible(true);
            }
        });
    }
}
