import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class BoardInsert extends JFrame {
	
	
	Board_list board_list = new Board_list();

	
	public BoardInsert() {
		setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 15));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		
		setBounds(new Rectangle(300,10,600,500));
		setTitle("게시글 등록");
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		
		JTextField title = new JTextField("제목을 입력해 주세요.");
		title.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
		title.setBounds(88,86,466,34);
		getContentPane().add(title);
		title.setColumns(10);
		
		title.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(title.getText().trim().equals(""))
					title.setText("제목을 입력해 주세요.");
				else {
					
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(title.getText().trim().equals("제목을 입력해 주세요."))
					title.setText("");
				else {
					
				}
			}
		});
		
		JTextArea textArea = new JTextArea("");		
		
		textArea.setToolTipText("");
		textArea.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 13));
		textArea.setLineWrap(true); //행넘기기 기능 on
		textArea.setWrapStyleWord(true); //행 넘길 때 마지막 행의 단어가 두행에 걸쳐 나뉘어지지 않도록.
        textArea.setRows(7);
        textArea.setBounds(88, 142, 466, 205);
        
        Border lineBorder = BorderFactory.createLineBorder(new Color(160, 160,160));
        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
        textArea.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
        
        getContentPane().add(textArea);
        
        
        RoundedButton btnWrite = new RoundedButton("등록");
        btnWrite.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 13));
        btnWrite.setBounds(473,369,75,30);
        btnWrite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String titles =title.getText();
				String txtarea =textArea.getText();
				String username =Client_App.current_id;
				System.out.println(username);
				board_list.createBoard(titles,txtarea,username);
				
				setVisible(false);
				Board board=new Board();
			}
		});
        
        getContentPane().add(btnWrite);
        
        
        RoundedButton btnClose = new RoundedButton("취소");
        btnClose.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 13));
        btnClose.setBounds(394,369,75,30);
        btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Board board=new Board();
			}
		});
        getContentPane().add(btnClose);
        
        JLabel lblNewLabel = new JLabel("제목");
        lblNewLabel.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 15));
        lblNewLabel.setBounds(24, 86, 62, 34);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("내용\r\n");
        lblNewLabel_1.setBackground(UIManager.getColor("Button.highlight"));
        lblNewLabel_1.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(24, 139, 62, 34);
        getContentPane().add(lblNewLabel_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(8, 130, 546, 25);
        separator.setBackground(UIManager.getColor("Button.background"));
        getContentPane().add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(UIManager.getColor("Button.background"));
        separator_1.setBounds(8, 356, 546, 25);
        getContentPane().add(separator_1);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBackground(UIManager.getColor("Button.background"));
        separator_2.setBounds(8, 74, 546, 25);
        getContentPane().add(separator_2);
        
        JLabel lblNewLabel_2 = new JLabel("게시글 작성\r\n");
        lblNewLabel_2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 18));
        lblNewLabel_2.setBounds(217, 12, 154, 34);
        getContentPane().add(lblNewLabel_2);
        
		setVisible(true);
		
		
	}
}
