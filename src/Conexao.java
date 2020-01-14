import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Conexao {
	// Essa classe ainda esta em andamento
	private static final int PORT = 123;
	private JFrame frame = new JFrame();
	private JButton send = new JButton("Send");
	private JTextArea talk = new JTextArea();
	private JTextField message = new JTextField();
	private String nick;
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Conexao() {
		setupGui();
	}

	private void setupGui() {
		nick = JOptionPane.showInputDialog("Qual � o teu nome?");
		frame.setTitle("PCD Skype - " + nick);
		talk.setEditable(false);
		JPanel bottonPanel = new JPanel(new BorderLayout());
		bottonPanel.add(message);
		bottonPanel.add(send, BorderLayout.EAST);
		Container cont = frame.getContentPane();
		cont.add(talk);
		cont.add(bottonPanel, BorderLayout.SOUTH);

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!message.getText().equals("")) {
					sendMessageToServer();
					message.setText("");
				}

			}
		});

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init() {
		frame.setVisible(true);
		try {
			connectToServer();
			getServerMessages();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void getServerMessages() throws IOException {
		while (true) {
			try {
				Cliente message = (Cliente) in.readObject();
				talk.append(message + "\n");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void connectToServer() throws IOException {
		InetAddress serverAddress = InetAddress.getByName("localhost");
		socket = new Socket(serverAddress, PORT);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
		out.writeObject(nick);
	}

	private void sendMessageToServer() {
		try {
			Cliente broadcastMessage = new Cliente(nick, message.getText());
			out.writeObject(broadcastMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Conexao().init();
	}
}
