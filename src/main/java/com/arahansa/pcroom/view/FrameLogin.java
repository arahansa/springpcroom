package com.arahansa.pcroom.view;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.arahansa.pcroom.util.FileManager;


 
public class FrameLogin extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	BufferedImage img = null;
    JTextField loginTextField;
    JPasswordField passwordField;
    ClassLoader classLoader = getClass().getClassLoader();
   
    JButton bt;
    
 
    
    public static void main(String[] args) throws Exception {
       new FrameLogin();
    }
 
    // constructor
    public FrameLogin() {
        setTitle("Login Panel");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // set layout
        setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1600, 900);
        layeredPane.setLayout(null);
 
        // panel 1. get Image
        try {
            img = ImageIO.read(FileManager.getFile("images/login.png"));
        } catch (IOException e) {
            System.out.println("Failed to load image");
            System.exit(0);
        }
         
        BackgroundPanel panel = new BackgroundPanel();
        panel.setBounds(0, 0, 1600, 900);
         
 
        //  configure Login text Field
        loginTextField = new JTextField(15);
        loginTextField.setBounds(731, 399, 280, 30);
        layeredPane.add(loginTextField);
        setFieldTransparency(loginTextField);
        
        // configure  passwordField
        passwordField = new JPasswordField(15);
        passwordField.setBounds(731, 529, 280, 30);
        passwordField.setText("message");
        setFieldTransparency(passwordField);
        layeredPane.add(passwordField);
 
        // add Login Button
        bt = new JButton(new ImageIcon(FileManager.getFilename("images/btLogin_hud.png")));
        bt.setBounds(755, 689, 104, 48);
        bt.addActionListener(this);//액션걸림
 
        // configure button transparency
        bt.setBorderPainted(false);
        bt.setFocusPainted(false);
        bt.setContentAreaFilled(false);
 
        layeredPane.add(bt);
 
        // add final panel
        layeredPane.add(panel);
        add(layeredPane);
        setVisible(true);
    }

	private void setFieldTransparency(JTextComponent component) {
		component.setOpaque(false);
		component.setForeground(Color.green);
		component.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	}
 
    class BackgroundPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(loginTextField.getText());
		System.out.println(passwordField.getPassword());
		
		//사용자가 값을 넣었는지 체크한 후에
		if(loginTextField.getText().equals("")|| new String(passwordField.getPassword()).equals("")){
			JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 입력해주세요", "아이디나 비밀번호 입력", JOptionPane.INFORMATION_MESSAGE);
		}else{
			//사용자가 값을 넣었으면 로그인 체크를 한다. 
			System.out.println("사용자 로그인을 해야되는데.. 데이터베이스에 접근해야 됩니다. ");
		}
	}
 
}