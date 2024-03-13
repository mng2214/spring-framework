package org.example.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("OVERTIME")
public class OvertimeHours implements HoursRepository {
    @Override
    public int getHours() {
        return 15;
    }
}
