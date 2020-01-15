/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.CardLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Conexao extends javax.swing.JFrame {

    private static final int PORT = 123;
    private static String tipoUsuario;
    private String nomeUsuario;
    private Socket canal;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;

    public Conexao() {
        initComponents();
    }

    private void conectarServidor() throws IOException {
        InetAddress serverAddress = InetAddress.getByName("localhost");
        canal = new Socket(serverAddress, PORT);
        saida = new ObjectOutputStream(canal.getOutputStream());
        entrada = new ObjectInputStream(canal.getInputStream());
        saida.writeObject(nomeUsuario);
    }
    
    private void init() {
    	  new Conexao().setVisible(true);
    	  try {
    		  conectarServidor();
  		} catch (IOException e) {
  			e.printStackTrace();
  		} finally {
  			try {
  				canal.close();
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        panelEscolhaDeUsuario = new javax.swing.JPanel();
        labelPanelEscolhaDeUsuario = new javax.swing.JLabel();
        btnPanelTrabalhoEscolhaDeUsuario = new javax.swing.JButton();
        btnPanelClienteEscolhaDeUsuario = new javax.swing.JButton();
        labelEscolha = new javax.swing.JLabel();
        panelQualSeuNome = new javax.swing.JPanel();
        labelPanelQualSeuNome = new javax.swing.JLabel();
        inputPanelQualSeuNome = new javax.swing.JTextField();
        btnPanelQualSeuNome = new javax.swing.JToggleButton();
        labelNome = new javax.swing.JLabel();
        panelCliente = new javax.swing.JPanel();
        labelCliente = new javax.swing.JLabel();
        panelClienteConfiguracoes = new javax.swing.JPanel();
        labelPanelClienteConfiguracaoPasta = new javax.swing.JLabel();
        inpuutPanelClienteConfiguracaImagem = new javax.swing.JTextField();
        labelPanelClienteConfiguracaoImagem = new javax.swing.JLabel();
        inpuutPanelClienteConfiguracaoPasta = new javax.swing.JTextField();
        btnPanelClienteConfiguracaoImagem = new javax.swing.JToggleButton();
        btnPanelClienteConfiguracaoPasta = new javax.swing.JToggleButton();
        btnPanelClienteConfiguracaoPesquisar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaPanelCliente = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDePesquisas = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        panelPanelCliente = new javax.swing.JPanel();
        scrollPanelPanelCliente = new javax.swing.JScrollPane();
        labelPanelPanelScrolClienteImagem = new javax.swing.JLabel();
        panelTrabalhador = new javax.swing.JPanel();
        labelPanelTrabalhador = new javax.swing.JLabel();
        inputPanelTrabalhador = new javax.swing.JTextField();
        btnPanelTrabalhador = new javax.swing.JToggleButton();
        labelTrabalhador = new javax.swing.JLabel();
        paenlTrabalhadorAtivo = new javax.swing.JPanel();
        labelTrabalhadorAtivo = new javax.swing.JLabel();
        labelPanelTrabalhadorAtivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frameConexao"); // NOI18N

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 122)));
        painelPrincipal.setLayout(new java.awt.CardLayout());

        panelEscolhaDeUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelEscolhaDeUsuario.setMaximumSize(new java.awt.Dimension(1010, 700));
        panelEscolhaDeUsuario.setMinimumSize(new java.awt.Dimension(1010, 700));
        panelEscolhaDeUsuario.setPreferredSize(new java.awt.Dimension(1010, 700));

        labelPanelEscolhaDeUsuario.setBackground(new java.awt.Color(255, 255, 255));
        labelPanelEscolhaDeUsuario.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelPanelEscolhaDeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPanelEscolhaDeUsuario.setText("Voce e um Cliente ou um trabalhador?");
        labelPanelEscolhaDeUsuario.setToolTipText("");
        labelPanelEscolhaDeUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 48))); // NOI18N
        labelPanelEscolhaDeUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPanelTrabalhoEscolhaDeUsuario.setBackground(new java.awt.Color(220, 53, 69));
        btnPanelTrabalhoEscolhaDeUsuario.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btnPanelTrabalhoEscolhaDeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnPanelTrabalhoEscolhaDeUsuario.setText("Trabalhador");
        btnPanelTrabalhoEscolhaDeUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 48), new java.awt.Color(112, 112, 112))); // NOI18N
        btnPanelTrabalhoEscolhaDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelTrabalhoEscolhaDeUsuarioActionPerformed(evt);
            }
        });

        btnPanelClienteEscolhaDeUsuario.setBackground(new java.awt.Color(40, 167, 69));
        btnPanelClienteEscolhaDeUsuario.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btnPanelClienteEscolhaDeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnPanelClienteEscolhaDeUsuario.setText("Cliente");
        btnPanelClienteEscolhaDeUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 48))); // NOI18N
        btnPanelClienteEscolhaDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelClienteEscolhaDeUsuarioActionPerformed(evt);
            }
        });

        labelEscolha.setBackground(new java.awt.Color(255, 255, 255));
        labelEscolha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelEscolha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEscolha.setText("Usuario");

        javax.swing.GroupLayout panelEscolhaDeUsuarioLayout = new javax.swing.GroupLayout(panelEscolhaDeUsuario);
        panelEscolhaDeUsuario.setLayout(panelEscolhaDeUsuarioLayout);
        panelEscolhaDeUsuarioLayout.setHorizontalGroup(
            panelEscolhaDeUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEscolha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEscolhaDeUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEscolhaDeUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPanelEscolhaDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                    .addGroup(panelEscolhaDeUsuarioLayout.createSequentialGroup()
                        .addComponent(btnPanelTrabalhoEscolhaDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(btnPanelClienteEscolhaDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        panelEscolhaDeUsuarioLayout.setVerticalGroup(
            panelEscolhaDeUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEscolhaDeUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelEscolha)
                .addGap(20, 20, 20)
                .addComponent(labelPanelEscolhaDeUsuario)
                .addGap(20, 20, 20)
                .addGroup(panelEscolhaDeUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPanelTrabalhoEscolhaDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(btnPanelClienteEscolhaDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        painelPrincipal.add(panelEscolhaDeUsuario, "escolhaDeUsuario");

        panelQualSeuNome.setBackground(new java.awt.Color(255, 255, 255));
        panelQualSeuNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));
        panelQualSeuNome.setMaximumSize(new java.awt.Dimension(1010, 700));
        panelQualSeuNome.setMinimumSize(new java.awt.Dimension(1010, 700));
        panelQualSeuNome.setPreferredSize(new java.awt.Dimension(1010, 700));

        labelPanelQualSeuNome.setBackground(new java.awt.Color(255, 255, 255));
        labelPanelQualSeuNome.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelPanelQualSeuNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPanelQualSeuNome.setText("Como gostaria de ser chamado?");
        labelPanelQualSeuNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 48))); // NOI18N

        inputPanelQualSeuNome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        inputPanelQualSeuNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputPanelQualSeuNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));
        inputPanelQualSeuNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnPanelQualSeuNome.setBackground(new java.awt.Color(0, 123, 255));
        btnPanelQualSeuNome.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btnPanelQualSeuNome.setForeground(new java.awt.Color(255, 255, 255));
        btnPanelQualSeuNome.setText("Proximo");
        btnPanelQualSeuNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));
        btnPanelQualSeuNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelQualSeuNomeActionPerformed(evt);
            }
        });

        labelNome.setBackground(new java.awt.Color(255, 255, 255));
        labelNome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("Usuario");

        javax.swing.GroupLayout panelQualSeuNomeLayout = new javax.swing.GroupLayout(panelQualSeuNome);
        panelQualSeuNome.setLayout(panelQualSeuNomeLayout);
        panelQualSeuNomeLayout.setHorizontalGroup(
            panelQualSeuNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQualSeuNomeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelQualSeuNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPanelQualSeuNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPanelQualSeuNome, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQualSeuNomeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(inputPanelQualSeuNome)
                .addGap(20, 20, 20))
        );
        panelQualSeuNomeLayout.setVerticalGroup(
            panelQualSeuNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQualSeuNomeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelPanelQualSeuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(inputPanelQualSeuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(btnPanelQualSeuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        painelPrincipal.add(panelQualSeuNome, "qualSeuNome");

        panelCliente.setBackground(new java.awt.Color(255, 255, 255));
        panelCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 122), 1, true));
        panelCliente.setMaximumSize(new java.awt.Dimension(1010, 700));
        panelCliente.setMinimumSize(new java.awt.Dimension(1010, 700));
        panelCliente.setPreferredSize(new java.awt.Dimension(1010, 700));

        labelCliente.setBackground(new java.awt.Color(255, 255, 255));
        labelCliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCliente.setText("Cliente");

        panelClienteConfiguracoes.setBackground(new java.awt.Color(255, 255, 255));
        panelClienteConfiguracoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracoes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        labelPanelClienteConfiguracaoPasta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPanelClienteConfiguracaoPasta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPanelClienteConfiguracaoPasta.setText("Escolha o caminho da pasta: ");

        labelPanelClienteConfiguracaoImagem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPanelClienteConfiguracaoImagem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPanelClienteConfiguracaoImagem.setText("Escolha o caminho da imagem: ");

        inpuutPanelClienteConfiguracaoPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpuutPanelClienteConfiguracaoPastaActionPerformed(evt);
            }
        });

        btnPanelClienteConfiguracaoImagem.setBackground(new java.awt.Color(40, 167, 69));
        btnPanelClienteConfiguracaoImagem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPanelClienteConfiguracaoImagem.setText("Imagem");
        btnPanelClienteConfiguracaoImagem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 48))); // NOI18N

        btnPanelClienteConfiguracaoPasta.setBackground(new java.awt.Color(0, 123, 255));
        btnPanelClienteConfiguracaoPasta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPanelClienteConfiguracaoPasta.setText("Pasta");
        btnPanelClienteConfiguracaoPasta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 48))); // NOI18N

        btnPanelClienteConfiguracaoPesquisar.setBackground(new java.awt.Color(255, 193, 7));
        btnPanelClienteConfiguracaoPesquisar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPanelClienteConfiguracaoPesquisar.setText("Pesquisar");
        btnPanelClienteConfiguracaoPesquisar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 48))); // NOI18N
        btnPanelClienteConfiguracaoPesquisar.setPreferredSize(new java.awt.Dimension(99, 39));

        javax.swing.GroupLayout panelClienteConfiguracoesLayout = new javax.swing.GroupLayout(panelClienteConfiguracoes);
        panelClienteConfiguracoes.setLayout(panelClienteConfiguracoesLayout);
        panelClienteConfiguracoesLayout.setHorizontalGroup(
            panelClienteConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteConfiguracoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelClienteConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelPanelClienteConfiguracaoImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addComponent(inpuutPanelClienteConfiguracaImagem)
                    .addComponent(labelPanelClienteConfiguracaoPasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inpuutPanelClienteConfiguracaoPasta))
                .addGap(10, 10, 10)
                .addGroup(panelClienteConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteConfiguracoesLayout.createSequentialGroup()
                        .addComponent(btnPanelClienteConfiguracaoImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(panelClienteConfiguracoesLayout.createSequentialGroup()
                        .addComponent(btnPanelClienteConfiguracaoPasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
            .addGroup(panelClienteConfiguracoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnPanelClienteConfiguracaoPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        panelClienteConfiguracoesLayout.setVerticalGroup(
            panelClienteConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteConfiguracoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelClienteConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteConfiguracoesLayout.createSequentialGroup()
                        .addComponent(labelPanelClienteConfiguracaoImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inpuutPanelClienteConfiguracaImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPanelClienteConfiguracaoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelClienteConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelClienteConfiguracoesLayout.createSequentialGroup()
                        .addComponent(labelPanelClienteConfiguracaoPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(inpuutPanelClienteConfiguracaoPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClienteConfiguracoesLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnPanelClienteConfiguracaoPasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addComponent(btnPanelClienteConfiguracaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textAreaPanelCliente.setColumns(20);
        textAreaPanelCliente.setRows(5);
        textAreaPanelCliente.setText("Lista de Usuarios online:");
        jScrollPane1.setViewportView(textAreaPanelCliente);

        listaDePesquisas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listaDePesquisas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Normal" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaDePesquisas);

        jList1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Normal" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setToolTipText("");
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jList1);

        panelPanelCliente.setBackground(new java.awt.Color(255, 255, 255));

        labelPanelPanelScrolClienteImagem.setBackground(new java.awt.Color(255, 255, 255));
        labelPanelPanelScrolClienteImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPanelPanelScrolClienteImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPanelPanelCliente.setViewportView(labelPanelPanelScrolClienteImagem);

        javax.swing.GroupLayout panelPanelClienteLayout = new javax.swing.GroupLayout(panelPanelCliente);
        panelPanelCliente.setLayout(panelPanelClienteLayout);
        panelPanelClienteLayout.setHorizontalGroup(
            panelPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelPanelCliente)
        );
        panelPanelClienteLayout.setVerticalGroup(
            panelPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelPanelCliente)
        );

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(panelPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelClienteConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelCliente)
                .addGap(10, 10, 10)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(panelPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelClienteConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        painelPrincipal.add(panelCliente, "cliente");

        panelTrabalhador.setBackground(new java.awt.Color(255, 255, 255));
        panelTrabalhador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));
        panelTrabalhador.setMaximumSize(new java.awt.Dimension(1000, 700));
        panelTrabalhador.setMinimumSize(new java.awt.Dimension(1000, 700));
        panelTrabalhador.setPreferredSize(new java.awt.Dimension(1000, 700));

        labelPanelTrabalhador.setBackground(new java.awt.Color(255, 255, 255));
        labelPanelTrabalhador.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelPanelTrabalhador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPanelTrabalhador.setText("Que tipo de Trabalhador voce e ?");
        labelPanelTrabalhador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 48))); // NOI18N

        inputPanelTrabalhador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        inputPanelTrabalhador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputPanelTrabalhador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));
        inputPanelTrabalhador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPanelTrabalhadorActionPerformed(evt);
            }
        });

        btnPanelTrabalhador.setBackground(new java.awt.Color(0, 123, 255));
        btnPanelTrabalhador.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btnPanelTrabalhador.setForeground(new java.awt.Color(255, 255, 255));
        btnPanelTrabalhador.setText("Proximo");
        btnPanelTrabalhador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));
        btnPanelTrabalhador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelTrabalhadorActionPerformed(evt);
            }
        });

        labelTrabalhador.setBackground(new java.awt.Color(255, 255, 255));
        labelTrabalhador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelTrabalhador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTrabalhador.setText("Trabalhador");

        javax.swing.GroupLayout panelTrabalhadorLayout = new javax.swing.GroupLayout(panelTrabalhador);
        panelTrabalhador.setLayout(panelTrabalhadorLayout);
        panelTrabalhadorLayout.setHorizontalGroup(
            panelTrabalhadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTrabalhador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrabalhadorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelTrabalhadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputPanelTrabalhador)
                    .addComponent(btnPanelTrabalhador, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addComponent(labelPanelTrabalhador, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelTrabalhadorLayout.setVerticalGroup(
            panelTrabalhadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrabalhadorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelTrabalhador)
                .addGap(20, 20, 20)
                .addComponent(labelPanelTrabalhador, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(inputPanelTrabalhador, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(btnPanelTrabalhador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        painelPrincipal.add(panelTrabalhador, "trabalhador");

        paenlTrabalhadorAtivo.setBackground(new java.awt.Color(220, 53, 69));
        paenlTrabalhadorAtivo.setPreferredSize(new java.awt.Dimension(1000, 700));

        labelTrabalhadorAtivo.setBackground(new java.awt.Color(255, 255, 255));
        labelTrabalhadorAtivo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelTrabalhadorAtivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTrabalhadorAtivo.setText("Trabalhador");

        labelPanelTrabalhadorAtivo.setBackground(new java.awt.Color(220, 53, 69));
        labelPanelTrabalhadorAtivo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelPanelTrabalhadorAtivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPanelTrabalhadorAtivo.setText("Trabalhador do tipo ()");

        javax.swing.GroupLayout paenlTrabalhadorAtivoLayout = new javax.swing.GroupLayout(paenlTrabalhadorAtivo);
        paenlTrabalhadorAtivo.setLayout(paenlTrabalhadorAtivoLayout);
        paenlTrabalhadorAtivoLayout.setHorizontalGroup(
            paenlTrabalhadorAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPanelTrabalhadorAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelTrabalhadorAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        paenlTrabalhadorAtivoLayout.setVerticalGroup(
            paenlTrabalhadorAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paenlTrabalhadorAtivoLayout.createSequentialGroup()
                .addComponent(labelTrabalhadorAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(labelPanelTrabalhadorAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelPrincipal.add(paenlTrabalhadorAtivo, "trabalhadorAtivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        painelPrincipal.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPanelClienteEscolhaDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelClienteEscolhaDeUsuarioActionPerformed
        tipoUsuario = "cliente";
        CardLayout c1 = (CardLayout) painelPrincipal.getLayout();
        c1.show(painelPrincipal, "qualSeuNome");
    }//GEN-LAST:event_btnPanelClienteEscolhaDeUsuarioActionPerformed

    private void btnPanelTrabalhoEscolhaDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelTrabalhoEscolhaDeUsuarioActionPerformed
        tipoUsuario = "trabalhador";
        CardLayout c1 = (CardLayout) painelPrincipal.getLayout();
        c1.show(painelPrincipal, "qualSeuNome");
    }//GEN-LAST:event_btnPanelTrabalhoEscolhaDeUsuarioActionPerformed

    private void btnPanelQualSeuNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelQualSeuNomeActionPerformed
        if (inputPanelQualSeuNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha os Campos!");
        } else {
            nomeUsuario = inputPanelQualSeuNome.getText();
            if (tipoUsuario.equals("cliente")) {
                CardLayout c1 = (CardLayout) painelPrincipal.getLayout();
                c1.show(painelPrincipal, "cliente");
            } else {
                CardLayout c1 = (CardLayout) painelPrincipal.getLayout();
                c1.show(painelPrincipal, "trabalhador");
            }
        }
    }//GEN-LAST:event_btnPanelQualSeuNomeActionPerformed

    private void btnPanelTrabalhadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelTrabalhadorActionPerformed
        if (inputPanelTrabalhador.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha os Campos!");
        } else {
            CardLayout c1 = (CardLayout) painelPrincipal.getLayout();
            c1.show(painelPrincipal, "trabalhadorAtivo");
        }
    }//GEN-LAST:event_btnPanelTrabalhadorActionPerformed

    private void inputPanelTrabalhadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPanelTrabalhadorActionPerformed

    }//GEN-LAST:event_inputPanelTrabalhadorActionPerformed

    private void inpuutPanelClienteConfiguracaoPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpuutPanelClienteConfiguracaoPastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpuutPanelClienteConfiguracaoPastaActionPerformed


    public static void main(String args[]) {
       new Conexao().init();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnPanelClienteConfiguracaoImagem;
    private javax.swing.JToggleButton btnPanelClienteConfiguracaoPasta;
    private javax.swing.JToggleButton btnPanelClienteConfiguracaoPesquisar;
    private javax.swing.JButton btnPanelClienteEscolhaDeUsuario;
    private javax.swing.JToggleButton btnPanelQualSeuNome;
    private javax.swing.JToggleButton btnPanelTrabalhador;
    private javax.swing.JButton btnPanelTrabalhoEscolhaDeUsuario;
    private javax.swing.JTextField inputPanelQualSeuNome;
    private javax.swing.JTextField inputPanelTrabalhador;
    private javax.swing.JTextField inpuutPanelClienteConfiguracaImagem;
    private javax.swing.JTextField inpuutPanelClienteConfiguracaoPasta;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelEscolha;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPanelClienteConfiguracaoImagem;
    private javax.swing.JLabel labelPanelClienteConfiguracaoPasta;
    private javax.swing.JLabel labelPanelEscolhaDeUsuario;
    private javax.swing.JLabel labelPanelPanelScrolClienteImagem;
    private javax.swing.JLabel labelPanelQualSeuNome;
    private javax.swing.JLabel labelPanelTrabalhador;
    private javax.swing.JLabel labelPanelTrabalhadorAtivo;
    private javax.swing.JLabel labelTrabalhador;
    private javax.swing.JLabel labelTrabalhadorAtivo;
    private javax.swing.JList<String> listaDePesquisas;
    private javax.swing.JPanel paenlTrabalhadorAtivo;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelClienteConfiguracoes;
    private javax.swing.JPanel panelEscolhaDeUsuario;
    private javax.swing.JPanel panelPanelCliente;
    private javax.swing.JPanel panelQualSeuNome;
    private javax.swing.JPanel panelTrabalhador;
    private javax.swing.JScrollPane scrollPanelPanelCliente;
    private javax.swing.JTextArea textAreaPanelCliente;
    // End of variables declaration//GEN-END:variables
}
