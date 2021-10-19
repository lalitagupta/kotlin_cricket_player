package com.demo.match.datamodel


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("Matchdetail")
    @Expose
    val matchdetail: Matchdetail,
    @SerializedName("Teams")
    @Expose
    val teams: Teams,
    @SerializedName("Innings")

    val innings: List<Inning>
)