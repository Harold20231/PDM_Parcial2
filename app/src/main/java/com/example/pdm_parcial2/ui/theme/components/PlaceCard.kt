package com.example.pdm_parcial2.ui.theme.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pdm_parcial2.domain.model.Place

@Composable
fun PlaceCard(place: Place, isSelected: Boolean, onVote: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onVote() },
        elevation = if (isSelected) { androidx.compose.material3.CardDefaults.cardElevation(8.dp) } else { androidx.compose.material3.CardDefaults.cardElevation(2.dp) }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = place.imageUrl,
                contentDescription = place.name,
                modifier = Modifier.size(64.dp)
            )
            Text(text = place.name, style = MaterialTheme.typography.titleLarge)
        }
    }
}