package com_mec_yxxzyxx;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class parentWindow 
{
     private JFrame jfrmMain;
     private Container cont;
     
     private DesktopPane jdtpBorder;
     private JLabel jlblBackground;
     
     private void initFrame()
     {
    	 jfrmMain=new JFrame("΢�������ϵͳ ");
    	 cont=jfrmMain.getContentPane();
    	 jfrmMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	 jfrmMain.setIconImage(Toolkit.getDefaultToolkit().createImage("E:\\����\\eclipse\\������ϰ\\8.jpg"));
    	 jfrmMain.setVisible(true);
    	 
    	jdtpBorder=new DesktopPane();
    	
    	ImageIcon imgiBackground=new ImageIcon("E:\\����\\eclipse\\������ϰ\\7.jpg");
    	imgiBackground.setImage(imgiBackground.getImage().getScaledInstance(
			jfrmMain.getWidth(), jfrmMain.getHeight(), Image.SCALE_DEFAULT));
    	jlblBackground=new JLabel(imgiBackground);
    	jlblBackground.setIcon(imgiBackground);
    	jlblBackground.setBounds(0,0,jfrmMain.getWidth(),jfrmMain.getHeight());;
    	 cont.add(jdtpBorder);
    	 
    	 JMenuBar jmubMain;
    	 JMenu jmnuMenu;
    	 JMenuItem jmniItem;
    	 JMenuItem jmniItemExit;
    	 
    	 jmubMain=new JMenuBar();
    	 jmnuMenu=new JMenu("ϵͳ����");
    	 jmniItem=new JMenuItem("ԺУ��ϵ��רҵ��Ϣ����");
    	 jmniItemExit=new JMenuItem("�˳�");
    	 
    	jmnuMenu.add(jmniItem);
    	jmnuMenu.add(jmniItemExit);
    	jmubMain.add(jmnuMenu);
    	jfrmMain.setJMenuBar(jmubMain);
    	
    	
    	jmniItem.addActionListener
    	(
    			new ActionListener()
    			{

					public void actionPerformed(ActionEvent e) 
					{
						new U_D_MInfo(jdtpBorder,"123456","��ޱޱ");
						
					}
    				
    			}
    	);
    	jmniItemExit.addActionListener
    	(
    			new ActionListener()
    			{

					public void actionPerformed(ActionEvent e) 
					{
						jfrmMain.dispose();
						
					}
    				
    			}
    			
    	);
    	
    	jfrmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jfrmMain.setVisible(true);
    	jfrmMain.setResizable(false);
    	
     }
	
	public parentWindow()
	{
		initFrame();
	}
	
	public static void main(String[] arg)
	{
		new parentWindow();
	}
	
}
