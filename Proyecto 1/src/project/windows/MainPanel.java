package project.windows;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel VideoClubLabel = new JLabel("Gestion de notas");
		VideoClubLabel.setHorizontalAlignment(SwingConstants.CENTER);
		VideoClubLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 70));
		
		JLabel WelcomeLabel = new JLabel("Bienvenido!");
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(143)
					.addComponent(VideoClubLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(123))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(WelcomeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(196))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(VideoClubLabel)
					.addGap(18)
					.addComponent(WelcomeLabel)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
