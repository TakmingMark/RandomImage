import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Model {

	private ArrayList<String> fileNameArray;

	private Model() {

	}

	public static Model getModelObject() {
		return new Model();
	}
	
	public int getScreenBorder() {
		return (int) ((getScreenWidth()*0.1)/2);
	}
	public int getScreenWidth() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) screenSize.getWidth();
	}

	public int getScreenHeight() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) screenSize.getHeight();
	}

	public BufferedImage fixedBufferedImageSize(BufferedImage bufferedImage) {
		int screenWidth = (int) (getScreenWidth() * 0.9);
		int screenHeight = (int) (getScreenHeight() * 0.9);
		Image tmp = bufferedImage.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
		bufferedImage = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics2d = bufferedImage.createGraphics();
		graphics2d.drawImage(tmp, 0, 0, null);
		graphics2d.dispose();

		return bufferedImage;
	}

	public ArrayList<String> listFilesNameForFolderPath(String FolderPath) {
		ArrayList<String> fileNameArray = new ArrayList<>();
		File folder = new File(FolderPath);
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				fileNameArray.addAll(listFilesNameForFolderPath(fileEntry.getPath()));
			} else {
				fileNameArray.add(fileEntry.getPath() );
			}
		}
		this.fileNameArray = fileNameArray;
		return fileNameArray;
	}

	public void print() {
		for (String filename : fileNameArray)
			System.out.println(filename);
	}

	public BufferedImage getBufferedImageByFilePath(String filePath) {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferedImage;
	}

	public String randomImagePath() {
		int size=fileNameArray.size();
		if(size>0) {
			int index=(int) (Math.random()*size);
			String ImagePath=fileNameArray.get(index);
			fileNameArray.remove(index);
			return ImagePath;
		}else {
			return "D:/end.jpg";
		}
	
	}

	public ArrayList<String> getFileNameArray() {
		return fileNameArray;
	}

	public void setFileNameArray(ArrayList<String> fileNameArray) {
		this.fileNameArray = fileNameArray;
	}
}
