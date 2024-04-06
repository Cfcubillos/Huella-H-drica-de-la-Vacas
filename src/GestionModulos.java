import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;

public class GestionModulos extends JFrame {

    private GestionarFinca gestionFinca = new GestionarFinca();
    private GestionAnimal gestionAnimal = new GestionAnimal();
    private GestionPotreros gestionPotrero = new GestionPotreros();
    private GestionLeche gestionProduccionLeche = new GestionLeche();
    private GestionConsumo gestionConsumoAgua = new GestionConsumo();
    private GestionPasto gestionPasto = new GestionPasto();

    private JButton gestFinca;
    private JButton gestPotrero;
    private JButton gestAnimal;
    private JButton gestProduccionLeche;
    private JButton gestConsumoAgua;
    private JButton gestPasto;
    private JLabel labelTitulo;

    public GestionModulos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        gestFinca = new JButton("Gestion Finca");
        gestPotrero = new JButton("Gestion Potreros");
        gestAnimal = new JButton("Gestion Animal");
        gestProduccionLeche = new JButton("Gestion Produccion de leche");
        gestConsumoAgua = new JButton("Gestion Consumo Agua");
        gestPasto = new JButton("Gestion Pasto");
        labelTitulo = new JLabel("GESTION DE HUELLA HIDRICA");
        
        // Establecer fuente negrita y tamaño para la etiqueta
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        gestFinca.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            gestionFinca.setVisible(true);
        });

        gestPotrero.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            gestionPotrero.setVisible(true);
        });
        
        gestAnimal.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            gestionAnimal.setVisible(true);
        });
        
        gestProduccionLeche.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            gestionProduccionLeche.setVisible(true);
        });
        
        gestConsumoAgua.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            gestionConsumoAgua.setVisible(true);
        });
        
        gestPasto.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            gestionPasto.setVisible(true);
        });

        
        // Establecer tamaño preferido para los botones
        int buttonWidth = 200;
        int buttonHeight = 100;
        gestFinca.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
        gestPotrero.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
        gestAnimal.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
        gestProduccionLeche.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
        gestConsumoAgua.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
        gestPasto.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GroupLayout jPanel1Layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(gestFinca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(gestAnimal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(gestProduccionLeche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(gestPotrero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(gestConsumoAgua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(gestPasto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelTitulo)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(gestFinca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(gestPotrero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(gestAnimal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(gestConsumoAgua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(gestProduccionLeche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(gestPasto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GestionModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new GestionModulos().setVisible(true);
        });
    }
}


