package network02.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import network02.common.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StartClient {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        try (Socket socket = new Socket(Configuration.host, Configuration.port)){
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Request request = new Request(Commands.RunTest, null);
            String jsonRequest = objectMapper.writeValueAsString(request);
            System.out.println("Send JSON: " + jsonRequest);

            out.println(jsonRequest);
            Response response;

            do {
                String jsonResponse = in.readLine();
                // System.out.println("Catch JSON: " + jsonResponse);

                response = objectMapper.readValue(jsonResponse, Response.class);
                System.out.println(response);
            } while (response.getStatus()!= Status.OK);






        } catch (IOException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
}
