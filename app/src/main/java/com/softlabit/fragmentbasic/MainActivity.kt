package com.softlabit.fragmentbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.softlabit.fragmentbasic.Fragments.GalleryFragment
import com.softlabit.fragmentbasic.Fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        // actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        // Load Default Fragment..
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.add(R.id.container_fragment, HomeFragment())
        fragmentTransition.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                val fragmentManager = supportFragmentManager
                val fragmentTransition = fragmentManager.beginTransaction()
                fragmentTransition.replace(R.id.container_fragment, HomeFragment())
                fragmentTransition.commit()
                // Toast.makeText(this, "Hmm", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_gallery -> {
                val fragmentManager = supportFragmentManager
                val fragmentTransition = fragmentManager.beginTransaction()
                fragmentTransition.replace(R.id.container_fragment, GalleryFragment())
                fragmentTransition.commit()
                // Toast.makeText(this, "Hmm", Toast.LENGTH_SHORT).show()
            }
        }
        // Close Menu Drawer..
        drawer.closeDrawer(GravityCompat.START)


        return true
    }
}
