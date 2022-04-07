package com.john.fbi_mostwanted.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.john.fbi_mostwanted.database.Converters

@Entity
@TypeConverters(Converters::class)
data class Item(
    @SerializedName("additional_information")
    val additionalInformation: String?,
    @SerializedName("age_max")
    val ageMax: Int?,
    @SerializedName("age_min")
    val ageMin: Int?,
    @SerializedName("age_range")
    val ageRange: String?,
    @SerializedName("aliases")
    val aliases: String?,
    @SerializedName("build")
    val build: String?,
    @SerializedName("caution")
    val caution: String?,
    @SerializedName("complexion")
    val complexion: String?,
    @SerializedName("coordinates")
    val coordinates: List<String?>,
    @SerializedName("dates_of_birth_used")
    val datesOfBirthUsed: String?,
    @SerializedName("description")
    val description: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("eyes")
    val eyes: String?,
    @SerializedName("eyes_raw")
    val eyesRaw: String?,
    @SerializedName("field_offices")
    val fieldOffices: List<String>,
    @SerializedName("files")
    val files: List<String>,
    @SerializedName("hair")
    val hair: String,
    @SerializedName("hair_raw")
    val hairRaw: String,
    @SerializedName("height_max")
    val heightMax: Int?,
    @SerializedName("height_min")
    val heightMin: Int?,
    @SerializedName("@id")
    @PrimaryKey
    val id: String,
    @SerializedName("images")
    val images: List<String?>,
    @SerializedName("languages")
    val languages: String?,
    @SerializedName("legat_names")
    val legatNames: String?,
    @SerializedName("locations")
    val locations: String?,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("nationality")
    val nationality: String?,
    @SerializedName("ncic")
    val ncic: String?,
    @SerializedName("occupations")
    val occupations: String?,
    @SerializedName("path")
    val path: String,
    @SerializedName("person_classification")
    val personClassification: String,
    @SerializedName("place_of_birth")
    val placeOfBirth: String?,
    @SerializedName("possible_countries")
    val possibleCountries: String?,
    @SerializedName("possible_states")
    val possibleStates: String?,
    @SerializedName("publication")
    val publication: String,
    @SerializedName("race")
    val race: String,
    @SerializedName("race_raw")
    val raceRaw: String,
    @SerializedName("remarks")
    val remarks: String?,
    @SerializedName("reward_max")
    val rewardMax: Int,
    @SerializedName("reward_min")
    val rewardMin: Int,
    @SerializedName("reward_text")
    val rewardText: String?,
    @SerializedName("scars_and_marks")
    val scarsAndMarks: String?,
    @SerializedName("sex")
    val sex: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("subjects")
    val subjects: List<String>,
    @SerializedName("suspects")
    val suspects: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("warning_message")
    val warningMessage: String?,
    @SerializedName("weight")
    val weight: Int?,
    @SerializedName("weight_max")
    val weightMax: Int?,
    @SerializedName("weight_min")
    val weightMin: Int?
)