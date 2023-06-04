package com.test.app_cantante.repository

import com.test.app_cantante.data.Model.SingerModel

class Repository(private val singers: MutableList<SingerModel>) {
    fun getSingers () = singers

    fun setSinger (singer: SingerModel) = singers.add(singer)
}
