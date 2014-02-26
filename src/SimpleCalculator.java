import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SimpleCalculator {  // need to sort buttons
    JTextArea calcDisplay;
    ArrayList<JButton> numList = new ArrayList<JButton>();
    ArrayList<JButton> opList = new ArrayList<JButton>();
    String[] numbers = {"7","8","9","4","5","6","1","2","3","0"};
    String[] operators = {"/","*","-","+"};
    
    int firstNumber;
    int secondNumber;
    String operator;
    Boolean newProblem = false;
    
    public static void main(String[] args){	
    	SimpleCalculator calc = new SimpleCalculator();
    	calc.gui();
    }
    
    
    public void gui(){
    	JFrame frame = new JFrame("Simple Calculator");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	BorderLayout border = new BorderLayout();
    	JPanel background = new JPanel(border);
    	
    	GridLayout grid = new GridLayout(4,4);
    	JPanel panel = new JPanel(grid);
    	Font newFont = new Font("SansSerfif", Font.PLAIN, 50);
    	calcDisplay = new JTextArea(1,8);
    	calcDisplay.setEditable(false);
    	calcDisplay.setFont(newFont);
    	background.add(BorderLayout.CENTER, panel);
    	background.add(BorderLayout.NORTH, calcDisplay);
    	
    	for(int x=0; x<numbers.length; x++){
    		JButton numButton = new JButton(numbers[x]);
    		numList.add(numButton);
    		numButton.addActionListener(new MyNumberListener());
    		panel.add(numButton);
    	}
    	
    	for(int y=0; y<operators.length; y++){
    		JButton opButton = new JButton(operators[y]);
    		opButton.addActionListener(new MyOperatorListener());
    		opList.add(opButton);
    		panel.add(opButton);
    	}
    	
    	JButton clear = new JButton("C");
    	clear.addActionListener(new MyClearListener());
    	panel.add(clear);
    	JButton equals = new JButton("=");
    	equals.addActionListener(new MyEqualsListener());
    	panel.add(equals);
    	
    	frame.getContentPane().add(background);
    	frame.setSize(250,400);
    	frame.setResizable(false);
    	frame.setVisible(true);
    }
    
    public void clear(){
    		firstNumber = 0;
    		secondNumber = 0;
    		operator = "";
    		newProblem = false;
    		calcDisplay.setText("");
    		
    }
    	
    class MyNumberListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){ 
    		Object source = e.getSource();
    		
    		if (newProblem) {
    			clear();
    		}
    		
    		for(int i=0; i<numbers.length; i++){
    		    if (source == numList.get(i)){
    		    	calcDisplay.append(numbers[i]);
    		    }
			}
    	}
    }
    
    class MyOperatorListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		Object source = e.getSource();
    		newProblem = false; 
    		
    		for(int i=0;i<operators.length; i++){
	    		if (source == opList.get(i)){
    				firstNumber = Integer.parseInt(calcDisplay.getText());
	    			operator = operators[i];
	    			calcDisplay.setText("");
	    		}
    		}
    	}
    }
    
    
    class MyClearListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		clear();
    	}
    }
    
    
    class MyEqualsListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		secondNumber = Integer.parseInt(calcDisplay.getText());
    		newProblem = true;
    		
			if (operator == "/"){
				calcDisplay.setText(String.valueOf(firstNumber/secondNumber));
			} else if (operator == "*"){
				calcDisplay.setText(String.valueOf(firstNumber*secondNumber));
			} else if (operator == "-"){
				calcDisplay.setText(String.valueOf(firstNumber-secondNumber));
			} else if (operator == "+"){
				calcDisplay.setText(String.valueOf(firstNumber+secondNumber));
			}
    	}
    }
}