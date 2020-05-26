package cn.homework.util;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// ��ʱ����
public class CountClock {
	JLabel TimeLabel;			//��ʾʱ��ı�ǩ
	int time ;					//���յ������ʱ��
	int min;					//��
	int sec;					//��
	boolean CountDirection;		//��ʱ����		true:˳���ʱ	false:����ʱ
	
	//�ĸ���ť �������ÿ�ʼ��Ϸ��������Ϸ����ͣ��Ϸ��������Ϸ������ĸ�����Ӧ������Ҳ��
	JButton Start;
	JButton Reset;
	JButton Stop;
	JButton KeepOn;
	
	JPanel jpanelTime;  //��ʱ������
	JPanel jpanelButton;  //��ʱ������ť�����
	
	
	public CountClock(int time, JPanel jpanelTime, JPanel jpanelButton, boolean CountDirection) {
		super();
		this.time = time;
		this.jpanelTime = jpanelTime;
		this.jpanelButton = jpanelButton;
		this.CountDirection = CountDirection;
		
	}

	//�߳�
	TimerThread timerThread = new TimerThread();
	Thread th;
		
	//��ʼ������,�������趨�õ�ʱ�䡣
	public void init() {
		
		//��ʾʱ��
		TimeLabel = new JLabel("00:00");
		TimeLabel.setFont(new Font("����",1,36));
		TimeLabel.setPreferredSize(new Dimension(600, 100));
		TimeLabel.setBackground(Color.white);
		TimeLabel.setHorizontalAlignment(JLabel.CENTER);
		TimeLabel.setVerticalAlignment(JLabel.CENTER);
		
		TimeLabel.setForeground(Color.blue);
		jpanelTime.add(TimeLabel);
		
		//���ÿ�ʼ��ť
		Dimension preferredSize = new Dimension(160, 25); //���ð�ť�ߴ�
		Start = new JButton("��ʼ");
		Start.setPreferredSize(preferredSize);//����ť�޸ĳ����úõĳߴ�
		Start.addActionListener(new StartCountListener());//��Ӽ���
		//jpanelButton.add(Star);//��Ӱ�ť�����*/
				
		//�������ð�ť
		Reset = new JButton("����");
		Reset.addActionListener(new ResetCountListener());
		
		//������ͣ��ť
		Stop = new JButton("��ͣ");
		Stop.addActionListener(new StopActionListener());
		
		//���ü�����ť
		KeepOn = new JButton("����");
		KeepOn.addActionListener(new KeepOnActionListener());
	
	}
	
	//��ʱ�߳�ִ�еĳ���
	class TimerThread implements Runnable{
		public void run() {
			while(true) {
				//˳���ʱģʽ
				if(CountDirection == true) {
					if(sec==60) {
			        	min=min+1;
			        	sec=sec-60;
			        }
					DecimalFormat f1 = new DecimalFormat("00");
					TimeLabel.setText(f1.format(min)+":"+f1.format(sec));
					try {
						Thread.sleep(1000);//�߳�����һ�룬����+1
						sec++;
					}catch(InterruptedException e) {
						break;
				    }
				}
				//����ʱģʽ
				else {
					if(sec<0&&min>0) {
						sec=59;
						min--;
					}
					//�涨��ʾ�ĸ�ʽ
					//��ʱ���ǩ��ʾʱ�䣬ÿ��ˢ��һ��
					DecimalFormat f1 = new DecimalFormat("00");
					TimeLabel.setText(f1.format(min)+":"+f1.format(sec));
					
					//�ж�ʱ���Ƿ����꣬�����ɾ����ͣ��ť
					//TODO	����ģʽ����Ҫ����
					if(sec==0 && min==0) {
						TimeLabel.setText("00:00");
						/*jpanelButton.remove(Stop);
						jpanelButton.remove(KeepOn);
						jpanelTime.updateUI();
						Start.setEnabled(true);*/
						return;
					}
					
					try {
						Thread.sleep(1000);//�߳�����һ�룬����-1
						sec--;
					}catch(InterruptedException e) {
						break;
					}
				}
			}
		}
	}
	
	//TODO ��Ҫ����ʼ��ʱ�¼���ӵ�ͼƬѡ��ȷ�ϵİ�ť��
	//��ʼ��ʱ��ť��ť�����¼�
	 class StartCountListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//����ʼ��ť��Ϊ������
	        	Start.setEnabled(false);
	        	//ɾ��ԭ���

	        	jpanelButton.remove(Start);
	        	
	        	//������ø���ͣ
	        	jpanelButton.add(Reset);
	        	jpanelButton.add(Stop);
	        	//�ѱ�ǩ�ŵ������
	        	jpanelTime.add(TimeLabel);  
	        
	        	//ˢ�����  
	        	jpanelTime.updateUI();
	        	jpanelButton.updateUI();

//�涨��ʱ��
	        	//����������ַ�����ʱ��
	        		min = time/60;
	            	sec = time%60;
	       
	        	//����һ�����̲߳�ִ��
	        	th = new Thread(timerThread);
	        	th.start();
	        }
	    }
	 
	 //TODO ���������¼��ڴ���ģʽ��Ӧ��
	 //���ü�ʱ�¼�
	 class ResetCountListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ֹ�߳�
				th.interrupt();
				timerThread = new TimerThread();
				// ɾ������е�ʱ����ʾ�����ð�ť����ͣ��ť��������ť
				jpanelTime.remove(TimeLabel);
				jpanelButton.remove(Reset);
				jpanelButton.remove(Stop);
				jpanelButton.remove(KeepOn);
				
				// ��ӿ�ʼ��ť�ͳ�ʼʱ����ʾ
				jpanelButton.add(Start);
				jpanelTime.add(TimeLabel);
				TimeLabel.setText("00:00");
				Start.setEnabled(true);
				
	        	// ˢ�����
	        	jpanelTime. updateUI();
	        	jpanelButton.updateUI();
			}
	    }
	 
	 //��ͣ��ʱ�¼�
	 class StopActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ֹ�߳�
				th.interrupt();
				// ����ͣ��ť��ɼ�����ť
				jpanelButton.remove(Stop);
				jpanelButton.add(KeepOn);	
				jpanelButton.updateUI();
			}
	    	
	    }

	 //������ʱ�¼�
	 class KeepOnActionListener implements ActionListener {
	    	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		// �����߳�
	    		th = new Thread(timerThread);
	    		th.start();
	    		// ��������ť�����ͣ��ť
				jpanelButton.remove(KeepOn);
				jpanelButton.add(Stop);	
				jpanelButton.updateUI();
	    	}
	    	
	    }
	
	 //TODO	���Լ���ӻ�ɾ�����ఴť�Ӳ����밴ť�����
	 public void addStartButtonToJPanelButton() {
		 jpanelButton.add(Start);
	 }
	 
	 public void addStopButtonToJPanelButton() {
		 jpanelButton.add(Stop);
	 }
}
