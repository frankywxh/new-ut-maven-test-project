package joe.test.websocket.service.impl;

import joe.test.websocket.service.WebSocketService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class WebSocketServiceImplTest {

    @Mock
    private SimpMessageSendingOperations messagingTemplate;

    @InjectMocks
    private WebSocketServiceImpl webSocketService;

    @Before
    public void setup() {

    }

    @Test
    public void sensAdhocMessageTest() {
        // have to use Mockito.anyMap() as the original method is using current time
        // if we use current time here for Map, this test has possibility failed as the current time might
        // might be different between original method and this test method
        doNothing().when(messagingTemplate).convertAndSend(Mockito.anyString(), Mockito.anyMap());

        boolean result = webSocketService.sensAdhocMessage();
        Assert.assertTrue(result);
    }
}
