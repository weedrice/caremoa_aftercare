package comskcc.caremoa.model.entity;

import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "\"care_review\"", indexes = {
        @Index(name = "review_id_idx", columnList = "id")
})
@Getter
@Setter
@SQLDelete(sql = "UPDATE \"care_review\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class CareReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cont_id")
    private Long contId;

    @Column(name="member_id")
    private Long memberId;

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

    public static CareReviewEntity of(Long contId, Long memberId) {
        CareReviewEntity entity = new CareReviewEntity();
        entity.setContId(contId);
        entity.setMemberId(memberId);

        return entity;
    }
}