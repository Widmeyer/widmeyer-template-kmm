package com.features.ui.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.features.ui.Res
import com.features.ui.ic_back
import com.features.ui.theme.MainTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DialogError(
    title: String,
    description: String,
    onClose: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onClose() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 36.dp, vertical = 16.dp)
                .fillMaxWidth()
                .background(MainTheme.colors.primary, shape = RoundedCornerShape(16.dp))
                .border(8.dp, MainTheme.colors.white, RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_back),
                    modifier = Modifier
                        .size(48.dp),
                    contentDescription = null,
                )

                Text(
                    text = title,
                    style = MainTheme.typography.dialog.title,
                    color = MainTheme.colors.thirdly,
                    modifier = Modifier.padding(bottom = 12.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = description,
                    style = MainTheme.typography.dialog.main,
                    color = MainTheme.colors.black.copy(alpha = 0.5f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(start = 24.dp)
                .clip(RoundedCornerShape(100.dp))
                .size(42.dp)
                .background(MainTheme.colors.error)
                .clickable(onClick = onClose),
        ) {
            Icon(
                modifier = Modifier,
                painter = painterResource(Res.drawable.ic_back),
                tint = MainTheme.colors.white,
                contentDescription = null
            )
        }
    }
}


@Preview
@Composable
internal fun DialogError_Preview() {
    MainTheme {
        DialogError(
            title = "Ой споткнулся",
            description = "Описание в две строки, Описание в две строки"
        ) {

        }
    }
}