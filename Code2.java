import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
class Expense {
 private String description;
 private double amount;
 public Expense(String description, double amount) {
 this.description = description;
 this.amount = amount;
 }
 public String getDescription() {
 return description;
 }
 public double getAmount() {
 return amount;
 }
}
public class ExpenseTracker extends Frame implements ActionListener {
 private static ArrayList<Expense> expenses = new ArrayList<>();
 private static double incomeAmount = 0;
 private static double savedAmount = 0;
 private Label label;
 private Button addIncomeButton;
 private Button addExpenseButton;
 private Button viewAllExpensesButton;
 private Button viewTotalExpensesButton;
 public ExpenseTracker() {
 setLayout(new GridLayout(5, 1));
 Font font = new Font("Arial", Font.BOLD, 16);
 label = new Label("Expense Tracking System", Label.CENTER);
 label.setFont(font);
 add(label);
 addIncomeButton = new Button("Add Income");
 add(addIncomeButton);
 addIncomeButton.addActionListener(this);
 addIncomeButton.setFont(font);
 addIncomeButton.setForeground(Color.BLUE);
 addExpenseButton = new Button("Add Expense");
 add(addExpenseButton);
 addExpenseButton.addActionListener(this);
 addExpenseButton.setFont(font);
 addExpenseButton.setForeground(Color.BLUE);
 viewAllExpensesButton = new Button("View All Expenses");
 add(viewAllExpensesButton);
 viewAllExpensesButton.addActionListener(this);
 viewAllExpensesButton.setFont(font);
 viewAllExpensesButton.setForeground(Color.BLUE);
 viewTotalExpensesButton = new Button("View Total Expenses");
 add(viewTotalExpensesButton);
 viewTotalExpensesButton.addActionListener(this);
 viewTotalExpensesButton.setFont(font);
 viewTotalExpensesButton.setForeground(Color.BLUE);
 setTitle("Expense Tracker");
 setSize(400, 300);
 setVisible(true);
 addWindowListener(new WindowAdapter() {
 public void windowClosing(WindowEvent windowEvent) {
 System.exit(0);
 }
 });
 }
 public void actionPerformed(ActionEvent e) {
 if (e.getSource() == addIncomeButton) {
 addIncome();
 } else if (e.getSource() == addExpenseButton) {
 addExpense();
 } else if (e.getSource() == viewAllExpensesButton) {
 viewAllExpenses();
 } else if (e.getSource() == viewTotalExpensesButton) {
 viewTotalExpenses();
 }
 }
 private void addIncome() {
 Frame f = new Frame();
 f.setLayout(new GridLayout(3, 1));
 Label incomeLabel = new Label("Enter income amount: ");
 TextField incomeField = new TextField(10);
 Label savedLabel = new Label("Enter saved amount: ");
 TextField savedField = new TextField(10);
 Button submitButton = new Button("Submit");
 submitButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 incomeAmount = Double.parseDouble(incomeField.getText());
 savedAmount = Double.parseDouble(savedField.getText());
 System.out.println("Income details added successfully.");
 f.dispose();
 }
 });
 f.add(incomeLabel);
 f.add(incomeField);
 f.add(savedLabel);
 f.add(savedField);
 f.add(submitButton);
 f.setTitle("Add Income");
 f.setSize(300, 150);
 f.setLayout(new FlowLayout());
 f.setVisible(true);
 }
 private void addExpense() {
 if (incomeAmount == 0) {
 System.out.println("Please add income details first.");
 return;
 }
 Frame f = new Frame();
 f.setLayout(new GridLayout(4, 1));
 Label descriptionLabel = new Label("Enter expense description: ");
 TextField descriptionField = new TextField(20);
 Label amountLabel = new Label("Enter expense amount: ");
 TextField amountField = new TextField(10);
 Button submitButton = new Button("Submit");
 submitButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 String description = descriptionField.getText();
 double amount = Double.parseDouble(amountField.getText());
 expenses.add(new Expense(description, amount));
 System.out.println("Expense added successfully.");
 f.dispose();
 }
 });
 f.add(descriptionLabel);
 f.add(descriptionField);
 f.add(amountLabel);
 f.add(amountField);
 f.add(submitButton);
 f.setTitle("Add Expense");
 f.setSize(350, 150);
 f.setLayout(new FlowLayout());
 f.setVisible(true);
 }
 private void viewAllExpenses() {
 if (expenses.isEmpty()) {
 System.out.println("No expenses recorded yet.");
 } else {
 System.out.println("All Expenses:");
 for (Expense expense : expenses) {
 System.out.println("Description: " + expense.getDescription() + ", Amount: " +
expense.getAmount());
 }
 }
 }
 private void viewTotalExpenses() {
 if (incomeAmount == 0) {
 System.out.println("Please add income details first.");
 return;
 }
 double totalExpenses = 0;
 for (Expense expense : expenses) {
 totalExpenses += expense.getAmount();
 }
 double remainingAmount = incomeAmount - savedAmount - totalExpenses;
 System.out.println("\nTotal Expenses: " + totalExpenses);
 System.out.println("Remaining Amount: " + remainingAmount);
 }
 public static void main(String[] args) {
 new ExpenseTracker();
 }
}
