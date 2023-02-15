package AdminChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


class ChatCli {  

   private Socket s;
   private DataInputStream din;
   private DataOutputStream dout;
   private ClientGui cg;

   public void setCg(ClientGui cg) {
       this.cg = cg;
  }

    public void connect() {
          try {
             s = new Socket("127.0.0.1", 8888);
             din = new DataInputStream(s.getInputStream());
             dout = new DataOutputStream(s.getOutputStream());  
             dout.writeUTF("클라이언트가 입장했습니다 \n");

             while(din != null) {
                String msg = din.readUTF();
                cg.appendMsg(msg);
              }
           } catch(IOException e) {
                 e.printStackTrace();
           }
        }
        public void sendMessage(String msg2) {
            try {
                dout.writeUTF("클라이언트:" + msg2);  
            } catch(IOException e) {
                e.printStackTrace();
            }
         }
    }
