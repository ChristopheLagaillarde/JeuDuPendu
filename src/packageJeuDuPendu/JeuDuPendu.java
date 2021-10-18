/*/////////////////En tête////////////////////////////
 * Programme : Jeu du pendu
 *
 * Description : Ce programme génère le jeu du pendu
 *
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 03/10/2021
 *        
 *///////////////////////////////////////////////////

// Déclaration des bibliotheques de fonctions...
package packageJeuDuPendu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPanel;

//////////////////Le Programme principal/////////////

//////////////////Début//////////////////////////////
public class JeuDuPendu {

	// initialisation
	int essaieARate = 0;
	int i = 0;
	String lettresAChercher="";
	String solutionTrouve = "";
	String solution = "";

	private JFrame fenetreDuJeu;
	JPanel panneauAlphabet = new JPanel();
	boolean[] lettresDansMot;
	boolean lettreDansMot = false;

	private JLabel DessinEchec1;
	private JLabel DessinEchec2;
	private JLabel DessinEchec3;
	private JLabel DessinEchec4;
	private JLabel DessinEchec5;
	private JLabel DessinEchec6;
	private JLabel DessinEchec7;
	private JLabel DessinEchec8;
	private JLabel motATrouver;
	private JLabel lettreAbsente;
	JLabel motTropLong;

	private JButton boutonA;
	private JButton boutonB;
	private JButton boutonC;
	private JButton boutonD;
	private JButton boutonE;
	private JButton boutonF;
	private JButton boutonG;
	private JButton boutonH;
	private JButton boutonI;
	private JButton boutonJ;
	private JButton boutonK;
	private JButton boutonL;
	private JButton boutonM;
	private JButton boutonN;
	private JButton boutonO;
	private JButton boutonP;
	private JButton boutonQ;
	private JButton boutonR;
	private JButton boutonS;
	private JButton boutonT;
	private JButton boutonU;
	private JButton boutonV;
	private JButton boutonW;
	private JButton boutonX;
	private JButton boutonY;
	private JButton boutonZ;
	JButton boutonDebutJeu;
	
	JTextArea ZoneTexteMotAChercher;
	
	boolean pasDedans(boolean[]lettresDansMot,int tailleMot) {
		for(i=0;i <tailleMot; i++) {
			if(lettresDansMot[i]) {
				return false;
			}
		}
		return true;
	}

	String AfficherLettreManquante(String solutionTrouve) {
		for(i = 0; i < lettresAChercher.length(); i++){
			solutionTrouve = solutionTrouve.concat("_");
		}
		motATrouver.setText(solutionTrouve);
		return solutionTrouve;
	}

	void verifierLettre(char lettreAVerifier) {
		for(i = 0; i < solution.length(); i++) {
			if(lettreAVerifier == solution.charAt(i)) {
				lettresDansMot[i] = true;
				lettresAChercher = lettresAChercher.replaceAll(Character.toString(lettreAVerifier), "");
				solutionTrouve = solutionTrouve.substring(0,i) + lettreAVerifier + solutionTrouve.substring(i+1);
				motATrouver.setText(solutionTrouve);
			}
			else if(lettreAVerifier != solution.charAt(i)){ 
				lettresDansMot[i] = false; 
			}
		}

		for(i = 0; i < solution.length(); i++) {
			if(lettresDansMot[i]) {
				lettreDansMot = true;
				lettreAbsente.setVisible(false);
			}
			
		}

		if(pasDedans(lettresDansMot,solution.length())) {
			lettreDansMot = false;
			lettreAbsente.setVisible(true);
		}


		if(!lettreDansMot) {
			essaieARate += 1;

			if(essaieARate ==1) {
				DessinEchec1.setVisible(true);
			}
			if(essaieARate ==2) {
				DessinEchec2.setVisible(true);
			}
			if(essaieARate ==3) {
				DessinEchec3.setVisible(true);
			}
			if(essaieARate ==4) {
				DessinEchec4.setVisible(true);
			}
			if(essaieARate ==5) {
				DessinEchec5.setVisible(true);
			}
			if(essaieARate ==6) {
				DessinEchec6.setVisible(true);
			}
			if(essaieARate ==7) {
				DessinEchec7.setVisible(true);
			}
			if(essaieARate ==8) {
				DessinEchec8.setVisible(true);
				JOptionPane.showMessageDialog(null,"Perdu !"); 
			}

		}
		
		if(lettresAChercher.equals("")) {
			JOptionPane.showMessageDialog(null,"Gagné!"); 
		}
	}
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JeuDuPendu window = new JeuDuPendu();
					window.fenetreDuJeu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */


	public JeuDuPendu() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fenetreDuJeu = new JFrame();
		fenetreDuJeu.getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		fenetreDuJeu.setBounds(200, 100, 517, 369);
		fenetreDuJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreDuJeu.getContentPane().setLayout(null);	
		
		motTropLong = new JLabel("Trop long !");
		motTropLong.setBounds(382, 12, 85, 14);
		fenetreDuJeu.getContentPane().add(motTropLong);
		motTropLong.setVisible(false);
		
		lettreAbsente = new JLabel("la lettre est absente");
		lettreAbsente.setFont(new Font("Arial", Font.PLAIN, 18));
		lettreAbsente.setBounds(115, 12, 160, 19);
		fenetreDuJeu.getContentPane().add(lettreAbsente);
		lettreAbsente.setVisible(false);
		
		motATrouver = new JLabel(solutionTrouve);
		motATrouver.setFont(new Font("Arial", Font.BOLD, 20));
		motATrouver.setBounds(25, 163, 444, 34);
		fenetreDuJeu.getContentPane().add(motATrouver);
		motATrouver.setVisible(false);
		
		
		DessinEchec1 = new JLabel("==================================");
		DessinEchec1.setBounds(51, 130, 277, 80);
		fenetreDuJeu.getContentPane().add(DessinEchec1);
		DessinEchec1.setVisible(false);
		
		DessinEchec2 = new JLabel("<html>I<br/>I<br/>I<br/>I<br/>I<br/>I<br/>I<br/>I</html>");
		DessinEchec2.setVerticalAlignment(SwingConstants.BOTTOM);
		DessinEchec2.setBounds(91, 0, 25, 168);
		fenetreDuJeu.getContentPane().add(DessinEchec2);
		DessinEchec2.setVisible(false);

		
		DessinEchec3 = new JLabel("_____________________");
		DessinEchec3.setBounds(91, 42, 160, 14);
		fenetreDuJeu.getContentPane().add(DessinEchec3);
		DessinEchec3.setVisible(false);

		
		DessinEchec4 = new JLabel("II");
		DessinEchec4.setBounds(205, 55, 46, 14);
		fenetreDuJeu.getContentPane().add(DessinEchec4);
		DessinEchec4.setVisible(false);

		
		DessinEchec5 = new JLabel(" O");
		DessinEchec5.setFont(new Font("Arial", Font.BOLD, 18));
		DessinEchec5.setBounds(197, 49, 25, 50);
		fenetreDuJeu.getContentPane().add(DessinEchec5);
		DessinEchec5.setVisible(false);

		
		DessinEchec6 = new JLabel("<html>I<br/>I<br/>I<br/>I</html>");
		DessinEchec6.setVerticalAlignment(SwingConstants.BOTTOM);
		DessinEchec6.setBounds(207, 74, 15, 50);
		fenetreDuJeu.getContentPane().add(DessinEchec6);
		DessinEchec6.setVisible(false);

		
		DessinEchec7 = new JLabel("______");
		DessinEchec7.setBounds(189, 80, 46, 14);
		fenetreDuJeu.getContentPane().add(DessinEchec7);
		DessinEchec7.setVisible(false);

		
		DessinEchec8 = new JLabel("/\\");
		DessinEchec8.setFont(new Font("Arial", Font.PLAIN, 21));
		DessinEchec8.setBounds(203, 110, 75, 42);
		fenetreDuJeu.getContentPane().add(DessinEchec8);
		DessinEchec8.setVisible(false);
		
		panneauAlphabet.setBounds(25, 201, 334, 140);
		fenetreDuJeu.getContentPane().add(panneauAlphabet);
		panneauAlphabet.setVisible(false);
		
		boutonA = new JButton("a");
		boutonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('a');

			}
		});
		panneauAlphabet.add(boutonA);
		
		boutonB = new JButton("b");
		boutonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('b');
			}
		});
		panneauAlphabet.add(boutonB);
		
		boutonC = new JButton("c");
		boutonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('c');
			}
		});
		panneauAlphabet.add(boutonC);
		
		boutonD = new JButton("d");
		boutonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('d');
			}
		});
		panneauAlphabet.add(boutonD);
		
		boutonE = new JButton("e");
		boutonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('e');
			}
		});
		panneauAlphabet.add(boutonE);
		
		
		boutonF = new JButton("f");
		boutonF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('f');
			}
		});
		panneauAlphabet.add(boutonF);
		
		boutonG = new JButton("g");
		boutonG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('g');
			}
		});
		panneauAlphabet.add(boutonG);
		
		boutonH = new JButton("h");
		boutonH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('h');
			}
		});
		panneauAlphabet.add(boutonH);
		
		boutonI = new JButton("i");
		boutonI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('i');
			}
		});
		panneauAlphabet.add(boutonI);
		
		boutonJ = new JButton("j");
		boutonJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('j');
			}
		});
		panneauAlphabet.add(boutonJ);
		
		boutonK = new JButton("k");
		boutonK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('k');
			}
		});
		panneauAlphabet.add(boutonK);
		
		boutonL = new JButton("l");
		boutonL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('l');
			}
		});
		panneauAlphabet.add(boutonL);
		
		boutonM = new JButton("m");
		boutonM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('m');
			}
		});
		panneauAlphabet.add(boutonM);
		
		boutonN = new JButton("n");
		boutonN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('n');
			}
		});
		panneauAlphabet.add(boutonN);
		
		boutonO = new JButton("o");
		boutonO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('o');
			}
		});
		panneauAlphabet.add(boutonO);
		
		boutonP = new JButton("p");
		boutonP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('p');
			}
		});
		panneauAlphabet.add(boutonP);
		
		boutonQ = new JButton("q");
		boutonQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('q');
			}
		});
		panneauAlphabet.add(boutonQ);
		
		boutonR = new JButton("r");
		boutonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('r');
			}
		});
		panneauAlphabet.add(boutonR);
		
		boutonS = new JButton("s");
		boutonS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('s');
			}
		});
		panneauAlphabet.add(boutonS);
		
		boutonT = new JButton("t");
		boutonT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('t');
			}
		});
		panneauAlphabet.add(boutonT);
		
		boutonU = new JButton("u");
		boutonU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('u');
			}
		});
		panneauAlphabet.add(boutonU);
		
		boutonV = new JButton("v");
		boutonV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('v');
			}
		});
		panneauAlphabet.add(boutonV);
		
		boutonW = new JButton("w");
		boutonW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('w');
			}
		});
		panneauAlphabet.add(boutonW);
		
		boutonX = new JButton("x");
		boutonX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('x');
			}
		});
		panneauAlphabet.add(boutonX);
		
		boutonY = new JButton("y");
		boutonY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('y');
			}
		});
		panneauAlphabet.add(boutonY);
		
		boutonZ = new JButton("z");
		boutonZ .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettreAbsente.setVisible(false);
				verifierLettre('z');
			}
		});
		panneauAlphabet.add(boutonZ);
		
		
		ZoneTexteMotAChercher = new JTextArea();
		ZoneTexteMotAChercher.setBounds(341, 37, 126, 22);
		fenetreDuJeu.getContentPane().add(ZoneTexteMotAChercher);
		ZoneTexteMotAChercher.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent appuyerTouche) {
				motTropLong.setVisible(false);

				char caractere = appuyerTouche.getKeyChar();
				
				
				if(ZoneTexteMotAChercher.getText().length() < 2) {
					boutonDebutJeu.setVisible(false);
				}
				else if(ZoneTexteMotAChercher.getText().length() >= 2){
					boutonDebutJeu.setVisible(true);
				}
					if(ZoneTexteMotAChercher.getText().length() >= 20) {
						appuyerTouche.consume();
						motTropLong.setVisible(true);
						
					}
				
				else if(!(Character.isAlphabetic(caractere)) || (caractere == KeyEvent.VK_BACK_SPACE) || (caractere == KeyEvent.VK_DELETE) || (ZoneTexteMotAChercher.getText().length() >= 20) ){
					appuyerTouche.consume();
				}
			}
		});

		
		
		boutonDebutJeu = new JButton("D\u00E9but jeu");
		boutonDebutJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lettresAChercher= ZoneTexteMotAChercher.getText();
				solution = lettresAChercher;
				lettresDansMot = new boolean[lettresAChercher.length() + 1];
				solutionTrouve = AfficherLettreManquante(solutionTrouve);
				ZoneTexteMotAChercher.setVisible(false);
				panneauAlphabet.setVisible(true);
				motATrouver.setVisible(true);
			}
		});
		boutonDebutJeu.setBounds(365, 74, 89, 23);
		fenetreDuJeu.getContentPane().add(boutonDebutJeu);
		boutonDebutJeu.setVisible(false);
			
	}
}
//////////////////Fin//////////////////////////////