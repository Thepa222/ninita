package com.example.myapplication

interface IsneakersRepository {
    fun getAll(): MutableList<Sneakers>
    fun getUserByID(Id: Int?): Sneakers?
    fun insert(sneakers: Sneakers)
    fun delete(sneakers: Sneakers)
    fun update(sneakers: Sneakers)
}