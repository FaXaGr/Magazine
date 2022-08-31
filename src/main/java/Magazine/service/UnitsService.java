package Magazine.service;

import Magazine.dto.ResponseDto;
import Magazine.dto.UnitsDto;
import Magazine.entity.Units;

public interface UnitsService {
    ResponseDto<String> add(UnitsDto unitsDto);
}
