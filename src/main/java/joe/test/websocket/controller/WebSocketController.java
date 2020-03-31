package joe.test.websocket.controller;


import joe.test.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    @Autowired
    private WebSocketService webSocketService;

    /**
     * Send adhoc message to front end via websocket if this endpoint is called.
     * @return
     */
    @PostMapping(value = "/message")
    public boolean adhocMessage() {
        return webSocketService.sensAdhocMessage();
    }

    @GetMapping(value = "/message")
    public String getMessgae() {
        return "This is a message from backend.";
    }

}
