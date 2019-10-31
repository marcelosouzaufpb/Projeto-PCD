import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class FindImage {

	public static void main(String[] args) {
		try {
			BufferedImage image = ImageIO.read(new File("/Users/ivocosta/git/Projeto-PCD/bin/img/in/Superman.png"));
			//BufferedImage image = ImageIO.read(new File("C:/Users/marce/git/Projeto-PCD/src/img/in/Superman.png"));
			boolean isOnScreen = isOnImagem(image);
			System.out.print(isOnScreen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The image function receives an image that will be compared with an already
	 * determined image, checking if there is one image inside the other, all behind
	 * rgb, returning true or false, for existence.
	 */
	private static boolean isOnImagem(BufferedImage bi) throws IOException {

		BufferedImage image = ImageIO.read(new File("/Users/ivocosta/git/Projeto-PCD/bin/img/out/image6_2.png"));
		//local variable is incorporated
		boolean vixi= false;

		

		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				/*
				 * int c = 0; int d = 0; int e = 0;
				 */
				boolean invalid = false;
				int k = x, l = y;
				for (int a = 0; a < bi.getWidth(); a++) {
					l = y;
					for (int b = 0; b < bi.getHeight(); b++) {
						if (bi.getRGB(a, b) != image.getRGB(k, l)) {
							invalid = true;
							break;
						} else {
							l++;
							// c++;
						}
						/*
						 * if (c == 1) { d = k; e = l; }
						 */
					}
					if (invalid) {
						break;
					} else if (!invalid) {
						drawRectangle(image, x, y, bi.getWidth(), bi.getHeight());
						save(image);
						//a local variable is incorporated to return a boolean as any image is drawn.
						vixi= true;
						
					}else {
						k++;
					}
				
				}
				//function below is unnecessary was searching the other superman images
				/*if (!invalid) {
					drawRectangle(image, x, y, bi.getWidth(), bi.getHeight());
					save(image);
					return true;
				}*/
			}
			
		}
		return vixi;
		 // If no image is found
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
	public static void save(BufferedImage image) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		ImageIO.write(image, "png", baos);

		baos.flush();

		byte[] img = baos.toByteArray();

		baos.close();

		InputStream in = new ByteArrayInputStream(img);

		BufferedImage bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "png", new File("/Users/ivocosta/git/Projeto-PCD/bin/img/out/out15.png"));


		
		//ImageIO.write(bImageFromConvert, "png", new File("C:\\Users\\marce\\git\\Projeto-PCD\\src\\img\\out\\out.png"));

	}

}
