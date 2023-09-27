// Number Guessing Game
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
// Code by varunbalaji
class NumberGuessingGame extends Frame implements ActionListener
{
    int numberToGuess;
    int remainingAttempts = 5;
    Label lbl,result,points;
    TextField textField;
    NumberGuessingGame()
    {
        //Window Code
        setTitle("Number Guessing Game");
        setSize(400, 350);
        setLayout(null);
        setVisible(true);
        Color formColor = new Color(255,255,204);
        setBackground(formColor);

        // Close the window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        }); 

        // Label
        Font labelFont = new Font("ariel",Font.BOLD, 15);
        lbl = new Label(" -- Enter a number between 1 to 100 -- ");
        lbl.setBounds(40,50,350,50);
        lbl.setFont(labelFont);
        lbl.setForeground(Color.RED);
        add(lbl);

        // Textfield
        textField = new TextField(10);
        textField.setBounds(100, 100, 150, 30);
        add(textField);

        //Button 
        Button guessButton = new Button("Guess");
        guessButton.setBounds(100, 150, 150, 30);
        guessButton.setBackground(Color.BLUE);
        guessButton.setFont(labelFont);
        add(guessButton);

        //points
        points = new Label("Points: ");
        points.setBounds(30,250,100,30);
        points.setFont(labelFont);
        points.setForeground(Color.BLACK);
        add(points);

        // Result 
        result = new Label("");
        result.setBounds(30,200,350,50);
        result.setFont(labelFont);
        result.setForeground(Color.BLACK);
        add(result);

        //Random number
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;

        // Generating number between 1 to 100
        guessButton.addActionListener(new ActionListener()
        {   
           public void actionPerformed(ActionEvent e) 
           {
            if (remainingAttempts <= 0) {
                    result.setText("Out of attempts. The number was " + numberToGuess);
                    textField.setText("");
                    textField.setEnabled(false);
                    guessButton.setEnabled(false);
             }
             else
             {
                try {
                    int input = Integer.parseInt(textField.getText());
                    if (input == numberToGuess) 
                    {
                        result.setText("Congratulations! You guessed the number.");
                        calculatePoints(remainingAttempts, points);
                        textField.setText("");
                        remainingAttempts-=1;
                    } 
                    else if (input < numberToGuess) 
                    {
                        result.setText("Your guess is too low.");
                        textField.setText("");
                        remainingAttempts-=1;

                    } 
                    else 
                    {
                        result.setText("Your guess is too high.");
                        textField.setText("");
                        remainingAttempts-=1;
                    }
                     if (remainingAttempts == 0) 
                    {
                        result.setText("Out of attempts. The number was " + numberToGuess);
                        textField.setText("");
                        textField.setEnabled(false);
                        guessButton.setEnabled(false);
                        calculatePoints(remainingAttempts, points);
                    }
                } 
                catch (NumberFormatException ex) 
                {
                    result.setText("Invalid input. Please enter a valid number.");
                }
             }
            }
        }); 
    }
    // Method to Calculate points
    public int calculatePoints(int remainingAttempts,Label point) {
    int maxAttempts = 5; 
    int maxPoints = 100; 
    int points = (int) (((double) remainingAttempts / maxAttempts) * maxPoints);
    point.setText("Points: " + Integer.toString(points));
    return points;
}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}   
public class Main
{ 
public static void main(String[] args) 
    {
        NumberGuessingGame game = new NumberGuessingGame();
        System.out.println(game.numberToGuess);
    }
}