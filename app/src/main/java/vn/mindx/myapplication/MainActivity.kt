package vn.mindx.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.ll_main,
            homeFragment,
            HomeFragment::class.java.name
        ).commitAllowingStateLoss()

    }
}