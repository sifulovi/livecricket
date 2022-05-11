package com.sio.livecricket.configuration;


import com.sio.livecricket.service.LiveCricketService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;

@Configuration
@EnableScheduling
public class ApplicationScheduler {
    LiveCricketService cricketService;

    public ApplicationScheduler(LiveCricketService cricketService) {
        this.cricketService = cricketService;
    }
    @Scheduled(fixedRate = 20000)
    public void scorePublisher() throws JAXBException, MalformedURLException {
        cricketService.scoreSeeding();
    }
}
