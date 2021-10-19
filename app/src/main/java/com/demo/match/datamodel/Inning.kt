package com.demo.match.datamodel


import com.google.gson.annotations.SerializedName

data class Inning(
    @SerializedName("AllottedOvers")
    val allottedOvers: String,
    @SerializedName("Batsmen")
    val batsmen: List<Batsmen>,
    @SerializedName("Battingteam")
    val battingteam: String,
    @SerializedName("Bowlers")
    val bowlers: List<Bowler>,
    @SerializedName("Byes")
    val byes: String,
    @SerializedName("Legbyes")
    val legbyes: String,
    @SerializedName("Noballs")
    val noballs: String,
    @SerializedName("Number")
    val number: String,
    @SerializedName("Overs")
    val overs: String,
    @SerializedName("Penalty")
    val penalty: String,
    @SerializedName("Target")
    val target: String,
    @SerializedName("Total")
    val total: String,
    @SerializedName("Wickets")
    val wickets: String,
    @SerializedName("Wides")
    val wides: String
)