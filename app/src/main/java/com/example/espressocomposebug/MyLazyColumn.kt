package com.example.espressocomposebug

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.viewinterop.AndroidView

class MyLazyColumn @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AbstractComposeView(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        val listState = rememberLazyListState()

        MessagesLazyColumnImpl(
            list = mutableListOf(ListItemData),
            listState = listState
        )
    }
}

object ListItemData

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MessagesLazyColumnImpl(
    modifier: Modifier = Modifier,
    list: List<ListItemData>,
    listState: LazyListState,
) {

    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        state = listState,
    ) {
        items(
            items = list,
            key = { 1 },
        ) {
            AndroidView(
                factory = { context ->
                    val view = LayoutInflater.from(context).inflate(R.layout.list_item, null, false)

                    view.findViewById<View>(R.id.button_inside).setOnClickListener {
                        Log.d("TRLOG ", "TRLOG **********************************")
                        Log.d("TRLOG ", "TRLOG BUTTON INSIDE CLICKED")
                        Log.d("TRLOG ", "TRLOG **********************************")
                    }

                    view
                },
            )
        }
    }
}
