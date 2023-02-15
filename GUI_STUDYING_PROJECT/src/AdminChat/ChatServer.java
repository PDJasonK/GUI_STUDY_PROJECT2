package AdminChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ChatServ {

	ServerSocket ss;
	private Socket s;
	private DataInputStream din;
	private DataOutputStream dout;
	private ServerGui sg;

	public void setSg(ServerGui sg) {
		this.sg = sg;
	}

	public void setting() {
		try {
			ss = new ServerSocket(8888);
			s = ss.accept();

			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			String msg = din.readUTF();
			sg.appendMsg(msg);

			while (din != null) {
				msg = din.readUTF();
				sg.appendMsg(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try {
			dout.writeUTF("서버 :" + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
