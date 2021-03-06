package com.company.server;

import java.io.*;
import java.net.Socket;
import java.io.InputStreamReader;

public class ClientHandler implements  Runnable {

    private  Socket client;

    public ClientHandler(Socket socket) {
        this.client=socket;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30000); //wait for 30 seconds executing the rest of the code
            //received data
            InputStream inputStream = this.client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(this.client.getOutputStream());

            // continuous reading data from client
            String inputData;
            while ( (inputData=bufferedReader.readLine()) != null){


                System.out.println("client says: " + inputData);

                //send data to client
                switch (inputData) {
                    case "Hello From the client":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case  "How are you?":
                        outputStream.writeBytes("I'm fine. How are you? \n");
                        break;

                    case "I'm fine":
                        outputStream.writeBytes("Okay Good to know \n");
                        break;

                    case "Thank you":
                        outputStream.writeBytes("You are welcome \n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand that \n");

                }

                if (inputData.equals("exit")){
                    break;
                }
            }

            this.client.close();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }
}

