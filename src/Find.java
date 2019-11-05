
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class Find extends javax.swing.JFrame {
	public FindImage fm = new FindImage();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	String findImage = "C:/Users/marce/git/Projeto-PCD/src/img/in/Superman.png";
	String img = "";
	String caminho = "C:/Users/marce/git/Projeto-PCD/src/img/modified/";

	public Find() {
		initComponents();
	}

	public void addListImage() {
		File selectedFile = fm.fileChooser();
		jTextField1.setText(selectedFile.toString());
		for (File file : selectedFile.listFiles()) {
			dlm.addElement(file.getName());
		}
		listaDeImagem.setModel(dlm);
		listaDePesquisa.setModel(dlm);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		listaDeImagem = new javax.swing.JList<>();
		jButton1 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		painelImagem = new javax.swing.JPanel();
		show_image = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		listaDePesquisa = new javax.swing.JList<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		listaDeImagem.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
				listaDeImagemAncestorAdded(evt);
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});
		jScrollPane1.setViewportView(listaDeImagem);

		jButton1.setText("Procurar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Pasta");

		jButton3.setText("Imgem");

		painelImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		show_image.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
				show_imageAncestorAdded(evt);
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});

		javax.swing.GroupLayout painelImagemLayout = new javax.swing.GroupLayout(painelImagem);
		painelImagem.setLayout(painelImagemLayout);
		painelImagemLayout
				.setHorizontalGroup(painelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								painelImagemLayout.createSequentialGroup().addGap(0, 30, Short.MAX_VALUE).addComponent(
										show_image, javax.swing.GroupLayout.PREFERRED_SIZE, 612,
										javax.swing.GroupLayout.PREFERRED_SIZE)));
		painelImagemLayout.setVerticalGroup(
				painelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
						show_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jScrollPane3.setViewportView(listaDePesquisa);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 795,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 795,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
														Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(painelImagem, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 144,
												Short.MAX_VALUE)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE))))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1)
								.addComponent(painelImagem, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1)
						.addContainerGap()));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		addListImage();
	}

	private void listaDeImagemAncestorAdded(javax.swing.event.AncestorEvent evt) {

	}

	private void show_imageAncestorAdded(javax.swing.event.AncestorEvent evt) {
		int selecionado = listaDeImagem.getAnchorSelectionIndex();
		//ImageIcon m = new ImageIcon("C:\\Users\\marce\\git\\Projeto-PCD\\src\\img\\out\\" + imagem.toString());
		System.out.print(selecionado);
		//show_image.setIcon(m);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new Find().setVisible(true);

			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JList<String> listaDeImagem;
	private javax.swing.JList<String> listaDePesquisa;
	private javax.swing.JPanel painelImagem;
	private javax.swing.JLabel show_image;
	// End of variables declaration
}
