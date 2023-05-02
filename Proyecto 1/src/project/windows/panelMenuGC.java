package project.windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import proyect.exception.NotIntExceptions;
import proyect.exception.ValidNota;
import proyecto.GE.Asignatura;
import proyecto.GE.ControllerGN;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")

public class panelMenuGC extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelMenuGC(Hashtable<String,Asignatura> listA) {
        setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        
        JButton btnNewButton = new JButton("anaaal");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(35)
        			.addComponent(btnNewButton)
        			.addContainerGap(346, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(23)
        			.addComponent(btnNewButton)
        			.addContainerGap(250, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
        
        
		JLabel titleLabel = new JLabel("MENU PRINCIPAL");
		titleLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 60));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JButton AsignaturaButton = new JButton("agregar asignatura");
		AsignaturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    ControllerGN ctr = new ControllerGN();
					String name = JOptionPane.showInputDialog("Ingrese Asignatura");
					Asignatura Asign = new Asignatura();
					String cantP = JOptionPane.showInputDialog("cuantas pruebas tenddra");					
			
					ctr.isInt(cantP);
					Asign.setPrueba(Integer.parseInt(cantP));
					Asign.setnombA(name);
					listA.put(name, Asign);
					JOptionPane.showMessageDialog(null, "Cliente registrado");
					
				
			}catch(NotIntExceptions ix) {
				JOptionPane.showMessageDialog(null, "no es un valor valido");
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ValidNota e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		});
		AsignaturaButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		
		

	}

}
