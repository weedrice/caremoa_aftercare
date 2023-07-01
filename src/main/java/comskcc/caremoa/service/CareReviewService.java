package comskcc.caremoa.service;

import comskcc.caremoa.exception.CareReviewException;
import comskcc.caremoa.exception.ErrorCode;
import comskcc.caremoa.model.CareReview;
import comskcc.caremoa.model.ReviewType;
import comskcc.caremoa.model.entity.CareReviewEntity;
import comskcc.caremoa.repository.CareReviewEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CareReviewService {
    private final CareReviewEntityRepository careReviewRepository;

    public Page<CareReview> my(Long memberId, Pageable pageable) throws Exception {
        return careReviewRepository.findAllByMemberId(memberId, pageable).map(CareReview::fromEntity);
    }

    public CareReview getByContId(Long contId) throws Exception {
        return careReviewRepository.findByContId(contId).map(CareReview::fromEntity).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", contId)));
    }

    @Transactional
    public void create(Long contId, Long memberId, ReviewType reviewType) {
        careReviewRepository.save(CareReviewEntity.of(contId, memberId, ReviewType.NONE));
    }
}