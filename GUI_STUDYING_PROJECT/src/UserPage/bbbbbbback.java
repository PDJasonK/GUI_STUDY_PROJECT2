package UserPage;

package Brand;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class Volkswagen  extends WindowAdapter implements ActionListener {
   private JFrame frame;
   private int index;
   private JTextArea Area = new JTextArea();

   
   
   private String[] images = { "image/ID4.png", "image/ID5.png", "image/ID6.png", "image/ID3.png"};
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Volkswagen vk = new Volkswagen();
               vk.getFrame().setVisible(true);
               
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public Volkswagen() {
      ArrayList<CarDTO> arr = new ArrayList<CarDTO>();
      arr = VolkswagenF();
      setFrame(new JFrame());
      getFrame().setBounds(100, 100, 800, 800);
      getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getFrame().getContentPane().setLayout(null);
      getFrame().setLocationRelativeTo(null);
      getFrame().setResizable(false);

      Font font = new Font("굴림", Font.BOLD, 48);

      JLabel lblImage = new JLabel();
      lblImage.setBounds(0, 0, 980, 370);

      Area = new JTextArea();
      Area.setBounds(0, 400, 800, 240);
      Area.setFocusable(false);
      Area.setFont(new Font("Gothic", Font.BOLD, 22));

      getFrame().add(Area);

      lblImage.setIcon(new ImageIcon(images[getIndex()])); // index 처음 0, IMAGES[0] 랑 결과 같음
      getFrame().getContentPane().add(lblImage);
      Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: " + arr.get(getIndex()).getModel() + "\n"
            + "  가격:" + arr.get(getIndex()).getPrice() + "\n" + "  차량타입: " + arr.get(getIndex()).getType() + "\n"
            + "  배터리용량:" + arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
            + "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
            + arr.get(getIndex()).getMaxdistance() + "\n");

// frame 안에 이미지추가

      JButton btnPrev = new JButton("←");
      btnPrev.setBackground(Color.CYAN);
      btnPrev.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            ArrayList<CarDTO> arr = new ArrayList<CarDTO>();
            arr = VolkswagenF();
            if (getIndex() > 0) { // 현재 인덱스가 0보다 크면
               setIndex(getIndex() - 1); // 인덱스를 감소
               Area.setText(null);
               Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: "
                     + arr.get(getIndex()).getModel() + "\n" + "  가격:" + arr.get(getIndex()).getPrice() + "\n"
                     + "  차량타입: " + arr.get(getIndex()).getType() + "\n" + "  배터리용량:"
                     + arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
                     + "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
                     + arr.get(getIndex()).getMaxdistance() + "\n");
            } else { // 현재 인덱스가 0이면
               setIndex(images.length - 1); // 배열의 가장 큰 인덱스 번호로 변경
               if (getIndex() == 6) {
                  Area.setText(null);
                  Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: "
                        + arr.get(getIndex()).getModel() + "\n" + "  가격:" + arr.get(getIndex()).getPrice()
                        + "\n" + "  차량타입: " + arr.get(getIndex()).getType() + "\n" + "  배터리용량:"
                        + arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
                        + "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
                        + arr.get(getIndex()).getMaxdistance() + "\n");
               }
            }
            lblImage.setIcon(new ImageIcon(images[getIndex()])); // 버튼 누를때마다 다음 이미지로 이동
         }

      });
      btnPrev.setFont(font);
      btnPrev.setBounds(10, 665, 200, 80);
      getFrame().getContentPane().add(btnPrev);

      JButton logo = new JButton(new ImageIcon("image\\폭스바겐.jpg"));
      logo.setBackground(Color.WHITE);
      logo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }

      });
      logo.setFont(font);
      logo.setBounds(275, 645, 200, 117);
      getFrame().getContentPane().add(logo);