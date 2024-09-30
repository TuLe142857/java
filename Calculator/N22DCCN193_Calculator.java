import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class N22DCCN193_Calculator {
	public static void main(String []args){
		Calculator mycalc = new Calculator();
		// try{
		// 	String expression = "  (   ( 10 + 5 * 2 )  -  ( 3 + 4 / 7 *  ( 1 - 2 )  + 2 * 3 )  * 2 )  * 2";
		// 	System.out.println("\'" + Expression.convertInfixToPostfix(expression) + "\'");
		// 	String []s = (" 1234 567   ").split(" ");//Expression.convertInfixToPostfix(expression).split("\\s+");
		// 	for(String i : s)
		// 		System.out.println("\'" + i + "\'");
		// 	System.out.println(Expression.calculate(expression));
		// }
		// catch (IllegalArgumentException e){
		// 	System.out.println("Error: " + e.getClass().getName() + " " + e.getMessage());
		// }
		// catch (ArithmeticException e){
		// 	System.out.println("Error: " + e.getClass().getName()+ " " + e.getMessage());
		// }
	}
}

/*
			<expression>
					<Answer>

			7 8 9 DEL AC
			4 5 6  +   -
			1 2 3  *   /
			0 . =  (   )
 */

class Calculator extends JFrame{
	private String expression;	// Luu bieu thuc can tin
	private JPanel buttonPandel;
	private JPanel screenPanel; //hien thi bieu thuc, ket qua tinh toan



	public Calculator(){
		expression = "";
		initWindow();
		initButtonPanel();
		initScreenPanel();	
	}

	private void initWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
    	Dimension screenSize = kit.getScreenSize();
    	setSize(screenSize.width/3, screenSize.height*4/5);
    	setLocationByPlatform(true);
    	setTitle("My Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		
	}

	

	/*
	 * 7 8 9 DEL AC
 	 * 4 5 6  +   -
 	 * 1 2 3  *   /
 	 * 0 . =  (   )
	 */
	private void initButtonPanel(){
		buttonPandel = new JPanel();
		
		buttonPandel.setLayout(new GridLayout(4, 5));
		JButton calcButton = new JButton("=");
		JButton delButton = new JButton("DEL");
		JButton acButton = new JButton("AC");

		// Tinh gia tri
		calcButton.addActionListener(event ->{

			if(expression.compareTo("") != 0){
				try{
					System.out.println("CALCULATE");
					double ans = Expression.calculate(expression);
					printAnswer(ans);
					//Print
					System.out.println("ANS :" + ans);
				}
				catch(Exception e ){
					System.out.println("Loi: " + e.getMessage());
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
				System.out.println("Expression: " + expression);
				printExpression();
			}
		});

		//xoa toan bo bieu thuc
		acButton.addActionListener(event->{
			expression = "";
			System.out.println("Expression: " + expression);
			printExpression();
		});

		buttonPandel.add(new JButton(new NumberButtonAction("7")), 0);
		buttonPandel.add(new JButton(new NumberButtonAction("8")), 1);
		buttonPandel.add(new JButton(new NumberButtonAction("9")), 2);
		buttonPandel.add(delButton, 3);
		buttonPandel.add(acButton, 4);

		buttonPandel.add(new JButton(new NumberButtonAction("4")), 5);
		buttonPandel.add(new JButton(new NumberButtonAction("5")), 6);
		buttonPandel.add(new JButton(new NumberButtonAction("6")), 7);
		buttonPandel.add(new JButton(new NumberButtonAction(" + ")), 8);
		buttonPandel.add(new JButton(new NumberButtonAction(" - ")), 9);

		buttonPandel.add(new JButton(new NumberButtonAction("1")), 10);
		buttonPandel.add(new JButton(new NumberButtonAction("2")), 11);
		buttonPandel.add(new JButton(new NumberButtonAction("3")), 12);
		buttonPandel.add(new JButton(new NumberButtonAction(" * ")), 13);
		buttonPandel.add(new JButton(new NumberButtonAction(" / ")), 14);

		buttonPandel.add(new JButton(new NumberButtonAction("0")), 15);
		buttonPandel.add(new JButton(new NumberButtonAction(".")), 16);
		buttonPandel.add(calcButton, 17);
		buttonPandel.add(new JButton(new NumberButtonAction(" ( ")), 18);
		buttonPandel.add(new JButton(new NumberButtonAction(" ) ")), 19);
		
		for(int i = 0; i < 20; i++)
			buttonPandel.getComponent(i).setBackground(new Color(128, 202, 255));
		this.add(buttonPandel, BorderLayout.SOUTH);

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
			System.out.println("Expression: " + expression);
			printExpression();
		}
	}

	private void initScreenPanel(){
		screenPanel = new JPanel();
		
		this.add(screenPanel, BorderLayout.CENTER);

	}


	private void printExpression(){

	}

	private void printAnswer(double ans){

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
