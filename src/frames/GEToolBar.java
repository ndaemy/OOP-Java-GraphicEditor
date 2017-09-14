package frames;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;

public class GEToolBar extends JToolBar {
	public GEToolBar(String label) {
		super(label);
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton rButton = null;
		
		for (EToolBarButtons btn : EToolBarButtons.values()) {
			rButton = new JRadioButton();
			rButton.setIcon(new ImageIcon(
					GEConstants.IMG_URL
					+ btn.toString()
					+ GEConstants.TOOLBAR_BTN));
			rButton.setSelectedIcon(new ImageIcon(
					GEConstants.IMG_URL
					+ btn.toString()
					+ GEConstants.TOOLBAR_BTN_SLT));
			this.add(rButton);
			buttonGroup.add(rButton);
		}
	}
}
