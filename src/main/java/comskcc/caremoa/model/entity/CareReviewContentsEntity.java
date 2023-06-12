package comskcc.caremoa.model.entity;

import comskcc.caremoa.model.LikeType;
import comskcc.caremoa.model.ReviewType;
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
@Table(name="\"care_review_contents\"")
@Getter
@Setter
@SQLDelete(sql = "UPDATE \"care_review_contents\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class CareReviewContentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "contents")
    private String contents;

    @Column(name = "like_type")
    @Enumerated(EnumType.STRING)
    private LikeType likeType;

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

    public static CareReviewContentsEntity of(Long reviewId, String contents, LikeType likeType) {
        CareReviewContentsEntity entity = new CareReviewContentsEntity();
        entity.setReviewId(reviewId);
        entity.setContents(contents);
        entity.setLikeType(likeType);

        return entity;
    }
}
