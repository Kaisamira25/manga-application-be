package com.alpha.mangaapplication.model;

import com.alpha.mangaapplication.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "email",columnDefinition = "varchar(100)",nullable = false,unique = true)
    private String email;
    @Column(name = "full_name",columnDefinition = "nvarchar(100)",nullable = false)
    private String fullName;
    @JsonIgnore
    @Column(name = "password",columnDefinition = "varchar(1000)",nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    @Column(name = "refresh_token",columnDefinition = "nvarchar(1000)")
    private String refreshToken;
    @Column(name = "is_verify")
    private boolean isVerify = false;
    @Column(name = "verify_email_code",columnDefinition = "nvarchar(25)")
    private String verifyEmailCode;
    @Column(name = "verify_email_code_expiration")
    private Date verifyEmailCodeExpiration;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "refresh_password_code",columnDefinition = "nvarchar(1000)")
    private String refreshPasswordCode;
    @Column(name = "refresh_password_code_expiration")
    private Date refreshPasswordCodeExpiration;
}
