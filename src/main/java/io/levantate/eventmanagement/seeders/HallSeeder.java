package io.levantate.eventmanagement.seeders;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.levantate.eventmanagement.models.Hall;
import io.levantate.eventmanagement.repository.HallRepository;


@Component
public class HallSeeder implements CommandLineRunner {

    @Autowired
    private HallRepository hallRepository;

    @Override
    public void run(String... args) throws Exception {
        if (hallRepository.count() == 0) {
            List<Hall> halls = new ArrayList<>();

            Hall hall1 = new Hall();
            hall1.setName("Grand Ballroom");
            hall1.setLocation("Downtown");
            hall1.setCategories("Wedding, Corporate Events");
            hall1.setPrice(5000);
            hall1.setDescription("A luxurious ballroom suitable for grand events.");
            hall1.setPhotos(Arrays.asList("https://plus.unsplash.com/premium_photo-1680807988328-7ba28ad24d9f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8aGFsbHxlbnwwfHwwfHx8MA%3D%3D", "https://images.unsplash.com/photo-1542665952-14513db15293?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGhhbGx8ZW58MHx8MHx8fDA%3D"));
            halls.add(hall1);

            Hall hall2 = new Hall();
            hall2.setName("Garden Pavilion");
            hall2.setLocation("Suburbs");
            hall2.setCategories("Outdoor Events");
            hall2.setPrice(3000);
            hall2.setDescription("A beautiful garden pavilion perfect for outdoor weddings.");
            hall2.setPhotos(Arrays.asList("https://images.unsplash.com/photo-1596522354195-e84ae3c98731?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzB8fGhhbGx8ZW58MHx8MHx8fDA%3D", "https://images.unsplash.com/photo-1571071001565-f89ac540effc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGhhbGx8ZW58MHx8MHx8fDA%3D"));
            halls.add(hall2);

            Hall hall3 = new Hall();
            hall3.setName("Riverside Retreat");
            hall3.setLocation("Countryside");
            hall3.setCategories("Nature Events, Retreats");
            hall3.setPrice(4000);
            hall3.setDescription("A serene riverside venue ideal for nature-themed events.");
            hall3.setPhotos(Arrays.asList("https://plus.unsplash.com/premium_photo-1676285069077-65a39ed9acf5?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTJ8fGhhbGx8ZW58MHx8MHx8fDA%3D", "https://images.unsplash.com/photo-1602081112620-4da569dda684?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjN8fGhhbGx8ZW58MHx8MHx8fDA%3D"));
            halls.add(hall3);

            Hall hall4 = new Hall();
            hall4.setName("Urban Loft");
            hall4.setLocation("City Center");
            hall4.setCategories("Social Gatherings, Workshops");
            hall4.setPrice(2500);
            hall4.setDescription("A trendy urban loft space suitable for creative events.");
            hall4.setPhotos(Arrays.asList("https://images.unsplash.com/photo-1544078751-58fee2d8a03b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDB8fHdlZGRpbmd8ZW58MHx8MHx8fDA%3D", "https://images.unsplash.com/photo-1591604466107-ec97de577aff?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzB8fHdlZGRpbmd8ZW58MHx8MHx8fDA%3D"));
            halls.add(hall4);

            Hall hall5 = new Hall();
            hall5.setName("Seaside Resort");
            hall5.setLocation("Coastal Area");
            hall5.setCategories("Beach Events, Retreats");
            hall5.setPrice(6000);
            hall5.setDescription("A luxurious seaside resort with stunning ocean views.");
            hall5.setPhotos(Arrays.asList("https://images.unsplash.com/photo-1549451371-64aa98a6f660?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8ZXZlbnRzfGVufDB8fDB8fHww", "https://images.unsplash.com/photo-1519741497674-611481863552?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8d2VkZGluZ3xlbnwwfHwwfHx8MA%3D%3D"));
            halls.add(hall5);

            hallRepository.saveAll(halls);
            System.out.println("Hall seed data inserted successfully.");
        } else {
            System.out.println("Hall seed data already exists. Skipping insertion.");
        }
    }
}
