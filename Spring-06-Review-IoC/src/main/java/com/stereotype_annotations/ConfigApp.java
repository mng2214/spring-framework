package com.stereotype_annotations;

import com.stereotype_annotations.config.AppConfig;
import com.stereotype_annotations.model.DataStructure;
import com.stereotype_annotations.model.DevOps;
import com.stereotype_annotations.model.MicroService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        container.getBean(MicroService.class).getTotalHours();
        container.getBean(DataStructure.class).getTotalHours();

    }
}
