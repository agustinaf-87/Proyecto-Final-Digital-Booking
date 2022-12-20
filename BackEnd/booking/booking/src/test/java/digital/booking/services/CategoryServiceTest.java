package digital.booking.services;

import digital.booking.DTO.CategoryDTO;
import digital.booking.exceptions.BadRequestException;
import digital.booking.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    CategoryDTO categoryDTO = new CategoryDTO(1L,"titleTest","descriptionTest","imageURLTest");


    @Test
    public void testSearchAll(){

        try {
            List<CategoryDTO> categoriesList = categoryService.searchAll();
            assertTrue(categoriesList.size() > 0,"There are no categories to list.");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testSearchById(){
        try {
            CategoryDTO categoryFounded = categoryService.searchById(categoryDTO.getId());
            assertEquals(categoryDTO.getId(), categoryFounded.getId(), "Ids don't match.");
            assertNotNull(categoryFounded,"The categpry founded is null.");

        } catch (NotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() {
        try{
            categoryService.create(categoryDTO);

            CategoryDTO categoryCreated = categoryService.searchById(1L);
            assertNotNull(categoryCreated,"The category is null");
            assertEquals(categoryDTO.getTitle(), categoryCreated.getTitle(), "Titles don't match.");
            assertEquals(categoryDTO.getDescription(), categoryCreated.getDescription(), "Descriptions don't match.");
            assertEquals(categoryDTO.getImageURL(), categoryCreated.getImageURL(), "ImageURLs don't match.");

        } catch (BadRequestException | NotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {
        try{
            categoryDTO.setTitle("titleEdited");
            categoryDTO.setDescription("descriptionEdited");
            categoryDTO.setImageURL("ImageURLEdited");

            CategoryDTO categoryUpdated = categoryService.update(categoryDTO,1L);

            assertEquals(categoryDTO.getTitle(), categoryUpdated.getTitle(), "Titles don't match.");
            assertEquals(categoryDTO.getDescription(), categoryUpdated.getDescription(), "Descriptions don't match.");
            assertEquals(categoryDTO.getImageURL(), categoryUpdated.getImageURL(), "ImageURLs don't match.");

        } catch (NotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try {
            categoryService.delete(1L);
            assertNull(categoryService.searchById(categoryDTO.getId()));
        } catch (NotFoundException e){
            e.printStackTrace();
        }
    }





}
