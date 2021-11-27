package domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Answer {
    private int id;

    private String text;

    private int weight;
}

