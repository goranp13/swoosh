package com.goranp13.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.goranp13.swoosh.Model.Player
import com.goranp13.swoosh.R
import com.goranp13.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onMensClicked(view: View) {
        btnWomansLeague.isChecked = false
        btnCoedLeague.isChecked = false

        player.league = "mens"
    }

    fun onWomansClicked(view: View) {
        btnMensLeague.isChecked = false
        btnCoedLeague.isChecked = false

        player.league = "Womens"

    }

    fun onCoedsClicked(view: View) {
        btnMensLeague.isChecked = false
        btnWomansLeague.isChecked = false

        player.league = "co-ed"

    }


    fun leagueNextClicked(view: View) {

        if (player.league != ""){
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }else {
            Toast.makeText(this, "Please select your league!", Toast.LENGTH_SHORT).show()
        }

    }
}
