package training360.gardenservices;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;
import training360.gardenservices.domain.Gardener;
import training360.gardenservices.domain.Gardenwork;
import training360.gardenservices.dto.*;
import training360.gardenservices.repository.GardenerRepository;
import training360.gardenservices.repository.GardenworkRepository;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class GardenerService {

    private final ModelMapper mapper;

    private final GardenerRepository gardenerRepository;

    private final GardenworkRepository gardenworkRepository;


    @Transactional
    public GardenerDto createGardener(CreateGardenerCommand command) {
        Gardener gardener = new Gardener(command.getName());
        gardenerRepository.save(gardener);
        return mapper.map(gardener, GardenerDto.class);
    }


    public List<GardenerDto> getGardeners() {
        Type targetListType = new TypeToken<List<GardenerDto>>() {
        }.getType();
        return mapper.map(gardenerRepository.findAll(), targetListType);
    }

    @Transactional
    public GardenWorkDto createGardenWork(long gardenerId, CreateGardenWorkCommand command) {

        Gardener gardener = gardenerRepository.findById(gardenerId)
                .orElseThrow(() -> new GardenerException("gardeners/gardener-not-found",
                        "Gardener not found", Status.NOT_FOUND));

        GardenWork gardenWork = new GardenWork(gardener, command.getDescription());
        gardenworkRepository.save(gardenWork);
        return mapper.map(gardenWork, GardenWorkDto.class);
    }

    public List<GardenWorkDto> getGardenWorks(long gardenerId) {
        Type targetListType = new TypeToken<List<GardenWorkDto>>() {}.getType();
        return mapper.map(gardenworkRepository.findById(gardenerId).orElseThrow(
                () -> new GardenerException("gardeners/gardener-not-found",
                        "Gardener not found", Status.NOT_FOUND)).getGardener(), targetListType);
    }

    public List<NameDescriptionPairDto> getPairs() {
        return gardenworkRepository.findPairs();
    }

    @Transactional
    public GardenerDto answer(long gardenWorkId, AnswerCommand command) {

        Gardenwork gardenwork = gardenworkRepository.findById(gardenWorkId)
                .orElseThrow(() -> new GardenerException("gardenworks/gardenwork-not-found", "Garden work not found", Status.NOT_FOUND));
        gardenwork.setDone(true);
        gardenwork.setAnswer(command.getAnswer());

        return mapper.map(gardenwork, Gardenwork.class);

    }
}
