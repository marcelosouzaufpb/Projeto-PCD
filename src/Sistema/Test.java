package Sistema;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) throws IOException {
		String find = "C:/Users/marce/git/Projeto-PCD/src/img/in/Superman.png";
		String img = "C:/Users/marce/git/Projeto-PCD/src/img/out/image2_3.png";
		String caminho = "C:/Users/marce/git/Projeto-PCD/src/img/modified/teste.png";
		BufferedImage image = ImageIO.read(new File(find));
		BufferedImage image2 = ImageIO.read(new File(img));
		FindImage.isOnImagem(image, image2, caminho, 180);
		//FindImage.save(FindImage.rotateImage(image, 180), caminho);

	}

}
