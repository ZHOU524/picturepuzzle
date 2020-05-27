package cn.homework.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.homework.util.CountClock;
import cn.homework.util.SwingConsole;
import cn.homework.util.TimeFormat;
import cn.homework.util.image.ImageView;
import cn.homework.util.panel.MyPanel;
import cn.homework.util.panel.OperationPanel;

import java.awt.image.BufferedImage;

public class LIANXI_view extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jpanelTime = new MyPanel();
	CountClock cc = new CountClock(new TimeFormat(0, 0), jpanelTime, CountClock.LIANXI);
	
	private JPanel root;
	
	public LIANXI_view(BufferedImage image, int pattern) {
		
		root = (JPanel)this.getContentPane();
		init(image, pattern);
	}
	
	
	public void init(BufferedImage image, int pattern) {
		//��ʼ����ʱ��
		cc.init();
		
		JPanel top = new MyPanel();
		JPanel buttom = new MyPanel();
		JButton back = new JButton("����");
		back.setPreferredSize(new Dimension(100, 100));
		back.addActionListener(new Tomenu());
		
		top.setLayout(new BorderLayout());
		top.add(jpanelTime);
		top.add(back, BorderLayout.EAST);
		
		//������ʱ���뷵�ذ�ť�����
		root.add(top, BorderLayout.NORTH);
		
		//Ԥ��������ƴͼ��������
		ImageView previewArea = new ImageView();
		previewArea.setImage(image);
		OperationPanel operateArea  = new OperationPanel(image, pattern);
		operateArea.setListener(true);
		
		new Thread( new Runnable() {
			@Override
			public void run() {
				while(true)
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if( operateArea.check() == true ) {
						cc.setStopCountFlag(true);
						
						JButton ctn = new JButton("����");
						JButton rtn = new JButton("����");
						
						ctn.addActionListener(new CtnGame());
						rtn.addActionListener(new Tomenu());
						
						JButton[] bs = {ctn, rtn};
						JOptionPane.showOptionDialog(operateArea, "ƴͼ���", "ѡ��", 1,3, null, bs, bs[0]);
						break;
					}
				}
			}
		}).start();
		
		buttom.setLayout(new GridLayout(1, 2));
		buttom.add(previewArea);
		buttom.add(operateArea);
		
		root.add(buttom);
		
	}

	class Tomenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cc.setStopCountFlag(true);
			
			dispose();
			
			PINTU window = new PINTU();
			
			SwingConsole.run(window.PINTU);			
		}
	}
	
	class CtnGame implements ActionListener {
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			// TODO Auto-generated method stub
			SelectPractice s = new SelectPractice("ѡ��ǰͼƬ");
			SwingConsole.run(s);
		}
	    
	}
}