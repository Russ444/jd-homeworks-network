import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен на порту " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новое подключение принято с порта " + clientSocket.getPort());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("Привет! Назови свое имя?");
                String name = in.readLine();
                System.out.println("Имя клиента: " + name);

                out.println("Добро пожаловать, " + name + "! Ты ребенок? (да/нет)");
                String isChild = in.readLine();
                System.out.println("Клиент ответил: " + isChild);

                String response;
                if (isChild.equalsIgnoreCase("да")) {
                    response = "Добро пожаловать в детскую зону, " + name + "! Давай поиграем!";
                } else {
                    response = "Добро пожаловать в зону для взрослых, " + name + "! Приятного отдыха или продуктивного рабочего дня!";
                }
                out.println(response);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
