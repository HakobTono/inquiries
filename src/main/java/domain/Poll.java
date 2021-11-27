package domain;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
    public class Poll {

        private int id;

        private String name;

        private String description;

        private List<Question> questions;

        private List<Result> results;
    }

