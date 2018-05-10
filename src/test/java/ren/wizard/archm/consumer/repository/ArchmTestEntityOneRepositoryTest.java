package ren.wizard.archm.consumer.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ren.wizard.archm.consumer.entity.ArchmTestEntityOneEntity;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class ArchmTestEntityOneRepositoryTest {

    @Autowired
    ArchmTestEntityOneRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRepository() {
        assertEquals(1, repository.findAll().size());
    }

    @Test
    public void testInsert() {
        ArchmTestEntityOneEntity entityOneEntity = new ArchmTestEntityOneEntity();
        entityOneEntity.setThisIsAString("asd");
        repository.save(entityOneEntity);
        List<ArchmTestEntityOneEntity> res = repository.findAll();
        assertNotNull(res);
        assertTrue(res.size() > 1);
    }
}