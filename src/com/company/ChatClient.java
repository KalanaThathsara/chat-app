package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        System.out.println("Client is running");
        Socket socket = new Socket("localhost", 6000);


        //Get the data from the user
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String receivedData = bufferedReader.readLine();

        System.out.println("Data received from server:" + receivedData);
        System.out.println("client finished the execution");

        //Input and Output stream


        //Send data from client to the server

        //send data both ways
        //server sends data according to the client input
        //get the user input and sending the data to the server
        //handling multiple clients at the same time using threads
    }
}