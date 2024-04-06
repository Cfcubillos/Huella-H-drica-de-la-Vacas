
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class GestionPotreros extends JFrame {

    private JTextField txtCodigoFinca;
    private JTextField txtCodigo;
    private JTextField txtArea;
    private JTextField txtCapacidadAgua;

    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnAtras;

    public GestionPotreros() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Potreros");

        JLabel lblCodigoFinca = new JLabel("Código Finca:");
        txtCodigoFinca = new JTextField(10);

        JLabel lblCodigo = new JLabel("Código:");
        txtCodigo = new JTextField(10);

        JLabel lblArea = new JLabel("Área:");
        txtArea = new JTextField(10);

        JLabel lblCapacidadAgua = new JLabel("Capacidad de Agua:");
        txtCapacidadAgua = new JTextField(10);

        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarDatos();
            }
        });

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPotrero();
            }
        });

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarPotrero();
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
        horizontalBoxBtns.add(Box.createHorizontalGlue());

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
                                                        .addComponent(lblCodigo)
                                                        .addComponent(lblArea)
                                                        .addComponent(lblCapacidadAgua))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCodigoFinca)
                                                        .addComponent(txtCodigo)
                                                        .addComponent(txtArea)
                                                        .addComponent(txtCapacidadAgua)))
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
                                        .addComponent(lblCodigo)
                                        .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblArea)
                                        .addComponent(txtArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCapacidadAgua)
                                        .addComponent(txtCapacidadAgua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horizontalBoxBtns)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        pack();
    }

    private void insertarDatos() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();
            String codigo = txtCodigo.getText();
            float area = Float.parseFloat(txtArea.getText());
            float capacidadAgua = Float.parseFloat(txtCapacidadAgua.getText());

            String sql = "INSERT INTO Potrero(codigo_finca, codigo, areaPotrero, capacidadAgua) VALUES (?, ?, ?, ?)";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoFinca);
                preparedStatement.setString(2, codigo);
                preparedStatement.setFloat(3, area);
                preparedStatement.setFloat(4, capacidadAgua);

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos del potrero insertados correctamente.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar datos del potrero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void eliminarPotrero() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigo = txtCodigo.getText();

            String sql = "DELETE FROM Potrero WHERE codigo = ?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigo);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Potrero eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún potrero con el código especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar el potrero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void modificarPotrero() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();
            String codigo = txtCodigo.getText();
            float nuevaArea = Float.parseFloat(txtArea.getText());
            float nuevaCapacidadAgua = Float.parseFloat(txtCapacidadAgua.getText());

            String sql = "UPDATE Potrero SET codigo_finca=?, areaPotrero=?, capacidadAgua=? WHERE codigo=?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoFinca);
                preparedStatement.setFloat(2, nuevaArea);
                preparedStatement.setFloat(3, nuevaCapacidadAgua);
                preparedStatement.setString(4, codigo);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Datos del potrero modificados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún potrero con el código especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar datos del potrero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                new GestionPotreros().setVisible(true);
            }
        });
    }
}
