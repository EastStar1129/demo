package com.cms.database.user.entity;

import com.cms.database.common.entity.DateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "tbl_user")
@RequiredArgsConstructor
@AllArgsConstructor
public class User extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private Boolean isDel;
}
