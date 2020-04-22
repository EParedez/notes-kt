package com.eparedez.todokotlin.todokotlin

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("blog")
data class TodoKotlinProperties(var title: String, val banner: Banner) {
    data class Banner(val title: String? = null, val content: String)
}
