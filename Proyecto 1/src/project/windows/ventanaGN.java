package project.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import proyecto.GE.Asignatura;

import java.awt.Font;

@SuppressWarnings("unused")
public class ventanaGN {
	Hashtable<String,Asignatura> listA;
	private JFrame VcWindow;
	private JPanel content;
	private JButton ClientMenu;
	
	// Para ejecutar el programa 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					ventanaGN window = new ventanaGN();
					window.VcWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaGN() {
		initialize();
		this.listA = new Hashtable<String,Asignatura>();

		MainPanel sP = new MainPanel();
		sP.setSize(600, 400);
		sP.setLocation(0,0);
		
		content.removeAll();
		content.add(sP, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initComponents();
	}

	
	//////////////////////////////////////////////
	public void initComponents() {
		VcWindow = new JFrame();
		VcWindow.setTitle("VideoClub - Twistos");
		VcWindow.setBounds(100, 100, 800, 600);
		VcWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClientMenu = new JButton("Menu Principal");
		ClientMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenuGC Menu = new panelMenuGC(listA);
				Menu.setSize(700,500);
				Menu.setLocation(0,0);
				
				content.removeAll();
				content.add(Menu, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		ClientMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		
		content = new JPanel();
	
		GroupLayout groupLayout = new GroupLayout(VcWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(content, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addComponent(ClientMenu, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(ClientMenu, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(content, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
		);
		VcWindow.getContentPane().setLayout(groupLayout);
		
	}}
	
	
	////////////////////////////////////////////////////////////


