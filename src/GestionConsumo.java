
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

public class GestionConsumo extends JFrame {

    private JTextField txtCodigoFinca;
    private JTextField txtFecha;
    private JTextField txtCantidad;
    private JTextField txtTipoAgua;
    private JTextField txtTipoUso;

    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnAtras;

    public GestionConsumo() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Consumo de Agua");

        JLabel lblCodigoFinca = new JLabel("Código Finca:");
        txtCodigoFinca = new JTextField(10);

        JLabel lblFecha = new JLabel("Fecha:");
        txtFecha = new JTextField(20);

        JLabel lblCantidad = new JLabel("Cantidad:");
        txtCantidad = new JTextField(10);

        JLabel lblTipoAgua = new JLabel("Tipo de Agua:");
        txtTipoAgua = new JTextField(10);

        JLabel lblTipoUso = new JLabel("Tipo de Uso:");
        txtTipoUso = new JTextField(10);

        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarConsumo();
            }
        });

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarConsumo();
            }
        });

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarConsumo();
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
                                                        .addComponent(lblFecha)
                                                        .addComponent(lblCantidad)
                                                        .addComponent(lblTipoAgua)
                                                        .addComponent(lblTipoUso))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCodigoFinca)
                                                        .addComponent(txtFecha)
                                                        .addComponent(txtCantidad)
                                                        .addComponent(txtTipoAgua)
                                                        .addComponent(txtTipoUso)))
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
                                        .addComponent(lblFecha)
                                        .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCantidad)
                                        .addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTipoAgua)
                                        .addComponent(txtTipoAgua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTipoUso)
                                        .addComponent(txtTipoUso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horizontalBoxBtns)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        pack();
    }

    private void insertarConsumo() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();
            String fecha = txtFecha.getText();
            float cantidad = Float.parseFloat(txtCantidad.getText());
            String tipoAgua = txtTipoAgua.getText();
            String tipoUso = txtTipoUso.getText();

            String sql = "INSERT INTO ConsumoAgua(codigo_finca, fecha, cantidad, tipoAgua, tipoUso) VALUES (?, ?, ?, ?, ?)";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoFinca);
                preparedStatement.setString(2, fecha);
                preparedStatement.setFloat(3, cantidad);
                preparedStatement.setString(4, tipoAgua);
                preparedStatement.setString(5, tipoUso);

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos de consumo insertados correctamente.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar datos de consumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void eliminarConsumo() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();

            String sql = "DELETE FROM ConsumoAgua WHERE codigo_finca = ?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoFinca);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Datos de consumo eliminados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún consumo con el código de finca especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar datos de consumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void modificarConsumo() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigoFinca = txtCodigoFinca.getText();
            String nuevaFecha = txtFecha.getText();
            float nuevaCantidad = Float.parseFloat(txtCantidad.getText());
            String nuevoTipoAgua = txtTipoAgua.getText();
            String nuevoTipoUso = txtTipoUso.getText();

            String sql = "UPDATE ConsumoAgua SET fecha=?, cantidad=?, tipoAgua=?, tipoUso=? WHERE codigo_finca=?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nuevaFecha);
                preparedStatement.setFloat(2, nuevaCantidad);
                preparedStatement.setString(3, nuevoTipoAgua);
                preparedStatement.setString(4, nuevoTipoUso);
                preparedStatement.setString(5, codigoFinca);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Datos de consumo modificados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún consumo con el código de finca especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar datos de consumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                new GestionConsumo().setVisible(true);
            }
        });
    }
}
