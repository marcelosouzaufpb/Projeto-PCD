import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class FindImage {

	public static void main(String[] args) {
		String findImage = "C:/Users/marce/git/Projeto-PCD/src/img/in/Superman.png";
		String img = "C:/Users/marce/git/Projeto-PCD/src/img/out/image2_3.png";
		String caminho = "C:/Users/marce/git/Projeto-PCD/src/img/out/out.png";

		fileChooser();

		File selectedFile = fileChooser();

		for (File file : selectedFile.listFiles()) {
			System.out.println(file.getName());
		}

		try {
			BufferedImage find = ImageIO.read(new File(findImage));
			BufferedImage image = ImageIO.read(new File(img));
			isOnImagem(find, image, caminho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The image function receives an image that will be compared with an already
	 * determined image, checking if there is one image inside the other, all behind
	 * rgb, returning true or false, for existence.
	 */
	private static void isOnImagem(BufferedImage find, BufferedImage image, String caminho) throws IOException {
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {

				boolean invalid = false;
				int k = x, l = y;
				for (int a = 0; a < find.getWidth(); a++) {
					l = y;
					for (int b = 0; b < find.getHeight(); b++) {
						if (find.getRGB(a, b) != image.getRGB(k, l)) {
							invalid = true;
							break;
						} else {
							l++;
						}
					}
					if (invalid) {
						break;
					} else if (!invalid) {
						drawRectangle(image, x, y, find.getWidth(), find.getHeight());
						save(image, caminho);
					} else {
						k++;
					}
				}
			}

		}
		System.out.println("Finish");
	}

	/*
	 * Draw rectangle function, receives the largest image, the value of x and y,
	 * the width and height of the smaller image, and returns the larger image,
	 * marking the smaller image with a rectangle.
	 */
	public static void drawRectangle(BufferedImage image, int x, int y, int w, int h) {
		Graphics2D g2d = image.createGraphics();

		g2d.setColor(Color.RED);

		g2d.drawRect(x, y, w, h);

		g2d.dispose();
	}

	/*
	 * Save function receives an image, which is converted to byte, to be saved in a
	 * default folder
	 */
	public static void save(BufferedImage image, String caminho) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		ImageIO.write(image, "png", baos);

		baos.flush();

		byte[] img = baos.toByteArray();

		baos.close();

		InputStream in = new ByteArrayInputStream(img);

		BufferedImage bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "png", new File(caminho));

	}

	/*
	 * This function picks a folder and returns a list of all files in it.
	 */
	private static File fileChooser() {
		JFileChooser jfc = new JFileChooser(".");

		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			return selectedFile;

		}
		return null;
	}

}
