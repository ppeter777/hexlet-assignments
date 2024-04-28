package exercise.mapper;

import org.mapstruct.*;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarUpdateDTO;
import exercise.dto.CarDTO;
import exercise.model.Car;

// BEGIN
@Mapper(
        // Подключение JsonNullableMapper
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CarMapper {
    // Остальные методы
    public abstract void update(CarUpdateDTO dto, @MappingTarget Car model);

    @Mapping(target = "model", source = "model")
    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "enginePower", source = "enginePower")
//    public abstract Car map(@MappingTarget CarCreateDTO dto);
    public abstract CarDTO map(Car car);
    public abstract Car map(CarCreateDTO car);
//    public abstract CarDTO map(@MappingTarget Car dto);
}
// END
