package com.goranp13.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.goranp13.swoosh.Model.Player
import com.goranp13.swoosh.R
import com.goranp13.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
    }

    fun onBeginnerClick(view: View) {
        btnBallerSkill.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClick(view: View) {
        btnBegginerSkill.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinshClicked(view: View) {
        if (player.skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }else {
            Toast.makeText(this, "Select skill level.", Toast.LENGTH_SHORT).show()
        }

    }
}
