Wawa-Software-Engineering
=========================

Wawa Nutritional Planner

Set up in the following manner:
 - Languages have their dedicated folder to focus on each modular component.
 - Server Folder contains instructions on setting up the server, will eventually contain necessary files
   for Glassfish, MySQL, and ObjectDB in respective directories. Should eventually be possible 
   to transfer files to right folder under root. 
 - Website folder will contain the files necessary to host the website. 
 
 
 Server set up information:
 Method 1:
  - Follow instructions on the link provided 
  - Modification include
	- Glassfish version 3.1.2 released
	- MySQL version 5.5
	- MySQL-connector-java-5.1.22.zip
 
 Method 2 (using included bash):
  - Open up two terminals (one will run intilaze script, the other requires more user interaction)
  - Open the website link provided 
  
  Terminal 1:
  - Copy files in server folder into home directory under Ubuntu
  - Set chmod 755 to initalize file.
  - Run sudo ./initalize
  - This should create a Glassfish environment
  
  - Requires set up of MySQL
  - Requires the commenting out of #bind-address = 127.0.0.1 in the /etc/mysql/my.cnf file

  - Requires the creation of glassfish user with "glassfish" password (make sure password works)
  - Requires the creation of the two JDBC Connection Pools (MySQLDataSource, MySQLDataSource)
    - Set up properties can be found in link
  