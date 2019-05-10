package dtos

import com.fasterxml.jackson.annotation.JsonProperty

class Place(
        @JsonProperty("place name") var name: String,
        @JsonProperty("longitude") var longitude: String,
        @JsonProperty("state") var state: String,
        @JsonProperty("state abbreviation") var stateAbbreviation: String,
        @JsonProperty("latitude") var latitude: String
)