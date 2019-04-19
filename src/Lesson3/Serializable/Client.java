package Lesson3.Serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket toServer = new Socket("",8000);

        ObjectOutputStream ser = new ObjectOutputStream(toServer.getOutputStream());
        ObjectInputStream deser = new ObjectInputStream(toServer.getInputStream());
        Player c = new Player ("Вася",1);
        ser.writeObject(c);


        Player b = (Player)deser.readObject();
        System.out.println(b.name + " " + b.level);
    }
}
