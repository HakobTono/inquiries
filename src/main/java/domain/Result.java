package domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {

    private int id;
    private String explanation;
    private int minScore;
    private int maxScore;

}
