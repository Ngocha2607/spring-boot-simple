package io.reflectoring.spring_boot_simple.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

//    Mapping thong tin bien voi ten cot trong db
    @Column(name = "hp")
    private int hp;
    @Column(name = "stamina")
    private int stamina;

//    Neu k danh dau @Column thi se mapping tu dong theo ten
    private int atk;
    private int def;
    private int agi;
}
