package today.stepbeyond.examples.bruno;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
@RequestMapping("dogs")
public class DogResource {

    Map<UUID,String> dogRepository;

    public DogResource() {
        this.dogRepository =  new HashMap<>(Map.of(
                UUID.fromString("9FF0C130-55D2-46A2-A76F-DE7D2ADBA396"), "Bulldog",
                UUID.fromString("279AC36F-934F-42F3-A169-B15ECDB0A19C"), "Labrador",
                UUID.fromString("18AAEB1C-D949-40AD-BFD0-40A581FEC1CE"), "Poodle"));


    }

    @GetMapping()
    public Map<UUID,String> getDogs() {
        return this.dogRepository;
    };

    @GetMapping("/{id}")
    public String getDog(@PathVariable("id") String id) {
        return Optional.ofNullable(id)
                .map(UUID::fromString)
                .map(this.dogRepository::get)
                .orElseThrow(DogNotFoundException::new);
    }

    @PostMapping()
    public UUID addDog(String dog) {
        UUID uuid = UUID.randomUUID();
        this.dogRepository.put(uuid, dog);
        return uuid;
    }

    @DeleteMapping("/{id}")
    public void deleteDog(int id) {
        this.dogRepository.remove(id);
    }
}
