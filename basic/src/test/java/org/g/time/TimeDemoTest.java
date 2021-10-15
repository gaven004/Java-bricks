package org.g.time;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

class TimeDemoTest {

    @Test
    void now() {
        TimeDemo.now();
    }

    @Test
    void parse() {
        TimeDemo.parse();
    }

    @Test
    void format() {
        TimeDemo.format();
    }

    @Test
    void plus() {
        TimeDemo.plus();
    }

    @Test
    void jacksonFormat() {
        /**
         * https://github.com/FasterXML/jackson-modules-java8/blob/master/README.md
         */

        ObjectMapper mapper = JsonMapper.builder() // or different mapper for other format
                .addModule(new JavaTimeModule())
                // and possibly other configuration, modules, then:
                .build();

        TimeDemoVo vo = new TimeDemoVo(1, LocalDateTime.now());

        try {
            System.out.println(mapper.writeValueAsString(vo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void jacksonParse() {
        /**
         * https://github.com/FasterXML/jackson-modules-java8/blob/master/README.md
         */

        ObjectMapper mapper = JsonMapper.builder() // or different mapper for other format
                .addModule(new JavaTimeModule())
                // and possibly other configuration, modules, then:
                .build();

        String s = "{\"id\":1,\"ctime\":\"2021-10-04 11:31:45\"}";

        try {
            TimeDemoVo vo = mapper.readValue(s, TimeDemoVo.class);
            System.out.println(vo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void jpa() {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("org.g");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new TimeDemoVo(1, LocalDateTime.now()));
        entityManager.persist(new TimeDemoVo(2, LocalDateTime.now().plusDays(1)));
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<TimeDemoVo> result = entityManager.createQuery("from TimeDemoVo", TimeDemoVo.class).getResultList();
        for (TimeDemoVo event : result) {
            System.out.println(event);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}