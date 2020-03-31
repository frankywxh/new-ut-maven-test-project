package joe.test.websocket.service.impl;

import joe.test.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    public boolean sensAdhocMessage() {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("This is a message sent from back end at ");
        sb.append(time);

        Map<String, String> result = new HashMap<>();
        result.put("line", sb.toString());

        // Push message to front-end
        messagingTemplate.convertAndSend("/channel/adhoc-message", result);

        return true;
    }
}
