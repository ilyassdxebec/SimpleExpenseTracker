💰 Expense Tracker (Java)

A simple command-line Expense Tracker built in Java that allows users to add, view, and manage their expenses efficiently.

📦 Features

➕ Add new expenses

🗂️ View all recorded expenses

🧾 Save and load data using JSON files

🏷️ Each expense includes a description, amount, and category

🧠 Technologies Used

Java 17+

Jackson (for JSON parsing)

⚙️ How to Run

Clone the repository

git clone https://github.com/your-username/expense-tracker.git
cd expense-tracker


Compile and run

javac -d out -cp "libs/*" src/org/example/Main.java
java -cp "out;libs/*" org.example.Main

📁 Project Structure
org/example/
 ├── Main.java
 ├── Expense.java
 ├── ExpenseManager.java
 ├── data/expenses.json

📈 Future Improvements

Add expense categories and filtering

Include a simple GUI

Add statistics (monthly totals, charts, etc.)

🧑‍💻 Author

ilyass — Computer Science student passionate about backend development.
this project idea is from roadmap.sh: https://roadmap.sh/projects/expense-tracker
