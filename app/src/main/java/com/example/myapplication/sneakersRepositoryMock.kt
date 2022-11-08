package com.example.myapplication

import androidx.compose.runtime.mutableStateListOf

class sneakersRepositoryMock: IsneakersRepository {
    private val alotofsneakers = mutableStateListOf<Sneakers>()
    private var idCount: Int = 100;
    init {
        for (i in 0..100) {
            val sneakers = Sneakers(i, "brand$i", "123456$i","2812$i","Black$i", "Nike$i")
            alotofsneakers.add(sneakers)
        }
    }

   override fun getAll(): MutableList<Sneakers> {
        return alotofsneakers
        }

    override fun getUserByID(id: Int?): Sneakers {
        return alotofsneakers.firstOrNull{it.id == id} ?: Sneakers(id = ++idCount)
    }

    override fun insert(sneakers: Sneakers) {
        if(sneakers.id == idCount){
            alotofsneakers.add(0, sneakers)
    }
    else{
        update(sneakers)
    }
}
override fun delete(sneakers: Sneakers) {
    alotofsneakers.remove(sneakers)
}

    override fun update(sneakers: Sneakers) {
        val index = alotofsneakers.indexOf(sneakers)
        alotofsneakers[index] = sneakers
    }
    }