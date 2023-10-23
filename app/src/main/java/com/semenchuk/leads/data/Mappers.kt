package com.semenchuk.leads.data

import com.semenchuk.leads.AdSourceQuery
import com.semenchuk.leads.CountriesQuery
import com.semenchuk.leads.LanguagesQuery
import com.semenchuk.leads.LeadIntentionQuery
import com.semenchuk.leads.LeadsQuery
import com.semenchuk.leads.domain.models.AdSource
import com.semenchuk.leads.domain.models.Avatar
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.Language
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.LeadIntentionType
import com.semenchuk.leads.domain.models.LeadsPaginated
import com.semenchuk.leads.domain.models.Status

fun CountriesQuery.FetchCountry.toCountry(): Country {
    return Country(
        emoji = emoji,
        id = id,
        phoneCode = phoneCode,
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
        id = id,
        displayName = displayName,
        firstName = firstName,
        lastName = lastName,
        secondName = secondName,
        avatar = avatar?.toAvatar(),
        country = country?.toCountry(),
        status = status?.toStatus()
    )
}

fun LeadsQuery.Avatar.toAvatar(): Avatar {
    return Avatar(
        id = id,
        thumbnail = thumbnail,
        path = path,
    )
}

fun LeadsQuery.Status.toStatus(): Status {
    return Status(
        id = id,
        title = title,
        color = color,
        backgroundColor = backgroundColor
    )
}

fun LeadsQuery.Country.toCountry(): Country {
    return Country(
        id = id,
        title = title,
        emoji = emoji,
        phoneCode = phoneCode,
    )
}

fun LeadIntentionQuery.FetchLeadIntentionType.toLeadIntentionType(): LeadIntentionType {
    return LeadIntentionType(
        id = id,
        title = title
    )
}

fun AdSourceQuery.FetchAdSource.toAdSource(): AdSource {
    return AdSource(
        id = id,
        title = title
    )
}

fun LanguagesQuery.Language.toLanguage(): Language {
    return Language(
        id = id,
        countries = countries?.map {
            it.toCountry()
        } ?: emptyList(),
        shortCode = shortCode,
        title = title
    )
}

fun LanguagesQuery.Country.toCountry(): Country {
    return Country(
        id = id,
        title = title,
        emoji = emoji,
        phoneCode = phoneCode,
    )

}