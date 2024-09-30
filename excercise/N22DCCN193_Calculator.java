import java.util.*;
import java.awt.*;
import javax.swing.*;

public class N22DCCN193_Calculator {
	public static void main(String []args){
		Caculator frame = new Caculator();
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setVisible(true);
	}
}


/*
 * Bieu thuc toan hoc duoc luu duoi dang trung to "(a+b)*c + d*f"
 * Tinh gia tri bieu thuc:
 * 	- chuyen ve dang hau to:  a b + c * d f * +
 * 	- dung stack tinh gia tri
 * 
 */
// class Expression {
// 	private static final char add = '+';
// 	private static final char sub = '-';
// 	private static final char mul = '*';
// 	private static final char div = '/';

// 	public static boolean check(String s){
// 		return true;
// 	}

// 	private String expression;

// 	public Expression(){
// 		expression = "";
// 	}

// 	public setExpression(String expression){
// 		this.expression = expression;
// 	}

	

// 	public double calculate(){
// 		return 1;
// 	}

// 	private String convertRPN(){
// 		return String("");
// 	}
// }

/*
 * UI:
 * 
 * (a*b) + c
 * 			<answer>
 * 7 8 9 + -
 * 4 5 6 x /
 * 1 2 3 ( )
 * 0 . = 
 */
class Caculator extends JFrame{
	private String expression;
	//private Expression expression;
	private JButton []numberButton = new JButton[10];
	private JPanel buttonPanel;
	public Caculator(){
		expression = "";
		setup();

		buttonPanel = new JPanel();
		for(int i = 0; i <= 9; i++){
			numberButton[i] = new JButton(String.valueOf(i));
			buttonPanel.add(numberButton[i]);
		}

		numberButton[0].addActionListener(event -> {
			expression += '0';
			System.out.println(expression);
		});

		numberButton[1].addActionListener(event -> {
			expression += '1';
			System.out.println(expression);
		});
		numberButton[2].addActionListener(event -> {
			expression += '2';
			System.out.println(expression);
		});
		numberButton[3].addActionListener(event -> {
			expression += '3';
			System.out.println(expression);
		});
		numberButton[4].addActionListener(event -> {
			expression += '4';
			System.out.println(expression);
		});
		numberButton[5].addActionListener(event -> {
			expression += '5';
			System.out.println(expression);
		});
		numberButton[6].addActionListener(event -> {
			expression += '6';
			System.out.println(expression);
		});
		numberButton[7].addActionListener(event -> {
			expression += '7';
			System.out.println(expression);
		});

		numberButton[8].addActionListener(event -> {
			expression += '8';
			System.out.println(expression);
		});

		numberButton[9].addActionListener(event -> {
			expression += '9';
			System.out.println(expression);
		});

		

		add(buttonPanel);

	}

	private void setup(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		setLocationByPlatform(true);
		setTitle("TuLe's calculator");

		


	}
}
