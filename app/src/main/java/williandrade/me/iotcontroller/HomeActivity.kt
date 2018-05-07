package williandrade.me.iotcontroller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fab_sub_menu.*
import williandrade.me.iotcontroller.adpter.HomeCardAdapter
import williandrade.me.iotcontroller.dto.HomeCardDTO

class HomeActivity : AppCompatActivity() {

    val itens = ArrayList<HomeCardDTO>();
    var fabExpanded: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val recyclerView = home_list_recyclerview

        closeSubMenusFab()
        initializeData()
        recyclerView.adapter = HomeCardAdapter(this, itens, { itemClickAction(it) })
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

        fabSetting.setOnClickListener { view ->
            if (fabExpanded) {
                closeSubMenusFab()
            } else {
                openSubMenusFab()
            }
        }
    }


    private fun initializeData() {
        itens.add(HomeCardDTO(R.drawable.ic_tv_black, "Living Room", "CONTROLLER", true))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT"))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT", true))
        itens.add(HomeCardDTO(R.drawable.ic_tv_black, "Living Room", "CONTROLLER", true))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT"))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT", true))
        itens.add(HomeCardDTO(R.drawable.ic_tv_black, "Living Room", "CONTROLLER", true))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT"))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT", true))
        itens.add(HomeCardDTO(R.drawable.ic_tv_black, "Living Room", "CONTROLLER", true))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT"))
        itens.add(HomeCardDTO(R.drawable.ic_lightbulb_outline_black, "Living Room", "LIGHT", true))
    }

    fun itemClickAction(item: HomeCardDTO) {
        val intent = Intent(this@HomeActivity, InsideItem::class.java);
        intent.putExtra("inside_item_icon", item.icon);
        intent.putExtra("inside_item_text", item.name);
        intent.putExtra("inside_item_sub_text", item.type);

        startActivity(intent)
    }


    private fun closeSubMenusFab() {
        layoutFabSave.setVisibility(View.INVISIBLE)
        layoutFabEdit.setVisibility(View.INVISIBLE)
        layoutFabPhoto.setVisibility(View.INVISIBLE)
        fabSetting.setImageResource(R.drawable.ic_add_white)
        fabExpanded = false
    }

    private fun openSubMenusFab() {
        layoutFabSave.setVisibility(View.VISIBLE)
        layoutFabEdit.setVisibility(View.VISIBLE)
        layoutFabPhoto.setVisibility(View.VISIBLE)
        //Change settings icon to 'X' icon
        fabSetting.setImageResource(R.drawable.ic_close_white)
        fabExpanded = true
    }

}
