package net.daan.recyclerview

import net.daan.recyclerview.model.Dentista

class DataSource {

    companion object {

        fun createDataset(): ArrayList<Dentista> {
            val list = ArrayList<Dentista>()

            list.add(Dentista(1, "14124", "Primeiro da Silva", "primeiro@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(2, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(3, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(4, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(1, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(2, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(3, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(4, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(1, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(2, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(3, "14124", "Daniel da Silva", "daan@gmail.com", "(11) 97070-7070"))
            list.add(Dentista(4, "14124", "Último da Silva", "ultimo@gmail.com", "(11) 97070-7070"))

            return list
        }
    }
}