package com.app.counselawb.service;

import com.app.counselawb.domain.vo.FieldCategoryVO;
import com.app.counselawb.repository.LawyerSearchDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LawyerSearchServiceImpl implements LawyerSearchService {
    private final LawyerSearchDAO lawyerSearchDAO;

    @Override
    public List<FieldCategoryVO> findAllFieldCategories() {
        return lawyerSearchDAO.readAllFieldCategories();
    }
}
