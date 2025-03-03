package network02.server;

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

public class StartServer_1Thread {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(Configuration.port)) {


            System.out.println("Server Started on port: " + Configuration.port + " and waiting clients");
            while (true) {

                try (Socket clientSocket = serverSocket.accept() ) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

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
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
