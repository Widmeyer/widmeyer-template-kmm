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
import com.features.base.domain.model.Error
import com.features.ui.Res
import com.features.ui.appName
import com.features.ui.theme.MainTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DialogError(
    title: String,
    error: Error,
    onClose: () -> Unit,
    onNavigateToAuthorization: () -> Unit = {},
) {
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
                    text = when (error) {
                        Error.CONNECTION -> stringResource(Res.string.appName)
                        Error.TOKEN -> stringResource(Res.string.appName)
                        Error.OTHER -> error.message ?: stringResource(Res.string.appName)
                    },
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
                            text = stringResource(Res.string.appName),
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
    MainTheme {
        DialogError(
            title = "Ой споткнулся",
            error = Error.CONNECTION,
            onClose = {}
        )
    }
}