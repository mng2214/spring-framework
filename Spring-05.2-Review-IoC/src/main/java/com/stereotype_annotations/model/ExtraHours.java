package com.stereotype_annotations.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ExtraHours {
    public Integer getHours() {
        return 10;
    }
}
