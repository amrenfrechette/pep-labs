package com.revature;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.util.CommandLine;

import io.javalin.Javalin;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Javalin app = JavalinSingleton.getSingleton();
    @Before
    public void beforeEach() throws InterruptedException{
        app.start(9001);
        Thread.sleep(3000);
    }

    @After
    public void afterEach(){
        app.stop();
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        String expectedResult = "Hello World";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9001/hello");


        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }
}