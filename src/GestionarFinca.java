
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

public class GestionarFinca extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtHumedad;
    private JTextField txtPrecipitacion;
    private JTextField txtCodigoDepartamento;
    private JTextField txtCodigoMunicipio;
    private JTextField txtCodigoVereda;

    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnAtras; // Nuevo botón "Atrás"

    public GestionarFinca() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Insertar Datos Finca");

        JLabel lblCodigo = new JLabel("Código:");
        txtCodigo = new JTextField(10);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);

        JLabel lblHumedad = new JLabel("Humedad:");
        txtHumedad = new JTextField(10);

        JLabel lblPrecipitacion = new JLabel("Precipitación:");
        txtPrecipitacion = new JTextField(10);

        JLabel lblCodigoDepartamento = new JLabel("Código Departamento:");
        txtCodigoDepartamento = new JTextField(10);

        JLabel lblCodigoMunicipio = new JLabel("Código Municipio:");
        txtCodigoMunicipio = new JTextField(10);

        JLabel lblCodigoVereda = new JLabel("Código Vereda:");
        txtCodigoVereda = new JTextField(10);

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
                eliminarFinca();
            }
        });

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarFinca();
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

        // Resto del código...
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
                                                        .addComponent(lblNombre)
                                                        .addComponent(lblHumedad)
                                                        .addComponent(lblPrecipitacion)
                                                        .addComponent(lblCodigoDepartamento)
                                                        .addComponent(lblCodigoMunicipio)
                                                        .addComponent(lblCodigoVereda))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCodigo)
                                                        .addComponent(txtNombre)
                                                        .addComponent(txtHumedad)
                                                        .addComponent(txtPrecipitacion)
                                                        .addComponent(txtCodigoDepartamento)
                                                        .addComponent(txtCodigoMunicipio)
                                                        .addComponent(txtCodigoVereda)))
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
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblHumedad)
                                        .addComponent(txtHumedad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPrecipitacion)
                                        .addComponent(txtPrecipitacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoDepartamento)
                                        .addComponent(txtCodigoDepartamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoMunicipio)
                                        .addComponent(txtCodigoMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoVereda)
                                        .addComponent(txtCodigoVereda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
            String nombre = txtNombre.getText();
            float humedad = Float.parseFloat(txtHumedad.getText());
            float precipitacion = Float.parseFloat(txtPrecipitacion.getText());
            String codigoDepartamento = txtCodigoDepartamento.getText();
            String codigoMunicipio = txtCodigoMunicipio.getText();
            String codigoVereda = txtCodigoVereda.getText();

            String sql = "INSERT INTO Finca(codigo, nombre, humedad, precipitacion, codigo_departamento, codigo_municipio, codigo_vereda) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigo);
                preparedStatement.setString(2, nombre);
                preparedStatement.setFloat(3, humedad);
                preparedStatement.setFloat(4, precipitacion);
                preparedStatement.setString(5, codigoDepartamento);
                preparedStatement.setString(6, codigoMunicipio);
                preparedStatement.setString(7, codigoVereda);

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Datos insertados correctamente.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void eliminarFinca() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigo = txtCodigo.getText();

            String sql = "DELETE FROM Finca WHERE codigo = ?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigo);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Finca eliminada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ninguna finca con el código especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar la finca: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void modificarFinca() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/huella_hidrica";
            String usuario = "root";
            String contraseña = "";

            connection = DriverManager.getConnection(url, usuario, contraseña);

            String codigo = txtCodigo.getText();
            String nuevoNombre = txtNombre.getText();
            float nuevaHumedad = Float.parseFloat(txtHumedad.getText());
            float nuevaPrecipitacion = Float.parseFloat(txtPrecipitacion.getText());
            String nuevoCodigoDepartamento = txtCodigoDepartamento.getText();
            String nuevoCodigoMunicipio = txtCodigoMunicipio.getText();
            String nuevoCodigoVereda = txtCodigoVereda.getText();

            String sql = "UPDATE Finca SET nombre=?, humedad=?, precipitacion=?, codigo_departamento=?, codigo_municipio=?, codigo_vereda=? WHERE codigo=?";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nuevoNombre);
                preparedStatement.setFloat(2, nuevaHumedad);
                preparedStatement.setFloat(3, nuevaPrecipitacion);
                preparedStatement.setString(4, nuevoCodigoDepartamento);
                preparedStatement.setString(5, nuevoCodigoMunicipio);
                preparedStatement.setString(6, nuevoCodigoVereda);
                preparedStatement.setString(7, codigo);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Datos de la finca modificados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ninguna finca con el código especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar datos de la finca: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                new GestionarFinca().setVisible(true);
            }
        });
    }
}
