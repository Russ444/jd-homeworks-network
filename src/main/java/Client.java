import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "netology.homework";
        int serverPort = 8080;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in))) {

            String message = in.readLine();
            System.out.println("Сервер отвечает: " + message);

            System.out.print("Введите ваше имя: ");
            String name = keyboardInput.readLine();
            out.println(name);

            message = in.readLine();
            System.out.println("Сервер спрашивает: " + message);

            System.out.print("Вы ребенок? (да/нет): ");
            String answer = keyboardInput.readLine();
            out.println(answer);

            message = in.readLine();
            System.out.println("Сервер отвечает: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
