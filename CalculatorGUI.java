import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CalculatorGUI is a simple Swing-based calculator application that allows
 * users to perform basic arithmetic operations (addition, subtraction,
 * multiplication, and division) on two input numbers.
 */
public class CalculatorGUI extends JFrame implements ActionListener {

    /** Text field for the first input number */
    private JTextField num1Field;

    /** Text field for the second input number */
    private JTextField num2Field;

    /** Text field for displaying the result of the calculation */
    private JTextField resultField;

    /**
     * Constructs a new CalculatorGUI with the necessary components and sets up the frame.
     */
    public CalculatorGUI() {
        // Set up the frame
        setTitle("Calculator GUI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        JLabel resultLabel = new JLabel("Result:");

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");

        // Set layout
        setLayout(new GridLayout(5, 2, 5, 5));

        // Add components to the frame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        // Add action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
    }

    /**
     * Performs the arithmetic operation based on the button clicked and updates the result field.
     *
     * @param e The ActionEvent representing the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get input values
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());

        // Perform calculations based on the button clicked
        double result = 0;
        switch (e.getActionCommand()) {
            case "Add":
                result = num1 + num2;
                break;
            case "Subtract":
                result = num1 - num2;
                break;
            case "Multiply":
                result = num1 * num2;
                break;
            case "Divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
        }

        // Display the result
        resultField.setText(String.valueOf(result));
    }

    /**
     * Main method to launch the CalculatorGUI application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculatorGUI = new CalculatorGUI();
            calculatorGUI.setVisible(true);
        });
    }
}