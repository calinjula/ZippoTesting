package tests

import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.testng.annotations.BeforeMethod

open class BaseTest {

    private lateinit var builder: RequestSpecBuilder
    lateinit var validRequestSpecification: RequestSpecification

    @BeforeMethod
    fun setUp() {

        builder = RequestSpecBuilder()
        builder.setBaseUri("http://api.zippopotam.us")
        builder.addFilter(AllureRestAssured())
        validRequestSpecification = builder.build()
    }
}