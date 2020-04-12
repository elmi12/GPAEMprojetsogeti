package groupe.com.aem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FenetreConnexion extends JFrame implements ActionListener {
	JButton boutonConnexion, boutonAnnule;
	JPanel panel;
	JLabel labelUtilisateur, labelMotDePasse;
	final JTextField inputUtilisateur, inputMotDePasse;

	FenetreConnexion() {
		setTitle("Connexion");

		labelUtilisateur = new JLabel();
		labelUtilisateur.setText("Utilisateur :");
		inputUtilisateur = new JTextField(15);

		labelMotDePasse = new JLabel();
		labelMotDePasse.setText("Mot de passe:");
		inputMotDePasse = new JPasswordField(15);

		boutonConnexion = new JButton("Connexion");
		boutonAnnule = new JButton("Annule");
		boutonConnexion.addActionListener(this);

		panel = new JPanel(new GridLayout(3, 1));
		panel.add(labelUtilisateur);
		panel.add(inputUtilisateur);
		panel.add(labelMotDePasse);
		panel.add(inputMotDePasse);
		panel.add(boutonConnexion);
		panel.add(boutonAnnule);
		setResizable(false);
		add(panel, BorderLayout.CENTER);
		boutonAnnule.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ar) {

				// JOptionPane.showInternalMessageDialog(this, "Mot de passe ou utilisateur
				// incorrecte", "Error", JOptionPane.ERROR_MESSAGE);
				JFrame ff = new JFrame();
				ff.setSize(350, 100);
				// ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ff.getContentPane().setLayout(new FlowLayout());
				ff.setResizable(false);

				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout());

				JLabel label = new JLabel("Merci de nous avoir rendu visiter");

				ff.add(label);
				ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				ff.setVisible(true);
				// JOptionPane.showConfirmDialog(this, "Mot de passe ou utilisateur incorrecte",
				// "Error", JOptionPane.ERROR_MESSAGE);
			}

		});

	}

	public void actionPerformed(ActionEvent ae) {
		String nomUtilisateur = inputUtilisateur.getText();
		String motDePasse = inputMotDePasse.getText();
		if (nomUtilisateur.equals("admin") && motDePasse.equals("admin")) {
			FenetreGestionDeProduitClient page = new FenetreGestionDeProduitClient();
			setVisible(true);

		} else {
			System.out.println("Entrer un nom d'utilisateur et un mot de passe valide");
			JOptionPane.showMessageDialog(this, "Mot de passe ou utilisateur incorrecte", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}