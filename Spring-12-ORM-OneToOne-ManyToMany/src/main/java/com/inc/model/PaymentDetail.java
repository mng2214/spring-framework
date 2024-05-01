package com.inc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "paymentDetails")
@NoArgsConstructor
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal merchantPayoutAmount;
    private BigDecimal commisionAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail", cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commisionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commisionAmount = commisionAmount;
        this.payoutDate = payoutDate;
    }
}
