package Telas;

import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Sistema.FindImage;
import Sistema.Trabalhador;

public class ClienteTela extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private static double angulo = 0;
	private DefaultListModel<String> listaImagensModificadas = new DefaultListModel<String>();
	private static DefaultListModel<String> listaDeProcura = new DefaultListModel<String>();
	private static DefaultListModel<String> listaDeProcura2 = new DefaultListModel<String>();
	private File caminhoPasta;
	private File caminhoLogo;
	private String caminhoImagensModificadas = "C:/Users/marce/git/Projeto-PCD/src/img/modified/";
	private static Trabalhador tipoPesquisa = new Trabalhador();

	public ClienteTela() {
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
			FindImage.isOnImagem(find, image, caminhoImagensModificadas, angulo);
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

	public static void addListaProcura() {
		for (String s : tipoPesquisa.tipoPesquisa) {
			listaDeProcura2.addElement(s);
			listaDeProcura.addElement(s);
		}
		listaProcura2.setModel(listaDeProcura2);
		listaProcura.setModel(listaDeProcura);
	}

	public static DefaultListModel<String> getListaDeProcura() {
		return listaDeProcura;
	}

	public static void setListaDeProcura(DefaultListModel<String> listaDeProcura) {
		ClienteTela.listaDeProcura = listaDeProcura;
	}

	public static DefaultListModel<String> getListaDeProcura2() {
		return listaDeProcura2;
	}

	public static void setListaDeProcura2(DefaultListModel<String> listaDeProcura2) {
		ClienteTela.listaDeProcura2 = listaDeProcura2;
	}

	public static javax.swing.JList<String> getListaProcura2() {
		return listaProcura2;
	}

	public static void setListaProcura2(javax.swing.JList<String> listaProcura2) {
		ClienteTela.listaProcura2 = listaProcura2;
	}

	public static javax.swing.JList<String> getListaProcura() {
		return listaProcura;
	}

	public static void setListaProcura(javax.swing.JList<String> listaProcura) {
		ClienteTela.listaProcura = listaProcura;
	}

	public static void addListaProcura2(String procura) {
		listaDeProcura.addElement(procura);
		listaDeProcura2.addElement(procura);
		listaProcura2.setModel(listaDeProcura2);
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
					if (selectedValue.equals("Procura Simples")) {
						System.out.println(selectedValue + "\n");
					} else {
						angulo = Double.parseDouble(selectedValue);
						System.out.print(selectedValue + "\n");
					}
				}
			}
		});
	}

	private void usuarioSelecionaProcura2() {
		listaProcura2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selectedValue = listaProcura2.getSelectedValue();
					System.out.println(selectedValue);
					inputAddPesquisa.setText(selectedValue);
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		JpanelUsuario = new javax.swing.JPanel();
		UsuarioPanel = new javax.swing.JPanel();
		jToggleButton1 = new javax.swing.JToggleButton();
		jToggleButton2 = new javax.swing.JToggleButton();
		jLabel1 = new javax.swing.JLabel();
		UsuarioClienteProcuraImagem = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		campoImagem = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		btnProcurar = new javax.swing.JToggleButton();
		inputImagem = new javax.swing.JTextField();
		inputPasta = new javax.swing.JTextField();
		btnImagem = new javax.swing.JToggleButton();
		btnPasta = new javax.swing.JToggleButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		listaProcura = new javax.swing.JList<>();
		jScrollPane3 = new javax.swing.JScrollPane();
		listaImagens = new javax.swing.JList<>();
		UsuarioTrabalhadorFim = new javax.swing.JPanel();
		jScrollPane4 = new javax.swing.JScrollPane();
		listaProcura2 = new javax.swing.JList<>();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		inputAddPesquisa = new javax.swing.JTextField();
		btnSalvarPesquisa = new javax.swing.JButton();
		btnProximoTrabalhador = new javax.swing.JButton();
		UsuarioTrabalhadorFuncao = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JpanelUsuario.setBackground(new java.awt.Color(255, 255, 255));
		JpanelUsuario.setToolTipText("");
		JpanelUsuario.setRequestFocusEnabled(false);
		JpanelUsuario.setLayout(new java.awt.CardLayout());

		UsuarioPanel.setBackground(new java.awt.Color(255, 255, 255));

		jToggleButton1.setBackground(new java.awt.Color(40, 167, 69));
		jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 48));
		jToggleButton1.setSelected(true);
		jToggleButton1.setText("Cliente");
		jToggleButton1.setDoubleBuffered(true);
		jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton1ActionPerformed(evt);
			}
		});

		jToggleButton2.setBackground(new java.awt.Color(0, 123, 255));
		jToggleButton2.setFont(new java.awt.Font("Tahoma", 0, 48));
		jToggleButton2.setText("Trabalhador");
		jToggleButton2.setDoubleBuffered(true);
		jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton2ActionPerformed(evt);
			}
		});

		jLabel1.setBackground(new java.awt.Color(255, 255, 255));
		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Voce é um Cliente ou um Trabalhador?");

		javax.swing.GroupLayout UsuarioPanelLayout = new javax.swing.GroupLayout(UsuarioPanel);
		UsuarioPanel.setLayout(UsuarioPanelLayout);
		UsuarioPanelLayout.setHorizontalGroup(UsuarioPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(UsuarioPanelLayout.createSequentialGroup().addContainerGap().addGroup(UsuarioPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(UsuarioPanelLayout.createSequentialGroup()
								.addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)))
						.addContainerGap()));
		UsuarioPanelLayout.setVerticalGroup(
				UsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						UsuarioPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addGroup(UsuarioPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 500,
												Short.MAX_VALUE)
										.addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 500,
												Short.MAX_VALUE))
								.addContainerGap()));

		JpanelUsuario.add(UsuarioPanel, "telaPrincipal");

		UsuarioClienteProcuraImagem.setBackground(new java.awt.Color(0, 123, 255));

		jScrollPane1.setViewportView(campoImagem);

		btnProcurar.setText("Procurar");
		btnProcurar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnProcurarActionPerformed(evt);
			}
		});

		btnImagem.setText("Imagem");
		btnImagem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnImagemActionPerformed(evt);
			}
		});

		btnPasta.setText("Pasta");
		btnPasta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPastaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnProcurar, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel2Layout.createSequentialGroup()
												.addComponent(inputPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 800,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnPasta, javax.swing.GroupLayout.DEFAULT_SIZE, 332,
														Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel2Layout.createSequentialGroup()
												.addComponent(inputImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 800,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnImagem, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(inputPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(inputImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(20, Short.MAX_VALUE)));

		listaProcura.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				listaProcuraAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});

		listaProcura2.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				listaProcura2AncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});
		jScrollPane2.setViewportView(listaProcura);

		listaImagens.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				listaImagensAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});
		jScrollPane3.setViewportView(listaImagens);

		javax.swing.GroupLayout UsuarioClienteProcuraImagemLayout = new javax.swing.GroupLayout(
				UsuarioClienteProcuraImagem);
		UsuarioClienteProcuraImagem.setLayout(UsuarioClienteProcuraImagemLayout);
		UsuarioClienteProcuraImagemLayout.setHorizontalGroup(
				UsuarioClienteProcuraImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(UsuarioClienteProcuraImagemLayout.createSequentialGroup().addContainerGap()
								.addGroup(UsuarioClienteProcuraImagemLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(UsuarioClienteProcuraImagemLayout.createSequentialGroup()
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jScrollPane1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		UsuarioClienteProcuraImagemLayout.setVerticalGroup(
				UsuarioClienteProcuraImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(UsuarioClienteProcuraImagemLayout.createSequentialGroup().addContainerGap()
								.addGroup(UsuarioClienteProcuraImagemLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane1).addComponent(jScrollPane2)
										.addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JpanelUsuario.add(UsuarioClienteProcuraImagem, "tela1");

		UsuarioTrabalhadorFim.setBackground(new java.awt.Color(40, 167, 69));

		jScrollPane4.setViewportView(listaProcura2);

		jLabel2.setBackground(new java.awt.Color(255, 255, 255));
		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Adicione uma nova forma de pesquisa!");

		jLabel3.setBackground(new java.awt.Color(255, 255, 255));
		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Selecione seu tipo de pesquisa? ");

		btnSalvarPesquisa.setBackground(new java.awt.Color(0, 123, 255));
		btnSalvarPesquisa.setText("Salvar");
		btnSalvarPesquisa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalvarPesquisaActionPerformed(evt);
			}
		});

		btnProximoTrabalhador.setBackground(new java.awt.Color(255, 193, 7));
		btnProximoTrabalhador.setText("Proximo");
		btnProximoTrabalhador.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnProximoTrabalhadorActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout UsuarioTrabalhadorFimLayout = new javax.swing.GroupLayout(UsuarioTrabalhadorFim);
		UsuarioTrabalhadorFim.setLayout(UsuarioTrabalhadorFimLayout);
		UsuarioTrabalhadorFimLayout.setHorizontalGroup(UsuarioTrabalhadorFimLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(UsuarioTrabalhadorFimLayout.createSequentialGroup().addContainerGap()
						.addGroup(UsuarioTrabalhadorFimLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(inputAddPesquisa)
								.addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(UsuarioTrabalhadorFimLayout.createSequentialGroup()
										.addComponent(btnSalvarPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnProximoTrabalhador, javax.swing.GroupLayout.PREFERRED_SIZE,
												600, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		UsuarioTrabalhadorFimLayout.setVerticalGroup(
				UsuarioTrabalhadorFimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(UsuarioTrabalhadorFimLayout.createSequentialGroup().addGap(8, 8, 8)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12)
								.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 306,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(inputAddPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(UsuarioTrabalhadorFimLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnSalvarPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnProximoTrabalhador, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JpanelUsuario.add(UsuarioTrabalhadorFim, "tela2");

		UsuarioTrabalhadorFuncao.setBackground(new java.awt.Color(220, 53, 69));

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("Trabalhador " + inputAddPesquisa.getText() + "°");

		javax.swing.GroupLayout UsuarioTrabalhadorFuncaoLayout = new javax.swing.GroupLayout(UsuarioTrabalhadorFuncao);
		UsuarioTrabalhadorFuncao.setLayout(UsuarioTrabalhadorFuncaoLayout);
		UsuarioTrabalhadorFuncaoLayout.setHorizontalGroup(
				UsuarioTrabalhadorFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(UsuarioTrabalhadorFuncaoLayout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
								.addContainerGap()));
		UsuarioTrabalhadorFuncaoLayout.setVerticalGroup(
				UsuarioTrabalhadorFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(UsuarioTrabalhadorFuncaoLayout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
								.addContainerGap()));

		JpanelUsuario.add(UsuarioTrabalhadorFuncao, "tela3");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				JpanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				JpanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}

	private void btnSalvarPesquisaActionPerformed(java.awt.event.ActionEvent evt) {
		String pesquisa = inputAddPesquisa.getText();
		// tipoPesquisa.add(pesquisa);
		addListaProcura2(inputAddPesquisa.getText());

	}

	private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		CardLayout c1 = (CardLayout) JpanelUsuario.getLayout();
		c1.show(JpanelUsuario, "tela1");
	}

	private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {
		addCaminhoLogo();
	}

	private void btnPastaActionPerformed(java.awt.event.ActionEvent evt) {
		addCaminhoPasta();
	}

	private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		CardLayout c2 = (CardLayout) JpanelUsuario.getLayout();
		c2.show(JpanelUsuario, "tela2");
	}

	private void btnProximoTrabalhadorActionPerformed(java.awt.event.ActionEvent evt) {
		CardLayout c2 = (CardLayout) JpanelUsuario.getLayout();
		c2.show(JpanelUsuario, "tela3");
	}

	private void listaProcuraAncestorMoved(javax.swing.event.AncestorEvent evt) {
		usuarioSelecionaProcura();
	}

	private void listaProcura2AncestorMoved(javax.swing.event.AncestorEvent evt) {
		usuarioSelecionaProcura2();
	}

	private void listaImagensAncestorMoved(javax.swing.event.AncestorEvent evt) {
		usuarioSelecionaImagem();
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
				new ClienteTela().setVisible(true);
				addListaProcura();

			}
		});
	}

	private javax.swing.JPanel JpanelUsuario;
	public javax.swing.JPanel UsuarioClienteProcuraImagem;
	private javax.swing.JPanel UsuarioPanel;
	private javax.swing.JPanel UsuarioTrabalhadorFim;
	private javax.swing.JPanel UsuarioTrabalhadorFuncao;
	private javax.swing.JToggleButton btnImagem;
	private javax.swing.JToggleButton btnPasta;
	private javax.swing.JToggleButton btnProcurar;
	private javax.swing.JLabel campoImagem;
	private javax.swing.JTextField inputImagem;
	private javax.swing.JTextField inputPasta;
	private javax.swing.JButton btnSalvarPesquisa;
	private javax.swing.JButton btnProximoTrabalhador;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private static javax.swing.JList<String> listaProcura2;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTextField inputAddPesquisa;
	private javax.swing.JToggleButton jToggleButton1;
	private javax.swing.JToggleButton jToggleButton2;
	private javax.swing.JList<String> listaImagens;
	private static javax.swing.JList<String> listaProcura;
}