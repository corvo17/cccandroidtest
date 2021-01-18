package com.corvo.cccandroidtest.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.corvo.cccandroidtest.db.entity.EstimateAndPerson

@Dao
interface EstimateAndPersonDao {

    @Query("SELECT estimate.*, person.* FROM estimate INNER JOIN person ON estimate.created_by = person.id AND estimate.requested_by = person.id AND estimate.contact = person.id ")
    fun getEstimateAndPerson(): EstimateAndPerson

}