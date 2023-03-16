

package educationalGame;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Quiz implements ActionListener{

	String[] questions = 	{
								"Which company created Java?",
								"Which year was Java created?",
								
							};
	String[][] options = 	{
								{"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
								{"1989","1996","1972","1492"},
								{"Apple","Latte","Oak","Koffing"},
								{"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"}
							};
	char[] answers = 		{
								'A',
								'B',
								'C',
								'C'
							};
	char guess;
	char answer;
	int index;
	int correct_guesses =0;
	int total_questions = questions.length;
	int result;
	int seconds=30;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
    JButton jButton1= new JButton();
    JButton jButton2 = new JButton();
    JButton start = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel seconds_left  = new JLabel();
    JPanel panel = new JPanel();
    JTextArea quoteLabel = new JTextArea();
    private static final String API_URL = "https://zenquotes.io/api/random";
    JPanel start_p = new JPanel();
    JTextField label_p = new JTextField();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	JPanel opinion_p = new JPanel();
	JPanel container = new JPanel();
	JLabel line1_l = new JLabel();
	JLabel line2_l = new JLabel();
	JPanel image_p = new JPanel();
	
	JPanel buttons_container = new JPanel();
	JButton Other_b = new JButton("Other");
	JButton PlayAgain_b = new JButton("PlayAgain");
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(950,650);
		frame.getContentPane().setBackground(new Color(255,255,255));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,950,70);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(255,255,102));
		textfield.setFont(new Font("",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,70,950,100);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(225,255,102));
		textarea.setForeground(new Color(25,25,25));
		textarea.setFont(new Font("",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,170,100,100);
		buttonA.setFont(new Font("",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,270,100,100);
		buttonB.setFont(new Font("",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,370,100,100);
		buttonC.setFont(new Font("",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,470,100,100);
		buttonD.setFont(new Font("",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,170,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("",Font.PLAIN,35));
		
		answer_labelB.setBounds(125,270,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("",Font.PLAIN,35));
		
		answer_labelC.setBounds(125,370,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("",Font.PLAIN,35));
		
		answer_labelD.setBounds(125,470,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("",Font.PLAIN,35));
		
		seconds_left.setBounds(835,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		
		
		number_right.setBounds(380,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(380,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		jButton1.setBounds(330,470,300,100);
		jButton1.setBackground(new Color(25,255,0));
        jButton1.setFont(new java.awt.Font("Snap ITC", 0, 17)); // NOI18N
        jButton1.setText("Teatcher Opinions ");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        
        quoteLabel.setBounds(0,150,950,200);
        quoteLabel.setBackground(new Color(50,50,50));
        quoteLabel.setForeground(new Color(25,255,50));
        quoteLabel.setFont(new Font("",Font.PLAIN,30));
        quoteLabel.setLineWrap(true);  
        quoteLabel.setWrapStyleWord(true);
        
        
        jButton2.setBounds(330,370,300,100);
        jButton2.setBackground(new Color(25,20,0));
        jButton2.setFont(new java.awt.Font("Snap ITC", 0, 17)); // NOI18N
        jButton2.setText("See what you can do ! ");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        
        opinion_p.setForeground(new Color(100,255,50));
        opinion_p.setBackground(new Color(255,255,51));
        opinion_p.setLayout(new GridLayout(2,1));
        
        container.add(opinion_p);
        container.setBounds(15,150,900,130);
        container.setBackground(new Color(255,255,51));
        
        
        
        
        line1_l.setBounds(0, 20,600,50);
        line1_l.setForeground(new Color(100,255,50));
        line1_l.setFont(new Font("Stencil", 0, 25));
        //set space between labels
       
        line2_l.setBounds(20, 20,600,50);
        line2_l.setForeground(new Color(100,255,50));
        line2_l.setFont(new Font("Stencil", 0, 25));

        opinion_p.add(line2_l);
        opinion_p.add(line1_l);

        
        label_p.setBounds(265,160,450,100);
		label_p.setBackground(new Color(25,25,25));
		label_p.setText("Game Educative");
		label_p.setForeground(new Color(255,255,0));
        label_p.setFont(new Font("Snap ITC", 0, 40)); // NOI18N
		label_p.setBorder(BorderFactory.createBevelBorder(1));
		label_p.setHorizontalAlignment(JTextField.CENTER);
		label_p.setEditable(false);
        
        start.setBounds(330,470,300,100);
		start.setBackground(new Color(25,25,25));
		start.setForeground(new Color(255,255,0));

        start.setFont(new java.awt.Font("Snap ITC", 0, 20)); // NOI18N
        start.setText("Start ");
        start.setBorder(new javax.swing.border.MatteBorder(null));
        
       
   
       
		
      
        frame.getContentPane().setBackground(new Color(25,25,25));
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.add(label_p);
		frame.add(start);
		
		frame.setVisible(true);
		seconds_left.setVisible(false);
		answer_labelA.setVisible(false);
		answer_labelB.setVisible(false);
		answer_labelC.setVisible(false);
		answer_labelD.setVisible(false);
		buttonA.setVisible(false);
		buttonB.setVisible(false);
		buttonC.setVisible(false);
		buttonD.setVisible(false);
		textarea.setVisible(false);
		textfield.setVisible(false);
		textarea.setVisible(false);
		start.setVisible(true);
		label_p.setVisible(true);
		timer.stop();
		

		


		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					if(e.getSource()==start) {
						timer.start();
						seconds_left.setVisible(true);
						answer_labelA.setVisible(true);
						answer_labelB.setVisible(true);
						answer_labelC.setVisible(true);
						answer_labelD.setVisible(true);
						buttonA.setVisible(true);
						buttonB.setVisible(true);
						buttonC.setVisible(true);
						buttonD.setVisible(true);
						textarea.setVisible(true);
						textfield.setVisible(true);
						textarea.setVisible(true);
						start.setVisible(false);
						start_p.setVisible(false);
						label_p.setVisible(false);
						nextQuestion();
					}
			}
			
		});
		
		
	}
	public void nextQuestion() {
		
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds=30;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
    private static String fetchRandomQuote() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        // Extract the quote from the JSON response
        String jsonString = response.toString();
        int start = jsonString.indexOf("q\":") + 4;
        int end = jsonString.indexOf("\",\"a\":");
        return jsonString.substring(start, end);
    }
	public void results(){
		
		buttonA.setVisible(false);
		buttonB.setVisible(false);
		buttonC.setVisible(false);
		buttonD.setVisible(false);
		textarea.setVisible(false);
		seconds_left.setVisible(false);
		jButton1.setVisible(true);
		textfield.setBounds(0,0,950,100);;
		
		
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		frame.add(jButton1);
		jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jButton1) {
                	 String quote = null;
					try {
						quote = fetchRandomQuote();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                     quoteLabel.setText(quote);
                     frame.add(quoteLabel);
                     frame.add(jButton2);
                     percentage.setVisible(false);
                     number_right.setVisible(false);
                     textfield.setText("QUOTES");
                     quoteLabel.setVisible(true);
                     jButton2.setVisible(true);
                     
                     jButton2.addActionListener(new ActionListener() {
                    	 
						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getSource()==jButton2) {
								textfield.setText("Some Shcools and Universities");
								quoteLabel.setVisible(false);
								jButton1.setVisible(false);
								jButton2.setVisible(false);
								container.add(opinion_p);
								frame.add(container);
								image_p.setVisible(true);
								frame.add(image_p);
								opinion_p.setVisible(true);
							}
						}
                    	 
                     });
                	if(result<50) {
                		line1_l.setText("Your score is low but don't worry you still have");
                		line2_l.setText("chance to integrate some shools and university like");
                		line1_l.setVisible(true);
                		line2_l.setVisible(true);
                        container.setBounds(15,150,900,90);
                        
                	}else if(result==50) {
                		line2_l.setText("You are close let see what you can do");
                		line2_l.setVisible(true);
                        container.setBounds(15,150,900,40);

                	}else if(result>50) {
                		line2_l.setText("You are very good ");
                		line2_l.setVisible(true);
                        container.setBounds(15,150,900,40);

                	}
                }
            }
        });

	}
	
public static void main(String[] args) {
		
		Quiz quiz = new Quiz();
	}
}