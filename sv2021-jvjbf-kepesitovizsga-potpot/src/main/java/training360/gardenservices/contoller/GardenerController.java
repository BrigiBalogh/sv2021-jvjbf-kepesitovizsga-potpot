package training360.gardenservices.contoller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import training360.gardenservices.GardenerService;
import training360.gardenservices.dto.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class GardenerController {

    private final GardenerService gardenerService;

    @PostMapping("/gardeners")
    public GardenerDto createGardener(@Valid @RequestBody CreateGardenerCommand command) {
        return gardenerService.createGardener(command);
    }


    @GetMapping("/gardeners")
    public List<GardenerDto> getGardeners() {
        return gardenerService.getGardeners();
    }

    @PostMapping("/gardeners/{gardenerId}/gardenworks")
    public GardenWorkDto createGardenWork(@PathVariable("gardenerId") long gardenerId,
                                          @Valid @RequestBody CreateGardenWorkCommand command) {
        return gardenerService.createGardenWork(gardenerId, command);
    }

    @GetMapping("/gardeners/{gardenerId}/gardenworks")
    public List<GardenWorkDto> getGardenWorks(@PathVariable("gardenerId") long gardenerId) {
        return gardenerService.getGardenWorks(gardenerId);
    }


    @PutMapping("/gardeners/{gardenerId}/gardenworks/{gardenWorkId}/answer")
    public GardenWorkDto  answer(@PathVariable("gardenerId") long gardenerId,
                              @PathVariable("gardenWorkId") long gardenWorkId,
                              @Valid @RequestBody AnswerCommand command) {
        return gardenerService.answer(gardenWorkId, command);
    }


    @GetMapping("/pairs")
    public List<NameDescriptionPairDto> getPairs() {
        return gardenerService.getPairs();
    }

}

