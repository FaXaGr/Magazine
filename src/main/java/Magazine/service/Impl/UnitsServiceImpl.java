package Magazine.service.Impl;

import Magazine.dto.ResponseDto;
import Magazine.dto.UnitsDto;
import Magazine.entity.Units;
import Magazine.mapper.UnitsMapper;
import Magazine.repository.UnitsRepository;
import Magazine.service.UnitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnitsServiceImpl implements UnitsService {
    private final UnitsRepository repository;
    private final UnitsMapper mapper;
    @Override
    public ResponseDto<String> add(UnitsDto unitsDto) {
        Units units = mapper.toEntity(unitsDto);
        repository.save(units);
        return null;
    }
}
