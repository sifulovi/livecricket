package com.sio.livecricket.repository;

import com.sio.livecricket.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Channel findByTtl(String ttl);
}
