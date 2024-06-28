package br.com.lsdl.weatherapp.viewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lsdl.weatherapp.R
import br.com.lsdl.weatherapp.models.City

class ListCitiesAdapter(private var citiesList: List<City> = emptyList())
    : RecyclerView.Adapter<ListCitiesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val state: TextView
        val country: TextView

        init {
            name = view.findViewById(R.id.name)
            state = view.findViewById(R.id.state)
            country = view.findViewById(R.id.country)
        }
    }

    private var onClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cities_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = citiesList[position].name
        holder.state.text = "${citiesList[position].stateName},"
        holder.country.text = citiesList[position].country
        holder.itemView.setOnClickListener {
            onClickListener?.onItemClick(position, citiesList[position])
        }
    }

    override fun getItemCount(): Int = citiesList.size

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onClickListener = onItemClickListener
    }

    fun updateList(updatedList: List<City>) {
        citiesList = updatedList
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, city: City)
    }
}