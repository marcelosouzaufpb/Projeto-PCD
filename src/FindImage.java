import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FindImage {

	public static void main(String[] args) {
		try {
			BufferedImage image = ImageIO.read(new File("C:/Users/marce/git/Projeto-PCD/src/img/in/Superman.png"));
			boolean isOnScreen = isOnImagem(image);
			System.out.print(isOnScreen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isOnImagem(BufferedImage bi) throws IOException {
		BufferedImage image = ImageIO.read(new File("C:/Users/marce/git/Projeto-PCD/src/img/out/image3_4.png"));

		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {

				boolean invalid = false;
				int k = x, l = y;
				for (int a = 0; a < bi.getWidth(); a++) {
					l = y;
					for (int b = 0; b < bi.getHeight(); b++) {
						if (bi.getRGB(a, b) != image.getRGB(k, l)) {
							invalid = true;
							drawRectangle(image, a, b);
							break;
						} else {
							l++;
						}
					}
					if (invalid) {
						break;
					} else {
						k++;
					}
				}

				if (!invalid) {
					return true;
				}
			}
		}
		return false; // If no image is found
	}

	public static void drawRectangle(BufferedImage image, int x, int y) {
		Graphics2D g2d = image.createGraphics();

		g2d.setColor(Color.RED);

		g2d.drawRect(x, y, 100, 400);

		g2d.dispose();
	}

}
