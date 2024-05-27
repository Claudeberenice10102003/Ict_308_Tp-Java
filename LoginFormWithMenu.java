import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFormWithMenu extends JFrame {

    private JComboBox<String> choixComboBox;
    private JLabel choixLabel;

    public LoginFormWithMenu() {
        // Définir les propriétés de la fenêtre principale
        setTitle("Formulaire de Connexion et Menu Admin");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel pour le formulaire de connexion
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);

        // Créer les composants du formulaire
        JLabel userLabel = new JLabel("Nom d'utilisateur:");
        userLabel.setBounds(50, 50, 150, 30);
        JTextField userText = new JTextField();
        userText.setBounds(200, 50, 150, 30);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setBounds(50, 100, 150, 30);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(200, 100, 150, 30);

        JCheckBox showPassword = new JCheckBox("Afficher le mot de passe");
        showPassword.setBounds(200, 150, 150, 30);

        JButton loginButton = new JButton("Connexion");
        loginButton.setBounds(50, 200, 120, 30);

        JButton registerButton = new JButton("S'enregistrer");
        registerButton.setBounds(230, 200, 120, 30);

        // Ajouter des actions aux boutons et à la checkbox
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordText.setEchoChar((char) 0);
                } else {
                    passwordText.setEchoChar('*');
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                // Logique de connexion à implémenter ici
                JOptionPane.showMessageDialog(formPanel, "Connexion réussie pour: " + username);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique d'enregistrement à implémenter ici
                JOptionPane.showMessageDialog(formPanel, "Redirection vers le formulaire d'enregistrement.");
            }
        });

        // Ajouter les composants au panel de formulaire
        formPanel.add(userLabel);
        formPanel.add(userText);
        formPanel.add(passwordLabel);
        formPanel.add(passwordText);
        formPanel.add(showPassword);
        formPanel.add(loginButton);
        formPanel.add(registerButton);

        // Panel pour le menu admin
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());

        // Création d'un tableau de choix pour le menu admin
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
        
        // Ajout des composants au panel du menu
        menuPanel.add(choixComboBox);
        menuPanel.add(choixLabel);

        // Ajouter les panels à la fenêtre principale
        add(formPanel, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.SOUTH);

        // Rendre la fenêtre visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Exécuter la création de l'interface graphique sur le thread de l'Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFormWithMenu();
            }
        });
    }
}

