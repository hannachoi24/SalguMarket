package com.ApricotMarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // 이 class가 db 연동을 위한 model class임을 알려줌
@Data
public class Board {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=0, max=30)
    @Column
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;


    @Column
    private String location;
    @Column
    private String name;

}
