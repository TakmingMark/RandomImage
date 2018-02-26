import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Controller {
	private Model model;
	private View view;

	private Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		view.setBorder_X(model.getScreenBorder());
		initController();
		initViewKeyStrokeAction();
	}

	public static Controller getControllerObject(Model model, View view) {
		return new Controller(model, view);
	}

	private void initController() {
		view.setBufferedImage(model.fixedBufferedImageSize(model.getBufferedImageByFilePath("D:/start.jpg")));
		view.initView();

		model.listFilesNameForFolderPath("D:/ImageFiles");

		// view.setBufferedImage(model.fixedBufferedImageSize(model.getBufferedImageByFilePath("D:/2.jpg")));
		// view.rePaint();
	}

	private void initListener() {
		view.getjFrame().addWindowListener(new FrameListener());
	}
	private void initViewKeyStrokeAction() {
		view.getjFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),
				"insertRowView");
		view.getjFrame().getRootPane().getActionMap().put("insertRowView",
				new KeyStrokeAction(ae -> pressF1KeyStroke()));
	}

	public void pressF1KeyStroke() {
		view.setBufferedImage(model.fixedBufferedImageSize(model.getBufferedImageByFilePath(model.randomImagePath())));
		view.rePaint();
		model.print();
	}
}
