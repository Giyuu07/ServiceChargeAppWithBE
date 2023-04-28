package ph.com.alliance.ServiceChargeApp5.Attachment.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ph.com.alliance.ServiceChargeApp5.Ticket.entity.Ticket;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attachments")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    @Getter
    @Setter
    private int attachment_id;

    @Column(name = "file_name")
    @Getter
    @Setter
    private String file_name;

    @Column(name = "file_type")
    @Getter
    @Setter
    private String file_type;
    
    @Column(name = "file_category")
    @Getter
    @Setter
    private String file_category;

    @Column(name = "file_data", columnDefinition = "BLOB")
    @Getter
    @Setter
    private byte[] file_data;

    @Column(name = "file_url")
    @Getter
    @Setter
    private String file_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    @Getter
    @Setter
    private Ticket ticket;
}
