/*
 * @author N22DCCN193 Le Ngoc Tu 
 * Chuong trinh Calculator co chuc nang:
 * 		- Nhap bieu thuc(tu button tren man hinh hoac dung ban phim)
 * 		- Tinh gia tri bieu thuc theo do uu tien cac toan tu)
 * 
 * Doi voi bieu thuc nhap vao chuong trinh nhan "-" la dau tru, khong 
 * nhan "-" la dau am VD: "3 + -2" duoc xem la bieu thuc khong hop le 
 * 
 * Bieu thuc nhap vao luon duoc tu dong chen ky tu " " de phan biet cac 
 * gia tri va cac toan tu 
 * 
 * Thuat toan:
 * 		- Nhan bieu thuc dang trung to "( a + b ) * c"
 * 		- Kiem tra bieu thuc co hop le hay khong
 * 		- Chuyen bieu thuc sang dang hau to "a b + c *" va tinh gia tri
 * 		- Hai ngoai le phat sinh:
 * 				- Bieu thuc khong hop le throw IllegalArgumentException (Expression.convertInfixToPostfix)
 * 				- Chia mot so cho 0 throw , ArithmeticException (Expression.Operator.calculate)
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class N22DCCN193_Calculator {
	public static void main(String []args){
		Calculator mycalc = new Calculator();
		mycalc.setVisible(true);
	}
}

class Calculator extends JFrame{
	private JPanel buttonPanel;	// phim bam

	private String expression;		// Luu bieu thuc can tinh
	private JPanel screenPanel; 	// hien thi bieu thuc, ket qua tinh toan
	private JLabel outAns;
	private JLabel outExpression;


	public Calculator(){
		expression = "";
		initWindow();
		initButtonPanel();
		initScreenPanel();	

		this.setLayout(new GridLayout(2, 1));
		this.add(screenPanel);
		this.add(buttonPanel);

		// add keyListener
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String key = String.valueOf(e.getKeyChar());
				switch (e.getKeyChar()){
					case '0': case '1' : case '2': case '3': case '4': 
					case '5': case '6' : case '7': case '8': case '9': 
					case '.':
						expression +=  key;
						outExpression.setText(expression);
						outAns.setText("");
						break;

					case '+': case '-' : case '*': case '/': 
					case '(': case ')' : 
						expression += " " + key + " ";
						outExpression.setText(expression);
						break;

					case '\n':
						if(expression.compareTo("") != 0){
							try{
								outAns.setText(String.valueOf(Expression.calculate(expression)));
							}
							catch(Exception except ){
								// co 2 TH IllegalArgumentException, ArithmeticException
								// chi in  thong bao nen catch Exception
								outAns.setText(except.getMessage());
							}
						}
						break;

					// Blackspace asscii code = 8
					// Blackspace thay cho DEL, khong co phim tuong ung voi AC(all clear)
					case (char)8:
						if(expression.length() != 0){
							if(expression.substring(expression.length() - 1, expression.length()).compareTo(" ") == 0)
								expression = expression.substring(0, expression.length() - 3);
							else
								expression = expression.substring(0, expression.length() - 1);
							outExpression.setText(expression);
							outAns.setText("");	
						}
						break;
				}
			}
		});
		
	}

	private void initWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
    	Dimension screenSize = kit.getScreenSize();
    	setSize(screenSize.width/3, screenSize.height/3);
    	setLocationByPlatform(true);
    	setTitle("My Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	private void initButtonPanel(){
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 5));

		//DEL: delete; AC: all clear
		JButton calcButton = new JButton("=");
		JButton delButton = new JButton("DEL");
		JButton acButton = new JButton("AC");

		// Tinh gia tri
		calcButton.addActionListener(event ->{
			if(expression.compareTo("") != 0){
				try{
					outAns.setText(String.valueOf(Expression.calculate(expression)));
				}
				catch(Exception e ){
					// co 2 TH IllegalArgumentException, ArithmeticException
					// chi in  thong bao nen catch Exception
					outAns.setText(e.getMessage());
				}
			}
		}); 

		//xoa phan gan nhat vua nhap
		delButton.addActionListener(event->{
			if(expression.length() != 0){
				if(expression.substring(expression.length() - 1, expression.length()).compareTo(" ") == 0)
					expression = expression.substring(0, expression.length() - 3);
				else
					expression = expression.substring(0, expression.length() - 1);
				outExpression.setText(expression);
				outAns.setText("");
				
			}
		});

		//xoa toan bo bieu thuc
		acButton.addActionListener(event->{
			expression = "";
			outExpression.setText(expression);
			outAns.setText("");
		});

		/*	
		 * Cac phim bo tri tren layout grid(4x5)
		 * 7 8 9 DEL AC			0  1  2  3  4
		 * 4 5 6  +   -			5  6  7  8  9
		 * 1 2 3  *   /	   =>	10 11 12 13 14
		 * 0 . =  (   )			15 16 17 18 19 
		 * 
		 * Cac phim + - * / ( ) them khoang trang truoc va sau
		 * de phan cach voi nhau va voi cac gia tri so
		 */
		

		buttonPanel.add(new JButton(new NumberButtonAction("7")), 0);
		buttonPanel.add(new JButton(new NumberButtonAction("8")), 1);
		buttonPanel.add(new JButton(new NumberButtonAction("9")), 2);
		buttonPanel.add(delButton, 3);
		buttonPanel.add(acButton, 4);

		buttonPanel.add(new JButton(new NumberButtonAction("4")), 5);
		buttonPanel.add(new JButton(new NumberButtonAction("5")), 6);
		buttonPanel.add(new JButton(new NumberButtonAction("6")), 7);
		buttonPanel.add(new JButton(new NumberButtonAction(" + ")), 8);
		buttonPanel.add(new JButton(new NumberButtonAction(" - ")), 9);

		buttonPanel.add(new JButton(new NumberButtonAction("1")), 10);
		buttonPanel.add(new JButton(new NumberButtonAction("2")), 11);
		buttonPanel.add(new JButton(new NumberButtonAction("3")), 12);
		buttonPanel.add(new JButton(new NumberButtonAction(" * ")), 13);
		buttonPanel.add(new JButton(new NumberButtonAction(" / ")), 14);

		buttonPanel.add(new JButton(new NumberButtonAction("0")), 15);
		buttonPanel.add(new JButton(new NumberButtonAction(".")), 16);
		buttonPanel.add(calcButton, 17);
		buttonPanel.add(new JButton(new NumberButtonAction(" ( ")), 18);
		buttonPanel.add(new JButton(new NumberButtonAction(" ) ")), 19);
		
		for(int i = 0; i < 20; i++)
			buttonPanel.getComponent(i).setBackground(new Color(207, 245, 255));
		buttonPanel.getComponent(3).setBackground(Color.BLUE);	// DEL
		buttonPanel.getComponent(3).setForeground(Color.WHITE);	// DEL
		
		buttonPanel.getComponent(4).setBackground(Color.BLUE);	// AC
		buttonPanel.getComponent(4).setForeground(Color.WHITE);	// AC
	}

	private void initScreenPanel(){
		screenPanel = new JPanel();
		screenPanel.setLayout(new GridLayout(2, 1));
		outAns = new JLabel();
		outAns.setHorizontalAlignment(JLabel.RIGHT);
		outAns.setVerticalAlignment(JLabel.CENTER);
		outAns.setFont(new Font("Arial", Font.PLAIN, 20));

		outExpression = new JLabel();
		outExpression.setHorizontalAlignment(JLabel.RIGHT);
		outExpression.setVerticalAlignment(JLabel.CENTER);
		outExpression.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		screenPanel.add(outExpression);
		screenPanel.add(outAns);
	}
	
	/*
	 * cac button nhap bieu thuc
	 */
	private class NumberButtonAction extends AbstractAction{
		public NumberButtonAction(String name){
			putValue(Action.NAME, name);
			
		}

		public void actionPerformed(ActionEvent event){
			expression += this.getValue(Action.NAME);
			outExpression.setText(expression);
		}
	}
}



class Expression {
	public static final String LEFT_BRACKET = "(";
	public static final String RIGHT_BRACKET = ")";

	/*
	 * 
	 * @param infixExpression bieu thuc dang trung to
	 * @return gia tri bieu thuc
	 * 
	 * @throws IllegalArgumentException new bieu thuc ko hop le
	 * @throwas ArithmeticException neu bieu thuc ton tai phep chia cho 0
	 */
	public static double calculate(String infixExpression)
					throws IllegalArgumentException, ArithmeticException
	{
		// co the throw IllegalArgumentException neu bieu thuc khong hop le
		String []s = convertInfixToPostfix(infixExpression).split("\\s+"); // "\\s+": 1 hoac nhieu khoang trang lien tiep
		Stack<Double> stack = new Stack<>();

		for(String i : s){
			if(Operator.isOperator(i)){
				double a = stack.pop();
				double b = stack.pop();
				// co the throw ArithmeticException neu thuc hien chia cho 0
				stack.push(Operator.calculate(b, a, i));
			}
			else{
				stack.push(Double.parseDouble(i));
			}
		}
		return stack.pop();
	}


	public static String convertInfixToPostfix(String infixExpression)
						throws IllegalArgumentException 
	{
		if(! isInfixExression(infixExpression))
			throw new IllegalArgumentException ("Bieu thuc khong hop le");
		
		String postfix = " ";
		Stack<String> stack = new Stack<>();
		String []s = infixExpression.trim().split("\\s+");
		for(String i : s){
			switch(i){
				case LEFT_BRACKET:
					stack.push(i);
					break;
				
				case RIGHT_BRACKET:
					while(true){
						if(stack.peek().compareTo(LEFT_BRACKET) == 0){
							stack.pop();
							break;
						}
						else{
							postfix += stack.pop() + " ";
						}
					}
					break;
				
				case Operator.ADD:
				case Operator.SUB:
					while( !stack.isEmpty() && Operator.isOperator(stack.peek())){
						postfix += stack.pop() + " ";
					}

					stack.push(i);
					break;
				
				case Operator.MUL:
				case Operator.DIV:
					while( !stack.isEmpty() &&
						(stack.peek().compareTo(Operator.MUL) == 0 || stack.peek().compareTo(Operator.DIV) == 0))
					{
						postfix += stack.pop() + " ";
					}

					stack.push(i);
					break;
				
				default:
					postfix += i + " ";
			}
		}

		while(! stack.isEmpty())
			postfix += stack.pop() + " ";
		return postfix.trim();	//bo khoang trang dau va cuoi chuoi
	}

	public static boolean isInfixExression(String expression){
		/*Dieu kien:
		 * 		-So toan tu  = so toan hang - 1
		 * 		-count"(" =  count")"
		 */
		int countOperator = 0;	//Dem so toan tu	
		int countOperand = 0;	//Dem so toan hang
		int countLeftBracket = 0;

		String []s = expression.trim().split("\\s+");
		for(String i : s){
			if(Operator.isOperator(i)){
				countOperator ++;
				if(countOperator > countOperand)
					return false;
			}

			else if ( i.compareTo(LEFT_BRACKET) == 0){
				countLeftBracket ++;
			}

			else if(i.compareTo(RIGHT_BRACKET) == 0){
				countLeftBracket -= 1;
				if(countLeftBracket == -1)
					return false;
			}

			else{
				//kiem tra xem i co la so khong
				try{
					Double.parseDouble(i);
				}
				catch(NumberFormatException e){
					return false;
				}

				countOperand ++;
				if(countOperand - countOperator == 2)
					return false;
			}
		}

		// check lai dk (countOperand - countOperator == 1) vi co TH: "1+1+"
		// trong code check operator, khong dung  "if(countOperator >= countOperand) return false" vi TH "2+2", xet toi "2+" return false
		return (countLeftBracket == 0 && (countOperand - countOperator == 1));
	}

	public class Operator{
		public static final String ADD = "+";
		public static final String SUB = "-";
		public static final String MUL = "*";
		public static final String DIV = "/";

		public static boolean isOperator(String s){
			return (s.compareTo(ADD) == 0 ||
					s.compareTo(SUB) == 0 || 
					s.compareTo(MUL) == 0 ||
					s.compareTo(DIV) == 0);
		}

		public static double calculate(double a, double b, String operator) 
						throws IllegalArgumentException, ArithmeticException
		{
			switch(operator){
				case ADD:
					return a + b;
	
				case SUB:
					return a - b;
				
				case MUL:
					return a * b;
				
				case DIV:
					if(b == 0)
						throw new ArithmeticException("Loi: bieu thuc chia cho 0");
					return a/b;
				
				default:
					throw new IllegalArgumentException("Toan tu khong hop le!");	
			}
		}
	}
}
