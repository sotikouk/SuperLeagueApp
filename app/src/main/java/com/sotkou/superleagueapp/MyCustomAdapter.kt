package com.sotkou.superleagueapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyCustomAdapter(val context: Context,val teams:List<Team>): BaseAdapter() {
    override fun getCount(): Int {
        // Επιστρέφει τον αριθμό των αντικειμένων στο Data Set
        return teams.size
    }

    override fun getItem(position: Int): Any {
        // Επιστρέφει ενα στοιχείο σε συγκεκριμένη θέση που του δίνουμε (position)
        return teams[position]
    }

    override fun getItemId(position: Int): Long {
        // επιστρέφει μια μοναδική ταυτοποίηση για το αντικείμενο στη θέση position
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Η μέθοδος που επιστρέφει το View που εμφανίζει τα δεδομένα στην
        // συγκεκριμένη θέση στη λίστα (position).
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View
        if (convertView == null) {
            // Αν το convertView είναι άδειο, γέμισε το με με ενα
            // νεο View
            view = inflater.inflate(R.layout.item_list_layout, parent, false)
        } else {
            view = convertView
        }
        // Βάζουμε τα δεδομένα στο view
        val item = getItem(position) as Team

        // Αρχικοποιούμε τα views
        val nameTextView = view.findViewById<TextView>(R.id.teamName)
        val seatTextView = view.findViewById<TextView>(R.id.teamSeat)
        val emblemTextView = view.findViewById<ImageView>(R.id.emblemImage)

        // Περνάμε τις μεταβλητές στο item
        nameTextView.text = item.teamName
        seatTextView.text = item.teamSeat
        emblemTextView.setImageResource(item.teamEmblem)

        // Χειρισμός των κλίκ
        view.setOnClickListener {
            Toast.makeText(context, "You clicked: ${teams[position].teamName}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}