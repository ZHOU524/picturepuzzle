package windowbuilder;

import java.awt.Image;
import java.awt.image.RenderedImage;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.Scanner;

public class ADD_photo {
   
	public ADD_photo() throws IOException {
		
		initialize();
		
	}
	
	String str = "";
	
	private void initialize() throws IOException {
		

		File file=new File("/windowbuilder/src/PHOTOHOUSE");
		if(!file.exists()){//����ļ��в�����
			file.mkdir();//�����ļ�
		}
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ͼƬ·��:");
		String path = scanner.next();
		while(!new File(path).exists()) {
			 scanner = new Scanner(System.in);
			System.out.println("��������ȷ��ͼƬ·��:");
			 path = scanner.next();
		}
		Image[] array = new Image[1];
		Image image = ImageIO.read(new File(path));//Ҫ��ȡ��ͼ���ļ�
		array[0] = image;
		ImageIO.write((RenderedImage) image, "png", new File("/windowbuilder/src/PHOTOHOUSE"));//��������Ҫд������ļ����������������ļ�����ôϵͳ���Զ�������
		
	}
}
