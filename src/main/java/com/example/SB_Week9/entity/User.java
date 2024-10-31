package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @Nationalized
    @Column(name = "user_name", unique = true, length = 50)
    private String username;

    private String email;

    @Column(length = 25)
    private String password;

    @Column(length = 11)
    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime birthday;

    @Check(constraints = "gender in ('Nam', 'Nữ', 'Khác')")
    private String gender;

    @Nationalized
    private String address;

    @Check(constraints = "role in ('admin', 'user')")
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> ticketList;
}
