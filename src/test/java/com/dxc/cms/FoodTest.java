package com.dxc.cms;
import com.dxc.cms.entity.Food;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
public class FoodTest {

    static Food fd;
    @BeforeClass
    public  static void beforeClass(){
        fd=new Food(1,"Pizza",200.0);
    }

    @Test
    public void testGet(){
        assertEquals(1, fd.getfId(),0);
        assertEquals("Pizza",fd.getfDesc());
        assertEquals(200.0,fd.getfUnitPrice(),0);
    }

    @Test
    public void testToString(){
        String expected="Food [fId=" + fd.getfId() + ", fDesc=" + fd.getfDesc() + ", fUnitPrice=" + fd.getfUnitPrice() + "]";
        String actual=fd.toString();
        assertEquals(actual,expected);
    }



    @AfterClass
    public static void afterClass(){
          fd=null;
    }


}
