package br.com.rasmoo.integranf.models;

import br.com.rasmoo.integranf.enums.IssueOn;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "invoice_settings")
public class InvoiceSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "invoice_model", nullable = false)
    private String invoiceModel;

    @Column(name = "issue_on")
    @Enumerated(EnumType.STRING)
    private IssueOn issueOn;

    @Column(name = "send_by_email", nullable = false)
    private boolean sendByEmail;

    @Column(name = "cancel_on_refund", nullable = false)
    private boolean cancelOnRefund;


}
