package com.semenchuk.leads.data.apollo

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
import com.semenchuk.leads.domain.utils.LeadConstants.AUTH_KEY
import com.semenchuk.leads.domain.utils.LeadConstants.TOKEN

class ApolloAuthorizationInterceptor : HttpInterceptor {
    override suspend fun intercept(
        request: HttpRequest,
        chain: HttpInterceptorChain,
    ): HttpResponse {
        return chain.proceed(
            request.newBuilder().addHeader(AUTH_KEY, TOKEN).build()
        )
    }
}