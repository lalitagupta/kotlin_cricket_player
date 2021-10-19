package com.demo.match.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.android.roomdbstoreobject.db.RoomAppDb
import com.demo.match.datamodel.*
import com.demo.match.retrofit.ApiService
import com.demo.match.retrofit.RetrofitClient
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamVM (app: Application): AndroidViewModel(app), LifecycleObserver, Callback<ResponseBody> {
    val teamsList = MutableLiveData<HashMap<String,ArrayList<Players>>>()
    var teamshmap = HashMap<String, ArrayList<Players>>()

    init {
        callMatchAPI()
    }

    public fun callMatchAPI() {
        var call: Call<ResponseBody>? = null
        call = RetrofitClient.getRetrofit().create(ApiService::class.java).getMatchDetails();
        call.enqueue(this)

    }

    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
        getAllUsers()
    }

    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
        var json =response?.body()!!.string()
        val matchResponse = Gson().fromJson(json, MatchResponse::class.java)
        val teams: JSONObject =JSONObject(json).getJSONObject("Teams");
        val teamHome: JSONObject =teams.getJSONObject(matchResponse.matchdetail.teamHome)
        val teamAway: JSONObject =teams.getJSONObject(matchResponse.matchdetail.teamAway)
        for (innings in matchResponse.innings)
        {
            val batsmenList:List<Batsmen> = innings.batsmen
            var playerList = ArrayList<Players>()
            var teamName:String=""
            for (batsmen in batsmenList)
            {
                var playersjObect = JSONObject()
                var players:Players?=null
                if (innings.battingteam==matchResponse.matchdetail.teamHome) {
                    val teams1: Teams = Gson().fromJson(teamHome.toString(), Teams::class.java)
                    teamName=teams1.nameFull
                    playersjObect=teamHome.getJSONObject("Players");
                    players=Gson().fromJson(playersjObect.getJSONObject(batsmen.batsman).toString(),Players::class.java)
                    players.teamid="1"
                    players.teamsname=teamName
                    playerList.add(players)
                } else {
                    val teams2:Teams = Gson().fromJson(teamAway.toString(), Teams::class.java)
                    teamName=teams2.nameFull
                    playersjObect=teamAway.getJSONObject("Players");
                    players=Gson().fromJson(playersjObect.getJSONObject(batsmen.batsman).toString(),Players::class.java)
                    players.teamid="2"
                    players.teamsname=teamName
                    playerList.add(players)
                }
                insertPlayersInfo(players)
            }
            teamshmap.put(teamName,playerList)
        }
        teamsList.value=teamshmap

    }

    fun getAllUsers() {
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.playerDao()
        for (i in 1..2) {
            val list = userDao?.getTeamAInfo(""+i)
            if (list != null) {
                teamshmap.put(list.get(0).teamsname, list as ArrayList<Players>)
            }
        }
        teamsList.value=teamshmap

    }

    fun insertPlayersInfo(entity: Players){
        val playerDao = RoomAppDb.getAppDatabase(getApplication())?.playerDao()
        playerDao?.insertUser(entity)
    }

}
