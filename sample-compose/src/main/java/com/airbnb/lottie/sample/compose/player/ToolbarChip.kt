package com.airbnb.lottie.sample.compose.player

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.sample.compose.R
import com.airbnb.lottie.sample.compose.ui.Teal

@Composable
fun ToolbarChip(
    label: String,
    isActivated: Boolean,
    onClick: (isActivated: Boolean) -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int = 0,
) {
    val unActivatedColor = remember { Color(0xFF444444) }
    Surface(
        shape = RoundedCornerShape(3.dp),
        color = if (isActivated) Teal else Color(0xFFEAEAEA),
        modifier = Modifier
            .then(modifier)
            .clickable(onClick = { onClick(!isActivated) })
            .clipToBounds()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            if (iconRes != 0) {
                Icon(
                    painterResource(iconRes),
                    tint = if (isActivated) Color.White else unActivatedColor,
                    modifier = Modifier
                        .preferredSize(12.dp),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.preferredWidth(6.dp))
            }
            Text(
                label,
                color = if (isActivated) Color.White else unActivatedColor,
                style = TextStyle(fontSize = 12.sp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewToolbarChip() {
    ToolbarChip(
        iconRes = R.drawable.ic_border,
        label = stringResource(R.string.toolbar_item_border),
        isActivated = false,
        onClick = {}
    )
}