package com.goranp13.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.goranp13.swoosh.Utilities.EXTRA_LEAGUE
import com.goranp13.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeadue = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        btnWomansLeague.isChecked = false
        btnCoedLeague.isChecked = false

        selectedLeadue = "mens"
    }

    fun onWomansClicked(view: View) {
        btnMensLeague.isChecked = false
        btnCoedLeague.isChecked = false

        selectedLeadue = "Womens"

    }

    fun onCoedsClicked(view: View) {
        btnMensLeague.isChecked = false
        btnWomansLeague.isChecked = false

        selectedLeadue = "co-ed"

    }


    fun leagueNextClicked(view: View) {

        if (selectedLeadue != ""){
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeadue)
            startActivity(skillActivity)
        }else {
            Toast.makeText(this, "Please select your league!", Toast.LENGTH_SHORT).show()
        }

    }
}
