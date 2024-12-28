Objective:
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  This project is a web-based application designed to manage bank-related operations, including managing customer details, account information, and transactions. Here’s a    
  detailed breakdown of the project.
        > Administrators or bank staff can register customers.
        > Each customer can have multiple accounts (e.g., savings, current).
        > Transactions (like deposits and withdrawals) can be tracked.
        > Data is managed in a structured and efficient way using Hibernate and MySQL.
        
Technologies Used:
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        1. Java Servlets: To handle HTTP requests and responses.
        2. Hibernate ORM: For mapping Java objects to database tables and managing database operations.
        3. MySQL: To store and retrieve data efficiently.
        4. JSP (Java Server Pages): For creating user interfaces.
        5. Apache Tomcat: As the server to deploy the application.
        
Features:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1.Customer Management:
      > Add new customers with details such as name, email, phone, and address.
      > Fetch and display a list of all customers.
2.Account Management:
      > Add multiple accounts for a customer (e.g., savings, current).
      > View account balances and types.
3.Transaction Management:
      > Record transactions (deposits, withdrawals).
      > Track transaction history for accounts.
4.Database Integration:
      > All data (customers, accounts, transactions) is stored in a MySQL database.
      > Hibernate manages the interaction between Java objects and database tables.
      
How the System Works:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1.Customer Registration:
      > A form in registerCustomer.jsp collects customer details.
      > This data is sent to the CustomerServlet via an HTTP POST request.
      > The servlet calls the CustomerService, which in turn uses CustomerDAO to save the data in the Customer table using Hibernate.
2.Account Management:
      > Similar to customer registration, accounts are added by sending data to a servlet that interacts with AccountDAO to save account details in the Account table.
3.Transaction Management:
      > Transactions like deposits and withdrawals are recorded via a servlet.
      > The servlet adds entries to the Transaction table with details like amount, type (deposit/withdrawal), and timestamp.
4.Viewing Data:
      > A servlet retrieves data from the database using Hibernate (e.g., list of customers) and forwards it to a JSP page to be displayed.
      Deployment
      
Run on Tomcat:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     > Deploy the application WAR file on Apache Tomcat.
     > Access it via http://localhost:8080/BankManagementSystem.
Testing:
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Register customers and verify entries in the database.
Add accounts and perform transactions.

