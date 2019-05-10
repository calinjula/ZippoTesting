package dtos

import com.fasterxml.jackson.annotation.JsonProperty

class RequestResponse(
        @JsonProperty("post code") var postCode: String,
        @JsonProperty("country") var country: String,
        @JsonProperty("country abbreviation") var countryAbbreviation: String,
        @JsonProperty("places") var places: List<Place>
)
