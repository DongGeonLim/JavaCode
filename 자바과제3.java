package hibbangaru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class p3 extends JFrame
{
	JPanel up = new JPanel();
	JPanel down = new JPanel();
	boolean flag;
	
	JButton nameSearchButton = new JButton("검색");
	JTextField nameSearchField = new JTextField();
	JLabel nameSearchLabel = new JLabel("이름 검색 결과:");
	JButton numSearchButton = new JButton("검색");
	JTextField numSearchField = new JTextField("");
	JLabel numSearchLabel = new JLabel("학번 검색 결과:");
	JButton addInfoButton = new JButton("학생 추가");
	JTextField addInfoNameField = new JTextField();
	JTextField addInfonNumField = new JTextField();	
	JTextField addInfoIdxField = new JTextField();
	JButton numSortButton = new JButton("학번 정렬"); 
	JButton nameSortButton = new JButton("이름 정렬"); 
	JTextArea stuListArea = new JTextArea();
	
	LinkedList<StudentInfo> stuList = new LinkedList<StudentInfo>(); 
	
	void searchStudentwithName(String name) 
	{
		for (int i = 0; i < stuList.size(); i++)
		{ 
			if (stuList.get(i).name.equals(name))
			{
				nameSearchLabel.setText(i+1 + "번째에 있음");
			}
			else
			{
				nameSearchLabel.setText("존재하지 않음");
			}
		}
	}
	
	void searchStudentwithNum(int n) 
	{
		for (int i = 0; i < stuList.size() ; i++)
		{ 
			if (stuList.get(i).num == n)
			{
				numSearchLabel.setText(i+1 + "번째에 있음"); 
			}
			else
			{
				numSearchLabel.setText("존재하지 않음");
			}
		}
	}
	
	void addStudent(String name, int num, int idx) 
	{
		stuList.add(idx, new StudentInfo(name, num));
	}
	
	void sortstuList(boolean flag) 
	{
		if (!flag) 
		{
			Collections.sort(stuList, new Comparator<StudentInfo>()
			{ 
				public int compare(StudentInfo o1, StudentInfo o2)
				{
					return (o1.num > o2.num) ? 1 : -1; 
				}
			}); 
		}
		else if (flag) 
		{
			Collections.sort(stuList, new Comparator<StudentInfo>()
			{ 
				public int compare(StudentInfo o1, StudentInfo o2)
				{
					return (o1.name.compareTo(o2.name)>=0) ? 1 : -1; 
				}
			}); 
		}
	}
	
	void showStudentInfo() 
	{
		String t = new String();
		for (StudentInfo studentInfo : stuList)
		{
			t += studentInfo.name + "\t" + Integer.toString(studentInfo.num) + "\n";
		}
		stuListArea.setText(t);
	}
	
	public p3()
	{
		setTitle("학생 정보 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); 
		up.setLayout(new GridLayout(4, 2));
		down.setLayout(new GridLayout(1, 2));
		JLabel jl;

		jl = new JLabel("이름 검색");
		jl.setSize(100,20);
		up.add(jl);
		
		nameSearchField.setSize(120,20);
		up.add(nameSearchField);
		
		nameSearchButton.setSize(60,20);
		up.add(nameSearchButton);
		
		nameSearchLabel.setSize(120,20);
		up.add(nameSearchLabel);
		
		jl = new JLabel("학번 검색"); 
		jl.setSize(100,20);
		up.add(jl);
		
		numSearchField.setSize(120,20);
		up.add(numSearchField);
		
		numSearchButton.setSize(60,20);
		up.add(numSearchButton);
		
		numSearchLabel.setSize(120,20);
		up.add(numSearchLabel);
		
		jl = new JLabel("이름, 학번, 인덱스");
		jl.setSize(120,20);
		up.add(jl);

		addInfoNameField.setSize(60,20);
		up.add(addInfoNameField);

		addInfonNumField.setSize(80,20);
		up.add(addInfonNumField);
		
		addInfoIdxField.setSize(60,20);
		up.add(addInfoIdxField);
		
		addInfoButton.setSize(120,20);
		up.add(addInfoButton);
		
		nameSortButton.setSize(120,20);
		up.add(nameSortButton);
		
		numSortButton.setSize(120,20);
		up.add(numSortButton);

		jl = new JLabel("학생 리스트");
		jl.setSize(200,20);
		down.add(jl);
		
		stuListArea.setSize(200, 200);
		down.add(stuListArea);
		
		numSearchButton.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{
				searchStudentwithNum(Integer.valueOf(numSearchField.getText()));
			} 
		});

		nameSearchButton.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{
				searchStudentwithName(nameSearchField.getText()); 
			}
		});

		addInfoButton.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{
				addStudent(addInfoNameField.getText(), Integer.valueOf(addInfonNumField.getText()),
						Integer.valueOf(addInfoIdxField.getText()));
				showStudentInfo(); 
			} 
		});
		
		numSortButton.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{
				flag = false;
				sortstuList(flag); 
				showStudentInfo();
			}
		});
		
		nameSortButton.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{
				flag = true;
				sortstuList(flag); 
				showStudentInfo();
			} 
		});
		
		showStudentInfo();
		
		c.add(up, BorderLayout.NORTH);
		c.add(down, BorderLayout.CENTER);
		
		setSize(500, 300); 
		setVisible(true);
	}
	
	public static void main(String[] args)
	{ 
		new p3();
	} 
}

class StudentInfo
{
	public String name;
	public int num;
	
	public StudentInfo(String name, int num)
	{
		this.name = name; 
		this.num = num;
	}
}