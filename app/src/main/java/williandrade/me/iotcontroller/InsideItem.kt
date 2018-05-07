package williandrade.me.iotcontroller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log

import kotlinx.android.synthetic.main.activity_inside_item.*
import williandrade.me.iotcontroller.adpter.InsideItemCardAdapter
import williandrade.me.iotcontroller.dto.HomeCardDTO
import williandrade.me.iotcontroller.dto.InsideItemCardDTO

class InsideItem : AppCompatActivity() {

    val itens = ArrayList<InsideItemCardDTO>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_item)
        toolbar.setTitle(intent.extras["inside_item_text"] as String)
        setSupportActionBar(toolbar)

        inside_item_icon.setImageResource(intent.extras["inside_item_icon"] as Int);
        inside_item_text.text = intent.extras["inside_item_text"] as String;
        inside_item_sub_text.text = intent.extras["inside_item_sub_text"] as String;

        val recyclerView = inside_item_list_recyclerview
        initializeData()

        recyclerView.adapter = InsideItemCardAdapter(this, itens, { itemClickAction(it) })
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    fun itemClickAction(item: InsideItemCardDTO) {
        Log.d("HERE", "A item was clicked ${item.text}")
    }


    private fun initializeData() {
        itens.add(InsideItemCardDTO("VOLUMN UP"))
        itens.add(InsideItemCardDTO("VOLUMN DOWN"))
        itens.add(InsideItemCardDTO("CHANNEL UP"))
        itens.add(InsideItemCardDTO("CHANNEL DOWN"))
        itens.add(InsideItemCardDTO("OFF", true))
    }
}
