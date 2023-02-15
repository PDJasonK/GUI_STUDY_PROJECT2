package AdminChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ClientGui extends JFrame implements ActionListener {
    private JTextField jtf;
    private JTextArea jta;
    private ChatCli cc = new ChatCli();

    public ClientGui() {
         setTitle("클라이언트");
         setBounds(500, 100, 300, 400);
         jta = new JTextArea(40, 25);
         jtf = new JTextField(25);
         add(jta, BorderLayout.CENTER);
         add(jtf, BorderLayout.SOUTH);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);

         jtf.addActionListener(this);
         cc.setCg(this);
         cc.connect();
         }
      @Override
         public void actionPerformed(ActionEvent e) {
               String msg = jtf.getText() + "\n";
               jta.append("클라이언트:"+msg);
               cc.sendMessage(msg);
               jtf.setText("");
          }

         public void appendMsg(String msg) {
               jta.append(msg);
          }

          public static void main(String[] args){
               new ClientGui();
          }
       }
 