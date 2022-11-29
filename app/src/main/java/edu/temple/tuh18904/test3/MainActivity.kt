package edu.temple.tuh18904.test3

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.math.ceil
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.action_take_picture -> Toast.makeText(this, "Taking Picture", Toast.LENGTH_SHORT).show()
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu/")))
            R.id.action_delete_picture -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmation\n")
                    .setMessage("Are sure you want to delete? This action cannot be undone")
                    .setPositiveButton("Yes"){_,_ -> Toast.makeText(this,"Deleting images",Toast.LENGTH_SHORT).show()}
                    .setNegativeButton("No"){dialog,_ -> dialog.cancel() }
                    .setCancelable(false)
                    .create()
                    .show()
            }

            else -> return false
        }

        return super.onOptionsItemSelected(item)
    }
}