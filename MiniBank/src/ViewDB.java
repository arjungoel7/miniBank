import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class ViewDB extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDB frame = new ViewDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewDB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin ad = new Admin();
				ad.setVisible(true);
			}
		});
		
		JButton btnBank = new JButton("Bank");
		btnBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {		
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();						        
				        ResultSet rs = stmt.executeQuery("SELECT * FROM Bank");
				        textPane.setText("Code" + "\t" + "Name" + "\t" + "Main Address" + "\n");
				        while (rs.next())
				        {		
				        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t" + rs.getString(2) + "\t" + rs.getString(3));
				        }			
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		
		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {		
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();						        
				        ResultSet rs = stmt.executeQuery("SELECT * FROM account");
				        textPane.setText("Number" + "\t" + "Balance" + "\t" + "Type" + "\t" + "Branch Number" + "\t" + "Bank Code" + "\n");
				        while (rs.next())
				        {		
				        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\t\t" + rs.getInt(5));
				        }			
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {		
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();						        
				        ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
				        textPane.setText("Aadhaar" + "\t" + "Name" + "\t" + "Phone" + "\t" + "Address" + "\n");
				        while (rs.next())
				        {		
				        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
				        }			
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		
		JButton btnNewButton = new JButton("Loan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
			        Class.forName("oracle.jdbc.driver.OracleDriver");					
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
			        Statement stmt = con.createStatement();						        
			        ResultSet rs = stmt.executeQuery("SELECT * FROM loan");
			        textPane.setText("Number" + "\t" + "Type" + "\t" + "Amount" + "\t" + "Branch" + "\t" + "Code:" + "\t" + "Aadhaar" + "\n");
			        while (rs.next())
			        {		
			        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t" + rs.getInt(5) + "\t" + rs.getInt(6));
			        }			
			        con.close();			
			    } catch (SQLException ex) {
	
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
			}
		});
		
		JButton btnBranch = new JButton("Branch");
		btnBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {		
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();						        
				        ResultSet rs = stmt.executeQuery("SELECT * FROM branch");
				        textPane.setText("Number" + "\t" + "Bank Code" + "\t" + "Address" + "\n");
				        while (rs.next())
				        {		
				        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t" + rs.getString(2) + "\t" + rs.getString(3));
				        }			
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		
		JButton btnCustaccount = new JButton("Cust_Account");
		btnCustaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {		
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();						        
				        ResultSet rs = stmt.executeQuery("SELECT * FROM customer_accounts");
				        textPane.setText("Aadhar" + "\t" + "Account Number" + "\n");
				        while (rs.next())
				        {		
				        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t" + rs.getString(2));
				        }			
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		
		JButton btnNewButton_1 = new JButton("Account Log");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {		
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();						        
				        ResultSet rs = stmt.executeQuery("SELECT * FROM log_account");
				        textPane.setText("Account Number" + "\t" + "Balance" + "\t" + "Account Type" + "\t" + "Action Performed" + "\n");
				        while (rs.next())
				        {		
				        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4));
				        }			
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		
		JButton btnNewButton_2 = new JButton("Transfer Log");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {		
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();						        
				        ResultSet rs = stmt.executeQuery("SELECT * FROM transfer_log");
				        textPane.setText("Account_1" + "\t" + "Account_2" + "\t" + "Amount" + "\t" + "Date" + "\n");
				        while (rs.next())
				        {		
				        	textPane.setText(textPane.getText() + "\n" + rs.getInt(1) + " \t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
				        }			
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnCustaccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBranch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBank, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)))
					.addGap(18)
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(textPane))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBank)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAccount)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCustomer)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBranch)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCustaccount)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2)))
					.addGap(65))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
