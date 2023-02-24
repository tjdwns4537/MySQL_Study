package com.example.databasestudy.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    @NonNull
    private String name;

    @Column(name = "phone_number")
    @NonNull
    private String phoneNumber;

    public static Users of(String name, String phoneNumber) {
        return new Users(name, phoneNumber);
    }
}
