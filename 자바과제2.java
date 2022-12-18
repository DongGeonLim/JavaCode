package hibbangaru;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p2 extends JFrame
{
	int inputarr[][];
	int exarr[][] = {{4,1,2,2},{0,4,1,3},{3,1,0,4},{2,1,3,2}};
	
	JTextField jtf = new JTextField(3);
	JTextArea jtA = new JTextArea(20, 20);
	JScrollPane jsp = new JScrollPane(jtA);
	
	Container c = getContentPane();

	JPanel up = new JPanel();
	JPanel down = new JPanel();
	
	boolean flag = true;
	
	int n;
	int sum;
	
	void makeMatrix(int n)
	{
		jtA.append("\n" + n + "by" + n + "행렬 계산");
		inputarr = new int[n][n];
		System.out.println(" ");
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int rand = (int)((Math.random()*10000)%5);
				inputarr[i][j] = rand;
			}
		}
		jtA.append("\n");
		printMatrix(inputarr, n);
		integralMatrix(inputarr, n);
	}
	
	void integralMatrix(int[][] arr, int size)
	{
		int copyarr[][] = new int[size][size];
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				copyarr[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				sum = 0;
				for (int a = 0; a < i + 1; a++) 
				{
					for (int b = 0; b < j + 1; b++)
					{
						sum += copyarr[a][b];
					}
				}
				arr[i][j] = sum;
			}
		}
		jtA.append("\n");

		printMatrix(arr, size);
	}
	
	void printMatrix(int[][] arr, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				jtA.append(Integer.toString(arr[i][j]) + " ");
			}
			jtA.append("\n");
		}
	}
	
	public p2()
	{
		setTitle("IntegImage 알고리즘");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new BorderLayout());
		
		up.add(new JLabel("정방행렬의 크기를 입력해주세요."));
		
		up.add(jtf);
		down.add(jsp);
		
		c.add(up, BorderLayout.NORTH);
		c.add(down, BorderLayout.CENTER);
		
		jtf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JTextField t = (JTextField)e.getSource();
				String text = t.getText();
				n = Integer.parseInt(text);
				t.setText("");
				if (flag == true)
				{
					jtA.append("계산 예제\n");
					printMatrix(exarr, 4);
					integralMatrix(exarr, 4);
					flag = false;
				}
				makeMatrix(n);
			}});
		
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new p2();
	}
}
