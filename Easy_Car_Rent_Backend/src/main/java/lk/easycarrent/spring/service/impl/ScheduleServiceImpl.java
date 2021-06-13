package lk.easycarrent.spring.service.impl;

import lk.easycarrent.spring.dto.ScheduleDTO;
import lk.easycarrent.spring.entity.Schedule;
import lk.easycarrent.spring.exception.ValidateException;
import lk.easycarrent.spring.repo.ScheduleRepo;
import lk.easycarrent.spring.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addSchedule(ScheduleDTO dto) {
        if (repo.existsById(dto.getScheduleID())) {
            throw new ValidateException("Schedule Already Exist");
        }
        repo.save(mapper.map(dto, Schedule.class));
    }

    @Override
    public void deleteSchedule(String id) {
        if (!repo.existsById(id)) {
            throw new ValidateException("No Schedule for Delete..!");
        }
        repo.deleteById(id);
    }

    @Override
    public ScheduleDTO searchSchedule(String id) {
        Optional<Schedule> op = repo.findById(id);
        if (op.isPresent()) {
            return mapper.map(op.get(), ScheduleDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<ScheduleDTO> getAllSchedule() {
        List<Schedule> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<ScheduleDTO>>() {
        }.getType());
    }

    @Override
    public void updateSchedule(ScheduleDTO dto) {
        if (repo.existsById(dto.getScheduleID())) {
            repo.save(mapper.map(dto, Schedule.class));
        }
    }
}
