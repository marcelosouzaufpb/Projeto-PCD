import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class UsuarioConexao extends javax.swing.JFrame {
	private static File caminhoDaPasta;
	private static File caminhoDoLogo;
	private String caminhoImagensModificadas = "/Users/ivocosta/git/Projeto-PCD/img/modificadas/";
	private static double angulo = 0;
	private static DefaultListModel<String> listaImagensModificadas = new DefaultListModel<String>();
	private static DefaultListModel<String> listaOpcoesProcura = new DefaultListModel<String>();
	private static String tipoUsuario = "Cliente";
	private Socket socket;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	private static final int PORT = 8080;
	
	
	public UsuarioConexao() {
		interfaceUsuarioConexao();
	}
	

	private void findCaminhoImagem() {
		caminhoDoLogo = FindImage.fileChooser();
		inputImageUsuarioConexao.setText(caminhoDoLogo.toString() + "/Superman.png");
	}

	private void findCaminhoPasta() {
		caminhoDaPasta = FindImage.fileChooser();
		inputPastaUsuarioConexao.setText(caminhoDaPasta.toString());
	}

	private void addListaImagens() {
		File imagensModificadas = new File(caminhoImagensModificadas);
		for (File file : imagensModificadas.listFiles()) {
			listaImagensModificadas.addElement(file.getName());
		}
		
		listaClienteUsuarioConexao.setModel(listaImagensModificadas);
	}
	
	private void connectToServer() throws IOException {
		InetAddress serverAddress = InetAddress.getByName("localhost");
		socket = new Socket(serverAddress, PORT);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
		out.writeObject(tipoUsuario);
	}
	
	public static void getUsuariosOlines() throws IOException {
		while (true) {
			try {
				Online usuario = (Online) in.readObject();
				listaOpcoesProcura.addElement(usuario + "\n");
				listaTrabalhadorUsuarioConexao.setModel(listaOpcoesProcura);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void sendUsuario() {
		try {
			Usuario usuario = new Usuario(tipoUsuario, inputFormaDeTrabalhoUsuarioConexao.getText());
			out.writeObject(usuario);
			listaOpcoesProcura.addElement(usuario + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void interfaceUsuarioConexao() {

		panelUsuarioConexao = new javax.swing.JPanel();
		panelMenuUsuarioConexao = new javax.swing.JPanel();
		btnClienteUsuarioConexao = new javax.swing.JToggleButton();
		btnTrabalhadorUsuarioConexao = new javax.swing.JToggleButton();
		panelClienteUsuarioConexao = new javax.swing.JPanel();
		labelTituloUsuarioConexao = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		listaTrabalhadorUsuarioConexao = new javax.swing.JList<>();
		jScrollPane2 = new javax.swing.JScrollPane();
		listaClienteUsuarioConexao = new javax.swing.JList<>();
		panelImageUsuarioConexao = new javax.swing.JPanel();
		panelRolagemIMmageUsuarioConexao = new javax.swing.JScrollPane();
		jPanel1 = new javax.swing.JPanel();
		btnProcurarUsuarioConexao = new javax.swing.JToggleButton();
		inputImageUsuarioConexao = new javax.swing.JTextField();
		btnImagemUsuarioConexao = new javax.swing.JToggleButton();
		inputPastaUsuarioConexao = new javax.swing.JTextField();
		btnPastaUsuarioConexao = new javax.swing.JToggleButton();
		panelTrabalhadorUsuarioConexao = new javax.swing.JPanel();
		labelTituloTrabalhadorUsuarioConexao = new javax.swing.JLabel();
		labelPerguntaTrabalhadorUsuarioConexao = new javax.swing.JLabel();
		inputFormaDeTrabalhoUsuarioConexao = new javax.swing.JTextField();
		btnProximoTrabalhadorUsuarioConexao = new javax.swing.JToggleButton();
		panelTrabalhadorEsperaUsuarioConexao = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panelUsuarioConexao.setLayout(new java.awt.CardLayout());

		panelMenuUsuarioConexao.setBackground(new java.awt.Color(255, 255, 255));

		btnClienteUsuarioConexao.setBackground(new java.awt.Color(40, 167, 69));
		btnClienteUsuarioConexao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		btnClienteUsuarioConexao.setText("Cliente");
		btnClienteUsuarioConexao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClienteUsuarioConexaoActionPerformed(evt);
			}
		});

		btnTrabalhadorUsuarioConexao.setBackground(new java.awt.Color(220, 53, 69));
		btnTrabalhadorUsuarioConexao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		btnTrabalhadorUsuarioConexao.setText("Trabalhador");
		btnTrabalhadorUsuarioConexao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTrabalhadorUsuarioConexaoActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelMenuUsuarioConexaoLayout = new javax.swing.GroupLayout(panelMenuUsuarioConexao);
		panelMenuUsuarioConexao.setLayout(panelMenuUsuarioConexaoLayout);
		panelMenuUsuarioConexaoLayout.setHorizontalGroup(
				panelMenuUsuarioConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelMenuUsuarioConexaoLayout.createSequentialGroup().addContainerGap()
										.addComponent(btnClienteUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE,
												500, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnTrabalhadorUsuarioConexao,
												javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
										.addContainerGap()));
		panelMenuUsuarioConexaoLayout.setVerticalGroup(panelMenuUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuUsuarioConexaoLayout
						.createSequentialGroup().addContainerGap()
						.addGroup(panelMenuUsuarioConexaoLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnTrabalhadorUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnClienteUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE, 618,
										Short.MAX_VALUE))
						.addContainerGap()));

		panelUsuarioConexao.add(panelMenuUsuarioConexao, "Menu");

		panelClienteUsuarioConexao.setBackground(new java.awt.Color(255, 255, 255));

		labelTituloUsuarioConexao.setBackground(new java.awt.Color(255, 255, 255));
		labelTituloUsuarioConexao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		labelTituloUsuarioConexao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelTituloUsuarioConexao.setText("Cliente");

		listaTrabalhadorUsuarioConexao.setBackground(new java.awt.Color(0, 123, 255));
		listaTrabalhadorUsuarioConexao
				.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		listaTrabalhadorUsuarioConexao.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
		listaTrabalhadorUsuarioConexao.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				listaTrabalhadorUsuarioConexaoAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});
		jScrollPane1.setViewportView(listaTrabalhadorUsuarioConexao);

		listaClienteUsuarioConexao.setBackground(new java.awt.Color(40, 167, 69));
		listaClienteUsuarioConexao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		listaClienteUsuarioConexao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		listaClienteUsuarioConexao.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				listaClienteUsuarioConexaoAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});
		jScrollPane2.setViewportView(listaClienteUsuarioConexao);

		panelImageUsuarioConexao.setBackground(new java.awt.Color(255, 255, 255));
		panelImageUsuarioConexao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		panelRolagemIMmageUsuarioConexao.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout panelImageUsuarioConexaoLayout = new javax.swing.GroupLayout(panelImageUsuarioConexao);
		panelImageUsuarioConexao.setLayout(panelImageUsuarioConexaoLayout);
		panelImageUsuarioConexaoLayout.setHorizontalGroup(panelImageUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
						panelRolagemIMmageUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE));
		panelImageUsuarioConexaoLayout.setVerticalGroup(
				panelImageUsuarioConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panelRolagemIMmageUsuarioConexao));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		btnProcurarUsuarioConexao.setBackground(new java.awt.Color(220, 53, 69));
		btnProcurarUsuarioConexao.setText("Procurar");
		btnProcurarUsuarioConexao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnProcurarUsuarioConexaoActionPerformed(evt);
			}
		});

		btnImagemUsuarioConexao.setText("Imagem");
		btnImagemUsuarioConexao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnImagemUsuarioConexaoActionPerformed(evt);
			}
		});

		btnPastaUsuarioConexao.setText("Pasta");
		btnPastaUsuarioConexao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPastaUsuarioConexaoActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnProcurarUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(inputPastaUsuarioConexao,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
												.addComponent(inputImageUsuarioConexao,
														javax.swing.GroupLayout.Alignment.LEADING))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(btnImagemUsuarioConexao,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnPastaUsuarioConexao,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(inputPastaUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE,
												30, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnPastaUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE,
												30, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(inputImageUsuarioConexao).addComponent(btnImagemUsuarioConexao,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnProcurarUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		javax.swing.GroupLayout panelClienteUsuarioConexaoLayout = new javax.swing.GroupLayout(
				panelClienteUsuarioConexao);
		panelClienteUsuarioConexao.setLayout(panelClienteUsuarioConexaoLayout);
		panelClienteUsuarioConexaoLayout.setHorizontalGroup(panelClienteUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(labelTituloUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(panelClienteUsuarioConexaoLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelClienteUsuarioConexaoLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(panelClienteUsuarioConexaoLayout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(panelImageUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		panelClienteUsuarioConexaoLayout.setVerticalGroup(panelClienteUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelClienteUsuarioConexaoLayout.createSequentialGroup()
						.addComponent(labelTituloUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelClienteUsuarioConexaoLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jScrollPane1)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
								.addComponent(panelImageUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panelUsuarioConexao.add(panelClienteUsuarioConexao, "Cliente");

		panelTrabalhadorUsuarioConexao.setBackground(new java.awt.Color(255, 255, 255));

		labelTituloTrabalhadorUsuarioConexao.setBackground(new java.awt.Color(255, 255, 255));
		labelTituloTrabalhadorUsuarioConexao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		labelTituloTrabalhadorUsuarioConexao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelTituloTrabalhadorUsuarioConexao.setText("Trabalhador");

		labelPerguntaTrabalhadorUsuarioConexao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		labelPerguntaTrabalhadorUsuarioConexao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelPerguntaTrabalhadorUsuarioConexao.setText("Digite a sua forma de Trabalho?");

		inputFormaDeTrabalhoUsuarioConexao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		inputFormaDeTrabalhoUsuarioConexao
				.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		btnProximoTrabalhadorUsuarioConexao.setBackground(new java.awt.Color(0, 123, 255));
		btnProximoTrabalhadorUsuarioConexao.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
		btnProximoTrabalhadorUsuarioConexao.setText("Proximo");
		btnProximoTrabalhadorUsuarioConexao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnProximoTrabalhadorUsuarioConexaoActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelTrabalhadorUsuarioConexaoLayout = new javax.swing.GroupLayout(
				panelTrabalhadorUsuarioConexao);
		panelTrabalhadorUsuarioConexao.setLayout(panelTrabalhadorUsuarioConexaoLayout);
		panelTrabalhadorUsuarioConexaoLayout.setHorizontalGroup(panelTrabalhadorUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(labelTituloTrabalhadorUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE, 1049,
						Short.MAX_VALUE)
				.addGroup(panelTrabalhadorUsuarioConexaoLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelTrabalhadorUsuarioConexaoLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelTrabalhadorUsuarioConexaoLayout.createSequentialGroup()
										.addComponent(labelPerguntaTrabalhadorUsuarioConexao,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(105, 105, 105))
								.addComponent(inputFormaDeTrabalhoUsuarioConexao)
								.addComponent(btnProximoTrabalhadorUsuarioConexao, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		panelTrabalhadorUsuarioConexaoLayout.setVerticalGroup(panelTrabalhadorUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelTrabalhadorUsuarioConexaoLayout.createSequentialGroup()
						.addComponent(labelTituloTrabalhadorUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(83, 83, 83)
						.addComponent(labelPerguntaTrabalhadorUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE,
								50, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(156, 156, 156)
						.addComponent(inputFormaDeTrabalhoUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
						.addComponent(btnProximoTrabalhadorUsuarioConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		panelUsuarioConexao.add(panelTrabalhadorUsuarioConexao, "Trabalhador");

		panelTrabalhadorEsperaUsuarioConexao.setBackground(new java.awt.Color(220, 53, 69));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout panelTrabalhadorEsperaUsuarioConexaoLayout = new javax.swing.GroupLayout(
				panelTrabalhadorEsperaUsuarioConexao);
		panelTrabalhadorEsperaUsuarioConexao.setLayout(panelTrabalhadorEsperaUsuarioConexaoLayout);
		panelTrabalhadorEsperaUsuarioConexaoLayout.setHorizontalGroup(panelTrabalhadorEsperaUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE));
		panelTrabalhadorEsperaUsuarioConexaoLayout.setVerticalGroup(panelTrabalhadorEsperaUsuarioConexaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE));

		panelUsuarioConexao.add(panelTrabalhadorEsperaUsuarioConexao, "Espera");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelUsuarioConexao,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelUsuarioConexao,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnClienteUsuarioConexaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClienteUsuarioConexaoActionPerformed
		CardLayout c1 = (CardLayout) panelUsuarioConexao.getLayout();
		c1.show(panelUsuarioConexao, "Cliente");
		tipoUsuario = "Cliente";
	}// GEN-LAST:event_btnClienteUsuarioConexaoActionPerformed

	private void btnTrabalhadorUsuarioConexaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTrabalhadorUsuarioConexaoActionPerformed
		CardLayout c1 = (CardLayout) panelUsuarioConexao.getLayout();
		c1.show(panelUsuarioConexao, "Trabalhador");
		tipoUsuario = "Trabalhador";
	}// GEN-LAST:event_btnTrabalhadorUsuarioConexaoActionPerformed

	private void btnProximoTrabalhadorUsuarioConexaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnProximoTrabalhadorUsuarioConexaoActionPerformed
		CardLayout c1 = (CardLayout) panelUsuarioConexao.getLayout();
		c1.show(panelUsuarioConexao, "Espera");
		String formaDeTrabalho = inputFormaDeTrabalhoUsuarioConexao.getText();
		jLabel1.setText("Trabalhador (" + formaDeTrabalho + ")");
		sendUsuario();

	}// GEN-LAST:event_btnProximoTrabalhadorUsuarioConexaoActionPerformed

	private void btnPastaUsuarioConexaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPastaUsuarioConexaoActionPerformed
		findCaminhoPasta();
	}// GEN-LAST:event_btnPastaUsuarioConexaoActionPerformed

	private void listaTrabalhadorUsuarioConexaoAncestorMoved(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_listaTrabalhadorUsuarioConexaoAncestorMoved
	}// GEN-LAST:event_listaTrabalhadorUsuarioConexaoAncestorMoved

	private void listaClienteUsuarioConexaoAncestorMoved(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_listaClienteUsuarioConexaoAncestorMoved
		// lista de procura
	}// GEN-LAST:event_listaClienteUsuarioConexaoAncestorMoved

	private void btnImagemUsuarioConexaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImagemUsuarioConexaoActionPerformed
		findCaminhoImagem();
	}// GEN-LAST:event_btnImagemUsuarioConexaoActionPerformed

	private void btnProcurarUsuarioConexaoActionPerformed(java.awt.event.ActionEvent evt) {
		// GEN-FIRST:event_btnProcurarUsuarioConexaoActionPerformed
		
		if (inputImageUsuarioConexao.getText().equals("") && inputImageUsuarioConexao.getText().endsWith("")) {
			JOptionPane.showMessageDialog(this, "Preencha os Campos!");

		}
	}// GEN-LAST:event_btnProcurarUsuarioConexaoActionPerformed
	
	private void init() {
		new UsuarioConexao().setVisible(true);
		
		try {
			connectToServer();
			getUsuariosOlines();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new UsuarioConexao().init();
		
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToggleButton btnClienteUsuarioConexao;
	private javax.swing.JToggleButton btnImagemUsuarioConexao;
	private javax.swing.JToggleButton btnPastaUsuarioConexao;
	private javax.swing.JToggleButton btnProcurarUsuarioConexao;
	private javax.swing.JToggleButton btnProximoTrabalhadorUsuarioConexao;
	private javax.swing.JToggleButton btnTrabalhadorUsuarioConexao;
	private javax.swing.JTextField inputFormaDeTrabalhoUsuarioConexao;
	private javax.swing.JTextField inputImageUsuarioConexao;
	private javax.swing.JTextField inputPastaUsuarioConexao;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel labelPerguntaTrabalhadorUsuarioConexao;
	private javax.swing.JLabel labelTituloTrabalhadorUsuarioConexao;
	private javax.swing.JLabel labelTituloUsuarioConexao;
	private javax.swing.JList<String> listaClienteUsuarioConexao;
	private static javax.swing.JList<String> listaTrabalhadorUsuarioConexao;
	private javax.swing.JPanel panelClienteUsuarioConexao;
	private javax.swing.JPanel panelImageUsuarioConexao;
	private javax.swing.JPanel panelMenuUsuarioConexao;
	private javax.swing.JScrollPane panelRolagemIMmageUsuarioConexao;
	private javax.swing.JPanel panelTrabalhadorEsperaUsuarioConexao;
	private javax.swing.JPanel panelTrabalhadorUsuarioConexao;
	private javax.swing.JPanel panelUsuarioConexao;
	// End of variables declaration//GEN-END:variables

}
