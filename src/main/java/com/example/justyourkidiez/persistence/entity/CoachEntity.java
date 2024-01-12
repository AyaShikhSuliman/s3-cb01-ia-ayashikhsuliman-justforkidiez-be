package com.example.justyourkidiez.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "coach")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "last_name")
    private String last_name;

    @NotNull
    @Column(name = "age")
    private Long age;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "phone_number")
    private String phone_number;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "email_address")
    private String email_address;
}
