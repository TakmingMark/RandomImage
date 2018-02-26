import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class FrameListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
