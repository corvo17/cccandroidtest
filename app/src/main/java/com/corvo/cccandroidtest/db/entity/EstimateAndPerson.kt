package com.corvo.cccandroidtest.db.entity

import androidx.room.Embedded

data class EstimateAndPerson(

    @Embedded
    val estimate: Estimate,

    @Embedded
    val person: Person
) {
}