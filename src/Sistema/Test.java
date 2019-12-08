package Sistema;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) throws IOException {
		String img = "C:/Users/marce/git/Projeto-PCD/src/img/in/Superman.png";
		String caminho = "C:/Users/marce/git/Projeto-PCD/src/img/modified/teste.png";
		BufferedImage image = ImageIO.read(new File(img));
		BufferedImage image2 = FindImage.rotateImage(image, 180);
		FindImage.save(image2, caminho);

	}

}
