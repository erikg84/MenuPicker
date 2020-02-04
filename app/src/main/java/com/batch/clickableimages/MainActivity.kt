package com.batch.clickableimages

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var message = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        snackbar_action.setOnClickListener{
            val intent = Intent(this,OrderActivity::class.java)
            intent.putExtra("message",message)
            startActivity(intent)
        }
    }
    fun showToast(view: View){
        val viewName = view.resources.getResourceEntryName(view.id)

        when(viewName){
            "first_image" -> makeToast(Toast.makeText(this,R.string.chocolate_order,Toast.LENGTH_LONG),resources.getString(R.string.chocolate_order))
            "second_image" -> makeToast(Toast.makeText(this,R.string.lemon_order,Toast.LENGTH_LONG),resources.getString(R.string.lemon_order))
            "third_image" -> makeToast(Toast.makeText(this,R.string.pumpkin_order,Toast.LENGTH_LONG),resources.getString(R.string.pumpkin_order))
        }

    }
    private fun makeToast(toast:Toast,msg:String){
        toast.show()
        message = msg
    }
    fun showAlert(view: View){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Do you want to close this application ?")
            .setCancelable(false)
            .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("AlertDialogExample")
        alert.show()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_order ->{
                val intent = Intent(this,OrderActivity::class.java)
                intent.putExtra("message",getString(R.string.action_order_message))
                startActivity(intent)
            }
            R.id.action_status -> displayToast(getString(R.string.action_status_message))
            R.id.action_favorites -> displayToast(getString(R.string.action_favorites_message))
            R.id.action_contact -> displayToast(getString(R.string.action_contact_message))
        }
        return super.onOptionsItemSelected(item)
    }
    private fun displayToast(toast:String){
        Toast.makeText(this,toast,Toast.LENGTH_SHORT).show()
    }
}
