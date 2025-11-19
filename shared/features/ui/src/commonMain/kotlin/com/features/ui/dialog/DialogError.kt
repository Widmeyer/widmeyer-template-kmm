package com.features.ui.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil3.compose.LocalPlatformContext
import com.core.data.utils.globalApplicationContext
import com.core.data.utils.localize
import com.features.base.domain.model.Error
import com.features.ui.theme.MainTheme
import com.resources.MultiplatformResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DialogError(
    title: String,
    error: Error,
    onClose: () -> Unit,
    onNavigateToAuthorization: () -> Unit = {},
) {
    val message = remember {
        when (error) {
            Error.CONNECTION -> MultiplatformResource.strings.appName.localize()
            Error.TOKEN -> MultiplatformResource.strings.appName.localize()
            Error.OTHER -> error.message
                ?: MultiplatformResource.strings.appName.localize()
        }
    }

    Dialog(
        onDismissRequest = if (error == Error.TOKEN) onNavigateToAuthorization else onClose,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 36.dp, vertical = 8.dp)
                .fillMaxWidth()
                .background(MainTheme.colors.white, shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = title,
                    style = MainTheme.typography.dialog.title,
                    color = MainTheme.colors.black,
                    textAlign = TextAlign.Start
                )

                Text(
                    modifier = Modifier.padding(bottom = 24.dp),
                    text = message,
                    style = MainTheme.typography.dialog.main,
                    color = MainTheme.colors.black,
                    textAlign = TextAlign.Justify
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        modifier = Modifier.padding(bottom = 8.dp),
                        contentPadding = PaddingValues(),
                        onClick = if (error == Error.TOKEN) onNavigateToAuthorization else onClose
                    ) {
                        Text(
                            text = MultiplatformResource.strings.appName.localize(),
                            style = MainTheme.typography.dialog.buttonText,
                            color = MainTheme.colors.black,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
internal fun DialogError_Preview() {
    globalApplicationContext = LocalPlatformContext.current

    MainTheme {
        DialogError(
            title = "Ой споткнулся",
            error = Error.CONNECTION,
            onClose = {}
        )
    }
}