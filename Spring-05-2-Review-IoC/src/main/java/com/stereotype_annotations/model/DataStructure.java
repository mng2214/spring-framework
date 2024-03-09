package com.stereotype_annotations.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
public class DataStructure {

    ExtraHours extraHours;

//    public void getTotalHours() {
//        System.out.println("Total hours " + (10 + new ExtraHours().getHours()));
//    }

//    @Autowired
//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getTotalHours() {
        System.out.println("Total hours " + (10 + extraHours.getHours()));
    }

}
