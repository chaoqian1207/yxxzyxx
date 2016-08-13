  package com_mec_yxxzyxx;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

  public class U_D_MInfo 
	{
	
	 private JInternalFrame jitfFrame;
	 private DesktopPane jdtpParent;
	 private Container con;
	 
	 private JLabel jlblTopic;
	 
	 private JComboBox jcboshow;
	 private static final String msg[] = {"��ʾԺУ��ϵ��רҵ������Ϣ","��ʾԺУ��ϵ��רҵȫ����Ϣ"};
	 
	 private DefaultListModel <String>dlmUniveristy;
	 private JList <String> jlstUniveristy;
	 private JScrollPane  jscpUniveristy;
	 private JLabel jlblUniveristy;
	 
	 private DefaultListModel <String>dlmDepartment;
	 private JList <String> jlstDepartment;
	 private JScrollPane  jscpDepartment;
	 private JLabel jlblDepartment;
	 
	 private DefaultListModel <String>dlmMajor;
	 private JList <String> jlstMajor;
	 private JScrollPane  jscpMajor;
	 private JLabel jlblMajor;
	 
	 private JLabel jlblname;
	 
	 private JLabel jlblSelectname;
	 private JTextField jtflSelectname;
	 
	 private ButtonGroup bgIsused;
	 private JRadioButton [] jrdbIsused;
	 
	 private JButton jbtnExit;
	 private JButton jbtnAdd;
	 private JButton jbtnModify;
	 
	 private static final int BROWS=1;
	 private static final int EDIT=0;
	 
	 private static final int Univeristy=0;
	 private static final int Department=1;
	 private static final int Major=2;
	 
	 private static int ACTION;
	 
	 private String oldselectname;
	 private JLabel jlblnumber;
	 
	 private String selectedid;
	 
	
	 //��ʼ�����ڽ���
	 private void interFrame()
	 {
		  Font normalFont = new Font("����",Font.PLAIN,15);
		 
		  jitfFrame = new JInternalFrame("΢����Ƽ���Ϣ����ϵͳ-ԺУϵ����",false,true,false,true);
		  ImageIcon image=new ImageIcon("E:\\����\\eclipse\\������ϰ\\8.jpg");
		  image.setImage(image.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		  jitfFrame.setFrameIcon(image);
		  con = jitfFrame.getContentPane();
		  con.setLayout(null);
		  jitfFrame.setSize(7908/15, 6792/15);
		  jitfFrame.setLocation(400,90);
		   
		   
		   jlblTopic = new JLabel(" ԺУ��ϵ��רҵ����");
		   jlblTopic.setFont(new Font("����",Font.PLAIN,26));
		   jlblTopic.setForeground(Color.BLUE);
		   jlblTopic.setBounds(1794/15, 0,4104/15, 444/15);
		   con.add(jlblTopic);
		   
		   jcboshow = new JComboBox(msg);
		   jcboshow.setFont(normalFont);
		   jcboshow.setBounds(240/15, 720/15, 4572/15, 436/15);
		   con.add(jcboshow);
		   
		   jlblname = new JLabel("����Ա��xxxxx");
		   jlblname.setFont(normalFont);
		   jlblname.setBounds(5520/15, 600/15, 1920/15, 240/15);
		   con.add(jlblname);
		   
		   dlmUniveristy = new DefaultListModel<String>();
		   jlstUniveristy = new JList<String>( dlmUniveristy);
		   jscpUniveristy =new JScrollPane (jlstUniveristy);
		   jscpUniveristy.setBounds(240/15, 1320/15, 2412/15, 2928/15);
		   jscpUniveristy.setBorder(new TitledBorder(null,"ԺУ�б�",TitledBorder.TOP,TitledBorder.TOP,new Font("����",Font.PLAIN,15),Color.black));
		   con.add(jscpUniveristy);
		   jlblUniveristy = new JLabel("����0��ԺУ");
		   jlblUniveristy.setFont(normalFont);
		   jlblUniveristy.setBounds(240/15, 4320/15, 2280/15, 240/15);
		   con.add(jlblUniveristy);
		   
		   dlmDepartment = new DefaultListModel<String>();
		   jlstDepartment = new JList<String>( dlmDepartment);
		   jscpDepartment =new JScrollPane (jlstDepartment);
		   jscpDepartment.setBounds(2640/15, 1320/15, 2412/15, 2928/15);
		   jscpDepartment.setBorder(new TitledBorder(null,"Ժϵ�б�",TitledBorder.TOP,TitledBorder.TOP,new Font("����",Font.PLAIN,15),Color.black));
		   con.add(jscpDepartment);
		   jlblDepartment = new JLabel("����0��Ժϵ");
		   jlblDepartment.setFont(normalFont);
		   jlblDepartment.setBounds(2640/15, 4320/15, 2280/15, 240/15);
		   con.add(jlblDepartment);
		   
		   dlmMajor = new DefaultListModel<String>();
		   jlstMajor  = new JList<String>( dlmMajor );
		   jscpMajor  =new JScrollPane (jlstMajor );
		   jscpMajor .setBounds(5040/15, 1320/15, 2412/15, 2928/15);
		   jscpMajor .setBorder(new TitledBorder(null,"רҵ�б�",TitledBorder.TOP,TitledBorder.TOP,new Font("����",Font.PLAIN,15),Color.black));
		   con.add(jscpMajor );
		   jlblMajor= new JLabel("����0��רҵ");
		   jlblMajor.setFont(normalFont);
		   jlblMajor.setBounds(5040/15, 4320/15, 2280/15, 240/15);
		   con.add(jlblMajor);
		   
		   jlblSelectname= new JLabel("רҵ:");
		   jlblSelectname.setFont(normalFont);
		   jlblSelectname.setBounds(240/15, 4800/15, 720/15, 420/15);
		   con.add(jlblSelectname);
		   
		   jtflSelectname =new JTextField();
		   jtflSelectname.setFont(normalFont);
		   jtflSelectname.setBounds(840/15, 4854/15, 3972/15, 372/15);
		   con.add(jtflSelectname);
		   
		   jrdbIsused = new JRadioButton[2];
		   jrdbIsused[0]=new JRadioButton("����");
		   jrdbIsused[0].setFont(normalFont);
		   jrdbIsused[0].setBounds(5040/15, 4920/15, 852/15, 252/15);
		   con.add(jrdbIsused[0]);
		   jrdbIsused[1]=new JRadioButton("������");
		   jrdbIsused[1].setFont(normalFont);
		   jrdbIsused[1].setBounds(6480/15, 4920/15, 1092/15, 252/15);
		   con.add(jrdbIsused[1]);
		   bgIsused = new ButtonGroup();
		   bgIsused.add(jrdbIsused[0]);
		   bgIsused.add(jrdbIsused[1]);
		   
		   jbtnExit = new JButton("�˳�");
		   jbtnExit.setFont(normalFont);
		   jbtnExit.setBounds(6360/15, 5520/15, 1092/15, 492/15);
		   con.add(jbtnExit);
		   
		   jbtnAdd = new JButton("���");
		   jbtnAdd.setFont(normalFont);
		   jbtnAdd.setBounds(240/15, 5520/15, 1092/15, 492/15);
		   con.add(jbtnAdd);
		   
		   
		   jbtnModify = new JButton("�޸�");
		   jbtnModify.setFont(normalFont);
		   jbtnModify.setBounds(1320/15, 5520/15, 1092/15, 492/15);
		   con.add(jbtnModify);
		   
		   jlblnumber = new JLabel();
		   jlblnumber.setFont(normalFont);
		   jlblnumber.setBounds(0, 0, 0, 0);
		   con.add(jlblnumber);
		   
		   jitfFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		   jitfFrame.setVisible(true);
		   jdtpParent.add(jitfFrame);
	 } 
	 //ShowMessage����
	 private void ShowMessge(JInternalFrame jfrmMain ,String mess)
	 {
	        JOptionPane.showConfirmDialog(jfrmMain, mess,"ϵͳ��ܰ��ʾ",JOptionPane.OK_OPTION)	 ;
	 }
	
	 
	 public JInternalFrame getJFrame()
	 {
		 return jitfFrame ;
	 }
	 
	 
	 public U_D_MInfo()
	 {
		 this(null,null,null);
	 }
	 
	 public U_D_MInfo(DesktopPane jdtpPane, String userId, String userName)
	 {
		 jdtpParent = jdtpPane;
		   interFrame();
		   reinterFrame();
		   dealAction();
	 }
	 
	 //�������״̬
	 private void setState(int type)
	 {
		 boolean state = type ==BROWS;
		 this.jlstUniveristy.setEnabled(state);
		 this.jlstDepartment.setEnabled(state);
		 this.jlstMajor.setEnabled(state);
		 this.jcboshow.setEnabled(state);
		 
		 this.jrdbIsused[0].setEnabled(!state);
		 this.jrdbIsused[1].setEnabled(!state);
		 this.jtflSelectname.setEnabled(!state);
		 
	 }
	 //���ø����б�֮��ı༭״̬
	 private void setListState()
	 {
		 if (this.dlmUniveristy.getSize()==0)
		 {
			 this.jlblUniveristy.setEnabled(true);
			 this.jlstUniveristy.setEnabled(true);
			 this.jlblDepartment.setEnabled(false);
			 this.jlstDepartment.setEnabled(false);
			 this.jlblMajor.setEnabled(false);
			 this.jlstMajor.setEnabled(false);
			 //this.jbtnModify.setEnabled(false);
		 }
		 else if(this.dlmDepartment.getSize()==0)
		 {
			 this.jlblUniveristy.setEnabled(true);
			 this.jlstUniveristy.setEnabled(true);
			 this.jlblDepartment.setEnabled(true);
			 this.jlstDepartment.setEnabled(true);
			 this.jlblMajor.setEnabled(false);
			 this.jlstMajor.setEnabled(false);
		 }
		 else
		 {
			 this.jlblUniveristy.setEnabled(true);
			 this.jlstUniveristy.setEnabled(true);
			 this.jlblDepartment.setEnabled(true);
			 this.jlstDepartment.setEnabled(true);
			 this.jlblMajor.setEnabled(true);
			 this.jlstMajor.setEnabled(true);
			
		 }
	 }
	 
	 //�ٴγ�ʼ������
	 private void reinterFrame()
	 {
		 try 
	    {
		 initUse();
		 setState(BROWS);
		 setListState();
		 clickonUniveristy();
	    } catch (Exception e)
			{
				e.printStackTrace();
			}
		
	 }
	 
	
	 //��ȡԺУ�б�������ʾ�ĸ���
	 private void countUniversity()
	 {
		 String count = String.valueOf(this.dlmUniveristy.getSize());
		 this.jlblUniveristy.setText("����"+count+"��ԺУ");
	 }
	 //��ȡԺϵ�б�������ʾ�ĸ���
	 private void countDepartment()
	 {
		 String count = String.valueOf(this.dlmDepartment.getSize());
		 this.jlblDepartment.setText("����"+count+"��Ժϵ");
	 }
	 //��ȡרҵ�б�������ʾ�ĸ���
	 private void countMajor()
	 {
		 String count = String.valueOf(this.dlmMajor.getSize());
		 this.jlblMajor.setText("����"+count+"��רҵ");
	 }
	 //��ʾ����ԺУ��ϵ��רҵ
	 private void initUse()
	 {
		 
		 try {
			  initU_D_MUse(dlmUniveristy,jlstUniveristy,"RIGHT (U_D_Mid,4)='0000'");
			  initDepartmentUse();
			  initMajorUse();
		     } catch (Exception e)
		     {
			
			   e.printStackTrace();
		     }
	 }
	 
	 //��ʾ����ԺУ��ϵ��רҵ
	 private void initAll()
	 {
		 
		 try {
			  initU_D_MAll(dlmUniveristy,jlstUniveristy,"RIGHT (U_D_Mid,4)='0000' ");
			  initDepartmentAll();
			  initMajorAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	 }
	 
	
	 //��ʾ����ԺУ��ϵ��רҵʱ���õķ���
	 private void initU_D_MUse(DefaultListModel<String> dlstList , JList <String> jlstList , String condition )throws Exception
	 {
		 countUniversity();
		 dlstList.removeAllElements();
		 ResultSet rs=null;
		 
		 String SQLString =
				 "SELECT  U_D_Mid, U_D_Mname, U_D_Mstate " + 
				 "FROM SYS_XTGL_YXXZYXX" +
				 " WHERE " + condition+ "AND U_D_Mstate = 0 "+
				 " ORDER BY U_D_Mid " ;
		 MECData  dat = new MECData("SYS_XTGL_YXXZYXX");
		
		 String name ;
		 String id;
		
			 
		 try 
		 {
			dat.connectionDatabase();
			
			rs = dat.select(SQLString);
			while(rs.next())
			{
				id = rs.getString("U_D_Mid");
				name = rs.getString("U_D_Mname");
				dlstList.addElement(id+"  "+name);
			}
			if(dlstList.getSize()>0)
				jlstList.setSelectedIndex(0) ;
			dat.disconnection();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 
	 }
	 
	 //��ʾ����Ժϵ
	 private void initDepartmentUse()throws Exception
	 {
		 
		 countDepartment();
		 if (jlstUniveristy.getSelectedIndex() !=-1 )
		 {    
			 String nimei = jlstUniveristy.getSelectedValue().substring(0, 0+2);
			 initU_D_MUse(dlmDepartment,jlstDepartment,
					 "LEFT(U_D_Mid,2) = '" +nimei+ "' AND MID(U_D_Mid, 3, 2) <> '00' AND RIGHT(U_D_Mid, 2) = '00'");
			
		 }
	 }
	 
	 //��ʾ����רҵ
	 private void initMajorUse()throws Exception
	 {
		 countMajor();
		 if (jlstDepartment.getSelectedIndex() !=-1 )
		 {    
			 String nimei = jlstDepartment.getSelectedValue().substring(0, 0+4);
			 initU_D_MUse(dlmMajor,jlstMajor,
					 "LEFT(U_D_Mid,4) = '" +nimei+ "'  AND RIGHT(U_D_Mid, 2) <> '00'");
			
		 }
		 else 
			 dlmMajor.removeAllElements();
	 }
	
	 //��ʾ����ԺУ��ϵ��רҵʱ���õķ���
	 private void initU_D_MAll(DefaultListModel<String> dlstList , JList <String> jlstList , String condition )throws Exception
	 {
		 countUniversity();
		 dlstList.removeAllElements();
		 ResultSet rs=null;
		 
		 String SQLString =
				 "SELECT  U_D_Mid, U_D_Mname, U_D_Mstate " + 
				 "FROM SYS_XTGL_YXXZYXX" +
				 " WHERE " + condition+ 
				 " ORDER BY U_D_Mid " ;
		 MECData  dat = new MECData("SYS_XTGL_YXXZYXX");
		
		 String name ;
		 String id;
		 
		 try 
		 {
			dat.connectionDatabase();
			rs = dat.select(SQLString);
			while(rs.next())
			{
				id = rs.getString("U_D_Mid");
				name = rs.getString("U_D_Mname");
				dlstList.addElement(id+"  "+name);
			}
			if(dlstList.getSize()>0)
				jlstList.setSelectedIndex(0) ;
			dat.disconnection();

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 
	 }
	 
	 //��ʾ����Ժϵ
	 private void initDepartmentAll()throws Exception
	 {
		 if (jlstUniveristy.getSelectedIndex() !=-1 )
		 {    
			 countDepartment();
			 String nimei = jlstUniveristy.getSelectedValue().substring(0, 0+2);
			 initU_D_MAll(dlmDepartment,jlstDepartment,
					 "LEFT(U_D_Mid,2) = '" +nimei+ "' AND MID(U_D_Mid, 3, 2) <> '00' AND RIGHT(U_D_Mid, 2) = '00'");
		 }
	 }
	 
	 //��ʾ����רҵ
	 private void initMajorAll()throws Exception
	 {
		 countMajor();
		 if (jlstDepartment.getSelectedIndex() !=-1 )
		 {    
			 String nimei = jlstDepartment.getSelectedValue().substring(0, 0+4);
			 initU_D_MAll(dlmMajor,jlstMajor,
					 "LEFT(U_D_Mid,4) = '" +nimei+ "'  AND RIGHT(U_D_Mid, 2) <> '00'");
			 
		 }
		 else 
			 dlmMajor.removeAllElements();
	 }
	 
	 //���б�����ѡ�е�ѡ����ʾ���༭��ʱ���ø÷���
	 private void showInfo(String id )throws Exception
	 {
		 ResultSet rs =null;
		 String SQLString = 
				 "SELECT U_D_Mname , U_D_Mstate,U_D_Mid "+
		         "FROM SYS_XTGL_YXXZYXX"+
				 " WHERE U_D_Mid = '" + id + "' " ;
		 MECData dat = new MECData("SYS_XTGL_YXXZYXX"); 
		 try 
		 {
			 dat.connectionDatabase();
			rs = dat.select(SQLString);

			 String name =null;
			 int status ;
			 String myid;
			
			while(rs.next())
			{
				name = rs.getString("U_D_Mname");
				status = rs.getInt("U_D_Mstate");
				myid = rs.getString("U_D_Mid");
				
				this.jtflSelectname.setText(name);
				this.jrdbIsused[status].setSelected(true);
				this.jlblnumber.setText(myid);
			}
			dat.disconnection();
		} catch (Exception e) {

			e.printStackTrace();
		} 
	 }
	 
	 //����ı���
	 private void cleanInfo()
	 {
		 this.jtflSelectname.setText("");
		 
	 }
	 
	 //���ԺУ�б�
	 private void clickonUniveristy()
	 {
		 if (jlstUniveristy.isEnabled())
		 {  
		try { 	 
			     if(jcboshow.getSelectedIndex()==0)
			       {
				     initDepartmentUse();
				     initMajorUse();
			       }
			     else 
			      {
			    	  initDepartmentAll();
					  initMajorAll();
			      }
				 this.jlblSelectname.setText("ԺУ��");
				 String id =null;
				 id = this.jlstUniveristy.getSelectedValue();
				 if(id != null)
				 {
					 id = id.substring(0, 0+6);
					 showInfo(id);
				 }
				 else
					 cleanInfo();
				     setListState();
			 } catch (Exception e) 
			 {
				e.printStackTrace();
			 }
			 
			
		 }
	 }
	 
	 //���Ժϵ�б�
	 private void clickonDepartment()
	 {
		 if(jlstDepartment.isEnabled())
		 {
			 try { 
			 {     if(jcboshow.getSelectedIndex()==0)
				      {
				 			initMajorUse();
				      }
				      else
				      {
					   initMajorAll();
				      }
					
				   this.jlblSelectname.setText("Ժϵ��");
					 String id = null ;
					 id = this.jlstDepartment.getSelectedValue();
					 if(id != null)
					 {
						 id =id.substring(0,0+ 6);
						 showInfo(id);
					 }
					 else
						 cleanInfo();
					     setListState();
			 }
			 } catch (Exception e)
			 {
				e.printStackTrace();
			 }
		 }
		
	 }
	 
	 //���רҵ�б�
	 private void clickonMajor()
	 {  try
	    {
		 if(jlstMajor.isEnabled())
		 {
		 this.jlblSelectname.setText("רҵ��");
		 String id =null ;
		 id = this.jlstMajor.getSelectedValue();
		 if(id != null)
		   {
		 	 id =id.substring(0,0+ 6);
		 	 showInfo(id);
		   }
		 else
			 cleanInfo();
		     setListState();
         }
	    } catch (Exception e)
	    {
		e.printStackTrace();
	    }
	 }
    
	
	//������ʽ���ж��ı���������������Ƿ���� 
	 public boolean checkNameSure()
	 {
		     boolean flag = true;
			 String str = null;
			 str = jtflSelectname.getText();

			 String mes ="[\u4E00-\u9FF5]+";

				if(str.equals(""))
				{
					 ShowMessge(jitfFrame, "�˴������пո�");
					flag = false;
				}
			
				else if(str.matches(mes) == false)
				{
					ShowMessge(jitfFrame, "ԺУ��ϵ��רҵ����ֻ���Ǻ��֣�");
					flag = false;
				}
				
				 if(!isRepeat())
				
				 {
					if(ACTION == 0)
			    	{
						ShowMessge(jitfFrame, "ԺУ��ϵ��רҵ���ֲ����ظ�");
						flag = false;
				   }
			     }
		    setState(BROWS);
		    return flag;

	 }

	 
	 //��ʾ�����ԺУ��ϵ��רҵ��ѡ��
	 private void showInservalue(String inservalue,int  type)
	 {
		 try
		 {
		 if(type == Univeristy)
		 {
			 this.dlmUniveristy.addElement(inservalue);
			 this.jlstUniveristy.setSelectedValue(inservalue, true);
			 if(jcboshow.getSelectedIndex()==0)
			 { 
				 initDepartmentUse();
			     initMajorUse();
			 }
			 else
			 {
				   initDepartmentAll();
				   initMajorAll();
			 }
			 setListState();
		 }
		 else if (type == Department)
		 {
			  this.dlmDepartment.addElement(inservalue);
			  this.jlstDepartment.setSelectedValue(inservalue, true);
			  if(jcboshow.getSelectedIndex()==0)
			  { 
				  initMajorUse();			  
			  }
			  else
			  {
			    initMajorAll();
			  }
			  setListState();
		 }
		 else if(type == Major)
		 {
			  this.dlmMajor.addElement(inservalue);
			  this.jlstMajor.setSelectedValue(inservalue, true);
		 }
		 } catch (Exception e) 
	     {
			
			e.printStackTrace();
		 }
	 }
	 
	 //���ԺУ��ϵ��רҵ
	 private void inserInfo(int type)
	 {
		 String condition = null;
		 if(type == Univeristy)
		 
			 condition = "";

		 else if(type == Department)
		 
			 condition = this.jlstUniveristy.getSelectedValue().substring(0, 0+2);
		 
		 else
		 
			 condition = this.jlstDepartment.getSelectedValue().substring(0, 0+4);
		
		 
		 try {
			 
			 
			String newid = getnewid(condition,type);
			String name = this.jtflSelectname.getText();
			int isUsed = jrdbIsused[0].isSelected() ? 0 : 1;
			String SQLString = 
					"INSERT INTO SYS_XTGL_YXXZYXX(U_D_Mid, U_D_Mname, U_D_Mstate) VALUES('" + newid+"','"+name+"',"+isUsed+")";
			
			MECData dat = new MECData("SYS_XTGL_YXXZYXX");
			dat.connectionDatabase();
			dat.update(SQLString);
			dat.disconnection();
			
			
			String inservalue = newid +"  "+name;
			
	
			showInservalue(inservalue,type);
			jtflSelectname.setText(name);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 }
	 
	 //
	 public boolean isRepeat()
		{
			boolean isRepeat = true;
			String strName = jtflSelectname.getText();
			String SQLString  = "SELECT U_D_Mname FROM SYS_XTGL_YXXZYXX";
			ResultSet rs = null;
			String udmName;
			MECData dat  = new MECData("SYS_XTGL_YXXZYXX");
			try {
					dat.connectionDatabase();
					
					rs = dat.select(SQLString);
					while(rs.next() && isRepeat)
					{
						udmName = rs.getString("U_D_Mname");
						isRepeat =! strName.equals(udmName);
					}
					
					dat.disconnection();
				}
				catch (Exception e) 
				{
				
				e.printStackTrace();
				}
			return isRepeat;
		} 

	 
	 //�����ʱ����ȡ�µ�Id
	 private String getnewid(String condition,int type) throws Exception
	 {
		 ResultSet rs=null;
		 String SQLString =null;
		 String newid = null;
		 String[] conditionArray =
			
			 {
				 "SELECT COUNT(*) AS C  FROM SYS_XTGL_YXXZYXX WHERE RIGHT(U_D_Mid,4) = '0000'",
				 "SELECT COUNT(*) AS C  FROM SYS_XTGL_YXXZYXX WHERE LEFT(U_D_Mid,2) = '##' AND MID(U_D_Mid,3,2) <>'00' AND RIGHT(U_D_Mid,2) = '00'",
				 "SELECT COUNT(*) AS C  FROM SYS_XTGL_YXXZYXX WHERE LEFT(U_D_Mid,4) ='####' AND RIGHT(U_D_Mid,2)<>'00'"
			 };    
		 MECData dat =new MECData("SYS_XTGL_YXXZYXX");
		 
		 if(type==Univeristy)
		 {
			 SQLString = conditionArray[type];
		 }
		 else if (type==Department)
		 {
			 SQLString = conditionArray[type].replaceFirst("##", condition);
		 }
		 else if(type == Major)
		 {
			 SQLString = conditionArray[type].replaceFirst("####", condition);
		 }
		 
	  try {
		     dat.connectionDatabase();
			 
			 int count =0;
			 rs= dat.select(SQLString);
			 if(rs.next())
			 {
				 count = rs.getInt("C");
			 }
			 count++;
			
			 String what = String.valueOf(count+100).substring(1);
			 
			 if(type == Univeristy)
			 {
				 newid = what+"0000";
			 }
			 else if(type == Department)
			 {
				 newid = condition+what+"00";
			 }
			 else
			 {
				 newid = condition+what;
			 }
			 dat.disconnection();
		  } catch (Exception e) {
			
			e.printStackTrace();
		  }
	     return newid;
		 
	 }
	 
	 //�޸�
	 private void inserModify()
	 {
	
		 
		  String id = jlblnumber.getText();
		  String name = jtflSelectname.getText(); 
		  int state = this.jrdbIsused[0].isSelected() ? 0:1 ;
		  
		  String SQLString = 
				  "UPDATE SYS_XTGL_YXXZYXX SET U_D_Mname = '"+ name+"',U_D_Mstate ="+state +" WHERE U_D_Mid ='"+id+"'";
		   

		  try {
			   selectedid=id;//TODO
			   MECData dat =new MECData("SYS_XTGL_YXXZYXX");
			   dat.connectionDatabase();
			   dat.update(SQLString);
			   dat.disconnection();
			   
			     
  		       if(jcboshow.getSelectedIndex()==0)
  		       {
  		    	   initUse();
  		       }
  		       else
  		       {
  		    	   initAll();
  		       }
				 jtflSelectname.setText(name);
				
		      } catch (Exception e) {
			
			e.printStackTrace();
		}
		  
	 }
	 
	 //ԺУ��ϵ��רҵ����״̬�ı�Ϊ������ʱ��������������ϵ��רҵ������Ϊ������
	 private void changstate()
	 {
		 ResultSet rs=null; 
		 int state;
		 String id=null; 
		 id=selectedid;
		 
		 String SQLString ="SELECT U_D_Mstate FROM SYS_XTGL_YXXZYXX WHERE U_D_Mid='"+id+"'";
		 try { 
			 	MECData dat=new MECData("SYS_XTGL_YXXZYXX");
			 	 dat.connectionDatabase();
			 	 rs=dat.select(SQLString);
			 	 while(rs.next())
			 	 {
			 		 state=rs.getInt("U_D_Mstate");
			 		 if(state==1)
				 	 {
			 			if(id.substring(2, 2+4).equals("0000"))
			 			{
			 				String id1=id.substring(0, 0+2);
			 			    String SQLString1="UPDATE SYS_XTGL_YXXZYXX SET U_D_Mstate ="+state +" WHERE LEFT(U_D_Mid,2) ='"+id1+"'" ;
			 			    MECData dat1 =new MECData("SYS_XTGL_YXXZYXX");
						    dat1.connectionDatabase();
							dat1.update(SQLString1);
							dat1.disconnection();
			 			}   
			 			   

			 			else if(!id.substring(2, 2+2).equals("00")&&id.substring(4, 4+2).equals("00"))	 
			 			{
			 				String id1=id.substring(0, 0+4);
			 			    String SQLString1="UPDATE SYS_XTGL_YXXZYXX SET U_D_Mstate ="+state +" WHERE LEFT(U_D_Mid,4) ='"+id1+"'" ;
			 			    MECData dat1 =new MECData("SYS_XTGL_YXXZYXX");
						    dat1.connectionDatabase();
						    dat1.update(SQLString1);
						    dat1.disconnection();	
			 			}
			 		
				 	 }
			 		 
			 	 } 
			     dat.disconnection();
			     if(jcboshow.getSelectedIndex()==0)
	  		       {
	  		    	   initUse();
	  		       }
	  		     else
	  		       {
	  		    	   initAll();
	  		       }
	 			    
	  	} catch (Exception e) 
		 {
		
			e.printStackTrace();
		 }
		 
		 
	 }
	 
	 //�¼�����
	 private void dealAction()
	 {
		 
		 //�޸İ�ť�ļ���
		 jbtnModify.addActionListener
		 (
				 new ActionListener()
				 {
					 
					 
					public void actionPerformed(ActionEvent e) 
					{
							
						if(jbtnModify.getText().equals("�޸�"))
						{
							 
							 int isUsed = jrdbIsused[0].isSelected() ? 0 :1;
								
							oldselectname = jtflSelectname.getText();
							
							jbtnAdd.setText("ȷ��");
							jbtnModify.setText("ȡ��");
							
							ACTION=1;
							setState(EDIT);
							
							if(isUsed==1)
							{
								jtflSelectname.setEnabled(false);
								jrdbIsused[0].setEnabled(false);
								jrdbIsused[1].setEnabled(false);
								jbtnAdd.setEnabled(false);
							}
							
							jtflSelectname.requestFocus();
							jtflSelectname.setSelectionStart(0);
							jtflSelectname.setSelectionEnd(jtflSelectname.getText().length());
							
						}
						else
						{
							jtflSelectname.setText(oldselectname);
							
							jbtnAdd.setText("���");
							jbtnModify.setText("�޸�");
							jbtnAdd.setEnabled(true);
							setState(BROWS);
						}
					}
					 
				 }
				 
		 );
		 
		 
		 //��Ӱ�ť�ļ���
		 jbtnAdd.addActionListener
		 (
				 new ActionListener()
				 {
					 
					public void actionPerformed(ActionEvent e)
					{
						if(jbtnAdd.getText().equals("���"))
						{
							
							oldselectname = jtflSelectname.getText();
							setState(EDIT);
							ACTION = 0;
							
							jbtnAdd.setText("ȷ��");
							jbtnModify.setText("ȡ��");
							jrdbIsused[1].setEnabled(false);
							jtflSelectname.requestFocus();
							jtflSelectname.setSelectionStart(0);
							jtflSelectname.setSelectionEnd(jtflSelectname.getText().length());
						}
						else
						{
							if(ACTION == 0)
							{
								if(jlblSelectname.getText().equals("ԺУ��"))
								{
									
									if(checkNameSure())
									inserInfo(Univeristy);
								
								}
								else if(jlblSelectname.getText().equals("Ժϵ��"))
								{
			
									if(checkNameSure())
									inserInfo(Department);

								}
								
								
								else if(jlblSelectname.getText().equals("רҵ��"))
								{
									if(checkNameSure())
									inserInfo(Major);	
								}
							}
							else
							{
								if(checkNameSure())
								inserModify();	
								changstate();
								
								jtflSelectname.setText(oldselectname);
							}
							jbtnAdd.setText("���");
							jbtnModify.setText("�޸�");
						
							setState(BROWS);
						}
					}
					 
				 }
		 );
 
		 //�˳���ť�ļ���
		 jbtnExit.addActionListener
		 (
			 new ActionListener()
			 {
				public void actionPerformed(ActionEvent e) 
				{
					int a = JOptionPane.showConfirmDialog(jitfFrame, "��ȷ����","ϵͳ��ܰ��ʾ",JOptionPane.YES_NO_CANCEL_OPTION);
					if(a==0)
					{
						jitfFrame.dispose();
					}
					
				}
				 
			 }
		 );
	 
		 //��ʾ�����б�ļ���
		 jcboshow.addItemListener
		 (
				 new ItemListener()
				 {
					public void itemStateChanged(ItemEvent e)
					{
						if(jcboshow.getSelectedIndex() == 1)
						{
							initAll();
						}
						else
						{
							initUse();
						}
					}
					 
				 }
		 );
		 
		 
		 
		 //ԺУ�б��������
		 jlstUniveristy.addMouseListener
		 (
				 new MouseListener()
				 {
					public void mouseClicked(MouseEvent e)
					{
						clickonUniveristy();
					}
					public void mousePressed(MouseEvent e) {}
					public void mouseReleased(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					 
				 }
		 );
		 
		 
		 
		 //ԺУ�б�ļ���
		 jlstUniveristy.addListSelectionListener
		 (
			   new ListSelectionListener()
			   {
				public void valueChanged(ListSelectionEvent e) 
				{
					clickonUniveristy();
				}
				   
			   }
		 );
		 
		 
		 
		 //Ժϵ�б��������
		 jlstDepartment.addMouseListener
		 (
				 new MouseListener()
				 {
					public void mouseClicked(MouseEvent e) 
					{
						clickonDepartment();
					}
					public void mousePressed(MouseEvent e) {}
					public void mouseReleased(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					 
				 }
		 );
		 
		 
		 
		 //Ժϵ�б�ļ���
		 jlstDepartment.addListSelectionListener
		 (
			   new ListSelectionListener()
			   {
				public void valueChanged(ListSelectionEvent e) 
				{
					clickonDepartment();
				}
				   
			   }
		 );
		 
		 
		 //רҵ�б��������
		 jlstMajor.addMouseListener
		 (
				 new MouseListener()
				 {
					public void mouseClicked(MouseEvent e) 
					{
						clickonMajor();
					}
					public void mousePressed(MouseEvent e) {}
					public void mouseReleased(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					 
				 }
		 );
		 
		 //רҵ�б�ļ���
		 jlstMajor.addListSelectionListener
		 (
			   new ListSelectionListener()
			   {
				public void valueChanged(ListSelectionEvent e) 
				{
					clickonMajor();
				}
				   
			   }
		 );
		 
	 }
	 
	
}

