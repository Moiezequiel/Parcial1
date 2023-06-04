package com.test.app_cantante

import android.app.Application
import com.test.app_cantante.data.Model.singers
import com.test.app_cantante.repository.Repository

class SingerReviewerApp: Application(){
    val singerRepository: Repository by lazy {
        Repository(singers)
    }
}

