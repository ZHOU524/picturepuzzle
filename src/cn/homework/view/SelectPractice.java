package cn.homework.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import cn.homework.util.SwingConsole;
import cn.homework.util.button.ThumbButton;
import cn.homework.util.image.ImageView;
import cn.homework.util.layout.RowLayout;
import cn.homework.util.panel.BottomBar;
import cn.homework.util.panel.ChoicePanel;
import cn.homework.util.panel.MyPanel;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SelectPractice extends JFrame{
	
	private static final long serialVersionUID = 5551321679060060033L;

	//��ʾ��ͼ����
	ImageView canvas = new ImageView();
	//Ԥ��ͼ
	MyPanel thumbBar = new MyPanel();
	// ͼ�갴ť��
	List<ThumbButton> buttons = new ArrayList<ThumbButton>(); //������е���ϰ�ز�
	// �Ѷ�ѡ��ҳ
	JPanel choice = new ChoicePanel();
	// �ײ�ȷ��ȡ����
	BottomBar bottomBar = new BottomBar();
	
	private int curPage = 0; //��ǰҳ
	
	public SelectPractice(String title) {
		super(title);
		
		JPanel root = new JPanel();
		this.setContentPane(root);
		root.setLayout(new BorderLayout());
		
		MyPanel topBar = new MyPanel();
		topBar.setLayout(new BorderLayout());
		topBar.padding(10).preferredHeight(80);
		JButton prePage = new JButton("<");
		JButton nextPage = new JButton(">");
		prePage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(curPage > 0) {
					curPage--;
					updateThumbBar();
				}
			}
		});
		nextPage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(curPage < buttons.size() / 4) {
					curPage++;
					updateThumbBar();
				}
			}
		});
		
		thumbBar.setLayout(new RowLayout(10));
		thumbBar.padding(5).preferredHeight(80);
		topBar.add(prePage, BorderLayout.WEST);
		topBar.add(nextPage, BorderLayout.EAST);
		topBar.add(thumbBar, BorderLayout.CENTER);
		root.add(topBar, BorderLayout.PAGE_START);
		
		
		MyPanel main = new MyPanel();
		main.setLayout(new RowLayout(30));
		main.padding(10);
		root.add(main, BorderLayout.CENTER);
		
		
		canvas.setBackground(Color.white);
        canvas.setScaleType(ImageView.FIT_CENTER_INSIDE);
        canvas.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        canvas.setPreferredSize(new Dimension(300, 200));
		
        
		main.add(canvas);
		main.add(choice);
		
		
		root.add(bottomBar, BorderLayout.PAGE_END);
		
		ThumbClickListener clickListener = new ThumbClickListener();
        // ���� images �ļ����µ�ͼƬ ( �����ļ���ʽ )
        File imageDir = new File("practise");
        File[] imageFiles = imageDir.listFiles();
        for(File f: imageFiles)
        {
            ThumbButton button = new ThumbButton(f);
            buttons.add(button);

            button.setPreferredSize(new Dimension(80,80));
            button.setBgColor(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.white,3));
            button.addMouseListener( clickListener );
        }
        
        updateThumbBar();
	}
	private class ThumbClickListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            // ������İ�ť
            ThumbButton source = (ThumbButton)e.getSource();

            // ����İ�ť����ʾ��ɫ�����߿�
            // ������ť����ɫ��ͨ�߿�
            for(ThumbButton button: buttons)
            {
                if(button == source)
                {
                    button.setBorder(BorderFactory.createLineBorder(new Color(0x1E9FFF),3));
                }
                else
                {
                    button.setBorder(BorderFactory.createLineBorder(Color.white,3));
                }
            }

            // �м����� ��ʾ��ͼ
            canvas.setImage( source.image );
        }

    }
	
	private void updateThumbBar() {
		thumbBar.removeAll();
		if(curPage == buttons.size() / 4) {
			for(int i = curPage*4; i < buttons.size(); i++) {
				thumbBar.add(buttons.get(i), "auto");
			}
		} else {
			for(int i = curPage*4; i < curPage*4 + 4; i++) {
				thumbBar.add(buttons.get(i), "auto");
			}
		}
		thumbBar.updateUI();
		thumbBar.repaint();
	}
	
	public static void main(String[] args) {
		SwingConsole console = new SwingConsole();
		console.run(new SelectPractice("��ѡ��ͼƬ"));
	}
}
