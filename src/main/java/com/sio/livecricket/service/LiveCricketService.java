package com.sio.livecricket.service;

import com.sio.livecricket.entity.Channel;
import com.sio.livecricket.entity.Item;
import com.sio.livecricket.entity.RSS;
import com.sio.livecricket.repository.ChannelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LiveCricketService {

    private static final String API_URL = "http://static.cricinfo.com/rss/livescores.xml";

    ChannelRepository channelRepository;

    public LiveCricketService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public Channel getDataset() {
        return channelRepository.findAll().size() > 0 ? channelRepository.findAll().get(0) : null;
    }

    public Channel findByTtl(String ttl) {
        return channelRepository.findByTtl(ttl);
    }

    public void save(Channel channel) {
        channelRepository.save(channel);
    }

    public void scoreSeeding() throws JAXBException, MalformedURLException {
        log.info("------------ Score Publishing ------------");
        JAXBContext jaxbContext = JAXBContext.newInstance(RSS.class);
        java.net.URL url = new URL(API_URL);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        RSS rss = (RSS) jaxbUnmarshaller.unmarshal(url);
        Channel parsedChannelObj = rss.getChannel();
        Channel byTtl = findByTtl(parsedChannelObj.getTtl());
        if (byTtl == null) {
            save(populate(parsedChannelObj));
        }
        else {
            parsedChannelObj.setId(byTtl.getId());
            save(populate(parsedChannelObj));
        }
    }
    Channel populate(Channel parsedChannelObj) {
        Channel newChannelObj = new Channel();
        BeanUtils.copyProperties(parsedChannelObj, newChannelObj);
        List<Item> itemList = new ArrayList<>();
        parsedChannelObj.getItem().forEach(parsedItem -> {
            Item newItemObj = new Item();
            BeanUtils.copyProperties(parsedItem, newItemObj);
            newItemObj.setChannel(newChannelObj);
            itemList.add(newItemObj);
        });
        newChannelObj.setItem(itemList);
        return newChannelObj;
    }
}
