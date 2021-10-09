import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client{
	
	Gui gui;
    Socket socket;
	DataOutputStream out;
	DataInputStream in;
	
	public Client(String addr, int port){
		try{
			this.socket = new Socket(addr, port); 
		    this.gui = new Gui();
		    this.out = new DataOutputStream(socket.getOutputStream());
		    this.in = new DataInputStream(socket.getInputStream());
		    String name = gui.askUser("Please enter your name. This is the name other users will see when you send a message.");
		    while(true){
			    String msg = gui.askUser();
			    out.writeUTF(name + ": " + msg);
			    msg = in.readUTF();
			    gui.tellUser(msg);
		    }
		}catch(Exception e){
			System.out.println(e);
		}
	
	}


    public static void main(String args[]){
		String address = args.length > 0 ? args[0] : "www.google.com";
		int port = args.length > 0 ? Integer.parseInt(args[1]) : 80;
	    Client client = new Client(address, port);
    }
}


class Gui{
	Scanner in;
	
	public Gui(){
		this.in = new Scanner(System.in);
	}

	public void tellUser(String msg){
		System.out.println(msg);
	}
	
	public String askUser(String msg){
		tellUser(msg);
		return in.nextLine();
	}
	
	public String askUser(){
		return in.nextLine();
	}
}