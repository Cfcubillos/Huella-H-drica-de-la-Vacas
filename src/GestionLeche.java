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

public class GestionLeche extends JFrame {

    private JTextField txtCodigoAnimal;
    private JTextField txtFechaOrdeño;
    private JTextField txtCantidad;

    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnAtras;

    public GestionLeche() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Producción de Leche");

        JLabel lblCodigoAnimal = new JLabel("Código Animal:");
        txtCodigoAnimal = new JTextField(10);

        JLabel lblFechaOrdeño = new JLabel("Fecha de Ordeño:");
        txtFechaOrdeño = new JTextField(20);

        JLabel lblCantidad = new JLabel("Cantidad:");
        txtCantidad = new JTextField(10);

        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarProduccionLeche();
            }
        });

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProduccionLeche();
            }
        });

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarProduccionLeche();
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
                                                        .addComponent(lblCodigoAnimal)
                                                        .addComponent(lblFechaOrdeño)
                                                        .addComponent(lblCantidad))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCodigoAnimal)
                                                        .addComponent(txtFechaOrdeño)
                                                        .addComponent(txtCantidad)))
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
                                        .addComponent(lblCodigoAnimal)
                                        .addComponent(txtCodigoAnimal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFechaOrdeño)
                                        .addComponent(txtFechaOrdeño, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCantidad)
                                        .addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horizontalBoxBtns)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        pack();
    }

    private void insertarProduccionLeche() {
    Connection connection = null;
    try {
        String url = "jdbc:mysql://localhost:3306/huella_hidrica"; // Reemplaza "nombre_de_tu_base_de_datos" con el nombre real de tu base de datos.
        String usuario = "root";
        String contraseña = "";

        connection = DriverManager.getConnection(url, usuario, contraseña);

        String codigoAnimal = txtCodigoAnimal.getText();
        String fechaOrdeño = txtFechaOrdeño.getText();
        float cantidad = Float.parseFloat(txtCantidad.getText());

        String sql = "INSERT INTO Leche(Codigo_animal, Fecha, Cantidad) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codigoAnimal);
            preparedStatement.setString(2, fechaOrdeño);
            preparedStatement.setFloat(3, cantidad);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Datos de producción de leche insertados correctamente.");
        }
    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al insertar datos de producción de leche: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

   private void eliminarProduccionLeche() {
    Connection connection = null;
    try {
        String url = "jdbc:mysql://localhost:3306/huella_hidrica"; // Reemplaza "nombre_de_tu_base_de_datos" con el nombre real de tu base de datos.
        String usuario = "root";
        String contraseña = "";

        connection = DriverManager.getConnection(url, usuario, contraseña);

        String codigoAnimal = txtCodigoAnimal.getText();

        String sql = "DELETE FROM Leche WHERE Codigo_animal = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codigoAnimal);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Datos de producción de leche eliminados correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún registro de producción de leche con el código de animal especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al eliminar datos de producción de leche: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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


    private void modificarProduccionLeche() {
    Connection connection = null;
    try {
        String url = "jdbc:mysql://localhost:3306/huella_hidrica"; // Reemplaza "nombre_de_tu_base_de_datos" con el nombre real de tu base de datos.
        String usuario = "root";
        String contraseña = "";

        connection = DriverManager.getConnection(url, usuario, contraseña);

        String codigoAnimal = txtCodigoAnimal.getText();
        String nuevaFechaOrdeño = txtFechaOrdeño.getText();
        float nuevaCantidad = Float.parseFloat(txtCantidad.getText());

        String sql = "UPDATE Leche SET Fecha=?, Cantidad=? WHERE Codigo_animal=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevaFechaOrdeño);
            preparedStatement.setFloat(2, nuevaCantidad);
            preparedStatement.setString(3, codigoAnimal);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Datos de producción de leche modificados correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún registro de producción de leche con el código de animal especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al modificar datos de producción de leche: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                new GestionLeche().setVisible(true);
            }
        });
    }
}

