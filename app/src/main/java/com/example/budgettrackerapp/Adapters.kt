package com.example.budgettrackerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.LinearProgressIndicator
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.abs

private val money: NumberFormat = NumberFormat.getCurrencyInstance(Locale.CANADA)

class CategoryAdapter(private val items: List<CategorySpend>) :
    RecyclerView.Adapter<CategoryAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.tv_category_name)
        val amount: TextView = v.findViewById(R.id.tv_category_amount)
        val progress: LinearProgressIndicator = v.findViewById(R.id.progress_category)
        val status: TextView = v.findViewById(R.id.tv_category_status)
    }

    override fun onCreateViewHolder(p: ViewGroup, t: Int) =
        VH(LayoutInflater.from(p.context).inflate(R.layout.item_category, p, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(h: VH, i: Int) {
        val c = items[i]
        val ctx = h.itemView.context
        h.name.text = c.name
        h.amount.text = "${money.format(c.spent)} / ${money.format(c.limit)}"
        h.progress.setProgressCompat(c.percent.coerceAtMost(100), false)

        val (colorRes, label) = when {
            c.percent > 100 -> R.color.over to "⚠ Over by ${money.format(c.spent - c.limit)}"
            c.percent >= 85 -> R.color.warn to "● Near limit · ${money.format(c.limit - c.spent)} left"
            else -> R.color.ok to "✔ ${money.format(c.limit - c.spent)} left"
        }
        val color = ContextCompat.getColor(ctx, colorRes)
        h.progress.setIndicatorColor(color)
        h.status.setTextColor(color)
        h.status.text = label
    }
}

class TransactionAdapter(private val items: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val emoji: TextView = v.findViewById(R.id.tv_emoji)
        val title: TextView = v.findViewById(R.id.tv_title)
        val subtitle: TextView = v.findViewById(R.id.tv_subtitle)
        val amount: TextView = v.findViewById(R.id.tv_amount)
    }

    override fun onCreateViewHolder(p: ViewGroup, t: Int) =
        VH(LayoutInflater.from(p.context).inflate(R.layout.item_transaction, p, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(h: VH, i: Int) {
        val t = items[i]
        h.emoji.text = t.emoji
        h.title.text = t.title
        h.subtitle.text = t.subtitle
        val sign = if (t.amount >= 0) "+" else "−"
        h.amount.text = "$sign${money.format(abs(t.amount))}"
        h.amount.setTextColor(
            ContextCompat.getColor(
                h.itemView.context,
                if (t.amount >= 0) R.color.ok else R.color.text_primary
            )
        )
    }
}
