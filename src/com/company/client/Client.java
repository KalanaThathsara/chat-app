package com.company.client;

import java.net.Socket;
import java.io.*;

public class Client {

    private DataOutputStream outputStream;
    private BufferedReader bufferedReader; //will be used in the future

    //even we can put this into constructor (then we no need to call this function)
    public void start() throws IOException {
        System.out.println("client is running");
        Socket socket = new Socket("localhost",6000);

        this.outputStream = new DataOutputStream(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void sendMessage(String message) throws IOException{
        System.out.println("Client Says: " + message);
        this.outputStream.writeBytes(message + "\n");
        String dataFromServer = this.bufferedReader.readLine();
        System.out.println("Server says: " + dataFromServer);
    }
}



