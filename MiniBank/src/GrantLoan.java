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

public class GrantLoan extends JFrame {

	private JPanel contentPane;
	private JTextField lNum;
	private JTextField lType;
	private JTextField lAmt;
	private JTextField brNum;
	private JTextField bCode;
	private JTextField aadhaar;
	private JLabel lblNewLabel;
	private JLabel lblAmount;
	private JLabel lblBranchNumber;
	private JLabel lblCode;
	private JLabel lblAadhaar;
	private JButton btnGrant;
	private JLabel msg;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrantLoan frame = new GrantLoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GrantLoan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450,300);
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
		
		lNum = new JTextField();
		lNum.setColumns(10);
		
		lType = new JTextField();
		lType.setColumns(10);
		
		lAmt = new JTextField();
		lAmt.setColumns(10);
		
		brNum = new JTextField();
		brNum.setColumns(10);
		
		bCode = new JTextField();
		bCode.setColumns(10);
		
		aadhaar = new JTextField();
		aadhaar.setColumns(10);
		
		JLabel lblLoanNumber = new JLabel("Loan Number");
		
		lblNewLabel = new JLabel("Loan Type");
		
		lblAmount = new JLabel("Amount");
		
		lblBranchNumber = new JLabel("Branch Number");
		
		lblCode = new JLabel("Code");
		
		lblAadhaar = new JLabel("Aadhaar");
		
		btnGrant = new JButton("Grant");
		btnGrant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(lNum.getText());
					String Type = lType.getText();
					int amt = Integer.parseInt(lAmt.getText());
					int br_no = Integer.parseInt(brNum.getText());
					int br_code = Integer.parseInt(bCode.getText());
					int adhar = Integer.parseInt(aadhaar.getText());
					
					try {
						
				    	Class.forName("oracle.jdbc.driver.OracleDriver");						
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "rajeev");					
				        Statement stmt = con.createStatement();							        
				        stmt.executeQuery("INSERT INTO loan VALUES ("+Integer.toString(num) + ",'" + Type + "'," + Integer.toString(amt) + "," + Integer.toString(br_no) + "," + Integer.toString(br_code) + "," + Integer.toString(adhar) + ")");		
				        con.close();			
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				}
				catch(Exception e1) {
					e1.printStackTrace();
					msg.setText("Enter proper values");
				}
			}
		});
		
		msg = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(145, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLoanNumber)
								.addComponent(lblNewLabel)
								.addComponent(lblAmount)
								.addComponent(lblBranchNumber)
								.addComponent(lblCode)
								.addComponent(lblAadhaar))
							.addGap(35))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)
							.addGap(188)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(msg)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnGrant, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(aadhaar, Alignment.TRAILING)
								.addComponent(bCode, Alignment.TRAILING)
								.addComponent(brNum, Alignment.TRAILING)
								.addComponent(lAmt, Alignment.TRAILING)
								.addComponent(lType, Alignment.TRAILING)
								.addComponent(lNum, Alignment.TRAILING))
							.addGap(85))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack)
						.addComponent(msg))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLoanNumber))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lAmt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(brNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBranchNumber))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCode))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(aadhaar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAadhaar))
					.addGap(18)
					.addComponent(btnGrant)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
