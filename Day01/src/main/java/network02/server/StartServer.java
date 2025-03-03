package network02.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import network02.common.Configuration;
import network02.common.Request;
import network02.common.Response;
import network02.common.Status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class StartServer {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static ExecutorService executor = Executors.newCachedThreadPool();
    public static List<ServerClient> clients = new ArrayList<>();

    public static void sendMessage(String message) throws JsonProcessingException {
        for (ServerClient client : clients) {
            client.sendMessage(message);
        }
    }

    public static void main(String[] args) {

        // ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Configuration.maxThreads);
        ExecutorService executor = Executors.newCachedThreadPool();


        try (ServerSocket serverSocket = new ServerSocket(Configuration.port)) {


            System.out.println("Server Started on port: " + Configuration.port + " and waiting clients");
            while (true) {

                Socket clientSocket = serverSocket.accept();
//                System.out.println("Queue size: " + executor.getQueue().size());
//                if (executor.getQueue().size() > Configuration.maxThreads * 2) {
//                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                    Response response = new Response(Status.Error, "Server is overload");
//                    out.println(objectMapper.writeValueAsString(response));
//                }
                ServerClient client = new ServerClient(clientSocket);
                clients.add(client);
                executor.execute( client);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
