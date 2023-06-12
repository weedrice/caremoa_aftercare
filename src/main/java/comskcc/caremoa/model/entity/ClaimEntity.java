package comskcc.caremoa.model.entity;

import comskcc.caremoa.model.ClaimStatus;
import comskcc.caremoa.model.ClaimType;
import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "\"claim\"")
@Getter
@Setter
@SQLDelete(sql = "UPDATE \"claim\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class ClaimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_id")
    private Long reivewId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

    @Column(name = "claimType")
    @Enumerated(EnumType.STRING)
    private ClaimType claimType;

    @Column(name ="registered_at")
    private Timestamp registeredAt;

    @Column(name ="updated_at")
    private Timestamp updatedAt;

    @Column(name ="deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        this.registeredAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static ClaimEntity of(Long reviewId, ClaimStatus claimStatus, ClaimType claimType) {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setReivewId(reviewId);
        claimEntity.setClaimStatus(claimStatus);
        claimEntity.setClaimType(claimType);

        return claimEntity;
    }
}
