package com.app.counselawb.service;

import com.app.counselawb.domain.dto.LawyerLocationDTO;
import com.app.counselawb.domain.vo.LawyerLocationVO;
import com.app.counselawb.domain.vo.LocationVO;
import com.app.counselawb.repository.LocationDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class LocationServiceImpl implements LocationService {
    private final LocationDAO locationDAO;

    @Override
    public List<LocationVO> findAllLocations() {
        return locationDAO.readAllLocations();
    }

    @Override
    public List<LawyerLocationDTO> findLocationsByLawyerId(Long lawyerId) {
        return locationDAO.readLocationsByLawyerId(lawyerId);
    }

    @Override
    public void discardLocationsByLawyerId(Long lawyerId) {
        locationDAO.removeLocationsByLawyerId(lawyerId);
    }

    @Override
    public void saveLocationsByLawyerId(LawyerLocationVO lawyerLocationVO) {
        locationDAO.writeLocationsByLawyerId(lawyerLocationVO);
    }
}
