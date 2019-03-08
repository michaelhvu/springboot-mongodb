package rc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;

    // constructor
    public DbSeeder(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                150,
                new Address("Arlington", "Texas"),
                Arrays.asList(
                        new Review("Michael", 9, false),
                        new Review("Wade", 6, true)
                )
        );

        Hotel fourSeasons = new Hotel(
                "Four Seasons",
                300,
                new Address("Baltimore", "Maryland"),
                Arrays.asList(
                        new Review("John", 9, true)
                )
        );

        Hotel canyonSuites = new Hotel(
                "The Canyon Suites",
                315,
                new Address("Phoenix", "Arizona"),
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        // add hotels to database
        List<Hotel> hotels = Arrays.asList(marriot,fourSeasons,canyonSuites);
        this.hotelRepository.saveAll(hotels);
    }
}
