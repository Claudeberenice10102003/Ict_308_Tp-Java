

    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChoixMenu extends JFrame {
    private JComboBox<String> choixComboBox;
    private JLabel choixLabel;

    public ChoixMenu() {
        setTitle("Fonctions_admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Création d'un tableau de choix
        String[] choix = {"ouvrir ", "enregistrer", "synchroniser"};

        // Création du JComboBox avec les choix
        choixComboBox = new JComboBox<>(choix);
        choixComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choixSelectionne = (String) choixComboBox.getSelectedItem();
                choixLabel.setText("Choix sélectionné : " + choixSelectionne);
            }
        });

        // Création d'un JLabel pour afficher le choix sélectionné
        choixLabel = new JLabel("Administrateur : ");
        
        // Ajout des composants à la fenêtre
        add(choixComboBox);
        add(choixLabel);

        pack();
        setLocationRelativeTo(null); // Centrer la fenêtre
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChoixMenu();
            }
        });
    }
}


