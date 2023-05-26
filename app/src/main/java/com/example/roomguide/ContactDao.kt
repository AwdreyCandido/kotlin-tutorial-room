package com.example.roomguide

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    /*
     Dentro do DAO estarão todas as funções que precisamos
     para manipular os dados referentes a tebela que queremos
     dentro do banco de dados.
    */

    @Upsert // update and insert
    suspend fun saveContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER by firstName ASC")
    fun getContactsOrderedByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER by lastName ASC")
    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER by phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}