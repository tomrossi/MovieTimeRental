package movietime.gui.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface PanelInterface {

	public void setPanelsVisibility();

	public void setVisiblePanel(JPanel visiblePanel, JFrame frame);

	public JFrame getFrame();

}
