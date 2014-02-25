import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SimpleCalculator {
	
    JTextArea calcDisplay;
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    String[] buttons = {"7", "8", "9", "/", 
    					   "4", "5", "6", "*",
    					   "1", "2", "3", "-",
    					   "0", "C", "=", "+"};
    
    public int firstNumber = 0;
	public int secondNumber = 0;
	public int answer = 0;
	public String operator = "";
	
    
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
    	
    	for(int i=0; i<buttons.length; i++){
    		JButton button = new JButton(buttons[i]);
    		buttonList.add(button);
    		button.addActionListener(new MyButtonListener());
    		panel.add(button);
    	}
    	
		frame.getContentPane().add(background);
    	frame.setSize(250,400);
    	frame.setResizable(false);
    	frame.setVisible(true);
    }
    class MyButtonListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e){ // there's gotta be a better way to do this
    		
    		Object source = e.getSource();
    		
    		if (source == buttonList.get(0)){
    			calcDisplay.append("7");
    		} else if (source == buttonList.get(1)){
    			calcDisplay.append("8");
    		} else if (source == buttonList.get(2)){
    			calcDisplay.append("9");
    		} else if (source == buttonList.get(3)){ // divide
    			operator = "/";
    			firstNumber = Integer.parseInt(calcDisplay.getText());
    			calcDisplay.setText("");
    		} else if (source == buttonList.get(4)){
    			calcDisplay.append("4");
    		} else if (source == buttonList.get(5)){
    			calcDisplay.append("5");
    		} else if (source == buttonList.get(6)){
    			calcDisplay.append("6");
    		} else if (source == buttonList.get(7)){ // multiply
    			firstNumber = Integer.parseInt(calcDisplay.getText());
    			operator = "*";
    			calcDisplay.setText("");
    		} else if (source == buttonList.get(8)){
    			calcDisplay.append("1");
    		} else if (source == buttonList.get(9)){
    			calcDisplay.append("2");
    		} else if (source == buttonList.get(10)){
    			calcDisplay.append("3");
    		} else if (source == buttonList.get(11)){ // subtract
    			firstNumber = Integer.parseInt(calcDisplay.getText());
    			operator = "-";
    			calcDisplay.setText("");
    		} else if (source == buttonList.get(12)){
    			calcDisplay.append("0");
    		} else if (source == buttonList.get(13)){ // clear
    			firstNumber = 0;
    			secondNumber = 0;
    			answer = 0;
    			operator = "";
    			calcDisplay.setText("");
    		} else if (source == buttonList.get(14)){ // equals
    			secondNumber = Integer.parseInt(calcDisplay.getText());
    			if (operator == "/"){
    				answer = firstNumber/secondNumber;
    				calcDisplay.setText(String.valueOf(answer));
    			} else if (operator == "*"){
    				answer = firstNumber*secondNumber;
    				calcDisplay.setText(String.valueOf(answer));
    			} else if (operator == "-"){
    				answer = firstNumber-secondNumber;
    				calcDisplay.setText(String.valueOf(answer));
    			} else if (operator == "+"){
    				answer = firstNumber+secondNumber;
    				calcDisplay.setText(String.valueOf(answer));
    			}
    			
    		} else if (source == buttonList.get(15)){ // add
    			firstNumber = Integer.parseInt(calcDisplay.getText());
    			operator = "+";
    			calcDisplay.setText("");
    		}
    	}
    }
}