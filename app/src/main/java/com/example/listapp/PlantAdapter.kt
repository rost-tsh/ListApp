package com.example.listapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.databinding.PlantItemBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    //список эллементов
    val plantList = ArrayList<Plant>()

    //с помощью ViewHolder Адаптер хранит ссылки на эти эллементы
    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) = with(binding){
            im.setImageResource(plant.imageId)
            tvTitle.text=plant.title

        }
    }

    //Надувает разметку и превращает во View который хранится в памяти и передаем в класс PlantHolder
    //Создает holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    //Выдает созданный holder и position
    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    //передаем в onBindViewHolder размер массива
    override fun getItemCount(): Int {
        return plantList.size
    }

    //Добавляем эллемент в список
    fun addPlant(plant: Plant){
        plantList.add(plant)
        //проверка на изменение данных
        notifyDataSetChanged()
    }

    //Если у нас есть список и мы хотим его поместить в адаптер
    fun adAll(list: List<Plant>){
        plantList.clear()
        plantList.addAll(list)
        notifyDataSetChanged()
    }
}