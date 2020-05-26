package cn.homework.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import cn.homework.util.CountClock;
import cn.homework.util.SwingConsole;
import cn.homework.util.image.ImageView;
import cn.homework.util.panel.OperationPanel;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LIANXI_view {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final boolean INCREASE = true;			//��ʱ����
	private JFrame jf = new JFrame();
	
	public LIANXI_view(BufferedImage image, int pattern) {
		init(image, pattern);
		SwingConsole.run(jf);
	}
	
	
	public void closeThis(){
		jf.dispose();
	}
	
	
	public void init(BufferedImage image, int pattern) {
		JPanel jpanelTime = new JPanel();
		CountClock cc = new CountClock(0, jpanelTime, null, INCREASE);
		cc.init();
		
		JPanel top = new JPanel();
		JPanel buttom = new JPanel();
		JButton back = new JButton("����");
		back.setPreferredSize(new Dimension(100, 100));
		
		top.setLayout(new BorderLayout());
		top.add(jpanelTime);
		top.add(back, BorderLayout.EAST);
		
		jf.add(top, BorderLayout.NORTH);
		
		ImageView previewArea = new ImageView();
		previewArea.setImage(image);
		OperationPanel operateArea = new OperationPanel(image, pattern);
		

		
		buttom.setLayout(new GridLayout(1, 2));
		buttom.add(previewArea);
		buttom.add(operateArea);
		
		
		jf.add(buttom);
		
		
		
	}
	
	
}