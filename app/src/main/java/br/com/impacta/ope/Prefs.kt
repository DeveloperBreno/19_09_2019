package br.com.impacta.ope

import android.content.Context
import android.content.SharedPreferences


//
//Novo token:
//dtmH_o2TxsA:APA91bGYQWudUNvuRD8x8KXnFo0hKzVuyrEc8TxDzDnwJ6B_-jTJ6CWQ7EITS6EaWvd0SNdpuosAblOJvR6C2-QkU9lWWugyr3PXX6kEDsQzp2uSs1PfQXGpGFVVzxYgplh1pX4OOo0K
//


object Prefs {
    val PREF_ID = "LMS"

    // retorna o armazém de preferências PREF_ID
    private fun prefs(): SharedPreferences {
        val context = LMSApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }

    fun setBoolean(flag: String, valor: Boolean){
        prefs().edit().putBoolean(flag, valor).apply()
    }


    fun getBoolean(flag: String): Boolean{

        return prefs().getBoolean(flag,false)
    }

    fun setString(flag: String, valor: String) {
        prefs().edit().putString(flag, valor).apply()
    }


    fun getString(flag: String): String {
        return prefs().getString(flag,"")
    }
}