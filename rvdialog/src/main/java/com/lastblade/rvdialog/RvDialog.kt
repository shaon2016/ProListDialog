package com.lastblade.rvdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_spinner_dialog.*
import kotlinx.android.synthetic.main.custom_spinner_dialog.view.*
import kotlinx.android.synthetic.main.rv_spinner_row.view.*

class RvDialog(context: Context) : Dialog(context, R.style.customRVDialog) {

    private val v: View = View.inflate(context, R.layout.custom_spinner_dialog, null)

    init {
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setContentView(v)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    fun title(text: String): RvDialog = apply {
        v.tv.text = text
    }

    fun listValues(
        data: ArrayList<String>,
        handler: (text: String, position: Int) -> Unit
    ): RvDialog = apply {
        v.rv.layoutManager = LinearLayoutManager(context)
        v.rv.adapter = RvSpinnerAdapter(data, handler)
    }

    fun negativeButton(text: String = "Cancel"): RvDialog = apply {
        cancel.text = text
        cancel.setOnClickListener { dismiss() }
    }

    inline fun show(func: RvDialog.() -> Unit): RvDialog = apply {
        this.func()
        this.show()
    }

    private inner class RvSpinnerAdapter(
        private val items: ArrayList<String>,
        private val handler: (text: String, position: Int) -> Unit
    ) :
        RecyclerView.Adapter<RvSpinnerAdapter.MyVH>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
            return MyVH(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_spinner_row, parent, false)
            )
        }

        override fun onBindViewHolder(holder: MyVH, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount() = items.size

        private inner class MyVH(private val v: View) : RecyclerView.ViewHolder(v) {
            private val tv = v.text1
            fun bind(value: String) {
                tv.text = value

                tv.setOnClickListener {
                    handler(value, adapterPosition)
                }
            }
        }
    }
}