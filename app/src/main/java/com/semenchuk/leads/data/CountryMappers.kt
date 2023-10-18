package com.semenchuk.leads.data

import com.semenchuk.leads.CountriesQuery
import com.semenchuk.leads.LeadsQuery
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.LeadsPaginated
import com.semenchuk.leads.type.DateTime

fun CountriesQuery.FetchCountry.toCountry(): Country {
    return Country(
        adWordsCode = adWordsCode,
        emoji = emoji,
        id = id,
        phoneCode = phoneCode,
        shortCode1 = shortCode1,
        shortCode2 = shortCode2,
        title = title,
    )
}

fun LeadsQuery.FetchLeads.toLeads(): LeadsPaginated {
    return LeadsPaginated(
        cursor = cursor,
        data = data.map { it.toLead() },
        hasMore = hasMore,
        totalCount = totalCount,

        )
}

fun LeadsQuery.Data1.toLead(): Lead {
    return Lead(
        birthDate = birthDate as DateTime,
        budget = budget,
        createdAt = createdAt as DateTime,
        displayName = displayName,
        displaySource = displaySource,
        firstName = firstName,
        id = id,
        itemType = itemType,
        lastName = lastName,
        personId = personId,
        quality = quality,
        secondName = secondName,
        seen = seen,
        sourceDetails = sourceDetails,
        updatedAt = updatedAt as DateTime,
    )
}