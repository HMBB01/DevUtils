package afkt.project.feature.ui_effect.recy_adapter.linear_snap

import afkt.project.R
import afkt.project.databinding.AdapterLinearSnapBinding
import afkt.project.model.bean.ItemBean
import afkt_replace.core.lib.utils.engine.image.IMAGE_ROUND_10
import afkt_replace.core.lib.utils.engine.image.display
import afkt_replace.core.lib.utils.engine.image.toImageConfig
import afkt_replace.core.lib.utils.toSource
import android.view.ViewGroup
import dev.adapter.DevDataAdapter
import dev.base.adapter.DevBaseViewBindingVH
import dev.base.adapter.newBindingViewHolder
import dev.utils.app.helper.view.ViewHelper

/**
 * detail: RecyclerView Gallery 效果 Adapter
 * @author Ttt
 */
class LinearSnapAdapter(data: List<ItemBean>) : DevDataAdapter<ItemBean, DevBaseViewBindingVH<AdapterLinearSnapBinding>>() {

    init {
        setDataList(data, false)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DevBaseViewBindingVH<AdapterLinearSnapBinding> {
        return newBindingViewHolder(parent, R.layout.adapter_linear_snap)
    }

    override fun onBindViewHolder(
        holder: DevBaseViewBindingVH<AdapterLinearSnapBinding>,
        position: Int
    ) {
        val item = getDataItem(position)
        ViewHelper.get()
            .setText(item.title, holder.binding.vidTitleTv)
            .setText(item.subtitle, holder.binding.vidSubtitleTv)
            .setText(item.timeFormat, holder.binding.vidTimeTv)

        holder.binding.vidIv.display(
            source = item.imageUrl?.toSource(),
            config = IMAGE_ROUND_10.toImageConfig()
        )
    }
}