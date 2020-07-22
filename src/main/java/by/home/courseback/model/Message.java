package by.home.courseback.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {

    private Long compositionId;
    private String text;
    private String username;
}
