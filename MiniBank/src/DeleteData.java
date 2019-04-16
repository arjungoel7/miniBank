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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class DeleteData extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtacc;
	private JTextField txtLoanNumber;
	private JTextField txtAadhar;
	private JTextField txtNumber;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteData frame = new DeleteData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin ad = new Admin();
				ad.setVisible(true);
			}
		});
		
		JButton btnDeleteBranch = new JButton("Delete Branch");
		btnDeleteBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int code = Integer.parseInt(txtCode.getText());
					int num = Integer.parseInt(txtNumber.getText());
					try {
									
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();							        
				        stmt.executeQuery("DELETE FROM branch WHERE code = "+Integer.toString(code) + "AND br_no = " + Integer.toString(num));			
				        con.close();
				        label.setText("Deleted Successfully");
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
				        label.setText("Deleted not successful");
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);	
				        label.setText("Deleted not successful");
				    }
				}
				catch(Exception e1){
					e1.printStackTrace();
					label.setText("Enter Proper Values");
				}
			}
		});
		
		txtCode = new JTextField();
		txtCode.setText("code");
		txtCode.setColumns(10);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int acc_no = Integer.parseInt(txtacc.getText());
					try {
									
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();							        
				        stmt.executeQuery("DELETE FROM account WHERE acc_no = "+Integer.toString(acc_no));			
				        con.close();
				        label.setText("Deleted Successfully");
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
				        label.setText("Deleted not successful");
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);	
				        label.setText("Deleted not successful");
				    }
				}
				catch(Exception e1){
					e1.printStackTrace();
					label.setText("Enter Proper Values");
				}
			}
		});
		
		txtacc = new JTextField();
		txtacc.setText("account number");
		txtacc.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete Loan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int loan_no = Integer.parseInt(txtLoanNumber.getText());
					try {
									
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();							        
				        stmt.executeQuery("DELETE FROM loan WHERE loan_no = "+Integer.toString(loan_no));			
				        con.close();
				        label.setText("Deleted Successfully");
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
				        label.setText("Deleted not successful");
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);	
				        label.setText("Deleted not successful");
				    }
				}
				catch(Exception e2){
					e2.printStackTrace();
					label.setText("Enter Proper Values");
				}
			}
		});
		
		txtLoanNumber = new JTextField();
		txtLoanNumber.setText("loan number");
		txtLoanNumber.setColumns(10);
		
		JButton btnDelete = new JButton("Delete Customer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int acc_no = Integer.parseInt(txtAadhar.getText());
					try {
									
				        Class.forName("oracle.jdbc.driver.OracleDriver");					
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();							        
				        stmt.executeQuery("DELETE FROM customer WHERE aadhaar = "+Integer.toString(acc_no));			
				        con.close();
				        label.setText("Deleted Successfully");
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
				        label.setText("Deleted not successful");
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);	
				        label.setText("Deleted not successful");
				    }
				}
				catch(Exception e1){
					e1.printStackTrace();
					label.setText("Enter Proper Values");
				}
			}
		});
		
		txtAadhar = new JTextField();
		txtAadhar.setText("aadhaar");
		txtAadhar.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setText("number");
		txtNumber.setColumns(10);
		
		label = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnDeleteBranch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDeleteAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtAadhar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLoanNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtacc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtCode, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(292, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteBranch)
						.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteAccount)
						.addComponent(txtacc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(txtLoanNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(txtAadhar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
