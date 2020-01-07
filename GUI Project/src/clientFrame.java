import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class clientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfQuestion;
	private JTextField tfName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	int Answer = 1;
	String ClientName = "";
	Client client;
	private JTextField tfReply;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientFrame frame = new clientFrame();
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
	public clientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Teacher Student Client");
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
		panelTop.add(lblTitle);
		
		JPanel panelRight = new JPanel();
		contentPane.add(panelRight, BorderLayout.EAST);
		
		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);
		
		JPanel panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(null);
		
		tfQuestion = new JTextField();
		tfQuestion.setEditable(false);
		tfQuestion.setBounds(77, 44, 356, 119);
		panelCentre.add(tfQuestion);
		tfQuestion.setColumns(10);
		
		JLabel lblClientName = new JLabel("Name:");
		lblClientName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClientName.setBounds(77, 15, 46, 14);
		panelCentre.add(lblClientName);
		
		tfName = new JTextField();
		tfName.setText("Enter Name:");
		tfName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ClientName = tfName.getText();
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				tfName.setText(ClientName);
					
			}
		});
		tfName.setBounds(133, 13, 104, 20);
		panelCentre.add(tfName);
		tfName.setColumns(10);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Answer = 2;
			}
		});
		rdbtnB.setMnemonic('B');
		buttonGroup.add(rdbtnB);
		rdbtnB.setBounds(84, 190, 39, 23);
		panelCentre.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Answer = 3;
			}
		});
		rdbtnC.setMnemonic('C');
		buttonGroup.add(rdbtnC);
		rdbtnC.setBounds(84, 210, 39, 23);
		panelCentre.add(rdbtnC);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendAnswer(Answer);
				client.sendName(ClientName);
				try {
					tfReply.setText(client.getReply());
				} catch (IOException e1) {
					tfReply.setText(e1.getMessage());
				}
			}
			
		});
		btnSubmit.setBounds(179, 244, 89, 23);
		panelCentre.add(btnSubmit);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(69);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(402, 244, 89, 23);
		panelCentre.add(btnExit);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Answer = 1 ;
			}
		});
		rdbtnA.setMnemonic('A');
		buttonGroup.add(rdbtnA);
		rdbtnA.setSelected(true);
		rdbtnA.setBounds(84, 170, 39, 23);
		panelCentre.add(rdbtnA);
		
		JButton btnNewButton = new JButton("Connect!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = new Client();
				try {
					client.connect();
					tfQuestion.setText(client.getQuestions());
					client.sendName(ClientName);
					
				} catch (Exception e1) {
					tfReply.setText("Connect Failed!!!!\nTry Again\n" +e1.getMessage());
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(344, 12, 89, 23);
		panelCentre.add(btnNewButton);
		
		tfReply = new JTextField();
		tfReply.setEditable(false);
		tfReply.setBounds(195, 174, 239, 54);
		panelCentre.add(tfReply);
		tfReply.setColumns(10);
		
		JPanel panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.SOUTH);
	}
}
