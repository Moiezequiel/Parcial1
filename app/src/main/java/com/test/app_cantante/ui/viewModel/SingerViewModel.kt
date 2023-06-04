package com.test.app_cantante.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.test.app_cantante.data.Model.SingerModel
import com.test.app_cantante.repository.Repository
import com.test.app_cantante.SingerReviewerApp

class SingerViewModel(private val singerRepository: Repository): ViewModel() {
    val Name = MutableLiveData("")
    val musicType = MutableLiveData("")
    val status = MutableLiveData("")

    fun getSingers () = singerRepository.getSingers()

    private fun addSinger (singer: SingerModel) = singerRepository.setSinger(singer)

    private fun validateData(): Boolean{
        when{
            Name.value.isNullOrBlank() -> return false
            musicType.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun createSinger(): String{
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return WRONG_INFORMATION
        }
        val singer = SingerModel(
            name = Name.value!!,
            music_type = musicType.value!!,
        )

        addSinger(singer)
        status.value = SINGER_ADDED

        return SINGER_ADDED
    }

    fun clearData(){
        Name.value = ""
        musicType.value = ""
    }

    fun clearStatus (){
        status.value = INACTIVE
    }

    fun setSelectedSinger(singer: SingerModel){
        Name.value = singer.name
        musicType.value = singer.music_type
    }

    companion object{

        val Factory = viewModelFactory {
            initializer {
                val singerRepository = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SingerReviewerApp).singerRepository
                SingerViewModel(singerRepository)
            }
        }

        const val SINGER_ADDED  = "employee added to database"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}