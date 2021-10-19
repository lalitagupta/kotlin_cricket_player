package com.android.roomdbstoreobject.db

import androidx.room.*
import com.demo.match.datamodel.Players


@Dao
interface PlayerDao {

    @Query("SELECT * FROM playersinfo WHERE teamid IN (:teams)")
    fun getTeamAInfo(teams: String): List<Players>?

    @Insert
    fun insertUser(user: Players?)

}
