package com.example.databasestudy.domain.customers;

import com.example.databasestudy.domain.work.Work;
import com.example.databasestudy.domain.work.WorkStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customers {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "work_status")
    @Enumerated(EnumType.STRING)
    private WorkStatus status;

    @Column(name = "work_list")
    @OneToMany
    private List<Work> workList;
}
