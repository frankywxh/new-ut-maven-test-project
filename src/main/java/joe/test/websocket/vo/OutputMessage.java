package joe.test.websocket.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OutputMessage {

    private String from;

    private String text;

    private String datetime;

}
