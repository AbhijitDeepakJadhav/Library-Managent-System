import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class MainWin {

	private JFrame frame;
	JLayeredPane layeredPane_1 = new JLayeredPane();
	private JTextField textField;
	private JPasswordField passwordField;
	private boolean RadioStatus = true;
	static Connection con;
	boolean LoginStatus =  true; //Login status
	boolean flag=false;
	boolean sortAut = false;
	boolean sortbknm = false;
	
	
	//layered panels
	JPanel welcome_panel_2 = new JPanel();
	JPanel Login_panel_3 = new JPanel();
	JPanel AddBook_panel_4 = new JPanel();
	JPanel IssueBook_panel_5 = new JPanel();
	JPanel StudReport_panel_1 = new JPanel();
	JPanel StudReport_panel_2 = new JPanel();
	JPanel Penaulty_panel = new JPanel();
	JPanel Searchbook_panel = new JPanel();
	JPanel Searchbook_panel_2 = new JPanel();
	
	private JTextField textField_Btitle;
	private JTextField textField_Author;
	private JTextField textField_Bedition;
	private JTextField textField_Pub;
	private JTextField textField_count;
	private JTextField textField_IBuname;
	private JTextField textField_IBsname;
	private JTextField textField_IBbname;
	private JTextField textField_IBedition;
	private JTextField textField_1;
	
	JLabel label_2 = new JLabel("Student Name");
	JLabel label_6 = new JLabel("Student Name");
	JLabel label_12 = new JLabel("");
	JLabel label_13 = new JLabel("");
	JLabel label_14 = new JLabel("");
	
	JTextArea stdrep = new JTextArea();
	JTextArea stdrep1 = new JTextArea();
	String Uname="";
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;
	
	
	/**
	 * Launch the application.
	 */
	
	static {
		 con = DbConnect.myconnector();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		MainWin obj = new MainWin();
		obj.togglepane(obj.welcome_panel_2);

		

	}
	
	

	/**
	 * Create the application.
	 */
	public MainWin() {
		initialize();
	}
	
	public void togglepane(JPanel panel)
	{
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	
	public boolean checkCredentials(String Uname, String Password)
	{
		boolean ans = false;
		try {
			PreparedStatement search=con.prepareStatement("select * from Login where UserName=?");
			search.setString(1, Uname);
			System.out.println("157");
			ResultSet rs = search.executeQuery();
			System.out.println("159");
			while(rs.next()) {	
			String RealPass = rs.getString(2);
			System.out.println(RealPass);
			if(RealPass.equals(Password))
				ans = true;
			}
			}catch(Exception a) {
				System.out.println("user name incorrect");
			}
		return ans;
	}
	
	public boolean checkCredentials(String Uname)
	{
		boolean ans = false;
		try {
			PreparedStatement search=con.prepareStatement("select * from Login where UserName=?");
			search.setString(1, Uname);
			ResultSet rs = search.executeQuery();
			while(rs.next()) {	
			String Unamesql = rs.getString(1);
			if(Unamesql.equals(Uname))
				ans = true;
			}
			}catch(Exception a) {
				System.out.println("user name incorrect");
			}
		return ans;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1920, 1024);
		frame.getContentPane().setLayout(null);
		Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Java Projects\\LibraryManage\\src\\Lib.png");
		frame.setIconImage(icon);
		JPanel panel = new JPanel();
		panel.setBounds(12, 977, 238, -968);
		frame.getContentPane().add(panel);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setText("Library Managment System");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 1902, 168);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 168, 417, 809);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		

				//ADMIN Button Action---------------------------
				JButton btnNewButton = new JButton("Login Page");
				btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setBorder(null);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						togglepane(Login_panel_3);
						
					}
				});
				btnNewButton.setBounds(51, 88, 333, 68);
				panel_1.add(btnNewButton);
				//btnNewButton.setOpaque(false);
				btnNewButton.setBackground(Color.BLACK);
				//-----------------------------------------------
		
		
				//Add Book Button Action---------------------------
				JButton btnNewButton1 = new JButton("Add New Book");
				btnNewButton1.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnNewButton1.setBackground(Color.BLACK);
				btnNewButton1.setForeground(Color.WHITE);
				btnNewButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							if(LoginStatus && Uname.equals("Admin"))
							{
								togglepane(AddBook_panel_4);
								try{
									PreparedStatement create = con.prepareStatement("create table if not exists Bookdtb(BookId int(10) not null auto_increment,BookName varchar(100),Author varchar(255),BookEdition int(10),Publication varchar(100),BookCount int(10),primary key(BookId))");
									create.executeUpdate();
									System.out.println("Table created");
									}
								catch(Exception o) {System.out.println(o);}
							}
							else {
								JOptionPane.showMessageDialog(null, "Action Reserved Only For Admin");
								togglepane(Login_panel_3);
							}
					}
				});
				btnNewButton1.setBounds(51, 188, 333, 68);
				panel_1.add(btnNewButton1);
				//------------------------- Page----------------------
				
				
				JButton btnNewButton2 = new JButton("Issue/Return Book");
				btnNewButton2.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnNewButton2.setBackground(Color.BLACK);
				btnNewButton2.setForeground(Color.WHITE);
				btnNewButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(LoginStatus && Uname.equals("Admin"))
						{
							try{
							PreparedStatement create = con.prepareStatement("create table if not exists IssuedBook(UserName varchar(20),StudName varchar(100),Book varchar(255),BookEdition int(10),IssueDate varchar(30),ReturnDate varchar(30))");
							create.executeUpdate();
							System.out.println("Table created IssueBook");
							togglepane(IssueBook_panel_5);
							}
							catch(Exception o) {System.out.println(o);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Action Reserved Only For Admin");
							togglepane(Login_panel_3);
						}
					}
				});
				btnNewButton2.setBounds(51, 288, 333, 68);
				panel_1.add(btnNewButton2);
				JButton btnNewButton3 = new JButton("Student Report");
				btnNewButton3.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnNewButton3.setBackground(Color.BLACK);
				btnNewButton3.setForeground(Color.WHITE);
				btnNewButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(LoginStatus)
						{
							
							if(Uname.equals("Admin"))
							{
								togglepane(StudReport_panel_1);
							}
							else
							{
								try {
									PreparedStatement search = con.prepareStatement("Select * from issuedbook where UserName=?");
									search.setString(1, Uname);
									ResultSet res = search.executeQuery();
									String data="";
									while(res.next())
									{
										label_6.setText(res.getString(2));
										data+="\t"+"Book Name :\t"+res.getString(3)+"\n"+"\t"+"Edition:\t   "+res.getString(4)+"\n"+"\t"+"Issue Date:\t"+res.getString(5)+"\n"+"\t"+"Return Date:\t "+res.getString(6)+"\n\n";
									}
									stdrep1.setText(data);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out.println(e);
								}
								togglepane(StudReport_panel_2);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Please Login to your account");
							togglepane(Login_panel_3);
						}
					}
				});
				btnNewButton3.setBounds(51, 388, 333, 68);
				panel_1.add(btnNewButton3);
				JButton btnNewButton4 = new JButton("Penaulty List");
				btnNewButton4.setBackground(Color.BLACK);
				btnNewButton4.setForeground(Color.WHITE);
				btnNewButton4.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnNewButton4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

							if(LoginStatus==true&&Uname.equals("Admin"))
							{
								if(flag==false) {
									try {
									SimpleDateFormat date_form1 = new SimpleDateFormat("dd/MM/yyyy");
									PreparedStatement pen = con.prepareStatement("Select * from issuedbook");
									ResultSet rs = pen.executeQuery();
									String Returndate="";
									while(rs.next())
									{
										Returndate = rs.getString(6);
										Date retdate;
										try {
											retdate = date_form1.parse(Returndate);
											Date currdate = new Date();
											if(currdate.compareTo(retdate)>0)
											{
		
												    DefaultTableModel model = (DefaultTableModel)table.getModel();
												    model.addRow(new Object[]{rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)});
		//										    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6));
												
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									
		
								} catch (SQLException e) {
									System.out.println(e);
								}	
								}
									togglepane(Penaulty_panel);
									flag = true;							
							
							}
							else {
								JOptionPane.showMessageDialog(null, "Action Reserved Only For Admin");
							}

						
						

					}
				});
				btnNewButton4.setBounds(51, 488, 333, 68);
				panel_1.add(btnNewButton4);
				
				JButton btnSearchBook = new JButton("Search Book");
				btnSearchBook.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_2.setText(null);
						textField_3.setText(null);
						label_12.setText(null);
						label_13.setText(null);
						label_14.setText(null);
//						togglepane(Searchbook_panel);
						togglepane(Searchbook_panel_2);
					}
				});
				btnSearchBook.setForeground(Color.WHITE);
				btnSearchBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnSearchBook.setBackground(Color.BLACK);
				btnSearchBook.setBounds(51, 588, 333, 68);
				panel_1.add(btnSearchBook);
		
		ImageIcon img = new ImageIcon("lib1.jpg");
		lblNewLabel_1.setIcon(null);
		

		layeredPane_1.setBounds(416, 168, 1311, 685);
		frame.getContentPane().add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		welcome_panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		welcome_panel_2.setEnabled(false);
		welcome_panel_2.setForeground(Color.WHITE);
		welcome_panel_2.setBackground(Color.DARK_GRAY);
		

		layeredPane_1.add(welcome_panel_2, "name_31266917653500");
		Login_panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		Login_panel_3.setBackground(Color.DARK_GRAY);

		layeredPane_1.add(Login_panel_3, "name_31280500591600");
		Login_panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(620, 276, 515, 66);
		Login_panel_3.add(textField);
		textField.setColumns(10);
		AddBook_panel_4.setForeground(Color.BLACK);
		AddBook_panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		AddBook_panel_4.setBackground(Color.DARK_GRAY);
		
		layeredPane_1.add(AddBook_panel_4, "name_31284282278800");
		AddBook_panel_4.setLayout(null);
		
		JLabel lblPublication = new JLabel("Publication");
		lblPublication.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblPublication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublication.setForeground(Color.WHITE);
		lblPublication.setBackground(Color.DARK_GRAY);
		lblPublication.setBounds(389, 307, 216, 50);
		AddBook_panel_4.add(lblPublication);
		
		JLabel lblNewLabel = new JLabel("ADD NEW BOOK HERE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 1299, 62);
		AddBook_panel_4.add(lblNewLabel);
		
		textField_Btitle = new JTextField();
		textField_Btitle.setBackground(Color.WHITE);
		textField_Btitle.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_Btitle.setDisabledTextColor(new Color(109, 109, 109));
		textField_Btitle.setColumns(10);
		textField_Btitle.setBounds(617, 118, 407, 50);
		AddBook_panel_4.add(textField_Btitle);
		
		JLabel lblEdition = new JLabel("Book Edition");
		lblEdition.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdition.setForeground(Color.WHITE);
		lblEdition.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblEdition.setBackground(Color.DARK_GRAY);
		lblEdition.setBounds(389, 244, 216, 50);
		AddBook_panel_4.add(lblEdition);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblAuthor.setBackground(Color.DARK_GRAY);
		lblAuthor.setBounds(389, 181, 216, 50);
		AddBook_panel_4.add(lblAuthor);
		
		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookTitle.setForeground(Color.WHITE);
		lblBookTitle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblBookTitle.setBackground(Color.DARK_GRAY);
		lblBookTitle.setBounds(389, 118, 216, 50);
		AddBook_panel_4.add(lblBookTitle);
		
		textField_Author = new JTextField();
		textField_Author.setDisabledTextColor(SystemColor.textInactiveText);
		textField_Author.setColumns(10);
		textField_Author.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_Author.setBackground(Color.WHITE);
		textField_Author.setBounds(617, 181, 407, 50);
		AddBook_panel_4.add(textField_Author);
		
		textField_Bedition = new JTextField();
		textField_Bedition.setDisabledTextColor(SystemColor.textInactiveText);
		textField_Bedition.setColumns(10);
		textField_Bedition.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_Bedition.setBackground(Color.WHITE);
		textField_Bedition.setBounds(617, 244, 407, 50);
		AddBook_panel_4.add(textField_Bedition);
		
		textField_Pub = new JTextField();
		textField_Pub.setDisabledTextColor(SystemColor.textInactiveText);
		textField_Pub.setColumns(10);
		textField_Pub.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_Pub.setBackground(Color.WHITE);
		textField_Pub.setBounds(617, 307, 407, 50);
		AddBook_panel_4.add(textField_Pub);
		
		JLabel lblNoumberOfBooks = new JLabel("Number of books");
		lblNoumberOfBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoumberOfBooks.setForeground(Color.WHITE);
		lblNoumberOfBooks.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNoumberOfBooks.setBackground(Color.DARK_GRAY);
		lblNoumberOfBooks.setBounds(389, 370, 216, 50);
		AddBook_panel_4.add(lblNoumberOfBooks);
		
		textField_count = new JTextField();
		textField_count.setDisabledTextColor(SystemColor.textInactiveText);
		textField_count.setColumns(10);
		textField_count.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_count.setBackground(Color.WHITE);
		textField_count.setBounds(617, 370, 101, 50);
		AddBook_panel_4.add(textField_count);
		
		JButton btnNewButton_2 = new JButton("ADD BOOK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int edi=0;
				String Name="";
				int Count = 0;
				String Book_name = textField_Btitle.getText();
				String Author = textField_Author.getText();
				String EditionStr = textField_Bedition.getText();
				int Edition = Integer.parseInt(EditionStr);
				String Publication = textField_Pub.getText();
				String Countstr = textField_count.getText();
				int BCount = Integer.parseInt(Countstr);
				
				try {
					PreparedStatement checkbk  = con.prepareStatement("Select BookCount,BookName,BookEdition  from Bookdtb where BookName = ? and BookEdition=?");
					checkbk.setString(1, Book_name);
					checkbk.setInt(2,Edition);
					ResultSet rs = checkbk.executeQuery();
					while(rs.next())
					{
						Count = rs.getInt(1);
						Name = rs.getString(2);
						edi = rs.getInt(3);
					}

					if(Book_name.equals(Name)&&Edition==edi) {
						PreparedStatement addbk  = con.prepareStatement("update Bookdtb set BookCount=? where BookName = ? and BookEdition=?");
						BCount = BCount + Count;
					addbk.setInt(1, BCount);
					addbk.setString(2, Book_name);
					addbk.setInt(3,Edition);
					addbk.executeUpdate();
					JOptionPane.showMessageDialog(null, "This book already exist in inventory so updated count");
					}
					else
					{
						try{
					
					PreparedStatement issue = con.prepareStatement("Insert into Bookdtb(BookName, Author, BookEdition, Publication, BookCount)values(?,?,?,?,?)");
					issue.setString(1,Book_name);
					issue.setString(2, Author);
					issue.setInt(3, Edition);
					issue.setString(4, Publication);
					issue.setInt(5, BCount);
					issue.executeUpdate();
					JOptionPane.showMessageDialog(null, "Booked added succesfully");
					}
				catch(Exception o) {JOptionPane.showMessageDialog(null, "Booked not added");}
					}
				}catch (Exception e3) {
					System.out.println(e3);
				}
				textField_Btitle.setText(null);
				textField_Author.setText(null);
				textField_Bedition.setText(null);
				textField_Pub.setText(null);
				textField_count.setText(null);

			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setBackground(new Color(255, 0, 255));
		btnNewButton_2.setBounds(808, 434, 216, 62);
		AddBook_panel_4.add(btnNewButton_2);
		welcome_panel_2.setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Online Library System\r\n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(4, 208, 1307, 61);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 52));
		welcome_panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Welcome to Online Library System\r\n");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(4, 5, 1307, 61);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 52));
		Login_panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("\"Take the first step towards Knowledge with us\"");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(0, 372, 1311, 42);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 36));
		welcome_panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("\"Take the first step towards Knowledge with us\"");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(0, 121, 1311, 42);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 36));
		Login_panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel_3.setBackground(Color.DARK_GRAY);
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Java Projects\\LibraryManage\\src\\pass.png"));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_3.setBounds(384, 352, 194, 66);
		Login_panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Login ID");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel_5.setBackground(Color.DARK_GRAY);
		lblNewLabel_5.setIcon(new ImageIcon("E:\\Java Projects\\LibraryManage\\src\\login.png"));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_5.setBounds(384, 276, 194, 66);
		Login_panel_3.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(620, 355, 515, 63);
		Login_panel_3.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Uname = textField.getText();
				String Pass = passwordField.getText();
				LoginStatus = checkCredentials(Uname, Pass);
				boolean namecheck = checkCredentials(Uname);
				
//				System.out.println(LoginStatus);
				if(namecheck==true)
				{
					if(LoginStatus)
					JOptionPane.showMessageDialog(null, "Login successfull");
					else {
					JOptionPane.showMessageDialog(null, "Wrong Credentials - Login Failed");
					}
					textField.setText(null);
					passwordField.setText(null);				
				}else {
					JOptionPane.showMessageDialog(null, "User Name incorrect - First register if not.");
				}

			}
		});
		btnNewButton_1.setBounds(978, 461, 157, 55);
		Login_panel_3.add(btnNewButton_1);
		
		JButton btnRegiter = new JButton("Register");
		btnRegiter.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRegiter.setForeground(Color.WHITE);
		btnRegiter.setBackground(Color.MAGENTA);
		btnRegiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(LoginStatus==true&&Uname.equals("Admin"))
				{
					try {
						String Uname1 = textField.getText();
						String Pass = passwordField.getText();
						boolean namecheck = checkCredentials(Uname1);
						if(namecheck==false)
						{
							PreparedStatement reg = con.prepareStatement("insert into login()values(?,?)");
							reg.setString(1, Uname1);
							reg.setString(2,Pass);
							reg.executeUpdate();
							JOptionPane.showMessageDialog(null, "Registered Successfully");
							textField.setText(null);
							passwordField.setText(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "This name is in use. Enter anther unique Username");
							textField.setText(null);
							passwordField.setText(null);
						}
					}
					catch(Exception r)
					{
						System.out.println(r);
					}					
				}
				else {
					JOptionPane.showMessageDialog(null, "Action Reserved only for Admin");
					textField.setText(null);
					passwordField.setText(null);
				}

			}
		});
		btnRegiter.setBounds(790, 461, 157, 55);
		Login_panel_3.add(btnRegiter);
		

		IssueBook_panel_5.setLayout(null);
		IssueBook_panel_5.setForeground(Color.BLACK);
		IssueBook_panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		IssueBook_panel_5.setBackground(Color.DARK_GRAY);
		layeredPane_1.add(IssueBook_panel_5, "name_11820103744900");
		
		JLabel lblEdition_1 = new JLabel("Edition");
		lblEdition_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdition_1.setForeground(Color.WHITE);
		lblEdition_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblEdition_1.setBackground(Color.DARK_GRAY);
		lblEdition_1.setBounds(389, 307, 216, 50);
		IssueBook_panel_5.add(lblEdition_1);
		
		JLabel lblIssueBookHere = new JLabel("Issue or Return the Book Here");
		lblIssueBookHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssueBookHere.setForeground(Color.WHITE);
		lblIssueBookHere.setFont(new Font("Verdana", Font.BOLD, 21));
		lblIssueBookHere.setBounds(12, 13, 1299, 62);
		IssueBook_panel_5.add(lblIssueBookHere);
		
		textField_IBuname = new JTextField();
		textField_IBuname.setDisabledTextColor(SystemColor.textInactiveText);
		textField_IBuname.setColumns(10);
		textField_IBuname.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_IBuname.setBackground(Color.WHITE);
		textField_IBuname.setBounds(617, 118, 407, 50);
		IssueBook_panel_5.add(textField_IBuname);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblBookName.setBackground(Color.DARK_GRAY);
		lblBookName.setBounds(389, 244, 216, 50);
		IssueBook_panel_5.add(lblBookName);
		
		JLabel lblNameOfStudent = new JLabel("Name of student");
		lblNameOfStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameOfStudent.setForeground(Color.WHITE);
		lblNameOfStudent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNameOfStudent.setBackground(Color.DARK_GRAY);
		lblNameOfStudent.setBounds(389, 181, 216, 50);
		IssueBook_panel_5.add(lblNameOfStudent);
		
		JLabel lblUsername = new JLabel("User Name");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblUsername.setBackground(Color.DARK_GRAY);
		lblUsername.setBounds(389, 118, 216, 50);
		IssueBook_panel_5.add(lblUsername);
		
		textField_IBsname = new JTextField();
		textField_IBsname.setDisabledTextColor(SystemColor.textInactiveText);
		textField_IBsname.setColumns(10);
		textField_IBsname.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_IBsname.setBackground(Color.WHITE);
		textField_IBsname.setBounds(617, 181, 407, 50);
		IssueBook_panel_5.add(textField_IBsname);
		
		textField_IBbname = new JTextField();
		textField_IBbname.setDisabledTextColor(SystemColor.textInactiveText);
		textField_IBbname.setColumns(10);
		textField_IBbname.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_IBbname.setBackground(Color.WHITE);
		textField_IBbname.setBounds(617, 244, 407, 50);
		IssueBook_panel_5.add(textField_IBbname);
		
		textField_IBedition = new JTextField();
		textField_IBedition.setDisabledTextColor(SystemColor.textInactiveText);
		textField_IBedition.setColumns(10);
		textField_IBedition.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_IBedition.setBackground(Color.WHITE);
		textField_IBedition.setBounds(617, 307, 407, 50);
		IssueBook_panel_5.add(textField_IBedition);
		
		JButton btnIssueBook = new JButton("Issue");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat date_form = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				Calendar next = Calendar.getInstance();
				String Uname = textField_IBuname.getText();
				String Sname = textField_IBsname.getText();
				String Bname = textField_IBbname.getText();
				int Bedition = Integer.parseInt(textField_IBedition.getText());
				String issueDate = date_form.format(cal.getTime());
				String RenewDate = issueDate;
				try{
					   //Setting the date to the given date
					   next.setTime(date_form.parse(RenewDate));
					}catch(ParseException e2){
						e2.printStackTrace();
					 }
				next.add(Calendar.DAY_OF_MONTH, 7);
				RenewDate = date_form.format(next.getTime());

				try {
					PreparedStatement checkbk = con.prepareStatement("select BookCount,BookName,BookEdition from Bookdtb where BookName=? and BookEdition=?");
					checkbk.setString(1, Bname);
					checkbk.setInt(2, Bedition);
					PreparedStatement removebk = con.prepareStatement("update Bookdtb set BookCount = BookCount-1 where BookName=? and BookEdition=?");
					removebk.setString(1, Bname);
					removebk.setInt(2, Bedition);
					PreparedStatement insert = con.prepareStatement("insert into IssuedBook(UserName, StudName, Book, BookEdition, IssueDate, ReturnDate)values(?,?,?,?,?,?)");
					insert.setString(1, Uname);
					insert.setString(2, Sname);
					insert.setString(3, Bname);
					insert.setInt(4, Bedition);
					insert.setString(5, issueDate);
					insert.setString(6, RenewDate);
					
					ResultSet res = checkbk.executeQuery();
					int count=0;
					String name="";
					int edi=0;
					while(res.next())
					{
						count=res.getInt(1);
						name = res.getString(2);
						edi = res.getInt(3);
					}
					
					if(name.equals(Bname)&&edi==Bedition&&count>0) {
						removebk.executeUpdate();
						insert.executeUpdate();
						JOptionPane.showMessageDialog(null, "Book Issued Successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Enetered Book or Edition not available in Library");
					}
					
				} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Failed To Issue Book");
						System.out.println(e1);
				}
				issueDate = "";
				RenewDate = "";
				cal = null;
				textField_IBuname.setText(null);
				textField_IBedition.setText(null);
				textField_IBsname.setText(null);
				textField_IBbname.setText(null);
			}
		});
		btnIssueBook.setFont(new Font("Verdana", Font.BOLD, 16));
		btnIssueBook.setForeground(Color.BLACK);
		btnIssueBook.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnIssueBook.setBackground(Color.MAGENTA);
		btnIssueBook.setBounds(837, 392, 187, 62);
		IssueBook_panel_5.add(btnIssueBook);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Calendar cal = Calendar.getInstance();
				SimpleDateFormat date_form = new SimpleDateFormat("dd/MM/yyyy");
				String Uname = textField_IBuname.getText();
				String Sname = textField_IBsname.getText();
				String Bname = textField_IBbname.getText();
				int Bedition = Integer.parseInt(textField_IBedition.getText());
				String RenewDate = "";
				try {
					PreparedStatement checkbk = con.prepareStatement("select ReturnDate from  IssuedBook where UserName=? and Book=? and BookEdition=?");
					checkbk.setString(1, Uname);
					checkbk.setString(2, Bname);
					checkbk.setInt(3, Bedition);
					PreparedStatement del = con.prepareStatement("delete from IssuedBook where UserName=? and Book=? and BookEdition=?");
					del.setString(1, Uname);
					del.setString(2, Bname);
					del.setInt(3, Bedition);
					PreparedStatement ret = con.prepareStatement("update Bookdtb set BookCount = BookCount+1 where BookName=? and BookEdition=?");
					ret.setString(1, Bname);
					ret.setInt(2, Bedition);
					ResultSet res = checkbk.executeQuery();
					while(res.next())
					{
						RenewDate = res.getString(1);
					}
					if(RenewDate!="") {
						Date renewd = date_form.parse(RenewDate);
						Date currdate = new Date();
						if(currdate.compareTo(renewd)>0)
						{
							JOptionPane.showMessageDialog(null, "Return date exceeded please pay the fine");
							del.executeUpdate();
							ret.executeUpdate();
							JOptionPane.showMessageDialog(null, "Book returned Successfully");
						}
						else {
							del.executeUpdate();
							ret.executeUpdate();
							JOptionPane.showMessageDialog(null, "Book returned Successfully");
						}
					}
					
				}catch(Exception x)
				{
					System.out.println(x);
					JOptionPane.showMessageDialog(null, x);
				}
			}
		});
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setFont(new Font("Verdana", Font.BOLD, 16));
		btnReturn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnReturn.setBackground(Color.MAGENTA);
		btnReturn.setBounds(617, 392, 187, 62);
		IssueBook_panel_5.add(btnReturn);
		StudReport_panel_1.setForeground(Color.BLACK);
		StudReport_panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		StudReport_panel_1.setBackground(Color.DARK_GRAY);
		layeredPane_1.add(StudReport_panel_1, "name_37118083360900");
		StudReport_panel_1.setLayout(null);
		StudReport_panel_1.add(stdrep);
		

		stdrep.setFont(new Font("Verdana", Font.PLAIN, 18));
		stdrep.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		stdrep.setBounds(352, 308, 757, 343);
		stdrep.setBackground(Color.CYAN);
		stdrep.setEditable(false);
		
		JLabel lblBooksIssued = new JLabel("Books Issued");
		lblBooksIssued.setBounds(96, 306, 216, 50);
		lblBooksIssued.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooksIssued.setForeground(Color.WHITE);
		lblBooksIssued.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblBooksIssued.setBackground(Color.DARK_GRAY);
		StudReport_panel_1.add(lblBooksIssued);
		
		JLabel lblStudentReport = new JLabel("Student Report");
		lblStudentReport.setBounds(10, 13, 1437, 62);
		lblStudentReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentReport.setForeground(Color.WHITE);
		lblStudentReport.setFont(new Font("Verdana", Font.BOLD, 21));
		StudReport_panel_1.add(lblStudentReport);
		
		textField_1 = new JTextField();
		textField_1.setBounds(352, 118, 761, 50);
		textField_1.setDisabledTextColor(SystemColor.textInactiveText);
		textField_1.setColumns(10);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_1.setBackground(Color.WHITE);
		StudReport_panel_1.add(textField_1);
		

		label_2.setBounds(352, 181, 761, 50);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_2.setBackground(Color.DARK_GRAY);
		StudReport_panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Name of student");
		label_3.setBounds(96, 182, 216, 50);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_3.setBackground(Color.DARK_GRAY);
		StudReport_panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("User Name");
		label_4.setBounds(96, 118, 216, 50);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_4.setBackground(Color.DARK_GRAY);
		StudReport_panel_1.add(label_4);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String User = textField_1.getText();
				try {
					PreparedStatement search = con.prepareStatement("Select * from issuedbook where UserName=?");
					search.setString(1, User);
					ResultSet res = search.executeQuery();
					String data="";
					while(res.next())
					{
						label_2.setText(res.getString(2));
						data+="\t"+"Book Name :\t"+res.getString(3)+"\n"+"\t"+"Edition:\t   "+res.getString(4)+"\n"+"\t"+"Issue Date:\t"+res.getString(5)+"\n"+"\t"+"Return Date:\t "+res.getString(6)+"\n\n";
					}
					stdrep.setText(data);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
			}
		});
		btnSearch.setBounds(1138, 116, 140, 50);
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 16));
		btnSearch.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSearch.setBackground(Color.MAGENTA);
		StudReport_panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBackground(Color.CYAN);
		scrollPane.setBounds(352, 304, 761, 347);
		StudReport_panel_1.add(scrollPane);
		

		StudReport_panel_2.setLayout(null);
		StudReport_panel_2.setForeground(Color.BLACK);
		StudReport_panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		StudReport_panel_2.setBackground(Color.DARK_GRAY);
		layeredPane_1.add(StudReport_panel_2, "name_42957375062400");
		
		JLabel label = new JLabel("Books Issued");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label.setBackground(Color.DARK_GRAY);
		label.setBounds(132, 299, 216, 50);
		StudReport_panel_2.add(label);
		
		JLabel lblYourActivities = new JLabel("Your Activities");
		lblYourActivities.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourActivities.setForeground(Color.WHITE);
		lblYourActivities.setFont(new Font("Verdana", Font.BOLD, 21));
		lblYourActivities.setBounds(12, 26, 1437, 62);
		StudReport_panel_2.add(lblYourActivities);
		

		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_6.setBackground(Color.DARK_GRAY);
		label_6.setBounds(397, 182, 761, 50);
		StudReport_panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Name of student");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_7.setBackground(Color.DARK_GRAY);
		label_7.setBounds(132, 182, 216, 50);
		StudReport_panel_2.add(label_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setBackground(Color.DARK_GRAY);
		scrollPane_1.setBounds(397, 302, 761, 339);
		StudReport_panel_2.add(scrollPane_1);

		stdrep1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		stdrep1.setFont(new Font("Verdana", Font.PLAIN, 18));
		stdrep1.setBounds(397, 302, 761, 440);
		stdrep1.setBackground(Color.CYAN);
		scrollPane_1.setViewportView(stdrep1);
		

		Penaulty_panel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		Penaulty_panel.setLayout(null);
		Penaulty_panel.setForeground(Color.BLACK);
		Penaulty_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		Penaulty_panel.setBackground(Color.DARK_GRAY);
		layeredPane_1.add(Penaulty_panel, "name_8415852913400");
		
		JLabel lblPanualtyList = new JLabel("Panualty List");
		lblPanualtyList.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanualtyList.setForeground(Color.WHITE);
		lblPanualtyList.setFont(new Font("Verdana", Font.BOLD, 21));
		lblPanualtyList.setBounds(12, 26, 1299, 62);
		Penaulty_panel.add(lblPanualtyList);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(Color.BLACK);
		scrollPane_2.setBounds(12, 144, 1287, 528);
		Penaulty_panel.add(scrollPane_2);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User Name", "Name of Student", "Book", "Edition", "Issued Date", "Return Date"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(108);
		table.getColumnModel().getColumn(1).setPreferredWidth(131);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(124);
		table.getColumnModel().getColumn(5).setPreferredWidth(124);
		scrollPane_2.setViewportView(table);
		

		Searchbook_panel.setLayout(null);
		Searchbook_panel.setForeground(Color.BLACK);
		Searchbook_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		Searchbook_panel.setBackground(Color.DARK_GRAY);
		layeredPane_1.add(Searchbook_panel, "name_30561418340400");
		
		JLabel label_1 = new JLabel("Publication");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_1.setBackground(Color.DARK_GRAY);
		label_1.setBounds(389, 307, 216, 50);
		Searchbook_panel.add(label_1);
		
		JLabel lblCheckBookAvailability = new JLabel("Check Book Availability");
		lblCheckBookAvailability.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckBookAvailability.setForeground(Color.WHITE);
		lblCheckBookAvailability.setFont(new Font("Verdana", Font.BOLD, 21));
		lblCheckBookAvailability.setBounds(12, 13, 1437, 62);
		Searchbook_panel.add(lblCheckBookAvailability);
		
		textField_2 = new JTextField();
		textField_2.setDisabledTextColor(SystemColor.textInactiveText);
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(617, 118, 407, 50);
		Searchbook_panel.add(textField_2);
		
		JLabel label_8 = new JLabel("Book Edition");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_8.setBackground(Color.DARK_GRAY);
		label_8.setBounds(389, 181, 216, 50);
		Searchbook_panel.add(label_8);
		
		JLabel label_9 = new JLabel("Author");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_9.setBackground(Color.DARK_GRAY);
		label_9.setBounds(389, 244, 216, 50);
		Searchbook_panel.add(label_9);
		
		JLabel label_10 = new JLabel("Book Title");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_10.setBackground(Color.DARK_GRAY);
		label_10.setBounds(389, 118, 216, 50);
		Searchbook_panel.add(label_10);
		
		JLabel lblNumberOfBooks = new JLabel("Number of Books Available");
		lblNumberOfBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfBooks.setForeground(Color.WHITE);
		lblNumberOfBooks.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNumberOfBooks.setBackground(Color.DARK_GRAY);
		lblNumberOfBooks.setBounds(389, 370, 216, 50);
		Searchbook_panel.add(lblNumberOfBooks);
		
		JButton btnSearchBook_1 = new JButton("SEARCH BOOK");
		btnSearchBook_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Bname=textField_2.getText();
				int edition=Integer.parseInt(textField_3.getText());
				String Author="";
				String publication="";
				int count=0;
//				JLabel label_12 = new JLabel("");
//				JLabel label_13 = new JLabel("");
//				JLabel label_14 = new JLabel("");
				
				try {
					PreparedStatement chbk = con.prepareStatement("Select * from Bookdtb where BookName=? and BookEdition=?");
					chbk.setString(1, Bname);
					chbk.setInt(2, edition);
					ResultSet rs =chbk.executeQuery();
					
					while(rs.next())
					{
						Author=rs.getString(3);
						publication=rs.getString(5);
						count=Integer.parseInt(rs.getString(6));
						
						if(Author.equals("")&&publication.equals(""))
						{
							JOptionPane.showMessageDialog(null, "No Such book available in library");
							break;
						}
						else {
							label_12.setText(Author);
							label_13.setText(publication);
							label_14.setText(String.valueOf(count));
						}
					}
				} catch (SQLException e1) {
					
				}
			}
		});
		btnSearchBook_1.setForeground(Color.BLACK);
		btnSearchBook_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSearchBook_1.setBackground(Color.MAGENTA);
		btnSearchBook_1.setBounds(1051, 112, 216, 62);
		Searchbook_panel.add(btnSearchBook_1);
		

		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_12.setBackground(Color.DARK_GRAY);
		label_12.setBounds(617, 244, 407, 50);
		Searchbook_panel.add(label_12);
		

		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.WHITE);
		label_13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_13.setBackground(Color.DARK_GRAY);
		label_13.setBounds(617, 307, 407, 50);
		Searchbook_panel.add(label_13);
		

		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.WHITE);
		label_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_14.setBackground(Color.DARK_GRAY);
		label_14.setBounds(617, 370, 407, 50);
		Searchbook_panel.add(label_14);
		
		textField_3 = new JTextField();
		textField_3.setDisabledTextColor(SystemColor.textInactiveText);
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(617, 181, 407, 50);
		Searchbook_panel.add(textField_3);
		

		Searchbook_panel_2.setLayout(null);
		Searchbook_panel_2.setForeground(Color.BLACK);
		Searchbook_panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		Searchbook_panel_2.setBackground(Color.DARK_GRAY);
		layeredPane_1.add(Searchbook_panel_2, "name_29591814346400");
		
		JLabel lblCheckAvailableBooks = new JLabel("Check available books ");
		lblCheckAvailableBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAvailableBooks.setForeground(Color.WHITE);
		lblCheckAvailableBooks.setFont(new Font("Verdana", Font.BOLD, 21));
		lblCheckAvailableBooks.setBounds(12, 26, 1299, 62);
		Searchbook_panel_2.add(lblCheckAvailableBooks);
		
		textField_4 = new JTextField();
		textField_4.setDisabledTextColor(SystemColor.textInactiveText);
		textField_4.setColumns(10);
		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(12, 101, 407, 50);
		Searchbook_panel_2.add(textField_4);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					int rows = model.getRowCount();
					for(int i=rows;i>0;i--)
					{
						model.removeRow(i-1);
					}
					PreparedStatement sh;
					if(sortAut)
					{
						 sh = con.prepareStatement("Select * from Bookdtb order by Author");
					}
					else if(sortbknm){
						 sh = con.prepareStatement("Select * from Bookdtb order by BookName");
					}
					else {
						sh = con.prepareStatement("Select * from Bookdtb");
					}
					ResultSet rs = sh.executeQuery();
					while(rs.next())
					{
					    
					    model.addRow(new Object[]{rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)});
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
			}
		});
		btnShowAll.setForeground(Color.BLACK);
		btnShowAll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnShowAll.setBackground(Color.MAGENTA);
		btnShowAll.setBounds(640, 101, 145, 62);
		Searchbook_panel_2.add(btnShowAll);
		
		JButton button = new JButton("SEARCH BOOK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Bname=textField_4.getText();
				String Author="";
				String publication="";
				int count=0;
				
				try {
					PreparedStatement chbk = con.prepareStatement("Select * from Bookdtb where BookName=?");
					chbk.setString(1, Bname);
					ResultSet rs =chbk.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					int rows = model.getRowCount();
					for(int i=rows;i>0;i--)
					{
						model.removeRow(i-1);
					}
					
					while(rs.next())
					{
						Author=rs.getString(3);
						publication=rs.getString(5);
						count=Integer.parseInt(rs.getString(6));
						
						if(Author.equals("")&&publication.equals(""))
						{
							JOptionPane.showMessageDialog(null, "No Such book available in library");
							break;
						}
						else {
							model.addRow(new Object[] {rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)});
						}
					}
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button.setBackground(Color.MAGENTA);
		button.setBounds(457, 101, 145, 62);
		Searchbook_panel_2.add(button);
		
		JButton btnSortByBook = new JButton("Sort by Book Name");
		btnSortByBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Now Click on Show All ");
				sortbknm = true;
				sortAut = false;
			}
		});
		btnSortByBook.setForeground(Color.BLACK);
		btnSortByBook.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSortByBook.setBackground(Color.MAGENTA);
		btnSortByBook.setBounds(823, 101, 145, 62);
		Searchbook_panel_2.add(btnSortByBook);
		
		JButton btnSortByAuthor = new JButton("Sort by Author Name");
		btnSortByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Now Click on Show All ");
				sortAut = true;
				sortbknm = false;
			}
		});
		btnSortByAuthor.setForeground(Color.BLACK);
		btnSortByAuthor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSortByAuthor.setBackground(Color.MAGENTA);
		btnSortByAuthor.setBounds(1017, 101, 145, 62);
		Searchbook_panel_2.add(btnSortByAuthor);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.DARK_GRAY);
		scrollPane_3.setBounds(12, 198, 1275, 438);
		Searchbook_panel_2.add(scrollPane_3);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book Id", "Book Name", "Author", "Edition", "Publication", "Book Count"
			}
		));
		scrollPane_3.setViewportView(table_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("E:\\Java Projects\\LibraryManage\\src\\largelib1.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1902, 977);
		frame.getContentPane().add(lblNewLabel_6);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}