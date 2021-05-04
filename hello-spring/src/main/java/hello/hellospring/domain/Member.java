package hello.hellospring.domain;

import javax.persistence.*;

@Entity //아래는 jpa가 관리하는 엔티티
public class Member {

    //pk 매핑
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //pk자동 db알아서 생성->아이덴티티
    private Long id;

    //@Column(name="username") //흠..컬럼명 문제가 생긴 듯? 일단 지워줌
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
