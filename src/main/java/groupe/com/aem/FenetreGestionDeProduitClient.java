package groupe.com.aem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format.Field;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FenetreGestionDeProduitClient {
	static final String SQL_URL = "jdbc:mysql://localhost:3308/nouveaudonne?autoReconnect=true&useSSL=false";
	static final String SQL_LOGIN = "root";
	static final String SQL_PASSWORD = "";

	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	public FenetreGestionDeProduitClient() {

		// Construction de l'interface graphique swing

		final JFrame f = new JFrame("A window");

		f.setTitle("BIENVENUE");
		f.setSize(590, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());
		// f.setResizable(false);

		final JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel label1 = new JLabel("Bienvenue dans mon application de Gestion de produit");
		panel.add(label1);
		final JButton boutonEnregistrer = new JButton("Enregistrer");
		final JButton boutonSupprimer = new JButton("Supprimer");
		final JButton boutonRechercher = new JButton("Rechercher");
		final JButton boutonModifier = new JButton("Modifier");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);
			st = cn.createStatement();

			String sql = "SELECT * FROM mesclients";
			rs = st.executeQuery(sql);

			ResultSetMetaData rsmt = rs.getMetaData();

			int c = rsmt.getColumnCount();

			Vector column = new Vector(c);

			for (int i = 1; i <= c; i++) {
				column.add(rsmt.getColumnName(i));
			}

			Vector data = new Vector();
			Vector row;
			while (rs.next()) {
				row = new Vector(c);

				for (int i = 1; i <= c; i++) {
					row.add(rs.getString(i));
				}

				data.add(row);
			}

			JTable table = new JTable(data, column);

			JScrollPane jsp = new JScrollPane(table);

			panel.add(jsp);
			jsp.setSize(800, 800);
			f.setContentPane(panel);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		final JTextField field1 = new JTextField();
		final JTextField field2 = new JTextField();
		final JTextField field3 = new JTextField();

		panel.add(field1);
		field1.setColumns(14);

		panel.add(field2);
		field2.setColumns(14);

		field3.setColumns(13);
		panel.add(field3);

		f.getContentPane().add(boutonEnregistrer);
		boutonEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

					st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					System.out.println("Connected database successfully...");

					System.out.println("Inserting records into the table...");

					String sql = "INSERT INTO Mesclients "
							+ "VALUES ('6' ,'10','11','28','leny', '0758961556', '28 rue jules vernes', '12cex')";
					st.executeUpdate(sql);
					sql = "INSERT INTO Mesclients "
							+ "VALUES ('3' ,'2','4','7','Muriel', '0678952051', '16 Rue de l''Observatoire', '56ptg')";
					st.executeUpdate(sql);

					sql = "INSERT INTO Mesclients "
							+ "VALUES('20' ,'58','1','coca','Pascal', '0797694305', '9 Rue de la Fonderie', '78ldr')";

					st.executeUpdate(sql);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		});

		f.getContentPane().add(boutonSupprimer);
		boutonSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

					st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					System.out.println("Connected database successfully...");

					System.out.println("Inserting records into the table...");

					String sql = "DELETE FROM `mesclients` where `yaourt`=" + field1.getText();
					st.executeUpdate(sql);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		});

		// Recherche

		f.getContentPane().add(boutonRechercher);
		boutonRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

					String query = "SELECT * FROM `mesclients` where `yaourt`=" + field2.getText();

					st = cn.prepareStatement(query);
					// int rs = null;
					ResultSet rs = st.executeQuery(query);
					rs.last();

					// query.substring(1);
					int nbrRow = rs.getRow();

					if (nbrRow != 0) {
						System.out.println("BoutonRechercher : Produit  trouvé");
					} else {

						System.out.println("BoutonRechercher : Produit non trouvé");
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}

		});

		// Modifier

		f.getContentPane().add(boutonModifier);
		boutonModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Class.forName("com.mysql.jdbc.Driver");

					cn = DriverManager.getConnection(SQL_URL, SQL_LOGIN, SQL_PASSWORD);

					st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					System.out.println("Connected database successfully...");

					System.out.println("Inserting records into the table...");

					String sql = "UPDATE `mesclients` SET `yaourt`= '" + field3.getText() + "' where TV=11";

					st.executeUpdate(sql);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		});

		f.setVisible(true);
	}

}