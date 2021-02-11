package TermProject;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

public class studentRegistrationGUI extends studentRegistration {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField insertPhone;
	private JTextField insertMail;
	private JTextField insertLast;
	private JTextField insertFirst;
	private JTextField insertID;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentRegistrationGUI window = new studentRegistrationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentRegistrationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ITU Student Registration");
		frame.getContentPane().setLayout(new CardLayout(0,0));
		frame.setBounds(300, 500, 500, 300);

		
		JPanel authPanel = new JPanel();
		authPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Authentication Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(authPanel, "name_69498054591102");
		authPanel.setLayout(null);
		authPanel.setVisible(true);
		
	
		
	
		textField = new JTextField();
		textField.setBounds(110, 88, 130, 26);
		authPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 150, 130, 26);
		authPanel.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		lblUsername.setBounds(39, 93, 91, 16);
		authPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		lblPassword.setBounds(39, 155, 71, 16);
		authPanel.add(lblPassword);
		
		
		JPanel userPanel = new JPanel();
		userPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Student Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(userPanel, "name_69544383193014");
		userPanel.setLayout(null);

		JPanel contactPanel = new JPanel();
		contactPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Contact Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(contactPanel, "name_658367209025");
		contactPanel.setLayout(null);
		contactPanel.setVisible(false);
		
		JPanel recordPanel = new JPanel();
		recordPanel.setBorder(new TitledBorder(null, "Grade Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(recordPanel, "name_881060737714");
		recordPanel.setLayout(null);
		recordPanel.setVisible(false);
		
		JButton btnContactInfo = new JButton("Contact Info");
		btnContactInfo.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		btnContactInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPanel.setVisible(false);
				contactPanel.setVisible(true);
				
				
			}
		});
		btnContactInfo.setBounds(304, 115, 132, 38);
		userPanel.add(btnContactInfo);
		
		JButton btnRecordInfo = new JButton("Grade Info");
		btnRecordInfo.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		btnRecordInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPanel.setVisible(false);
				recordPanel.setVisible(true);
			}
		});
		btnRecordInfo.setBounds(304, 183, 132, 38);
		userPanel.add(btnRecordInfo);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPanel.setVisible(false);
				authPanel.setVisible(true);
			}
		});
		btnNewButton.setBounds(400, 12, 84, 29);
		userPanel.add(btnNewButton);
		
		JLabel label_5 = new JLabel("ITU Student Database");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		label_5.setBounds(130, 55, 210, 26);
		userPanel.add(label_5);
		
		JLabel lblNewLabel = new JLabel("To view the student contact info :");
		lblNewLabel.setBounds(43, 125, 249, 16);
		userPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("To view the detailed grades :");
		lblNewLabel_1.setBounds(43, 193, 220, 16);
		userPanel.add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(131, 256, 278, 16);
		userPanel.add(label_6);
		
		Image img3 = new ImageIcon(this.getClass().getResource("/photo2.png")).getImage();
		label_6.setIcon(new ImageIcon(img3));
		
		
		JPanel insertStudentPanel = new JPanel();
		insertStudentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Insert Student Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(insertStudentPanel, "name_69589791154542");
		insertStudentPanel.setLayout(null);
		
		JLabel lblStudentId_1 = new JLabel("Student ID:");
		lblStudentId_1.setBounds(23, 60, 85, 16);
		insertStudentPanel.add(lblStudentId_1);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(23, 88, 85, 16);
		insertStudentPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(23, 116, 85, 16);
		insertStudentPanel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(23, 144, 85, 16);
		insertStudentPanel.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(23, 172, 96, 16);
		insertStudentPanel.add(lblPhoneNumber);
		
		JPanel adminPanel = new JPanel();
		adminPanel.setBorder(new TitledBorder(null, "Admin Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(adminPanel, "name_10339116645095");
		adminPanel.setLayout(null);
		
		insertPhone = new JTextField();
		insertPhone.setBounds(131, 167, 130, 26);
		insertStudentPanel.add(insertPhone);
		insertPhone.setColumns(10);
		
		insertMail = new JTextField();
		insertMail.setBounds(131, 139, 130, 26);
		insertStudentPanel.add(insertMail);
		insertMail.setColumns(10);
		
		insertLast = new JTextField();
		insertLast.setBounds(131, 111, 130, 26);
		insertStudentPanel.add(insertLast);
		insertLast.setColumns(10);
		
		insertFirst = new JTextField();
		insertFirst.setBounds(131, 83, 130, 26);
		insertStudentPanel.add(insertFirst);
		insertFirst.setColumns(10);
		
		insertID = new JTextField();
		insertID.setBounds(131, 55, 130, 26);
		insertStudentPanel.add(insertID);
		insertID.setColumns(10);
		
		JButton btnInserTheRecord = new JButton("Insert the Record");
		btnInserTheRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					insertStudent(insertID.getText(), insertFirst.getText(), insertLast.getText(), insertMail.getText(), insertPhone.getText());
					JOptionPane.showMessageDialog(insertStudentPanel, "You inserted a new data successfully");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				insertID.setText("");
				insertFirst.setText("");
				insertLast.setText("");
				insertMail.setText("");
				insertPhone.setText("");
			}
			
			
		});
		btnInserTheRecord.setBounds(85, 213, 154, 29);
		insertStudentPanel.add(btnInserTheRecord);
		
		JLabel photo_Label2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/photo.png")).getImage();
		photo_Label2.setIcon(new ImageIcon(img2));
		photo_Label2.setBounds(308, 42, 154, 182);
		insertStudentPanel.add(photo_Label2);
		
		JLabel label_1 = new JLabel("ITU Student Database");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(33, 16, 228, 32);
		insertStudentPanel.add(label_1);
		
		JButton button_1 = new JButton("Logout");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertStudentPanel.setVisible(false);
				authPanel.setVisible(true);
			}
		});
		button_1.setBounds(400, 12, 84, 29);
		insertStudentPanel.add(button_1);
				
		JButton button_6 = new JButton("Back");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertStudentPanel.setVisible(false);
				adminPanel.setVisible(true);
				
			}
		});
		button_6.setBounds(6, 243, 117, 29);
		insertStudentPanel.add(button_6);
		
		userPanel.setVisible(false);
		insertStudentPanel.setVisible(false);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
	//	authPanel.getRootPane().setDefaultButton(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
					try {
						Connection con = DriverManager.getConnection(url,user,password);
						PreparedStatement pst = con.prepareStatement("Select * from Permission where username=? and password=?");
					
						pst.setString(1, textField.getText());
						pst.setString(2, passwordField.getText());
						ResultSet rs = pst.executeQuery();
						
						if(rs.next()){
							System.out.println("Login Succesful");
							String s = rs.getString("type");
							
							if(s.equals("admin") ){
								authPanel.setVisible(false);
								adminPanel.setVisible(true);
							}
							else{
								authPanel.setVisible(false);
								userPanel.setVisible(true);
							}
						}
						else{
							JOptionPane.showMessageDialog(authPanel, "Wrong Combination");
						}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			textField.setText("");
			passwordField.setText("");
			
			}
		});
		btnLogin.setBounds(123, 218, 117, 29);
		authPanel.add(btnLogin);
		
		JLabel photo_Label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/photo.png")).getImage();
		photo_Label.setIcon(new ImageIcon(img));
		photo_Label.setBounds(308, 42, 154, 182);
		authPanel.add(photo_Label);
		
		JLabel label = new JLabel("ITU Student Database");
		label.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(55, 44, 210, 26);
		authPanel.add(label);
		
	
		
		JLabel label_2 = new JLabel("Contact Information");
		label_2.setBounds(178, 91, 130, 16);
		contactPanel.add(label_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textPane_1.setBounds(100, 119, 276, 94);
		contactPanel.add(textPane_1);
		
		JButton contactBack = new JButton("Back");
		contactBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contactPanel.setVisible(false);
				userPanel.setVisible(true);
				
				textPane_1.setText("");
				textField_2.setText("");
			}
		});
		contactBack.setBounds(6, 243, 117, 29);
		contactPanel.add(contactBack);
		
		JLabel label_3 = new JLabel("Student ID:");
		label_3.setBounds(44, 39, 114, 16);
		contactPanel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 34, 130, 26);
		contactPanel.add(textField_2);
		
		JButton btnGetContact = new JButton("Get Contact");
		btnGetContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(getStudentToTextArea(textField_2.getText()) != null){
					textPane_1.setText(getStudentToTextArea(textField_2.getText()));
					}
					else
						JOptionPane.showMessageDialog(userPanel, "Wrong Student ID");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGetContact.setBounds(325, 34, 117, 29);
		contactPanel.add(btnGetContact);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(131, 256, 278, 16);
		contactPanel.add(label_9);
		Image img4 = new ImageIcon(this.getClass().getResource("/photo2.png")).getImage();
		label_9.setIcon(new ImageIcon(img4));
		
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textPane_2.setBounds(155, 118, 195, 94);
		recordPanel.add(textPane_2);
		
		JLabel lblRecordInformation = new JLabel("Grade Information");
		lblRecordInformation.setBounds(192, 90, 130, 16);
		recordPanel.add(lblRecordInformation);
		
		JButton recordBack = new JButton("Back");
		recordBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPanel.setVisible(true);
				recordPanel.setVisible(false);
				textPane_2.setText("");
				textField_3.setText("");
			}
		});
		recordBack.setBounds(6, 243, 117, 29);
		recordPanel.add(recordBack);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 41, 130, 26);
		recordPanel.add(textField_3);
		
		JLabel label_4 = new JLabel("Student ID:");
		label_4.setBounds(46, 46, 114, 16);
		recordPanel.add(label_4);
		
		JButton button = new JButton("Get Record");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(getResultToTextArea(textField_3.getText()) != null){
					textPane_2.setText(getResultToTextArea(textField_3.getText()) + " ");
					}
					else
						JOptionPane.showMessageDialog(userPanel, "Wrong Student ID");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(330, 41, 117, 29);
		recordPanel.add(button);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(131, 256, 278, 16);
		recordPanel.add(label_8);
		
		Image img5 = new ImageIcon(this.getClass().getResource("/photo2.png")).getImage();
		label_8.setIcon(new ImageIcon(img5));
		

		
		JButton btnInsertStudent = new JButton("Insert Student");
		btnInsertStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanel.setVisible(false);
				insertStudentPanel.setVisible(true);
				
			}
		});
		btnInsertStudent.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		btnInsertStudent.setBounds(294, 106, 132, 38);
		adminPanel.add(btnInsertStudent);
		

		JPanel insertGradePanel = new JPanel();
		insertGradePanel.setBorder(new TitledBorder(null, "Insert Grade Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(insertGradePanel, "name_10604039080550");
		insertGradePanel.setLayout(null);
		
		JLabel label_11 = new JLabel("Student ID:");
		label_11.setBounds(23, 66, 85, 16);
		insertGradePanel.add(label_11);
		
		JLabel lblMidtermExam = new JLabel("Midterm Exam:");
		lblMidtermExam.setBounds(23, 94, 106, 16);
		insertGradePanel.add(lblMidtermExam);
		
		JLabel lblLabWorks = new JLabel("Lab Works:");
		lblLabWorks.setBounds(23, 122, 85, 16);
		insertGradePanel.add(lblLabWorks);
		
		JLabel lblFinalExam = new JLabel("Final Exam:");
		lblFinalExam.setBounds(23, 150, 85, 16);
		insertGradePanel.add(lblFinalExam);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(131, 145, 130, 26);
		insertGradePanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(131, 117, 130, 26);
		insertGradePanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(131, 89, 130, 26);
		insertGradePanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(131, 61, 130, 26);
		insertGradePanel.add(textField_7);
		
		JButton button_2 = new JButton("Insert the Record");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertGrades(textField_7.getText(), textField_6.getText(), textField_5.getText(), textField_4.getText());
					JOptionPane.showMessageDialog(insertGradePanel, "You inserted the grades successfully");
					
					textField_7.setText("");
					textField_6.setText("");
					textField_5.setText("");
					textField_4.setText("");

					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setBounds(86, 201, 154, 29);
		insertGradePanel.add(button_2);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(308, 48, 154, 182);
		insertGradePanel.add(label_17);
		Image img98 = new ImageIcon(this.getClass().getResource("/photo.png")).getImage();
		label_17.setIcon(new ImageIcon(img98));
		
		JLabel label_18 = new JLabel("ITU Student Database");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(33, 22, 228, 32);
		insertGradePanel.add(label_18);
		
		JButton button_3 = new JButton("Logout");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertGradePanel.setVisible(false);
				authPanel.setVisible(true);
			}
		});
		button_3.setBounds(400, 12, 84, 29);
		insertGradePanel.add(button_3);
		
		JButton button_5 = new JButton("Back");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertGradePanel.setVisible(false);
				adminPanel.setVisible(true);
			}
		});
		button_5.setBounds(0, 249, 117, 29);
		insertGradePanel.add(button_5);
		
		JButton btnRecordInfo_1 = new JButton("Insert Grades");
		btnRecordInfo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanel.setVisible(false);
				insertGradePanel.setVisible(true);
				
			}
		});
		btnRecordInfo_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		btnRecordInfo_1.setBounds(294, 174, 132, 38);
		adminPanel.add(btnRecordInfo_1);
		
		JButton button_4 = new JButton("Logout");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanel.setVisible(false);
				authPanel.setVisible(true);
				
			}
		});
		button_4.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		button_4.setBounds(400, 12, 84, 29);
		adminPanel.add(button_4);
		
		JLabel label_10 = new JLabel("ITU Student Database");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		label_10.setBounds(120, 46, 210, 26);
		adminPanel.add(label_10);
		
		JLabel lblToInsertA = new JLabel("To insert a new student :");
		lblToInsertA.setBounds(33, 116, 249, 16);
		adminPanel.add(lblToInsertA);
		
		JLabel lblToInsertStudent = new JLabel("To insert student grade records :");
		lblToInsertStudent.setBounds(33, 184, 220, 16);
		adminPanel.add(lblToInsertStudent);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(131, 256, 278, 16);
		adminPanel.add(label_13);
		Image img7 = new ImageIcon(this.getClass().getResource("/photo2.png")).getImage();
		label_13.setIcon(new ImageIcon(img7));
		
		
		
		
	}	
}

