package com.evaitcs.obp.customerprofile.entity;

import com.evaitcs.obp.customerprofile.config.AesEncryptionConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal Info
    @Column(nullable = false, length = 100)
    @Size(min = 2, max = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    @Size(min = 2, max = 100)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    @Convert(converter = AesEncryptionConverter.class)
    private String email;

    @Column(length = 20)
    private String phoneNumber;

    private LocalDate dateOfBirth;

    // Address Embedded
    @Embedded
    private Address address;

    // KYC Embedded
    @Embedded
    private KycDetails kyc;

    // Audit Fields
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
}
