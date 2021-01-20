package com.corvo.cccandroidtest.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.corvo.cccandroidtest.app.App
import com.corvo.cccandroidtest.db.LocalDB
import com.corvo.cccandroidtest.db.dao.EstimateAndPersonDao
import com.corvo.cccandroidtest.db.entity.Estimate
import com.corvo.cccandroidtest.db.entity.EstimateAndPerson
import com.corvo.cccandroidtest.db.entity.Person
import com.corvo.cccandroidtest.utils.PrefUtil
import io.reactivex.Flowable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainViewModel constructor(
    private val estimateDao: EstimateAndPersonDao,
    val prefUtil: PrefUtil,
    application: Application
) : AndroidViewModel(application) {

    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val estimate = MutableLiveData<EstimateAndPerson?>()

    fun initLocalDB() {

        CoroutineScope(Dispatchers.Main).launch {
            isLoading.value = true
            try {

                withContext(CoroutineScope(context = Dispatchers.Default).coroutineContext) {

                    //val list: MutableList<EstimateAndPerson> = ArrayList()
                    val currentTime = System.currentTimeMillis()

                    val person1 = Person(
                        UUID.randomUUID().toString(),
                        "Joseph",
                        "Sham",
                        "joseph.sham@fake.fake",
                        "123-456-7890"
                    )


                    val estimate1 = Estimate(
                        0,
                        "Placebo Secondary School",
                        "32 Commissioners Road East",
                        32,
                        3,
                        currentTime,
                        person1.personId,
                        person1.personId.toString(),
                        person1.personId.toString()
                    )

                    estimateDao.insertPerson(person1)
                    estimateDao.insertEstimate(estimate1)
                }

                loadEstimate()

            } catch (exception: Exception) {
                isLoading.value = false
                errorMessage.value = exception.message
            }
        }
    }

    fun loadEstimate() {

        CoroutineScope(Dispatchers.Main).launch {
            isLoading.value = true
            try {

                val _estimate: EstimateAndPerson

                withContext(CoroutineScope(context = Dispatchers.Default).coroutineContext) {
                    _estimate = estimateDao.getAll().first()
                }

                isLoading.value = false
                estimate.value = _estimate

            } catch (exception: Exception) {
                Log.i("loadedEtimtes", "fuckeddd = ${exception.message}")
                isLoading.value = false
                errorMessage.value = exception.message
            }
        }

    }


}