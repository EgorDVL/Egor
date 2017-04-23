package com.zhyzhko.controllers;

import com.zhyzhko.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Egor on 20.04.2017.
 */

public class ResponsesCounterWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ResponseService responseService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        while (true) {
            int size = responseService.getAllResponse().size();

            WebSocketMessage<String> textMessage = new TextMessage(String.valueOf(size));
            session.sendMessage(textMessage);

            Thread.sleep(2_000L);
        }
    }
}