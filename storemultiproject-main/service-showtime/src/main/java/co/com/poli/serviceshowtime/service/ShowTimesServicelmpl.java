package co.com.poli.serviceshowtime.service;

import co.com.poli.serviceshowtime.entities.ShowTime;
import co.com.poli.serviceshowtime.repository.ShowTimesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimesServicelmpl implements ShowTimesService {

    private final ShowTimesRepository showTimesRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShowTime showTimes) {
        showTimesRepository.save(showTimes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ShowTime showTimes) {
        showTimesRepository.delete(showTimes);
    }

    @Override
    @Transactional (readOnly = true)
    public List<ShowTime> findAll() {
        return showTimesRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public ShowTime findById(Long id) {
        return showTimesRepository.findById(id).orElse(null);
    }
}
