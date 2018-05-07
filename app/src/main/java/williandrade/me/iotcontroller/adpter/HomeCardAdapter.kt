package williandrade.me.iotcontroller.adpter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_home.view.*
import williandrade.me.iotcontroller.HomeActivity
import williandrade.me.iotcontroller.InsideItem
import williandrade.me.iotcontroller.R
import williandrade.me.iotcontroller.dto.HomeCardDTO

class HomeCardAdapter(private val context: Context,
                      private val itens: List<HomeCardDTO>,
                      private val callBack: (HomeCardDTO) -> Unit) : RecyclerView.Adapter<HomeCardAdapter.HomeCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_home, parent, false)
        return HomeCardHolder(view)
    }

    override fun getItemCount(): Int {
        return itens.size;
    }

    override fun onBindViewHolder(holder: HomeCardHolder, position: Int) {

        val item = itens[position];

        holder.icon.setImageResource(item.icon);
        holder.text.text = item.name;
        holder.subText.text = item.type;

        if (item.on) {
            holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.colorYellowOn), android.graphics.PorterDuff.Mode.SRC_IN)

        }

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                callBack(item)
            }
        })

    }

    class HomeCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val icon = itemView.card_home_icon;
        val text = itemView.card_home_text;
        val subText = itemView.card_home_sub_text;

    }

}