package comskcc.caremoa.service;

import comskcc.caremoa.controller.request.CareReviewContentsCreateRequest;
import comskcc.caremoa.exception.CareReviewException;
import comskcc.caremoa.exception.ErrorCode;
import comskcc.caremoa.model.CareReviewContents;
import comskcc.caremoa.model.ReviewType;
import comskcc.caremoa.model.entity.CareReviewContentsEntity;
import comskcc.caremoa.model.entity.CareReviewEntity;
import comskcc.caremoa.repository.CareReviewContentsRepository;
import comskcc.caremoa.repository.CareReviewEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CareReviewContentsService {

    private final CareReviewEntityRepository careReviewEntityRepository;
    private final CareReviewContentsRepository careReviewContentsRepository;

    public CareReviewContents getByReviewId(Long reviewId) {
        return CareReviewContents.fromEntity(getCareReviewContentsEntityOrException(reviewId));
    }

    @Transactional
    public void create(CareReviewContentsCreateRequest careReviewContentsCreateRequest) {
        CareReviewEntity careReviewEntity =
                careReviewEntityRepository.save(CareReviewEntity.of(careReviewContentsCreateRequest.getReviewId()
                        , null, ReviewType.REVIEW));

        careReviewContentsRepository.save(
                CareReviewContentsEntity.of(careReviewEntity.getId(), careReviewContentsCreateRequest.getContents()
                        , careReviewContentsCreateRequest.getLikeType()));
    }

    private CareReviewContentsEntity getCareReviewContentsEntityOrException(Long reviewId) {
        return careReviewContentsRepository.findByReviewId(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId))
        );
    }

    private CareReviewEntity getCareReviewEntityOrException(Long reviewId) {
        return careReviewEntityRepository.findById(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId))
        );
    }
}
