package cn.homework.util.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PPButton extends JButton{
		int row; //��Ť�ĺ�����
		int col;  // ��Ť��������
		public void setImageIcon(ImageIcon icon){
			this.setIcon(icon);
		}
		public void setRow(int row){
			this.row=row;
		}
		public int getRow(){
			return row;
		}
		public void setCol(int col){
			this.col=col;
		}
		public int getCol(){
			return col;
		}
}
