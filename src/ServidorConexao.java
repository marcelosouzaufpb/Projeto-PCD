import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorConexao extends javax.swing.JFrame {

	public ServidorConexao() {
		initComponents();
	}

	public void init() {
		new ServidorConexao().setVisible(true);
		UsuarioControle outs = new UsuarioControle();
		ServerSocket s = null;
		try {
			s = new ServerSocket(PORT);
			while (true) {
				Socket clientSocket = s.accept();
				UsuarioConectado dealWithClient = new UsuarioConectado(clientSocket, outs);
				dealWithClient.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panelServidorConexao = new javax.swing.JPanel();
		labelServidorConexao = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panelServidorConexao.setBackground(new java.awt.Color(0, 123, 255));

		labelServidorConexao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		labelServidorConexao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelServidorConexao.setText("");
		labelServidorConexao.addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
				labelServidorConexaoAncestorMoved(evt);
			}

			public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
			}
		});

		javax.swing.GroupLayout panelServidorConexaoLayout = new javax.swing.GroupLayout(panelServidorConexao);
		panelServidorConexao.setLayout(panelServidorConexaoLayout);
		panelServidorConexaoLayout.setHorizontalGroup(
				panelServidorConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(
						labelServidorConexao, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE));
		panelServidorConexaoLayout.setVerticalGroup(
				panelServidorConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(
						labelServidorConexao, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(panelServidorConexao,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(panelServidorConexao,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void labelServidorConexaoAncestorMoved(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_labelServidorConexaoAncestorMoved
		labelServidorConexao.setText("Servidor Online!!!");
	}// GEN-LAST:event_labelServidorConexaoAncestorMoved

	public static void main(String args[]) {
		new ServidorConexao().init();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel labelServidorConexao;
	private javax.swing.JPanel panelServidorConexao;
	private static final int PORT = 8080;
	// End of variables declaration//GEN-END:variables
}
