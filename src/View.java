import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class View extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> listaImagensModificadas = new DefaultListModel<String>();
	private static DefaultListModel<String> listaDeProcura = new DefaultListModel<String>();
	private File caminhoPasta;
	private File caminhoLogo;
	private String caminhoImagensModificadas = "C:/Users/marce/git/Projeto-PCD/src/img/modified/";

	public View() {
		initComponents();
	}

	private void addCaminhoLogo() {
		caminhoLogo = FindImage.fileChooser();
		inputImagem.setText(caminhoLogo.toString() + "/Superman.png");
	}

	private void addCaminhoPasta() {
		caminhoPasta = FindImage.fileChooser();
		inputPasta.setText(caminhoPasta.toString());
	}

	private void modificaImagem() throws IOException {
		String img = "";
		for (File file : caminhoPasta.listFiles()) {
			img = caminhoPasta + "/" + file.getName();

			BufferedImage find = ImageIO.read(new File(caminhoLogo.toString() + "/Superman.png"));
			BufferedImage image = ImageIO.read(new File(img));

			String caminhoTemporario = caminhoImagensModificadas;
			caminhoImagensModificadas += file.getName();
			FindImage.isOnImagem(find, image, caminhoImagensModificadas);
			caminhoImagensModificadas = caminhoTemporario;
		}
	}

	private void addListaImagem() {
		File imagensModificadas = new File(caminhoImagensModificadas);
		for (File file : imagensModificadas.listFiles()) {
			listaImagensModificadas.addElement(file.getName());
		}

		listaImagens.setModel(listaImagensModificadas);
	}

	private static void addListaProcura() {
		listaDeProcura.addElement("Procura Simples");
		listaProcura.setModel(listaDeProcura);
	}

	private void usuarioSelecionaImagem() {
		File imagensModificadas = new File(caminhoImagensModificadas);
		listaImagens.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selectedValue = listaImagens.getSelectedValue();
					ImageIcon m = new ImageIcon(imagensModificadas.toString() + "/" + selectedValue);
					campoImagem.setIcon(m);
				}

			}
		});
	}

	private void usuarioSelecionaProcura() {
		listaProcura.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selectedValue = listaProcura.getSelectedValue();
					System.out.println(selectedValue);
				}
			}
		});
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		btnPasta = new javax.swing.JToggleButton();
		btnProcurar = new javax.swing.JToggleButton();
		btnImagem = new javax.swing.JToggleButton();
		inputImagem = new javax.swing.JTextField();
		inputPasta = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		listaImagens = new javax.swing.JList<>();
		jScrollPane2 = new javax.swing.JScrollPane();
		listaProcura = new javax.swing.JList<>();
		painelComScroll = new javax.swing.JScrollPane();
		campoImagem = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));
		setResizable(false);

		btnPasta.setBackground(new java.awt.Color(255, 255, 255));
		btnPasta.setText("Pasta");
		btnPasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		btnPasta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPastaActionPerformed(evt);
			}
		});

		btnProcurar.setBackground(new java.awt.Color(255, 255, 255));
		btnProcurar.setText("Procurar");
		btnProcurar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		btnProcurar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnProcurarActionPerformed(evt);
			}
		});

		btnImagem.setBackground(new java.awt.Color(255, 255, 255));
		btnImagem.setText("Imagem");
		btnImagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		btnImagem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnImagemActionPerformed(evt);
			}
		});

		listaImagens.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
		listaImagens.setMaximumSize(new java.awt.Dimension(150, 0));
		listaImagens.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				listImagensAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});
		jScrollPane1.setViewportView(listaImagens);

		listaProcura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
		listaProcura.setMaximumSize(new java.awt.Dimension(150, 0));
		listaProcura.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				listProcuraAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});
		jScrollPane2.setViewportView(listaProcura);

		painelComScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
		painelComScroll.setViewportView(campoImagem);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnProcurar, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(inputPasta).addComponent(inputImagem))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(btnPasta, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnImagem, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(painelComScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 772,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
										javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543,
												Short.MAX_VALUE)
										.addComponent(painelComScroll))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnPasta).addComponent(inputPasta,
												javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnImagem).addComponent(inputImagem,
												javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnProcurar).addGap(7, 7, 7)));

		pack();
	}

	private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {
		addCaminhoLogo();
	}

	private void btnPastaActionPerformed(java.awt.event.ActionEvent evt) {
		addCaminhoPasta();
	}

	private void listImagensAncestorMoved(javax.swing.event.AncestorEvent evt) {
		usuarioSelecionaImagem();
	}

	private void listProcuraAncestorMoved(javax.swing.event.AncestorEvent evt) {
		usuarioSelecionaProcura();
	}

	private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {
		if (inputImagem.getText().equals("") && inputPasta.getText().endsWith("")) {
			JOptionPane.showMessageDialog(this, "Preencha os Campos!");

		} else {
			try {
				modificaImagem();
			} catch (IOException e) {
				e.printStackTrace();
			}
			addListaImagem();
		}
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new View().setVisible(true);
				addListaProcura();
			}
		});
	}

	private javax.swing.JToggleButton btnImagem;
	private javax.swing.JToggleButton btnPasta;
	private javax.swing.JToggleButton btnProcurar;
	private javax.swing.JLabel campoImagem;
	private javax.swing.JTextField inputImagem;
	private javax.swing.JTextField inputPasta;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JList<String> listaImagens;
	private static javax.swing.JList<String> listaProcura;
	private javax.swing.JScrollPane painelComScroll;
}
