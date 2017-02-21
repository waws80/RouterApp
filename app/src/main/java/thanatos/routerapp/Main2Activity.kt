package thanatos.routerapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val actionBar = supportActionBar
        actionBar?.setDefaultDisplayHomeAsUpEnabled(false)
    }
}
