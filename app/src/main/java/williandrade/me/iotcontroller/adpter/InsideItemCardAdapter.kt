package williandrade.me.iotcontroller.adpter

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_inside_item.view.*
import williandrade.me.iotcontroller.R
import williandrade.me.iotcontroller.dto.InsideItemCardDTO

class InsideItemCardAdapter(private val context: Context,
                            private val itens: List<InsideItemCardDTO>,
                            private val callBack: (InsideItemCardDTO) -> Unit) : RecyclerView.Adapter<InsideItemCardAdapter.InsideItemCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsideItemCardHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_inside_item, parent, false)
        return InsideItemCardHolder(view)
    }

    override fun getItemCount(): Int {
        return itens.size;
    }

    override fun onBindViewHolder(holder: InsideItemCardHolder, position: Int) {

        val item = itens[position];

        holder.text.text = item.text;

        if (item.on) {
            holder.card.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            holder.text.setTextColor(Color.WHITE)
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                callBack(item)
            }
        })
    }

    class InsideItemCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text = itemView.card_inside_text
        val card = itemView.card_inside_view

    }

}