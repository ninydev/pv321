package network02.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import network02.common.Request;
import network02.common.Response;
import network02.common.Status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static network02.server.StartServer.executor;

public class ServerClient implements Runnable
{
    private static ObjectMapper objectMapper = new ObjectMapper();

    private Socket clientSocket;
    BufferedReader in;
    PrintWriter out;

    public ServerClient (Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public void sendMessage (String message) throws JsonProcessingException {
        System.out.println("Send message: " + message);
        this.out.println(objectMapper.writeValueAsString(new Response(Status.Message, message)));
    }

//    public static void sendMessageToAllClients(String message) {
//        executor.execute(() -> {
//            System.out.println("Sending message: " + message + " from thread: " + Thread.currentThread().getName());
//        });
//    }

    @Override
    public void run() {
        try {
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            StartServer.sendMessage("Client connected: " + clientSocket.getInetAddress() + "Thread " + Thread.currentThread().getName());

            // ServerClient.sendMessageToAllClients("Client connected: " + clientSocket.getInetAddress());


//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String jsonRequest = in.readLine();
            System.out.println("Catch JSON: " + jsonRequest);

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Request request = objectMapper.readValue(jsonRequest, Request.class);
            System.out.println(request);

            Response response = new Response(Status.OK, null);
            String jsonResponse = objectMapper.writeValueAsString(response);
            System.out.println("Send JSON: " + jsonResponse);

            out.println(jsonResponse);

            clientSocket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
