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
/*
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
  */
    /*
    @Column
    private String location;
    @Column
    private String name;
     */

}
/*
그리고 아내가 무슨말할라했더라 아아 저기서 네임은 작성자 이름이야?응응
이렇게 하는거보다 강의에서 보드 만들때 유저랑 매핑하지 않았어?? 그게 id 같아 아이디가 같다고?? 아니아니 유저랑 매핑은 안하고 그냥
테이블로 번호, 제목, 내용 이렇게 가져갔는디 그럼 누가쓴글인지 모르지않아? 그니까.. 보드랑 유저랑 묶어주고 같은 방식으로 로케이션도 묶어줘야할거같아
로케이션 변수를 쓰기보단? 어떻게..?

로케이션은 유저 모델에 따로 멤버변수있어서 매핑안해줘도 될거같아 아항 그러고 .html에서 바꿔줘야하나? 어느부분??*/