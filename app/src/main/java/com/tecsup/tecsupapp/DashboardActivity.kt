package com.tecsup.tecsupapp

import android.R.layout
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DashboardActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar?.hide()


        val register = findViewById<Button>(R.id.btnCourse)
        val student = findViewById<Button>(R.id.btnStudent)
        val notes = findViewById<Button>(R.id.btnNotas)
        val docent = findViewById<Button>(R.id.btnDocent)

        val courseActivity = Intent(this, CursoActivity::class.java)
        val registerStudentActivity = Intent(this, RegistrarEstudianteActivity::class.java)
        val notesActivity = Intent(this, NotasActivity::class.java)
        val docentActivity = Intent(this, RegistrarDocenteActivity::class.java)

        val btnRightNav = findViewById<Button>(R.id.userBtn)
        val btnLeftNav = findViewById<Button>(R.id.moreInfo)
        val navViewLeft = findViewById<NavigationView>(R.id.nav_view_left)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        btnRightNav.setOnClickListener {
            navViewLeft.isEnabled = true
            drawerLayout.openDrawer(GravityCompat.START)
        }

        btnLeftNav.setOnClickListener {
            navView.isEnabled = true
            drawerLayout.openDrawer(GravityCompat.END)
        }

        register.setOnClickListener {
            startActivity(courseActivity)
        }

        student.setOnClickListener {
            startActivity(registerStudentActivity)
        }

        notes.setOnClickListener {
            startActivity(notesActivity)
        }

        docent.setOnClickListener {
            startActivity(docentActivity)
        }

        configurationNavegatioDrawer()
        configurationNavegatioDrawerLeft()

    }

    private fun configurationNavegatioDrawer(){
        val navViewLeft = findViewById<NavigationView>(R.id.nav_view_left)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        navViewLeft.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawer(GravityCompat.START)
            when(menuItem.itemId){
                R.id.nav_calculator -> {
                    Toast.makeText(this, "Calculadora", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_gallery -> {
                    Toast.makeText(this, "Galeria", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_slideshow -> {
                    Toast.makeText(this, "Diapositivas", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun configurationNavegatioDrawerLeft(){
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        navView.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawer(GravityCompat.END)
            when(menuItem.itemId){
                R.id.nav_notices -> {
                    Toast.makeText(this, "Noticias", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_curse -> {
                    Toast.makeText(this, "Cursos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_teachers -> {
                    Toast.makeText(this, "Profesore", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_students -> {
                    Toast.makeText(this, "Estudiantes", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_notes -> {
                    Toast.makeText(this, "Notas", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_contact -> {
                    Toast.makeText(this, "Contactos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_book -> {
                    Toast.makeText(this, "Libro de Reclamaciones", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }


}