import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View {
	private JFrame jFrame;
	private JPanel jPanel;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private BufferedImage bufferedImage;
	private int border_X;

	private View() {
	}

	public static View getViewObject() {
		return new View();
	}

	public void initView() {
		jFrame = new JFrame("random image");
		jPanel = new JPanel();
		imageIcon = new ImageIcon(bufferedImage);
		jLabel = new JLabel(imageIcon);

		jFrame.setLocation(new Point(border_X, 0));
		jPanel.add(jLabel);
		jFrame.add(jPanel);
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void rePaint() {
		updateImageIcon();
		jPanel.repaint();
		jPanel.validate();
		jFrame.repaint();
		jFrame.validate();
	}

	private void updateImageIcon() {
		jLabel.setIcon(new ImageIcon(bufferedImage));
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public int getBorder_X() {
		return border_X;
	}

	public void setBorder_X(int border_X) {
		this.border_X = border_X;
	}

}

