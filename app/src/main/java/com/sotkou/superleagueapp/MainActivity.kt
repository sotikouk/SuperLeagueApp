package com.sotkou.superleagueapp

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Το View: ListView
        val listView: ListView = findViewById(R.id.listView)

        // 2. Data source
        val teamsList = ArrayList<Team>()

        val team1 = Team("Α.Ε.Κ.", "OPAP Arena", R.drawable.aek)
        val team2 = Team("ΑΡΗΣ", "Κλεάνθης Βικελίδης", R.drawable.aris)
        val team3 = Team("Αστέρας AKTOR", "Θ. Κολοκοτρώνης", R.drawable.asteras)
        val team4 = Team("Ατρόμητος Αθ.", "Στάδιο Περιστερίου",R.drawable.atromitos)
        val team5 = Team("Βόλος ΝΠΣ", "Πανθεσσαλικό Στάδιο", R.drawable.volos)
        val team6 = Team("Καλλιθέα", "Απ. Νικολαίδης", R.drawable.kalithea)
        val team7 = Team("ΠΑΣ Λαμία", "Αθ. Διάκος", R.drawable.lamia)
        val team8 = Team("Λεβαδειακός", "Δημ. Στάδιο Λειβαδειάς", R.drawable.levadiakos)
        val team9 = Team("Ολυμπιακός", "Γ. Καραισκάκης", R.drawable.olympiakos)
        val team10 = Team("Ο.Φ.Η.", "Θ. Βαρδινογιάννης", R.drawable.ofi)
        val team11 = Team("Παναθηναικός", "Ολυμπιακό Στάδιο", R.drawable.pao)
        val team12 = Team("Παναιτολικός", "Γήπεδο Παναιτολικού", R.drawable.panaitolikos)
        val team13 = Team("Πασερραικός", "Δημ. Γήπεδο Σερρών", R.drawable.panseraikos)
        val team14 = Team("Π.Α.Ο.Κ.", "Γήπεδο Τούμπας", R.drawable.paok)

        teamsList.add(team1)
        teamsList.add(team2)
        teamsList.add(team3)
        teamsList.add(team4)
        teamsList.add(team5)
        teamsList.add(team6)
        teamsList.add(team7)
        teamsList.add(team8)
        teamsList.add(team9)
        teamsList.add(team10)
        teamsList.add(team11)
        teamsList.add(team12)
        teamsList.add(team13)
        teamsList.add(team14)

        // 3. Adapter
        var myAdapter = MyCustomAdapter(this, teamsList)

        listView.adapter = myAdapter

    }
}