package com.icode;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    OfficeHours officeHours;

//    @Autowired -- field injection - not recommended
//    OfficeHours officeHours;

    // @Autowired // Constructor Injection - Recommended
    // if 1 constructor Spring will inject it anyway

//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (20 + officeHours.getHours()));
    }
}
