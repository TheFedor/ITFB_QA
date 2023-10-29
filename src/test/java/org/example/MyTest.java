package org.example;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Feature1")
@Story("Story1")
public class MyTest {

    @Test(description = "Тестовый сценарий 1")
    public void test1() {
    }

}
