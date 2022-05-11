package com.sio.livecricket.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Channel extends BaseEntity {
    private String title;
    private String ttl;
    private String link;
    private String description;
    private String copyright;
    private String language;
    private String pubDate;
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "channel")
    private List<Item> item = new ArrayList<>();
}
