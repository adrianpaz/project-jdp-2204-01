package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
class GroupTestSuite {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    ProductRepository productRepository;

    private Group trousers;
    private Group hats;
    private List<Product> allProducts;

    @BeforeEach
    public void init() {
        groupRepository.deleteAll();
        hats = new Group("hats");
        hats = groupRepository.save(hats);
    }

    @AfterEach
    public void afterEach() {
        groupRepository.deleteAll();
    }

    @Test
    public void testCreateNewGroup() {
        //Given
        trousers = new Group("trousers");
        trousers = groupRepository.save(trousers);
        Group newGroup = new Group("newGroup");
        //When
        groupRepository.save(newGroup);
        //Then
        List<Group> allGroups = groupRepository.findAll();
        assertEquals(3, allGroups.size());
    }

    @Test
    public void testFindGroupById() {
        //When
        Group newGroup = groupRepository.findById(hats.getId()).get();
        //Then
        assertNotNull(newGroup);
        assertEquals(hats.getId(), newGroup.getId());
    }
    @Test
    public void testUpdateGroup() {
        //Given
        String newName = "updatedGroup";
        Group group1 = groupRepository.findById(1L).get();
        assertNotNull(group1);
        //When
        group1.setName(newName);
        group1 = groupRepository.findById(1L).get();
        //Then
        assertEquals(newName, group1.getName());
    }
    @Test
    public void testDeleteGroup() {
        //Given
        trousers = new Group("trousers");
        trousers = groupRepository.save(trousers);
        List<Group> allGroups = groupRepository.findAll();
        assertEquals(2, allGroups.size());
        //When
        groupRepository.deleteById(2L);
        allGroups = groupRepository.findAll();
        //Then
        assertEquals(1, allGroups.size());
    }
}

