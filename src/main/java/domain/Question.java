package domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Question {
    private int id;

    private String text;

    private List<Answer> answers;

}
