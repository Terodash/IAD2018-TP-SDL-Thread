package fr.imtld.sdl;

import fr.imtld.sdl.support.IProcess;

/**
 * Une interface graphique pour tester le pipeline d'Erathostène.
 * 
 * @author C. TOMBELLE
 */
public class Primes extends javax.swing.JFrame implements IProcess {
	/**
	 * Implantation d'une instance du process SDL Pipe correspondant au premier
	 * étage du pipeline.
	 */
	protected Pipe _pipeFirst;
	/** Bouton start. */
	protected javax.swing.JButton _btnStart;
	/** Label pour la partie gauche de la barre d'état (initialement "Ready."). */
	protected javax.swing.JLabel _jlblLeft;
	/** Label "Prime numbers are :". */
	protected javax.swing.JLabel _jlblPrimeList;
	/** Label pour la partie droite de la barre d'état (initialement ""). */
	protected javax.swing.JLabel _jlblRight;
	/** Barre de menu. */
	protected javax.swing.JMenuBar _jmbStd;
	/** MenuItem pour Exit. */
	protected javax.swing.JMenuItem _jmiExit;
	/** Menu pour File. */
	protected javax.swing.JMenu _jmnFile;
	/** Panel pour la zone principale. */
	protected javax.swing.JPanel _jpnlMain;
	/** Panel pour la barre d'état. */
	protected javax.swing.JPanel _jpnlStatus;
	/** Barre d'outils. */
	protected javax.swing.JToolBar _jtlbStd;
	/** Liste des signaux reçus. */
	protected java.awt.List _lstPrimes;

	/** Creates a Primes instance. */
	public Primes() {
		initComponents();
		_pipeFirst = new Pipe();
		_pipeFirst.setParent(null);
		setSize(450, 350);
	}

	/**
	 * Crée les éléments visuels de l'interface graphique.
	 */
	protected void initComponents() {
		_jtlbStd = new javax.swing.JToolBar();
		_btnStart = new javax.swing.JButton();
		_jpnlMain = new javax.swing.JPanel();
		_lstPrimes = new java.awt.List();
		_jlblPrimeList = new javax.swing.JLabel();
		_jpnlStatus = new javax.swing.JPanel();
		_jlblLeft = new javax.swing.JLabel();
		_jlblRight = new javax.swing.JLabel();
		_jmbStd = new javax.swing.JMenuBar();
		_jmnFile = new javax.swing.JMenu();
		_jmiExit = new javax.swing.JMenuItem();
		setTitle("Crible d'Erathostène");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm(evt);
			}
		});
		_btnStart.setText("Start");
		_btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startActionPerformed(evt);
			}
		});
		_jtlbStd.add(_btnStart);
		getContentPane().add(_jtlbStd, java.awt.BorderLayout.NORTH);
		_jpnlMain.setLayout(null);
		_jpnlMain.add(_lstPrimes);
		_lstPrimes.setBounds(90, 20, 270, 190);
		_jlblPrimeList.setText("Prime numbers are :");
		_jpnlMain.add(_jlblPrimeList);
		_jlblPrimeList.setBounds(100, 0, 170, 16);
		getContentPane().add(_jpnlMain, java.awt.BorderLayout.CENTER);
		_jpnlStatus.setLayout(new java.awt.GridLayout());
		_jlblLeft.setText("Ready.");
		_jpnlStatus.add(_jlblLeft);
		_jpnlStatus.add(_jlblRight);
		getContentPane().add(_jpnlStatus, java.awt.BorderLayout.SOUTH);
		_jmnFile.setText("File");
		_jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_X,
				java.awt.event.InputEvent.ALT_MASK));
		_jmiExit.setText("Exit");
		_jmiExit.setToolTipText("Exit the application.");
		_jmiExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});
		_jmnFile.add(_jmiExit);
		_jmbStd.add(_jmnFile);
		setJMenuBar(_jmbStd);
		pack();
	}

	/**
	 * Réagis à l'événement "actionPerformed" du bouton start.
	 * 
	 * @param evt
	 *            Réification de l'événement.
	 */
	protected void startActionPerformed(java.awt.event.ActionEvent evt) {
		// Envoyer les signaux SNb au premier étage du pipe line,
		// avec les nombres de 2 à 100
		for (int i = 2; i < 100; i++)
			_pipeFirst.add(new SNb(this, i));
		_pipeFirst.add(new SKill(this));
	}

	/**
	 * Termine l'application.
	 */
	protected void normalExit() {
		System.exit(0);
	}

	/**
	 * Réagis à l'événement "actionPerformed" du MenuItem Exit.
	 * @param evt L'objet événement.
	 */
	protected void exitActionPerformed(java.awt.event.ActionEvent evt) {
		normalExit();
	}

	/**
	 * Réagis à l'événement "windowClowing" de cette fenêtre.
	 * 
	 * @param evt
	 *            Réification de l'événement.
	 */
	protected void exitForm(java.awt.event.WindowEvent evt) {
		normalExit();
	}

	/**
	 * Déposer un signal dans la fifo de ce process SDL.
	 * 
	 * @param oSignal
	 *            Le signal à déposer.
	 */
	public void add(Object oSignal) {
		// Ajouter une représentation du signal dans la liste graphique des
		// signaux reçus.
		_lstPrimes.add(oSignal.toString());
	}

	/**
	 * Définir le parent de cette instance de process SDL.
	 * 
	 * @param procParent
	 *            Le PId du parent.
	 */
	public void setParent(IProcess procParent) {
	}

	/**
	 * Lancer l'application Primes.
	 * 
	 * @param args
	 *            Arguments de la ligne de commande.
	 */
	public static void main(String args[]) {
		new Primes().setVisible(true);
	}

}
