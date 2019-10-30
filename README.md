#Apresentação do Trabalho

#Dicas:

 //read image

 BufferedImage image = ImageIO.read(new File(filename));

 System.out.println("Image " + image.getWidth() + " x "

 + image.getHeight());

 System.out.println(image.getRGB(10, 10));

//------#######-------

// To serialize

 // convert BufferedImage to byte array

 ByteArrayOutputStream baos = new ByteArrayOutputStream();

 ImageIO.write(image, "png", baos);

 baos.flush();

 img = baos.toByteArray();

 baos.close();

 // convert byte array to BufferedImage

 InputStream in = new ByteArrayInputStream(img);

 BufferedImage bImageFromConvert = ImageIO.read(in);

 ImageIO.write(bImageFromConvert, "png", new File(

 "imagens/out.png"));


//------#######-------

 

 //desenhar retângulo sobre imagem

 Graphics2D g2d = image.createGraphics();

 g2d.setColor(Color.RED);

 g2d.drawRect(0, 0, 100, 400);

 g2d.dispose();



//------#######-------

 // Utilização do JFileChooser

 JFileChooser jfc = new JFileChooser(".");

 jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

 int returnValue = jfc.showOpenDialog(null);

 if (returnValue == JFileChooser.APPROVE_OPTION) {

 File selectedFile = jfc.getSelectedFile();

 System.out.println(selectedFile.getAbsolutePath());

 }