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

public class GestionAnimal extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtPeso;
    private JTextField txtFechaNacimiento;
    private JTextField txtRaza;
    private JTextField txtEstado;
    private JTextField txtCodigoFinca;
    private JTextField txtCodigoPotrero;

    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnAtras; // Nuevo botón "Atrás"

    public GestionAnimal() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Animales");

        JLabel lblCodigo = new JLabel("Código:");
        txtCodigo = new JTextField(10);

        JLabel lblPeso = new JLabel("Peso:");
        txtPeso = new JTextField(10);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        txtFechaNacimiento = new JTextField(10);

        JLabel lblRaza = new JLabel("Raza:");
        txtRaza = new JTextField(20);

        JLabel lblEstado = new JLabel("Estado:");
        txtEstado = new JTextField(10);

        JLabel lblCodigoFinca = new JLabel("Código Finca:");
        txtCodigoFinca = new JTextField(10);

        JLabel lblCodigoPotrero = new JLabel("Código Potrero:");
        txtCodigoPotrero = new JTextField(10);

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
                eliminarAnimal();
            }
        });

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarAnimal();
            }
        });

        btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar al presionar "Atrás"
                // En este caso, simplemente cerrar la ventana actual
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
        horizontalBoxBtns.add(btnAtras); // Agregamos el botón "Atrás"
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
                                                        .addComponent(lblCodigo)
                                                        .addComponent(lblPeso)
                                                        .addComponent(lblFechaNacimiento)
                                                        .addComponent(lblRaza)
                                                        .addComponent(lblEstado)
                                                        .addComponent(lblCodigoFinca)
                                                        .addComponent(lblCodigoPotrero))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCodigo)
                                                        .addComponent(txtPeso)
                                                        .addComponent(txtFechaNacimiento)
                                                        .addComponent(txtRaza)
                                                        .addComponent(txtEstado)
                                                        .addComponent(txtCodigoFinca)
                                                        .addComponent(txtCodigoPotrero)))
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
                                        .addComponent(lblCodigo)
                                        .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPeso)
                                        .addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFechaNacimiento)
                                        .addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblRaza)
                                        .addComponent(txtRaza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEstado)
                                        .addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoFinca)
                                        .addComponent(txtCodigoFinca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoPotrero)
                                        .addComponent(txtCodigoPotrero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

            String codigo = txtCodigo.getText();
            float peso = Float.parseFloat(txtPeso.getText());
            // Cambio: Parsea la fecha como un objeto java.sql.Date
            java.sql.Date fechaNacimiento = java.sql.Date.valueOf(txtFechaNacimiento.getText());
            System.out.println(fechaNacimiento);
            String raza = txtRaza.getText();
            String estado = txtEstado.getText();
            String codigoFinca = txtCodigoFinca.getText();
            String codigoPotrero = txtCodigoPotrero.getText();

            String sql = "INSERT INTO Animal(codigo, peso, fechaNacimiento, raza, estado, codigo_finca, codigo_potrero) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigo);
                preparedStatement.setFloat(2, peso);
                // Cambio: Utiliza setDate en lugar de setString para la fecha
                preparedStatement.setDate(3, fechaNacimiento);
                preparedStatement.setString(4, raza);
                preparedStatement.setString(5, estado);
                preparedStatement.setString(6, codigoFinca);
                preparedStatement.setString(7, codigoPotrero);

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos del animal insertados correctamente.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar datos del animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void eliminarAnimal() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigo = txtCodigo.getText();

            String sql = "DELETE FROM Animal WHERE codigo = ?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigo);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Animal eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún animal con el código especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar el animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void modificarAnimal() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigo = txtCodigo.getText();
            float nuevoPeso = Float.parseFloat(txtPeso.getText());
            String nuevaFechaNacimiento = txtFechaNacimiento.getText();
            String nuevaRaza = txtRaza.getText();
            String nuevoEstado = txtEstado.getText();
            String nuevoCodigoFinca = txtCodigoFinca.getText();
            String nuevoCodigoPotrero = txtCodigoPotrero.getText();

            String sql = "UPDATE Animal SET peso=?, fechanacimiento=?, raza=?, estado=?, codigo_finca=?, codigo_potrero=? WHERE codigo=?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setFloat(1, nuevoPeso);
                preparedStatement.setString(2, nuevaFechaNacimiento);
                preparedStatement.setString(3, nuevaRaza);
                preparedStatement.setString(4, nuevoEstado);
                preparedStatement.setString(5, nuevoCodigoFinca);
                preparedStatement.setString(6, nuevoCodigoPotrero);
                preparedStatement.setString(7, codigo);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Datos del animal modificados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún animal con el código especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar datos del animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                new GestionAnimal().setVisible(true);
            }
        });
    }
}
