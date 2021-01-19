package com.corvo.cccandroidtest.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.corvo.cccandroidtest.db.entity.Estimate
import com.corvo.cccandroidtest.db.entity.EstimateAndPerson
import com.corvo.cccandroidtest.db.entity.Person
import io.reactivex.Flowable

@Dao
interface EstimateAndPersonDao {

//    @Query("SELECT estimate.*, person.* FROM estimate INNER JOIN person ON estimate.created_by = person.id AND estimate.requested_by = person.id AND estimate.contact = person.id ")
//    fun getEstimateAndPerson(): EstimateAndPerson

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEstimate(estimate: Estimate)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Update
    fun editEstimate(estimate: Estimate)

    @Update
    suspend fun editPerson(person: Person)

    @Transaction
    @Query("SELECT * from person WHERE personId=:id")
    suspend fun getById(id: Long): List<EstimateAndPerson>?

    @Transaction
    @Query("SELECT * from person")
    suspend fun getAll(): List<EstimateAndPerson>

    @Query("SELECT * from estimate")
    suspend fun getEstimates(): List<Estimate>



}