package vn.teko.sandbox.nativeminiapptest.ui

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import vn.teko.sandbox.nativeminiapptest.R
import vn.teko.sandbox.nativeminiapptest.utils.SharedPreferenceUtils

/**
 * Created by TrungCS on 28/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
class MiniAppShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mini_app_shopping)

//
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setTitle(getTitleByScenarios())
//
//        navView.setupWithNavController(navController)
    }

    private val navController by lazy { findNavController(R.id.mainHostFragment) }

    private fun getTitleByScenarios(): Int {
        return when (SharedPreferenceUtils.getSavedDropdownPosition(this)) {
            SCENARIO_1 -> R.string.title_scenario_1
            SCENARIO_2 -> R.string.title_scenario_2
            else -> R.string.title_scenario_3
        }
    }

    companion object {
        const val SCENARIO_1 = 0
        const val SCENARIO_2 = 1
    }
}