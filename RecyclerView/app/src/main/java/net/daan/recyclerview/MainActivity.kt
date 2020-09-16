package net.daan.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import net.daan.recyclerview.adapter.DentistaRecyclerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var dentistaRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        recyclerViewDentistas.layoutManager = LinearLayoutManager(this)
        dentistaRecyclerAdapter = DentistaRecyclerAdapter(DataSource.createDataset())
        recyclerViewDentistas.adapter = dentistaRecyclerAdapter
    }
}
