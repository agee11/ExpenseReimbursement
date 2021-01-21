# Expense Reimbursement System

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can log in and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used
### Front End
- HTML
- CSS
- JavaScript
- Bootstrap 4
### Middle
- Tomcat 9
- Java
### Back End
- AWS
- PostgreSQL
- JDBC

## Features
* Employees are able to login and create/view reimbursement tickets.
* Managers are able to login and view all tickets.
* Managers are able to filter tickets by status.
* Ticket display is interactive and allows Managers to approve/deny tickets without refreshing the browser.

## To-do list
* Add abilities to register new accounts
* Allow employees to modify/delete existing tickets
* Allows Managers to submit their own tickets.
* Add modal that displays employee reimbursement data (total tickets, total amount reimbursed, etc).
* Allow managers to filter tickets by employee id.

## Getting Started
1) Run `git clone https://github.com/agee11/ExpenseReimbursement.git`
2) Open Spring Tool Suite
3) Import ExpenseReimbursement
4) Navigate to ExpenseReimbursement\src\main\java\com\project1\util\ConnectionFactory
5) Change the connection username, url, and password to your own Postgresql database
6) Run the application on the Tomcat server
