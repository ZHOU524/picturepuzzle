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

public class CHUANGGUAN_view {
	
	private JFrame CHUANGGUAN_view;
	
	
	public CHUANGGUAN_view() {
		initialize();
	}
	
	
	public void closeThis(){
		CHUANGGUAN_view.dispose();
	}
	
	
	private void initialize() {
		
		CHUANGGUAN_view = new JFrame();//��ܵ��������
		CHUANGGUAN_view.setIconImage(Toolkit.getDefaultToolkit().getImage(PINTU.class.getResource("/images/0427f65039b23489be76046b1cba8659.jpg")));
		CHUANGGUAN_view.getContentPane().setBackground(Color.WHITE);
		CHUANGGUAN_view.setTitle("��ϰģʽ");
		CHUANGGUAN_view.setBackground(Color.WHITE);//��ܱ���
		CHUANGGUAN_view.setBounds(100, 100, 450, 300);
		CHUANGGUAN_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CHUANGGUAN_view.getContentPane().setLayout(null);//����ܵĲ��ֹ������ص�
		CHUANGGUAN_view.setVisible(true);
		
		
		JButton Button_1 = new JButton("�ύ");//�ύ�İ�ť
		Button_1.setFont(new Font("����", Font.PLAIN, 15));//��������
		Button_1.setForeground(Color.WHITE);//������ɫ
		Button_1.setBackground(Color.GREEN);//��ť����ɫ
		Button_1.addActionListener(new ActionListener() {//�ύ��ť�¼�,����չ���幦��
			public void actionPerformed(ActionEvent e) {
	       
				
			   
				
			}
		});
		Button_1.setBounds(115, 260, 70, 30);//��ťλ��
		CHUANGGUAN_view.getContentPane().add(Button_1);//����ť������
		
		
		
		JButton Button_2 = new JButton("����");//���õİ�ť
		Button_2.addActionListener(new ActionListener() {//���õİ�ť�¼�
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		Button_2.setFont(new Font("����", Font.PLAIN, 15));//��������
		Button_2.setBackground(Color.GREEN);//��ť����ɫ
		Button_2.setForeground(Color.WHITE);//������ɫ
		Button_2.setBounds(230,  260, 70, 30);//��ťλ��
		CHUANGGUAN_view.getContentPane().add(Button_2);//����ť������
		
		
		JLabel Label_yulan_photo = new JLabel("Ԥ��ͼ");
		Label_yulan_photo.setBackground(Color.BLUE);
		Label_yulan_photo.setBounds(300, 100, 150, 100);
		CHUANGGUAN_view.getContentPane().add(Label_yulan_photo);
		
		
		CHUANGGUAN_view.addComponentListener(new ComponentAdapter() {//�϶����ڼ�������ť������ͼ�洰�ڴ�С����Ӧ
            public void componentResized(ComponentEvent e) {  
               
            	
            	int width=CHUANGGUAN_view.getWidth();//��ȡ���ڿ��
                int height=CHUANGGUAN_view.getHeight();//��ȡ���ڸ߶�
                Button_1.setBounds(width*23/90, height*13/15, width*7/45, height/10);//��ť�洰�ڴ�С����Ӧ
                Button_2.setBounds(width*23/45, height*13/15, width*7/45, height/10);
		
                
                Label_yulan_photo.setBounds(width*2/3, height/3, width/3, height/3);
                
            }  

        }); 
	}
	
}