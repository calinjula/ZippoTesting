package tests

import dtos.RequestResponse
import io.restassured.RestAssured.given
import org.assertj.core.api.Assertions
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class GetPlaceNameTest : BaseTest() {

    @DataProvider
    fun validValues() : Array<Array<String>> {
        return arrayOf(
                arrayOf("AR","1601","ISLA MARTIN GARCIA"),
                arrayOf("BE","2230","Herselt"),
                arrayOf("HU","9985","Felsőszölnök"),
                arrayOf("NL","1000","Amsterdam"),
                arrayOf("RU","101000","Москва"),
                arrayOf("TH","96220","Chanae")

        )
    }

    @Test(dataProvider = "validValues", description = "Country - Postal code pair returns a valid location")
    fun valid_Test(country: String, postalCode: String, expectedPlaceName: String) {

        val response = given().spec(validRequestSpecification)
                .`when`()
                .get("/$country/$postalCode")
                .then()
                .log().all()
                .extract().response().`as`(RequestResponse::class.java)

        Assertions.assertThat(response.places[0].name).isEqualTo(expectedPlaceName)

    }

    @DataProvider
    fun invalidValues() : Array<Array<String>> {
        return arrayOf(
                arrayOf("SE","98499","This should fail"),
                arrayOf("SM","47899","This should also fail")

        )
    }

    @Test(dataProvider = "invalidValues", description = "Country - Postal code pair does not return a valid location")
    fun invalid_Test(country: String, postalCode: String, expectedPlaceName: String) {

        val response = given().spec(validRequestSpecification)
                .`when`()
                .get("/$country/$postalCode")
                .then()
                .log().all()
                .extract().response().`as`(RequestResponse::class.java)

        Assertions.assertThat(response.places[0].name).isEqualTo(expectedPlaceName)

    }
}