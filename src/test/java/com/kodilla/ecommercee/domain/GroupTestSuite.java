package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
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
public class GroupTestSuite {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    ProductRepository productRepository;

    private Group trousers;
    private Group hats;
    private List<Product> allProducts;


    @Test
    public void testCreateNewGroup() {
        //Given
        trousers = new Group("trousers");
        hats = new Group("hats");
        trousers = groupRepository.save(trousers);
        hats = groupRepository.save(hats);
        Group newGroup = new Group("newGroup");
        //When
        groupRepository.save(newGroup);
        //Then
        List<Group> allGroups = groupRepository.findAll();
        assertEquals(3, allGroups.size());
        //cleanup
        groupRepository.deleteAll();
    }

    @Test
    public void testFindGroupById() {
        //When
        hats = new Group("hats");
        groupRepository.save(hats);
        List<Group> allGroups = groupRepository.findAll();
        Group newGroup = groupRepository.findById(1L).get();
        //Then
        assertNotNull(newGroup);
        assertEquals(1L, (long) newGroup.getId());
        //clean up
        groupRepository.deleteAll();
    }
    @Test
    public void testUpdateGroup() {
        //Given
        hats = new Group("hats");
        groupRepository.save(hats);
        String newName = "updatedGroup";
        Group group1 = groupRepository.findById(1L).get();
        assertNotNull(group1);
        //When
        group1.setName(newName);
        group1 = groupRepository.findById(1L).get();
        //Then
        assertEquals(newName, group1.getName());
        //clean up
        groupRepository.deleteAll();
    }
    @Test
    public void testDeleteGroup() {
        //Given
        trousers = new Group("trousers");
        hats = new Group("hats");
        trousers = groupRepository.save(trousers);
        hats = groupRepository.save(hats);
        List<Group> allGroups = groupRepository.findAll();
        assertEquals(2, allGroups.size());
        //When
        groupRepository.deleteById(2L);
        allGroups = groupRepository.findAll();
        //Then
        assertEquals(1, allGroups.size());
        //clean up
        groupRepository.deleteAll();
    }
}

