package com.evaitcs.obp.customerprofile.entity;

import com.evaitcs.obp.customerprofile.config.AesEncryptionConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KycDetails {

    @NotBlank
    @Size(max = 50)
    private String documentType;

    @NotBlank
    @Size(max = 100)
    @Column(name = "document_number")
    @Convert(converter = AesEncryptionConverter.class)
    private String documentNumber;

    @Column(nullable = false)
    private LocalDate documentIssuedDate;

    private LocalDate documentExpiryDate;

    @Column(nullable = false)
    private boolean verificationStatus;

    private LocalDate verificationDate;
}
