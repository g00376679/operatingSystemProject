import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread {
	
private Socket conn;
private int id;
ObjectOutputStream out;
ObjectInputStream in;
String message;
String option;
String storedUsers = "default";
String storedPass = "default";
String regid = "default";
String response;
String username;
String password;


// Constructor

public Server(Socket c, int i) {
conn = c;
id = i;
}

public void run() {	
try {
out = new ObjectOutputStream(conn.getOutputStream());
in = new ObjectInputStream(conn.getInputStream());
do {
// now it can send and receive message in client
message = (String) in.readObject();
out.writeObject("Press 1 to login or 2 to register");
out.flush();
option = (String) in.readObject();
if (option.equalsIgnoreCase("1")) {
// log in
out.writeObject("Please type user name and passward");
out.flush();
username = (String) in.readObject();
password = (String) in.readObject();

if (username.equalsIgnoreCase(storedUsers) && password.equalsIgnoreCase(storedPass)) {
response = "ok";
out.writeObject("ok");
out.flush();
} else {
response = "fail";
out.writeObject("Fail");
out.flush();
}

} else if (option.equalsIgnoreCase("2")) {
// Register
out.writeObject("Please type user name and passward");
out.flush();
storedUsers = (String) in.readObject();
storedPass = (String) in.readObject();
regid = (String) in.readObject();

response = "ok";
out.writeObject("ok");
out.flush();

out.writeObject("Fail");
out.flush();
}

} while (option.equalsIgnoreCase("2") || response.equalsIgnoreCase("fail"));
do {
// now logged in
out.writeObject("Press 1 for Name, 2 For Business ID or 3 for Email");
out.flush();

option = (String) in.readObject();
if (option.equalsIgnoreCase("1"))

{

out.writeObject("Please enter Firstname and Lastname");
out.flush();

String firstname = (String) in.readObject();
String lastname = (String) in.readObject();

String name = firstname + lastname;
out.writeObject("" + name);
out.flush();
} else if (option.equalsIgnoreCase("2"))

{
out.writeObject("Please enter Business ID: CompanyName and RegistryNumber");
out.flush();

String CompanyName = (String) in.readObject();
String RegistryNumber= (String) in.readObject();

int businessID = Integer.parseInt(CompanyName) + Integer.parseInt(RegistryNumber);
out.writeObject("" + businessID);
out.flush();
}

else if (option.equalsIgnoreCase("3")) {
out.writeObject("Please enter Email address");
out.flush();

String firstname = (String) in.readObject();
String lastname = (String) in.readObject();
String atgmaildotcom = (String) in.readObject();

int email= Integer.parseInt(firstname) + Integer.parseInt(lastname) +Integer.parseInt(atgmaildotcom);
out.writeObject("" + email);
out.flush();
}

out.writeObject("Press 1 to exit");
out.flush();

option = (String) in.readObject();

} while (option.equalsIgnoreCase("1"));

// finish to login successfully with name, business id and email
in.close();
out.close();
conn.close();

}

catch (Exception e) {

}

}

public static void main(String[] args) {

ServerSocket listener;
Socket connection;
int id = 0;

//registered Server socket
//add the fleet 
//load all the users into arraylist

try {
listener = new ServerSocket(25000, 10);

while (true)

{

System.out.println("Listening for a connection ");

connection = listener.accept();
System.out.println("Received connection from " + connection.getInetAddress());

Server th = new Server(connection, id);
id++;
th.start();
}

}

catch (Exception e) {

}

}
}