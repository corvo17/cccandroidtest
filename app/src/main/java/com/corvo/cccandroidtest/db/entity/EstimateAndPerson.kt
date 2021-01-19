package com.corvo.cccandroidtest.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class EstimateAndPerson(

    @Embedded  val person: Person?,
    @Relation(
        parentColumn = "personId",
        entityColumn = "created_by"
    )
    val estimate: Estimate?
)