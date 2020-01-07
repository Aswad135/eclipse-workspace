import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class serverFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea tfQuestion;
	private final ButtonGroup buttonGroupAnswer = new ButtonGroup();
	String Question = "";
	String Answer = "A";
	Server server;
	private JTextField tfServerInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					serverFrame frame = new serverFrame();
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
	public serverFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Teacher Student Server ");
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
		panelTop.add(lblTitle);
		
		JPanel panelRight = new JPanel();
		contentPane.add(panelRight, BorderLayout.EAST);
		
		JPanel panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(null);
		
		JButton btnServerInfo = new JButton("Server Info");
		btnServerInfo.setEnabled(false);
		btnServerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = server.getServerInfo();
				if(temp.charAt(0) == 'I')
					tfServerInfo.setForeground(new Color(0,255,0));
				else
					tfServerInfo.setForeground(new Color(255,0,0));
				
				tfServerInfo.setText(temp);
			}
		});
		btnServerInfo.setBounds(386, 11, 89, 23);
		panelCentre.add(btnServerInfo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(69);
			}
		});
		btnExit.setBounds(386, 239, 89, 23);
		panelCentre.add(btnExit);
		
		tfQuestion = new JTextArea();
		tfQuestion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				Question = tfQuestion.getText();
			}
		});
		tfQuestion.setBounds(29, 53, 337, 80);
		panelCentre.add(tfQuestion);
		tfQuestion.setColumns(10);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Answer = "A";
			}
		});
		rdbtnA.setMnemonic('A');
		rdbtnA.setSelected(true);
		buttonGroupAnswer.add(rdbtnA);
		rdbtnA.setBounds(29, 172, 46, 23);
		panelCentre.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Answer = "B";
			}
		});
		rdbtnB.setMnemonic('B');
		buttonGroupAnswer.add(rdbtnB);
		rdbtnB.setBounds(29, 192, 46, 23);
		panelCentre.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Answer = "C";
			}
		});
		rdbtnC.setMnemonic('C');
		buttonGroupAnswer.add(rdbtnC);
		rdbtnC.setBounds(29, 212, 46, 23);
		panelCentre.add(rdbtnC);
		
		JLabel lblNewLabel = new JLabel("Enter your Question with choices below:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(32, 38, 269, 14);
		panelCentre.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Correct Answer:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(29, 156, 149, 14);
		panelCentre.add(lblNewLabel_1);
		
		JButton btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server = new Server();
				server.setCorrect(Answer);
				server.setQuestion(Question);
				server.runServer();
				btnServerInfo.setEnabled(true);;
			}
		});
		btnStartServer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStartServer.setBounds(302, 172, 122, 43);
		panelCentre.add(btnStartServer);
		
		tfServerInfo = new JTextField();
		tfServerInfo.setBorder(null);
		tfServerInfo.setEditable(false);
		tfServerInfo.setBounds(376, 45, 86, 95);
		panelCentre.add(tfServerInfo);
		tfServerInfo.setColumns(10);
		
		JPanel panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.SOUTH);
		
		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);
	}
}
