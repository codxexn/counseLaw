package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerFieldDTO;
import com.app.counselawb.domain.vo.ExperienceVO;
import com.app.counselawb.domain.vo.FieldVO;
import com.app.counselawb.domain.vo.LawyerVO;
import com.app.counselawb.repository.LawyerDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class LawyerServiceImpl implements LawyerService {
    private final LawyerDAO lawyerDAO;

    @Override
    public Optional<LawyerVO> findByLawyerId(Long lawyerId) {
        return lawyerDAO.readByLawyerId(lawyerId);
    }

    @Override
    public int findSCTotalByLawyerId(Long lawyerId) {
        return lawyerDAO.readSCTotalByLawyerId(lawyerId);
    }

    @Override
    public int findLGTotalByLawyerId(Long lawyerId) {
        return lawyerDAO.readLGTotalByLawyerId(lawyerId);
    }

    @Override
    public int findFavTotalByLawyerId(Long lawyerId) {
        return lawyerDAO.readFavTotalByLawyerId(lawyerId);
    }

    @Override
    public List<LawyerFieldDTO> findFieldsByLawyerId(Long lawyerId) {
        return lawyerDAO.readFieldsByLawyerId(lawyerId);
    }

    @Override
    public int findPhoneCountByLawyerId(Long lawyerId) {
        return lawyerDAO.readPhoneCountByLawyerId(lawyerId);
    }

    @Override
    public int findVideoCountByLawyerId(Long lawyerId) {
        return lawyerDAO.readVideoCountByLawyerId(lawyerId);
    }

    @Override
    public int findVisitCountByLawyerId(Long lawyerId) {
        return lawyerDAO.readVisitCountByLawyerId(lawyerId);
    }

    @Override
    public int findReplyCountByLawyerId(Long lawyerId) {
        return lawyerDAO.readReplyCountByLawyerId(lawyerId);
    }

    @Override
    public void revisePw(LawyerVO lawyerVO) {
        lawyerDAO.modifyPw(lawyerVO);
    }

    @Override
    public void revisePhone(LawyerVO lawyerVO) {
        lawyerDAO.modifyPhone(lawyerVO);
    }

    @Override
    public List<FieldVO> findAllFields() {
        return lawyerDAO.readAllFields();
    }

    @Override
    public void saveLawyerFields(Long fieldId, Long lawyerId) {
        lawyerDAO.writeLawyerFields(fieldId, lawyerId);
    }

    @Override
    public void discardLawyerFields(Long lawyerId) {
        lawyerDAO.removeLawyerFields(lawyerId);
    }

    @Override
    public void reviseLawyerInfo(LawyerVO lawyerVO) {
        lawyerDAO.modifyLawyerInfo(lawyerVO);
    }

    @Override
    public List<ExperienceVO> findCareersByLawyerId(Long lawyerId) {
        return lawyerDAO.readCareersByLawyerId(lawyerId);
    }

    @Override
    public void discardExperienceByExperienceId(Long experienceId) {
        lawyerDAO.removeExperienceByExperienceId(experienceId);
    }

    @Override
    public void saveExperience(ExperienceVO experienceVO) {
        lawyerDAO.writeExperience(experienceVO);
    }

    @Override
    public void reviseProfileImage(LawyerVO lawyerVO) {
        lawyerDAO.modifyProfilePhoto(lawyerVO);
    }

    @Override
    public String findProfileImage(Long lawyerId) {
        return lawyerDAO.readProfileImage(lawyerId);
    }

    @Override
    public void discardProfileImage(Long lawyerId) {
        lawyerDAO.removeProfileImage(lawyerId);
    }

    @Override
    public void discardSCByLawyerId(Long lawyerId) {
        lawyerDAO.removeSCByLawyerId(lawyerId);
    }

    @Override
    public void discardLGByLawyerId(Long lawyerId) {
        lawyerDAO.removeLGByLawyerId(lawyerId);
    }

    @Override
    public void discardFieldByLawyerId(Long lawyerId) {
        lawyerDAO.removeFieldByLawyerId(lawyerId);
    }

    @Override
    public void discardLocationByLawyerId(Long lawyerId) {
        lawyerDAO.removeLocationByLawyerId(lawyerId);
    }

    @Override
    public void discardCareerByLawyerId(Long lawyerId) {
        lawyerDAO.removeCareerByLawyerId(lawyerId);
    }

    @Override
    public void discardReplyByLawyerId(Long lawyerId) {
        lawyerDAO.removeReplyByLawyerId(lawyerId);
    }

    @Override
    public void discardLawyerLikeByLawyerId(Long lawyerId) {
        lawyerDAO.removeLawyerLikeByLawyerId(lawyerId);
    }

    @Override
    public void discardLawyer(Long lawyerId) {
        lawyerDAO.removeLawyer(lawyerId);
    }
}
