package Lesson3.Serializable;

//Создать клиент и сервер.
//Далее создать класс Player
//Далее создать экземпляр класса Player, сереализовать объект, передать его по сети и десереализовать.


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket socket = new ServerSocket(8000);
        Socket client = socket.accept();

        ObjectInputStream deser = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream ser = new ObjectOutputStream(client.getOutputStream());

        Player c = (Player)deser.readObject();
        System.out.println(c.name + " " + c.level);
        ser.writeObject(c);
    }
}
