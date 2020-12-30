import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {

Scanner input = new Scanner(System.in);
Socket connection;
ObjectOutputStream out;
ObjectInputStream in;
String message;
String option;
String response = "";
try {
connection = new Socket("127.0.0.1", 25000);
out = new ObjectOutputStream(connection.getOutputStream());
in = new ObjectInputStream(connection.getInputStream());
do {

out.writeObject("SendMenu");
out.flush();

message = (String) in.readObject();
System.out.println(message);
option = input.nextLine();
out.writeObject(option);
out.flush();

if (option.equalsIgnoreCase("1")) {	
message = (String) in.readObject();
System.out.println(message);

message = input.nextLine();
out.writeObject(message);
out.flush();

message = input.nextLine();
out.writeObject(message);
out.flush();
response = (String) in.readObject();
System.out.println(response);

} else if (option.equalsIgnoreCase("2")) {

message = (String) in.readObject();
System.out.println(message);

message = input.nextLine();
out.writeObject(message);
out.flush();

message = input.nextLine();
out.writeObject(message);
out.flush();

message = input.nextLine();
out.writeObject(message);
out.flush();

response = (String) in.readObject();
System.out.println(response);

}
}

while (option.equalsIgnoreCase("2") || response.equalsIgnoreCase("Fail"));
do
{
//	log in menue....			
	
message = (String)in.readObject();
System.out.println(message);
response = input.nextLine();
out.writeObject(response);
out.flush();
if(response.equalsIgnoreCase("1"))
{
message = (String)in.readObject();
System.out.println(message);

//First put your first name;
response = input.nextLine();
out.writeObject(response);
out.flush();

//second add last name;
response = input.nextLine();
out.writeObject(response);
out.flush();
//receiving the answer
message = (String)in.readObject();
System.out.println(message);
}
else if(response.equalsIgnoreCase("2"))
{
message = (String)in.readObject();
System.out.println(message);
//num1
//response = input.nextLine();
//out.writeObject(response);
//out.flush();
//Enter company's name;
response = input.nextLine();
out.writeObject(response);
out.flush();
//Enter company's registration number
response = input.nextLine();
out.writeObject(response);
out.flush();
//receiving the answer
message = (String)in.readObject();
System.out.println(message);
}
else if(response.equalsIgnoreCase("3"))
{
message = (String)in.readObject();
System.out.println(message);

//Enter Email address
response = input.nextLine();
out.writeObject(response);
out.flush();
//receiving the answer
message = (String)in.readObject();
System.out.println(message);
}
message = (String)in.readObject();
System.out.println(message);
response = input.nextLine();
out.writeObject(response);
out.flush();
}while(response.equalsIgnoreCase("1"));
in.close();
out.close();
connection.close();
}

catch (Exception e) {

}

}
}
