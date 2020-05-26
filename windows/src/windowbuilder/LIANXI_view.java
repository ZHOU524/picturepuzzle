package windowbuilder;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LIANXI_view {
	
	private JFrame LIANXI_view;
	
	
	public  LIANXI_view() {
		initialize();
	}
	
	
	public void closeThis(){
		LIANXI_view.dispose();
	}
	
	
	private void initialize() {
		
		
		LIANXI_view = new JFrame();//��ܵ��������
		LIANXI_view.setIconImage(Toolkit.getDefaultToolkit().getImage(PINTU.class.getResource("/images/0427f65039b23489be76046b1cba8659.jpg")));
		LIANXI_view.getContentPane().setBackground(Color.WHITE);
		LIANXI_view.setTitle("��ϰģʽ");
		LIANXI_view.setBackground(Color.WHITE);//��ܱ���
		LIANXI_view.setBounds(100, 100, 450, 300);
		LIANXI_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LIANXI_view.getContentPane().setLayout(null);//����ܵĲ��ֹ������ص�
		LIANXI_view.setVisible(true);
		
		
		JButton Button_1 = new JButton("�ύ");//�ύ�İ�ť
		Button_1.setFont(new Font("����", Font.PLAIN, 15));//��������
		Button_1.setForeground(Color.WHITE);//������ɫ
		Button_1.setBackground(Color.GREEN);//��ť����ɫ
		Button_1.addActionListener(new ActionListener() {//�ύ��ť�¼�,����չ���幦��
			public void actionPerformed(ActionEvent e) {
	       
				
			   
				
			}
		});
		Button_1.setBounds(115, 260, 70, 30);//��ťλ��
		LIANXI_view.getContentPane().add(Button_1);//����ť������
		
		
		
		JButton Button_2 = new JButton("����");//���õİ�ť
		Button_2.addActionListener(new ActionListener() {//���õİ�ť�¼�������չ���幦��
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		Button_2.setFont(new Font("����", Font.PLAIN, 15));//��������
		Button_2.setBackground(Color.GREEN);//��ť����ɫ
		Button_2.setForeground(Color.WHITE);//������ɫ
		Button_2.setBounds(230,  260, 70, 30);//��ťλ��
		LIANXI_view.getContentPane().add(Button_2);//����ť������
		
		
		JLabel Label_yulan_photo = new JLabel("Ԥ��ͼ");
		Label_yulan_photo.setBackground(Color.BLUE);
		Label_yulan_photo.setBounds(300, 100, 150, 100);
		LIANXI_view.getContentPane().add(Label_yulan_photo);
		
		
		
		
		LIANXI_view.addComponentListener(new ComponentAdapter() {//�϶����ڼ�������ť������ͼ�洰�ڴ�С����Ӧ
            public void componentResized(ComponentEvent e) {  
               
            	
            	int width=LIANXI_view.getWidth();//��ȡ���ڿ��
                int height=LIANXI_view.getHeight();//��ȡ���ڸ߶�
                Button_1.setBounds(width*23/90, height*13/15, width*7/45, height/10);//��ť�洰�ڴ�С����Ӧ
                Button_2.setBounds(width*23/45, height*13/15, width*7/45, height/10);
               
                Label_yulan_photo.setBounds(width*2/3, height/3, width/3, height/3);
               
            }  

        }); 
		
		
	}
	
}
