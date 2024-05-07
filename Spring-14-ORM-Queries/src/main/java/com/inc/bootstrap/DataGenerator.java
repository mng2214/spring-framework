package com.inc.bootstrap;

import com.inc.repository.RegionRepository;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements Runnable {

    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run() {

        System.out.println("-------------------------Region Start-------------------------");



        System.out.println("-------------------------Region End-------------------------");




    }


}
