package com.romann1c.chatapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


@Service
public class MessageRequestSenderService {

    @Value("${SendRequestUrl}")
    private String requestUrl;

    final ChatMessageJsonService chatMessageJsonService;

    private HttpURLConnection connection;

    @Autowired
    public MessageRequestSenderService(ChatMessageJsonService chatMessageJsonService) {
        this.chatMessageJsonService = chatMessageJsonService;
    }

    public void sendRequest(String chatMessage){
        try {

            URL url = new URL(requestUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(2000);
            connection.setConnectTimeout(2000);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoOutput(true);
            try(OutputStream outputStream = connection.getOutputStream()){
                byte[] input = chatMessage.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }
            connection.getResponseCode();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
