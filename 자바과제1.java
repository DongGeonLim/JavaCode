package hibbangaru;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p1 extends JFrame
{
	JTextField jtf = new JTextField(20);
	JTextArea jtA = new JTextArea(7, 20);
	String searchWord, nowWord, sum = "";
	String splitText[], papago[];
	
	public p1()
	{
		setTitle("간단한 번역기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("영어 문장 입력 후 <Enter> 키를 입력하세요"));
		
		c.add(jtf);
		c.add(jtA);
		
		HashMap<String, String> word = new HashMap<String, String>();
		
		word.put("I", "나는");
		word.put("Like", "좋아한다");
		word.put("this", "이");
		word.put("cat", "고양이");
		word.put("dog", "개");
		word.put("hate", "싫어한다");
		
		jtf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JTextField t = (JTextField)e.getSource();
				String text = t.getText();
				splitText = text.split(" ");
				papago = splitText;
				t.setText("");
				for (int i = 0; i < splitText.length; i++)
				{
					nowWord = splitText[i];
					searchWord = word.get(nowWord);
					papago[i] = searchWord;
				}
				for (int i = 0; i < papago.length; i++)
				{
					sum = sum + " " + papago[i];
				}
				jtA.append(sum + "\n");
				sum = "";
			}});
		
		setSize(300, 275);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new p1();
	}
}