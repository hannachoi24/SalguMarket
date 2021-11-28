package com.ApricotMarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column
//    private String email;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Boolean enabled;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    // @JsonIgnore
    @ManyToMany
    @JoinTable( // 내가 만든 조인 테이블
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private final List<Board> boards = new ArrayList<>();

    // 추가 //
    @Column
    private int money;

    @Column
    private int mileage;

    @Column
    private int log;
}
