package com.javaProject.AptitudeApp.dao;

import com.javaProject.AptitudeApp.model.Category;
import com.javaProject.AptitudeApp.model.Topic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class TopicEntityTests {

    @Autowired
    private ITopicRepo topicRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindByCategory(){
        Category category = new Category("Logical Aptitude");
        entityManager.persist(category);

        List<Topic> topics = List.of(
                new Topic("Clocks",category,"clocks"),
                new Topic("Calendar", category, "calendar"),
                new Topic("Water Images", category, "water-images")
        );

        for (Topic topic : topics) {
            entityManager.persist(topic);
        }

        entityManager.flush();

        List<Topic> topicsList = topicRepo.findByCategory(category);

        assertEquals(3, topicsList.size());
        assertEquals("water-images", topicsList.get(2).getSlug());
        assertEquals(category.getcName(), topicsList.get(0).getCategory().getcName());
        assertEquals(category, topicsList.get(0).getCategory());
    }
}
