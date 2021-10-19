package com.demo.match.datamodel


import com.google.gson.annotations.SerializedName

data class MathResponse(
    @SerializedName("Innings")
    val innings: List<Inning>,
    @SerializedName("Matchdetail")
    val matchdetail: Matchdetail,
    @SerializedName("Nuggets")
    val nuggets: List<String>,
    @SerializedName("Teams")
    val teams: Teams
)