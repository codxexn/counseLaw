package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerFieldSearchDTO;
import com.app.counselawb.domain.pagination.Pagination;
import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.repository.LawyerSearchDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LawyerSearchServiceImpl implements LawyerSearchService {
    private final LawyerSearchDAO lawyerSearchDAO;

    @Override
    public List<FieldCategoryVO> findAllFieldCategories() {
        return lawyerSearchDAO.readAllFieldCategories();
    }

    @Override
    public int findLawyersCountByFieldId(Long fieldId) {
        return lawyerSearchDAO.readLawyersCountByFieldId(fieldId);
    }

    @Override
    public List<LawyerFieldSearchDTO> findLawyersByFieldId(Pagination pagination, Long fieldId) {
        return lawyerSearchDAO.readLawyersByFieldId(pagination, fieldId);
    }

    @Override
    public Optional<FieldVO> findFieldInfo(Long fieldId) {
        return lawyerSearchDAO.readFieldInfo(fieldId);
    }
}
