package br.edu.ifsp.scl.agendaroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contato (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var nome:String,
    var fone:String,
    var email:String?
)
